package com.madara.security.user;

public enum Role {
    USER,
    ADMIN;

    public String getAuthority(){
        return "ROLE_" + this.name();
    }
}
