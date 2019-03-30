package com.telekomatrix.m.m.service.api.response;


public class LatLonDTO {
	
	private String timestamp;
	private String lat;
	private String lon;
	
	public LatLonDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public LatLonDTO(String timestamp, String lat, String lon) {
		super();
		this.timestamp = timestamp;
		this.lat = lat;
		this.lon = lon;
	}
	
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLon() {
		return lon;
	}
	public void setLon(String lon) {
		this.lon = lon;
	}
	
	

}
