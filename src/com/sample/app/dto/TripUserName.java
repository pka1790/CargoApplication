package com.sample.app.dto;

public class TripUserName {
	private String startPoint,endPoint,distance,transportDate,specialInstruction,vehiclePreference,tripStatus,username;
	private int tripId;
	
	public TripUserName() {
		// TODO Auto-generated constructor stub
	}
		
	public void setStartPoint(String startPoint) {
		this.startPoint = startPoint;
	}
	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	public void setTransportDate(String transportDate) {
		this.transportDate = transportDate;
	}
	public void setSpecialInstruction(String specialInstruction) {
		this.specialInstruction = specialInstruction;
	}
	public void setVehiclePreference(String vehiclePreference) {
		this.vehiclePreference = vehiclePreference;
	}
	public void setTripStatus(String tripStatus) {
		this.tripStatus = tripStatus;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setTripId(int tripId) {
		this.tripId = tripId;
	}
	public String getStartPoint() {
		return startPoint;
	}
	public String getEndPoint() {
		return endPoint;
	}
	public String getDistance() {
		return distance;
	}
	public String getTransportDate() {
		return transportDate;
	}
	public String getSpecialInstruction() {
		return specialInstruction;
	}
	public String getVehiclePreference() {
		return vehiclePreference;
	}
	public String getTripStatus() {
		return tripStatus;
	}
	public String getUsername() {
		return username;
	}
	public int getTripId() {
		return tripId;
	}

	@Override
	public String toString() {
		return "TripUserName [startPoint=" + startPoint + ", endPoint=" + endPoint + ", distance=" + distance
				+ ", transportDate=" + transportDate + ", specialInstruction=" + specialInstruction
				+ ", vehiclePreference=" + vehiclePreference + ", tripStatus=" + tripStatus + ", username=" + username
				+ ", tripId=" + tripId + "]";
	}
	
	
	
	

}
