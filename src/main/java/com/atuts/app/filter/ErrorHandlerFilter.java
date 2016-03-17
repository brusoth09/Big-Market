package com.atuts.app.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by BurusothmanA on 3/15/2016 1:11 PM.
 */
public class ErrorHandlerFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //initialize the handler
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (Exception ex) {
            servletRequest.setAttribute("errorMessage", ex);
            servletRequest.getRequestDispatcher("/WEB-INF/views/jsp/error.jsp")
                    .forward(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
        //destroy the handler
    }
}
