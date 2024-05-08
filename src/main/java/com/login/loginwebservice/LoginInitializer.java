package com.login.loginwebservice;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

import com.login.loginwebservice.configuration.LoginSecurityConfig;

public class LoginInitializer extends AbstractSecurityWebApplicationInitializer {

	public LoginInitializer() {
		super(LoginSecurityConfig.class);
	}
}
