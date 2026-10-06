package com.avanza.tea.iam.application.usecase;


import com.avanza.tea.iam.application.dto.UpdateUserCommand;
import com.avanza.tea.iam.application.dto.UserResponseDto;
import com.avanza.tea.iam.domain.model.aggregates.User;
import com.avanza.tea.iam.domain.model.enums.RolUser;
import com.avanza.tea.iam.domain.model.valueobjets.UserName;
import com.avanza.tea.iam.domain.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UpdateUserUseCase {

    private final UserRepository userRepository;

    public UpdateUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public UserResponseDto execute(UpdateUserCommand command){
        // verificar si el usuario existe
        User existUser = userRepository.findById(command.iduser())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        UserName newUserName = new UserName(command.username());
        // validar que otro usuario no tenga el mismo username

        boolean usernameChanged = !existUser.getUsername().equals(newUserName);
        if (usernameChanged && userRepository.existsByUsername(newUserName)) {
            throw new IllegalArgumentException("The name user '" + command.username() + "' it is already in use");
        }

        existUser.updateInfo(
                command.idperson(),
                newUserName,
                RolUser.valueOf(command.role().toUpperCase())
        );

        User updatedUser = userRepository.saveUser(existUser);

        return UserResponseDto.fromDomain(updatedUser);


    }

}
