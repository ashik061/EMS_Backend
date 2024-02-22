package com.dev.EmsBackend.authentication;

import com.dev.EmsBackend.emsuser.EmsUser;

public class LoginResponseDTO {
    private EmsUser user;
    private String jwt;

    public LoginResponseDTO() {
    }

    public LoginResponseDTO(EmsUser user, String jwt) {
        this.user = user;
        this.jwt = jwt;
    }

    public EmsUser getUser() {
        return user;
    }

    public void setUser(EmsUser user) {
        this.user = user;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
