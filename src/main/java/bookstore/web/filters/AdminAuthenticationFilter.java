package bookstore.web.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebFilter("/admin/*")
public class AdminAuthenticationFilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {

      /* HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        Object adminUser = request.getSession()
                .getAttribute("userEmail");

        boolean isLoggedIn = (adminUser != null && request.getSession() != null);
        String loginURI = "/admin/login";

        boolean isLoginRequest = request.getRequestURI().equals(loginURI);

        boolean isLoginPage = request.getRequestURI().endsWith("admin_login.jsp");

        if (isLoggedIn && (isLoginRequest || isLoginPage)) {
            // the admin is already logged in and he's trying to login again
            // then forwards to the admin's homepage
            request.getRequestDispatcher("/admin/").
                    forward(request, response);

        } else if (isLoggedIn || isLoginRequest) {
            // continues the filter chain
            // allows the request to reach the destination
            chain.doFilter(request, response);

        } else {
            // the admin is not logged in, so authentication is required
            // forwards to the Login page
            request.getRequestDispatcher("admin_login.jsp").
                    forward(request, response);

        }*/
    }

    public AdminAuthenticationFilter() {
    }

    public void destroy() {
    }

    public void init(FilterConfig fConfig) throws ServletException {
    }
}
