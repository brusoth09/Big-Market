package com.cms.app.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Class to handle Errors.
 *
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
            servletRequest.getRequestDispatcher("500.jsp")
                    .forward(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
        //destroy the handler
    }
}
