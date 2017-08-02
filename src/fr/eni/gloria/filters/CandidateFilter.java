package fr.eni.gloria.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import fr.eni.gloria.beans.Candidate;

/**
 * Servlet Filter implementation class CandidateFilter
 */
public class CandidateFilter implements Filter {

    /**
     * Default constructor. 
     */
    public CandidateFilter() {
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest)request).getSession(true);
		if (session.getAttribute("user") != null && session.getAttribute("user") instanceof Candidate ) {
			chain.doFilter(request, response);
		}else{
			request.getRequestDispatcher("/LoginCandidate").forward(request, response);
			//request.getRequestDispatcher("/WEB-INF/jsp/includes/login.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
