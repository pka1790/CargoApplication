package com.sample.app;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sample.app.dto.Trip;
import com.sample.app.dto.TripUserName;
import com.sample.app.dto.UserData;
import com.sample.app.service.CargoService;

/**
 * Servlet implementation class AcceptedHistoryController
 */
@WebServlet("/getAcceptedTrips")
public class AcceptedHistoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get Trip Infor GET");

		HttpSession session= request.getSession();
		UserData userData = (UserData) session.getAttribute("userdata");
		CargoService cargoService= new CargoService();
		List<TripUserName> tripCarierList=cargoService.getAcceptedCarrierData(userData.getUserId());
		if(!tripCarierList.equals(null)){
			for (TripUserName tripUserName : tripCarierList) {
				System.out.println(tripUserName);
			}
			session.setAttribute("tripUsername", tripCarierList);
			request.getRequestDispatcher("carrierAcceptedHistory.jsp").forward(request, response);

		}
	}

}
