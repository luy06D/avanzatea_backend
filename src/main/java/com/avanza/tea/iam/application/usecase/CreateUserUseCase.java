package com.avanza.tea.iam.application.usecase;

import com.avanza.tea.iam.application.dto.CreateUserCommand;
import com.avanza.tea.iam.application.dto.UserResponseDto;
import com.avanza.tea.iam.domain.model.aggregates.User;
import com.avanza.tea.iam.domain.model.enums.RolUser;
import com.avanza.tea.iam.domain.model.valueobjets.Password;
import com.avanza.tea.iam.domain.model.valueobjets.UserName;
import com.avanza.tea.iam.domain.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateUserUseCase {

    private final UserRepository userRepository;

    public CreateUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDto execute(CreateUserCommand command){
        // Instanciamos los valueObjets
        UserName userName = new UserName(command.username());
        Password password = new Password(command.password());
        RolUser rol = RolUser.valueOf(command.role().toUpperCase());

        if(userRepository.existsByUsername(userName)){
            throw new IllegalArgumentException("El usuario ya existe");
        }

        User user = User.createNew(command.idperson(), userName, password, rol);

        User userSaved = userRepository.saveUser(user);

        return UserResponseDto.fromDomain(userSaved);

    }

}
