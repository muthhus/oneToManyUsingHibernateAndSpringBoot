package com.telekomatrix.m.m.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "lat_lon", uniqueConstraints = {@UniqueConstraint(columnNames= {"liid_cin_id", "timestamp"})})
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
	@Column(columnDefinition = "CHAR(32)")
	@Id
	private String id;
	
	@Column(name = "timestamp")
	private long timestamp;
	
	@Column(name = "lat")
	private double lat;
	
	@Column(name = "lon")
	private double lon;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "liid_cin_id")
	@JsonBackReference
	private LiidAndCin liidAndCin;
	
}
