package bookstore.web.filters;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class CustomerLoginFilter implements Filter {


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession(false);

        String path = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());

        if (path.startsWith("/admin/")){
            chain.doFilter(request,response);
            return;
        }
        boolean loggedIn = session != null && session.getAttribute("loggedCustomer") != null;

        System.out.println("Path" + path);
        System.out.println("loggedin"+loggedIn);

        if (!loggedIn && path.startsWith("/view_profile")) {
            httpRequest.getRequestDispatcher("login.jsp")
                    .forward(request, response);

        } else {
            chain.doFilter(request, response);
        }
    }
}
