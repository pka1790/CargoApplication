package com.sample.app;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sample.app.dto.PackageDetails;
import com.sample.app.dto.Trip;
import com.sample.app.dto.UserData;
import com.sample.app.service.CargoService;

/**
 * Servlet implementation class PlaceOrderController
 */
@WebServlet("/placeOrder")
public class PlaceOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String startPoint,endPoint,distance,transportDate,specialInstruction,vehiclePreference,
		 height,width,length,weight,itemCount,shipment;
		 int generatorId,tripId;
		 HttpSession session= request.getSession();
		 startPoint= request.getParameter("startPoint");
		 endPoint=request.getParameter("endPoint");
		 distance=request.getParameter("distance");
		 transportDate=request.getParameter("transportDate");
		 specialInstruction=request.getParameter("specialInstruction");
		 vehiclePreference=request.getParameter("vehiclePreference");
		 height=request.getParameter("height");
		 width=request.getParameter("width");
		 length=request.getParameter("length");
		 weight=request.getParameter("weight");
		 itemCount=request.getParameter("itemCount");
		 shipment=request.getParameter("shipment");
		 UserData userData=(UserData) session.getAttribute("userdata");
		 generatorId=userData.getUserId();
		 
		 CargoService cargoService= new CargoService();
		 Trip trip= new Trip(startPoint, endPoint, distance, transportDate, specialInstruction, vehiclePreference, generatorId);
		 tripId=cargoService.addTripDetails(trip);
		 System.out.println("tripId:>>>  "+tripId);
		 trip.setTripId(tripId);
		 System.out.println("Inserting Package data");
		 PackageDetails pkdetails= new PackageDetails(tripId, height, width, length, weight, itemCount, shipment);
		 int packageId=cargoService.addPackageDetails(pkdetails);
		 System.out.println("package ID:"+packageId);
		 pkdetails.setPackageId(packageId);
		 session.setAttribute("trip", trip);
		 session.setAttribute("packageDetails", pkdetails);
		 if(packageId!=0){
			 request.getRequestDispatcher("orderDetails.jsp").forward(request, response);
		 }else{
			 response.sendError(404, "UNABLE TO PLACE ORDER. PLEASE TRY AGAIN");
		 }
		 
		
	}

}
