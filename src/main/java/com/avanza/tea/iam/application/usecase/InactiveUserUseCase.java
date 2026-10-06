package com.avanza.tea.iam.application.usecase;


import com.avanza.tea.iam.domain.model.aggregates.User;
import com.avanza.tea.iam.domain.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InactiveUserUseCase {

    private final UserRepository userRepository;

    public InactiveUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void execute(Long iduser){
        User user = userRepository.findById(iduser)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        user.inactiveUser();
        userRepository.saveUser(user);
    }
}
