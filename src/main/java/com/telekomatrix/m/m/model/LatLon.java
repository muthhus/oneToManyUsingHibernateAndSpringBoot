package com.telekomatrix.m.m.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "lat_lon")
public class LatLon implements Serializable{

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public LiidAndCin getLiidAndCin() {
		return liidAndCin;
	}

	public void setLiidAndCin(LiidAndCin liidAndCin) {
		this.liidAndCin = liidAndCin;
	}

	public LatLon() {
		super();
	}

	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(name = "uuid")
	@Id
	private String id;
	
	@Column(name = "timestamp")
	private long timestamp;
	
	@Column(name = "lat")
	private double lat;
	
	@Column(name = "lon")
	private double lon;
	
	@ManyToOne
	@JoinColumn(name = "liid_cin_id")
	private LiidAndCin liidAndCin;
	
}
