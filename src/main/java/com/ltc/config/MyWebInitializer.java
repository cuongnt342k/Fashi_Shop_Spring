package com.ltc.config;

import com.ltc.config.security.SecurityConfig;
import com.ltc.config.hibernate.PersistenceJPAConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{PersistenceJPAConfig.class, SecurityConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { SpringWebConfig.class };    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }


}
