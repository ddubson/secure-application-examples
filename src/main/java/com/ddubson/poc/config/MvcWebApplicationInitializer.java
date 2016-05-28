package com.ddubson.poc.config;

import org.springframework.security.access.SecurityConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Author: ddubson
 */
public class MvcWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<SecurityConfig>[] getRootConfigClasses() {
        return new Class[] { WebSecurityConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[0];
    }

    @Override
    protected String[] getServletMappings() {
        return new String[0];
    }
}

