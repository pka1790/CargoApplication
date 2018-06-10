package com.sample.app;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sample.app.dto.UserData;
import com.sample.app.service.CargoService;

/**
 * Servlet implementation class AcceptTripController
 */
@WebServlet("/acceptTrip")
public class AcceptTripController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get Trip Infor GET");
		int tripId= Integer.valueOf(request.getParameter("tripId"));
		System.out.println("TripId: "+tripId);
		HttpSession session= request.getSession();
		UserData userData = (UserData) session.getAttribute("userdata");
		CargoService cargoService= new CargoService();
		if(tripId!=0){
			if(cargoService.updateTrip(tripId,userData.getUserId())){
				System.out.println("TRIP ACCEPTED...");
				request.getRequestDispatcher("loadCarrierAcceptedTrip.jsp").forward(request, response);
				
			}
	}
	}

}
