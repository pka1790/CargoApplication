package com.sample.app.dto;

public class TripPackage {

	private String startPoint,endPoint,distance,transportDate,specialInstruction,vehiclePreference,tripStatus,
	height,width,length,weight,itemCount,shipment;
	private int generatorId,tripId,packageId;

	public TripPackage() {
		// TODO Auto-generated constructor stub
	}
	//setters
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
	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}

	public void setHeight(String height) {
		this.height = height;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	public void setLength(String length) {
		this.length = length;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public void setItemCount(String itemCount) {
		this.itemCount = itemCount;
	}
	public void setShipment(String shipment) {
		this.shipment = shipment;
	}
	//getters
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

	public String getHeight() {
		return height;
	}
	public String getWidth() {
		return width;
	}
	public String getLength() {
		return length;
	}
	public String getWeight() {
		return weight;
	}
	public String getItemCount() {
		return itemCount;
	}
	public String getShipment() {
		return shipment;
	}
	public int getPackageId() {
		return packageId;
	}
	@Override
	public String toString() {
		return "TripPackage [startPoint=" + startPoint + ", endPoint=" + endPoint + ", distance=" + distance
				+ ", transportDate=" + transportDate + ", specialInstruction=" + specialInstruction
				+ ", vehiclePreference=" + vehiclePreference + ", tripStatus=" + tripStatus + ", height=" + height
				+ ", width=" + width + ", length=" + length + ", weight=" + weight + ", itemCount=" + itemCount
				+ ", shipment=" + shipment + ", generatorId=" + generatorId + ", tripId=" + tripId + ", packageId="
				+ packageId + "]";
	}

	

}
