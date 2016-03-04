package com.geo.model;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;


@XmlRootElement(name="response")
@XmlAccessorType(XmlAccessType.FIELD)
public class ServiceResponse {
	
	@XmlElement(name="merchantIds")
	private List<String> merchants;

	public List<String> getMerchants() {
		return merchants;
	}

	public void setMerchants(List<String> merchants) {
		this.merchants = merchants;
	}
	
	public ServiceResponse(){
		
	}
	
	public ServiceResponse(List<String> mList){
		this.merchants = mList;
	}
}
