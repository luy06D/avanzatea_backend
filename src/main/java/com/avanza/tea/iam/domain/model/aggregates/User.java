package com.avanza.tea.iam.domain.model.aggregates;

import com.avanza.tea.iam.domain.model.enums.RolUser;
import com.avanza.tea.iam.domain.model.enums.StateUser;
import com.avanza.tea.iam.domain.model.valueobjets.Password;
import com.avanza.tea.iam.domain.model.valueobjets.UserName;

public class User {
    private Long idUser;
    private Long idPerson;
    private UserName username;
    private Password password;
    private RolUser role;
    private StateUser status;


    public User(Long idUser, Long idPerson, UserName username, Password password, RolUser role, StateUser status) {
        this.idUser = idUser;
        this.idPerson = idPerson;
        this.username = username;
        this.password = password;
        this.role = role;
        this.status = status;
    }

    // Crear user sin ID
    public static User createNew(Long idPerson, UserName username, Password password, RolUser role) {
        return new User(null, idPerson, username, password, role, StateUser.ACTIVE);
    }

    // Update user
    public void updateInfo(Long idPerson, UserName userName, RolUser role){
        if(idPerson == null){
            throw new IllegalArgumentException("The idperson cannot be empty.");
        }
        this.idPerson = idPerson;
        this.username = userName;
        this.role = role;
    }

    // Dar de baja un usuario
    public void inactiveUser() {
        if (this.status == StateUser.INACTIVE) {
            throw new IllegalStateException("The user is already inactive.");
        }
        this.status = StateUser.INACTIVE;
    }

    // Activar usuario
    public void activeUser() {
        this.status = StateUser.ACTIVE;
    }



    public Long getIdUser() {
        return idUser;
    }

    public Long getIdPerson() {
        return idPerson;
    }

    public UserName getUsername() {
        return username;
    }

    public Password getPassword() {
        return password;
    }

    public RolUser getRol() {
        return role;
    }

    public StateUser getStatus() {
        return status;
    }
}
