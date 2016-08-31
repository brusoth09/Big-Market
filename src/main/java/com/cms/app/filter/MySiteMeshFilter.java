package com.cms.app.filter;


import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;


/**
 * Class for map site map 3 templates
 *
 */
public class MySiteMeshFilter extends ConfigurableSiteMeshFilter {
    @Override
    protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
        builder.addDecoratorPath("/*", "/decorators/default.jsp").
                addDecoratorPath("/index.jsp", "/decorators/default.jsp");
    }

}
