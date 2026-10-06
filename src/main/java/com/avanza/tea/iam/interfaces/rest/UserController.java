package com.avanza.tea.iam.interfaces.rest;


import com.avanza.tea.iam.application.dto.CreateUserCommand;
import com.avanza.tea.iam.application.dto.UpdateUserCommand;
import com.avanza.tea.iam.application.dto.UserResponseDto;
import com.avanza.tea.iam.application.usecase.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//indica que la clase atiente peticiones HTTP y devuelve JSON
@RestController

@RequestMapping("/api/users")
public class UserController {

    private final CreateUserUseCase createUserUseCase;
    private  final UpdateUserUseCase updateUserUseCase;
    private final FindUserByIdUseCase findUserByIdUseCase;
    private final FindAllUserUseCase findAllUserUseCase;
    private final InactiveUserUseCase inactiveUserUseCase;

    public UserController(CreateUserUseCase createUserUseCase, UpdateUserUseCase updateUserUseCase, FindUserByIdUseCase findUserByIdUseCase, FindAllUserUseCase findAllUserUseCase, InactiveUserUseCase inactiveUserUseCase) {
        this.createUserUseCase = createUserUseCase;
        this.updateUserUseCase = updateUserUseCase;
        this.findUserByIdUseCase = findUserByIdUseCase;
        this.findAllUserUseCase = findAllUserUseCase;
        this.inactiveUserUseCase = inactiveUserUseCase;
    }

    // POST - crear un nuevo usuario
    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@RequestBody CreateUserCommand userCommand){
        UserResponseDto responseDto = createUserUseCase.execute(userCommand);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    // PUT - actualizar usuario
    @PutMapping("/{iduser}")
    public ResponseEntity<UserResponseDto> updateUser(
            @PathVariable Long iduser,
            @RequestBody UpdateUserCommand userCommand){

        UpdateUserCommand updateUserCommand = new UpdateUserCommand(
                iduser,
                userCommand.idperson(),
                userCommand.username(),
                userCommand.role()
        );

        UserResponseDto responseDto = updateUserUseCase.execute(updateUserCommand);
        return  ResponseEntity.ok(responseDto);
    }

    // GET byId
    @GetMapping("/{iduser}")
    public ResponseEntity<UserResponseDto> getUserId(@PathVariable Long iduser){
        return ResponseEntity.ok(findUserByIdUseCase.execute(iduser));
    }

    // GET allUser
    @GetMapping
    public  ResponseEntity<List<UserResponseDto>> getAllUsers(){
        return  ResponseEntity.ok(findAllUserUseCase.execute());
    }

    // DELETE user
    @DeleteMapping("/iduser")
    public ResponseEntity<Void> inactiveUser(@PathVariable Long iduser){
        inactiveUserUseCase.execute(iduser);
        return ResponseEntity.noContent().build();
    }


}
