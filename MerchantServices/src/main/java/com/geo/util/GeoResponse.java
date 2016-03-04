package com.geo.util;

import java.util.List;

public class GeoResponse {
	
	private List<GeoLocation> postalCodes;

	public List<GeoLocation> getPostalCodes() {
		return postalCodes;
	}

	public void setPostalCodes(List<GeoLocation> postalCodes) {
		this.postalCodes = postalCodes;
	}
	
}
