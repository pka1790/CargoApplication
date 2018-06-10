package com.sample.app;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sample.app.dto.TripPackage;
import com.sample.app.service.CargoService;

/**
 * Servlet implementation class TripInfoController
 */
@WebServlet("/getTripInfo")
public class TripInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get Trip Infor GET");
		int tripId= Integer.valueOf(request.getParameter("tripId"));
		System.out.println("TripId: "+tripId);
		HttpSession session= request.getSession();
		CargoService cargoService= new CargoService();
		if(tripId!=0){
			List<TripPackage> tripPackages=cargoService.getTripInfo(tripId);
			if(!tripPackages.equals(null)){
				for (TripPackage tripPackage : tripPackages) {
					System.out.println(tripPackage);
				}
				session.setAttribute("tripPackages", tripPackages);
				request.getRequestDispatcher("viewTripDetails.jsp").forward(request, response);


			}else{

			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get Trip Info post");

	}

}
