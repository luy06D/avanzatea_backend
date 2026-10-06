package com.avanza.tea.iam.infraestructure.persitence.jpa.mapper;

import com.avanza.tea.profiles.infraestructure.persistence.jpa.entities.PersonEntity;
import com.avanza.tea.iam.domain.model.aggregates.User;
import com.avanza.tea.iam.domain.model.enums.RolUser;
import com.avanza.tea.iam.domain.model.enums.StateUser;
import com.avanza.tea.iam.domain.model.valueobjets.Password;
import com.avanza.tea.iam.domain.model.valueobjets.UserName;
import com.avanza.tea.iam.infraestructure.persitence.jpa.entities.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    //Dominio -> Entidad / guarda en la BD

    public UserEntity toEntity(User user){
        UserEntity userEntity = new UserEntity();
        userEntity.setIduser(user.getIdUser());

        PersonEntity personEntity = new PersonEntity();
        personEntity.setIdperson(user.getIdPerson());
        userEntity.setPerson(personEntity);

        userEntity.setUsername(user.getUsername().value());
        userEntity.setPassword(user.getPassword().password());
        userEntity.setRole(user.getRol().name());
        userEntity.setStatus(user.getStatus().name());
        return userEntity;
    }

    public  User toDomian(UserEntity userEntity){
        Long idPerson = (userEntity.getPerson() != null)
                ? userEntity.getPerson().getIdperson()
                : null;

        return new User(
                userEntity.getIduser(),
                idPerson,
                new UserName(userEntity.getUsername()),
                new Password(userEntity.getPassword()),
                RolUser.valueOf(userEntity.getRole()),
                StateUser.valueOf(userEntity.getStatus())
        );
    }


}
