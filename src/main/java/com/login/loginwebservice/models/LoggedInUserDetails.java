package com.login.loginwebservice.models;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class LoggedInUserDetails implements UserDetails {

    private String userName;
    private String password;
    private boolean expired;

    public LoggedInUserDetails(User user) {
          this.userName = user.getUserName();
          this.password = user.getPassword();
          this.expired = user.isExpired();
    }

    public LoggedInUserDetails() {}

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
      return userName;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !expired;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
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
    public boolean isEnabled() {
        return true;
    }
}
