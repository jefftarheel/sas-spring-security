package com.login.loginwebservice.models;

import java.sql.Date;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class LoggedInUserDetails implements UserDetails {

    private String userName;
    private String password;
    private Date passwordExpirationDate;

    public LoggedInUserDetails(User user) {
          this.userName = user.getUserName();
          this.password = user.getPassword();
          this.passwordExpirationDate = user.passwordExpirationDate();
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
        Date systemDate = new Date(System.currentTimeMillis());
        return passwordExpirationDate.after(systemDate);
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
