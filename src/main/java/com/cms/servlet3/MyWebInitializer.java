package com.cms.servlet3;

import com.cms.app.filter.ErrorHandlerFilter;
import com.cms.app.filter.MySiteMeshFilter;
import com.cms.config.SpringSecurityConfig;
import com.cms.config.SpringWebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * Class that replaces the web.xml configuration in earlier versions. Interface to be implemented in
 * Servlet 3.0+ environments in order to configure the ServletContext programmatically -- as opposed
 * to (or possibly in conjunction with) the traditional web.xml-based approach.
 *
 * will be detected automatically by SpringServletContainerInitializer.
 */
public class MyWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringWebConfig.class, SpringSecurityConfig.class};
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
