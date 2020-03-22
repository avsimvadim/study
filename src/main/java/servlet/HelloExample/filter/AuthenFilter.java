package servlet.HelloExample.filter;

import javax.servlet.*;

public class AuthenFilter implements Filter {

        public void  init(FilterConfig config) throws ServletException {

            System.out.println("AuthenFilter Init");
        }

        public void  doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws java.io.IOException, ServletException {

            System.out.println("AuthenFilter doFilter");
        chain.doFilter(request,response);
        }

        public void destroy( ) {
            System.out.println("AuthenFilter destroy");
        }
}
