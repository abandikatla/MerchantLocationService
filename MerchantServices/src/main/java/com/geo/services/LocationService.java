package com.geo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONException;

import com.geo.model.Location;
import com.geo.model.Query;
import com.geo.model.ServiceResponse;
import com.geo.util.GeoUtil;

public class LocationService {

	public LocationService() {

	}

	@POST
	@Path("/merchants/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ServiceResponse getMerchants(Query query) {

		
		List<String> response = new ArrayList<String>();
		String pincode;
		try {
			pincode = GeoUtil.getPostalCode(query.getLocationName());
		} catch (JSONException e1) {
			e1.printStackTrace();
			return new ServiceResponse(response);
		}
		Set<String> nearByPincodes;
		try {
			nearByPincodes = GeoUtil.nearBy(pincode, query.getRange());
			for (String pin : nearByPincodes) {
				System.out.println("Looking for merchants in the pin code : "
						+ pin);
				List<Location> temp = Global.merchantLocations.get(pin);
				if (temp != null) {
					for (Location l : temp) {
						response.add(l.getId());
					}
				}else{
					System.out.println("No merchants for this pin code " + pin);
				}

			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return new ServiceResponse(response);

	}

}
