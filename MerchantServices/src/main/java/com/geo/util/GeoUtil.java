package com.geo.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class GeoUtil {
	
	public static String getPostalCode(String locationName) throws JSONException{
		String url = "http://api.geonames.org/postalCodeSearchJSON?placename_startsWith="
				+ locationName.replace(" ", "%20") + "&maxRows=10&username=amulyab";
		String response;
		try {
			response = HTTPUtil.sendGet(url);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		JSONObject jsonObject = new JSONObject(response);
		System.out.println(response);
		JSONArray jsonArray = jsonObject.getJSONArray("postalCodes");
		Set<String> list = new HashSet<String>();
		if (jsonArray != null) { 
			   int len = jsonArray.length();
			   for (int i=0;i<len;i++){
				  return jsonArray.getJSONObject(i).get("postalCode").toString();
			   } 
		} 
		
		return null;
	}
	
	public static Set<String> nearBy(String pincode, Integer range) throws JSONException{
		
		String url = "http://api.geonames.org/findNearbyPostalCodesJSON?postalcode="
				+ pincode + "&radius=" + range + "&username=amulyab";
		String response;
		try {
			response = HTTPUtil.sendGet(url);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		System.out.println(response);
		JSONObject jsonObject = new JSONObject(response);
		JSONArray jsonArray = jsonObject.getJSONArray("postalCodes");
		Set<String> list = new HashSet<String>();
		if (jsonArray != null) { 
			   int len = jsonArray.length();
			   for (int i=0;i<len;i++){ 
			    list.add(jsonArray.getJSONObject(i).get("postalCode").toString());
			   } 
		} 
		return list;
		
	}

}
