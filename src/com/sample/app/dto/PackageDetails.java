package com.sample.app.dto;

public class PackageDetails {
	
	private int tripId,packageId;
	private String height,width,length,weight,itemCount,shipment;
	
	public PackageDetails() {
		// TODO Auto-generated constructor stub
	}
	
	public PackageDetails(int tripId, String height, String width, String length, String weight, String itemCount,
			String shipment) {
		this.tripId = tripId;
		this.height = height;
		this.width = width;
		this.length = length;
		this.weight = weight;
		this.itemCount = itemCount;
		this.shipment = shipment;
	}
	
	
	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}

	public void setTripId(int tripId) {
		this.tripId = tripId;
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
	public int getTripId() {
		return tripId;
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
		return "PackageDetails [tripId=" + tripId + ", height=" + height + ", width=" + width + ", length=" + length
				+ ", weight=" + weight + ", itemCount=" + itemCount + ", shipment=" + shipment + ", packageId=" + packageId + "]";
	}
	
	

}
