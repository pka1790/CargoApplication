package com.sample.app.dto;

public class Trip {

	private String startPoint,endPoint,distance,transportDate,specialInstruction,vehiclePreference,tripStatus;
	private int generatorId,tripId;
	
	
	public Trip() {
	}
			
	public Trip(String startPoint, String endPoint, String distance, String transportDate, String specialInstruction,
			String vehiclePreference, int generatorId) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.distance = distance;
		this.transportDate = transportDate;
		this.specialInstruction = specialInstruction;
		this.vehiclePreference = vehiclePreference;
		this.generatorId = generatorId;
	}
	
	
	
	public void setTripStatus(String tripStatus) {
		this.tripStatus = tripStatus;
	}

	public void setTripId(int tripId) {
		this.tripId = tripId;
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
	public void setGeneratorId(int generatorId) {
		this.generatorId = generatorId;
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
	
	public String getTripStatus() {
		return tripStatus;
	}

	public int getTripId() {
		return tripId;
	}

	public String getVehiclePreference() {
		return vehiclePreference;
	}
	public int getGeneratorId() {
		return generatorId;
	}

	@Override
	public String toString() {
		return "Orders [startPoint=" + startPoint + ", endPoint=" + endPoint + ", distance=" + distance
				+ ", transportDate=" + transportDate + ", specialInstruction=" + specialInstruction
				+ ", vehiclePreference=" + vehiclePreference + ", generatorId=" + generatorId + ", tripStatus=" + tripStatus +"]";
	}
	
	
	
	
	
	
	
}
