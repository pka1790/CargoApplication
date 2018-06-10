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
import com.sample.app.dto.UserData;
import com.sample.app.service.CargoService;

/**
 * Servlet implementation class CarrierController
 */
@WebServlet("/getPendingTrips")
public class CarrierController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
       
 	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("CarrierHOme");
		System.out.println("get showGeneratorHistory");
		HttpSession session= request.getSession();
		UserData userData=(UserData)session.getAttribute("userdata");
		//select tripid,startpoint,endpoint, distance, tripstatus,vehiclePreference,specialInstruction from tripdata 
		//where  generatorId = '+appSession.user.userid
		CargoService cargoService= new CargoService();
		List<Trip> tripCarierList=cargoService.getCarrierData();
		if(!tripCarierList.equals(null)){
			for (Trip trip : tripCarierList) {
				System.out.println("trip detaills: "+trip.toString());
				
			}
			
			System.out.println("Adding triplist session ");
		session.setAttribute("tripCarierList", tripCarierList);
		request.getRequestDispatcher("loadCarrierHome.jsp").forward(request, response);
		}else{
			
		}
		
	}

}
