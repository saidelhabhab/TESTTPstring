package com.TP.TEST.model.security;

import com.TP.TEST.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@AllArgsConstructor
public class UserSecurity implements UserDetails {

    private final User user;


    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        var authorities = user.getAuthoritySet().stream().map( a->new SimpleGrantedAuthority(a.getName()))
                .collect(Collectors.toSet());
       // return List.of(new SimpleGrantedAuthority("ADMIN")); use now this under
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
