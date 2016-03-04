package com.geo.services;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.geo.model.Location;
import com.geo.util.ConfigProperties;

public class Global {

	public static Map<String, List<Location>> merchantLocations; // Map of pin
																	// code and
																	// corresponding
																	// locations

	static {
		String fileName = ConfigProperties.getInstance().getProperty(
				"merchants");
		merchantLocations = new HashMap<String, List<Location>>();
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(fileName));
			String line = null;
			while ((line = br.readLine()) != null) {
				String[] temp = line.split(";");
				if (temp.length == 2) {
					String pincode = null;
					if ((pincode = Location.getPostalCodeFromAddress(temp[1])) != null) {
						if (!merchantLocations.containsKey(pincode))
							merchantLocations.put(pincode,
									new ArrayList<Location>());
						merchantLocations.get(pincode).add(
								new Location(temp[1], pincode, temp[0]));
					}
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
