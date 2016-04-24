package com.atuts.servlet3;

import com.atuts.app.filter.ErrorHandlerFilter;
import com.atuts.app.filter.MySiteMeshFilter;
import com.atuts.config.SpringSecurityConfig;
import com.atuts.config.SpringWebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * Class that replaces the web.xml configuration in earlier versions.
 *
 */
public class MyWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{ SpringWebConfig.class, SpringSecurityConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringWebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Filter[] getServletFilters() {
        return new Filter[]{new ErrorHandlerFilter(), new MySiteMeshFilter()};
    }
}
