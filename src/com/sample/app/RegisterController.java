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

import com.sample.app.dto.UserData;
import com.sample.app.service.CargoService;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/register")
public class RegisterController extends HttpServlet {


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(request.getParameter("password"));
		String firstname,lastname,username,password,emailid,birthdate,registeras,mobile;
		firstname=request.getParameter("firstname");
		lastname= request.getParameter("lastname");
		username= request.getParameter("username");
		password= request.getParameter("password");
		emailid= request.getParameter("emailid");
		mobile=request.getParameter("mobile");
		registeras=request.getParameter("registeras");
		birthdate= request.getParameter("birthdate");

		HttpSession session= request.getSession();//getting session
		

		@SuppressWarnings("deprecation")
		String encpass=Base64.encode(password.getBytes());

		CargoService service= new CargoService();
		UserData userData= new UserData(firstname, lastname, username, encpass, emailid, birthdate, registeras,mobile);
		System.out.println(userData);
		//authenticated and registered
		if(service.registerUser(userData)){
			session.setAttribute("userdata", userData);
			if(userData.getRegisteras().equalsIgnoreCase("loadGenerator")){
				//dispatcher 
//				RequestDispatcher dispatcher=request.getRequestDispatcher("success.jsp");
//				dispatcher.forward(request, response);
				response.sendRedirect("index.jsp");
			}else if (userData.getRegisteras().equalsIgnoreCase("loadCarrier")) {
				request.getRequestDispatcher("/getPendingTrips").forward(request, response);
				
			}
		}


	}

}
