package com.leon.stock.model;

//import org.springframework.security.core.GrantedAuthority;

public enum Role  {
    ADMIN,
    USER;

   // @Override
    public String getAuthority() {
        return this.name();
    }
}