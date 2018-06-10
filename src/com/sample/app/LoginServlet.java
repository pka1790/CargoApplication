package com.sample.app;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.util.Base64;

import com.sample.app.dto.User;
import com.sample.app.dto.UserData;
import com.sample.app.service.LoginService;
import com.sample.app.service.CargoService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username,password;
		System.out.println(request.getParameter("username"));
		username=request.getParameter("username");
		password=request.getParameter("password");
		String enPass=  Base64.encode(password.getBytes());
		//LoginService loginService= new LoginService();
		//boolean result=loginService.authenticate(username, password);
		
		CargoService service= new CargoService();
		UserData userData=service.logIn(username);
		
		if(userData!=null){
			if(userData.getUsername().equals(username) && userData.getPassword().equals(enPass)){
				HttpSession session= request.getSession();
				session.setAttribute("userdata", userData);
				if(userData.getRegisteras().equals("loadGenerator")){
					response.sendRedirect("index.jsp");
				}else{
					request.getRequestDispatcher("/getPendingTrips").forward(request, response);
					
				}
			}else{
				
				response.sendError(404, "INVALID CREDENTIALS");
			}
			
		}else{

			response.sendError(404, "USER NOT FOUND .PLEASE ENTER VALID USER");

			
		}
		
//		 if(result){
//			 User user=loginService.getUserDetail(username);
//			 request.setAttribute("user", user);
//			 //response.sendRedirect("success.jsp");
//			 RequestDispatcher dispatcher= request.getRequestDispatcher("success.jsp");
//			 dispatcher.forward(request, response);
//			 return;
//		 }
//		 else {
//			response.sendRedirect("login.jsp");
//			return;
//		}
		 
	}

}
