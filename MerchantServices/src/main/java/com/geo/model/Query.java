package com.geo.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "query")
public class Query {
	
	private String locationName;
	
	private Integer range;

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public Integer getRange() {
		return range;
	}

	public void setRange(Integer range) {
		this.range = range;
	}
	
	

}
