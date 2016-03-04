package com.geo.server;

import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;

import com.geo.services.LocationService;

public class Server {
	
	 protected Server() throws Exception {
	        JAXRSServerFactoryBean sf = new JAXRSServerFactoryBean();
	        sf.setResourceClasses(LocationService.class);
	        sf.setResourceProvider(LocationService.class, 
	            new SingletonResourceProvider(new LocationService()));
	        sf.setAddress("http://localhost:9011/");

	        sf.create();
	    }

	    public static void main(String args[]) throws Exception {
	        new Server();
	        System.out.println("Server ready...");

	    }

}
