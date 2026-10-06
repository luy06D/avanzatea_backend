package com.avanza.tea.iam.application.usecase;

import com.avanza.tea.iam.application.dto.UserResponseDto;
import com.avanza.tea.iam.domain.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FindUserByIdUseCase {

    private final UserRepository userRepository;

    public FindUserByIdUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public UserResponseDto execute(Long iduser){
        return  userRepository.findById(iduser)
                .map(UserResponseDto::fromDomain)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
    }
}
