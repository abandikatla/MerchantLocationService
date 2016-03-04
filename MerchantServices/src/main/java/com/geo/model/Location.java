package com.geo.model;

public class Location {

	private String completeAddress;
	private String postalCode;
	private String id;
	
	public Location(String address, String postalCode, String id) {
		this.postalCode = postalCode;
		this.completeAddress = address;
		this.id = id;
	}
	
	public static String getPostalCodeFromAddress(String address){
		String[] parts = address.replace("\"", "").split("PIN-");
		if(parts.length == 2){
			return parts[1];
		}
		return null;
	}

	public String getCompleteAddress() {
		return completeAddress;
	}

	public void setCompleteAddress(String completeAddress) {
		this.completeAddress = completeAddress;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}