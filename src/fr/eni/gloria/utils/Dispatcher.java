/**
 * @author lvanhove2017
 * @date 1 août 2017
 * @version GloriaProject V1.0
 */
package fr.eni.gloria.utils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletRequest;

/**
 * @author lvanhove2017
 * @date 1 août 2017
 * @version GloriaProject V1.0
 */
public class Dispatcher {
	public static RequestDispatcher dispatch(ServletRequest request, String file){
		String path = "/WEB-INF/jsp/";
		
		switch (file) {
		case "login":
			path += "login.jsp";
			break;

		default:
			path += "includes/error.jsp";
			break;
		}
		
		return request.getRequestDispatcher(path);
	}
}
