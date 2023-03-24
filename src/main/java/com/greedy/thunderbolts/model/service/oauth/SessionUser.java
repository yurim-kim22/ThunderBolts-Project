package com.greedy.thunderbolts.model.service.oauth;

import java.io.Serializable;

import lombok.Getter;

@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private Role role;


    public SessionUser(TblUser user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.role = user.getRole();

    }

}
