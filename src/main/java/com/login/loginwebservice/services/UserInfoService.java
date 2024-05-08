package com.login.loginwebservice.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.login.loginwebservice.models.LoggedInUserDetails;
import com.login.loginwebservice.models.User;
import com.login.loginwebservice.models.UserRepository;

@Service
public class UserInfoService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserName(userName);

        user.orElseThrow(() -> new UsernameNotFoundException("Cannot find user: " + userName));
        
        return user.map(LoggedInUserDetails::new).get();
    }

}
