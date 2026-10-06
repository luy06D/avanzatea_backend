package com.avanza.tea.iam.application.usecase;

import com.avanza.tea.iam.application.dto.UserResponseDto;
import com.avanza.tea.iam.domain.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class FindAllUserUseCase {

    private final UserRepository userRepository;

    public FindAllUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public List<UserResponseDto> execute(){
        return userRepository.findAll().stream()
                .map(UserResponseDto::fromDomain)
                .toList();
    }
}
