package com.noplay.gestionale.entities;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserPrincipal implements UserDetails {

    private Utente utente;


    public UserPrincipal(Utente utente) {
        this.utente = utente;
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
            if (utente.getUsername().equalsIgnoreCase("admin")){
                return Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN"));
            } else {
                return Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));
            }
    }

    @Override
    public String getPassword() {
        return utente.getPassword();
    }

    @Override
    public String getUsername() {
        return utente.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }
    
}
