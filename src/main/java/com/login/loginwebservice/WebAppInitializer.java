package com.login.loginwebservice;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.login.loginwebservice.configuration.WebConfig;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
 
    @Override
    protected Class<?>[] getRootConfigClasses() {
        // TODO Auto-generated method stub
        return null;
    }
 
    @Override
    protected Class<?>[] getServletConfigClasses() {
        Class[] configFiles = {WebConfig.class};
        return configFiles;
    }
 
    @Override
    protected String[] getServletMappings() {
        String[] mappings = {"/"};
        return mappings;
    }
 
}
