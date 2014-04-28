package edu.esprit.banque.webJSF.filtre;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.resteasy.spi.HttpResponse;

import edu.esprit.banque.webJSF.mb.AuthentificationMangedBean;

/**
 * Servlet Filter implementation class Filtre
 */
@WebFilter("/pages/admin/*")
public class Filtre implements Filter {

    /**
     * Default constructor. 
     */
    public Filtre() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
public void doFilter(ServletRequest requestServlet, ServletResponse responseServlet, FilterChain chain) throws IOException, ServletException {
		
		boolean letGo=false;
		
		HttpServletRequest request = (HttpServletRequest) requestServlet;
		HttpServletResponse response = (HttpServletResponse) responseServlet;
		
		AuthentificationMangedBean authentificationMangedBean = (AuthentificationMangedBean) request.getSession().getAttribute("authenMB");
		
		
		if(authentificationMangedBean !=null){
			if(authentificationMangedBean.isLoggedIn() & authentificationMangedBean.getUserType().equals("Admin")){
				letGo=true;
			}
		} 
		
		if(letGo){
			chain.doFilter(request, response);
		} else {
			response.sendRedirect(request.getContextPath()+"/pages/welcome.jsf");
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
