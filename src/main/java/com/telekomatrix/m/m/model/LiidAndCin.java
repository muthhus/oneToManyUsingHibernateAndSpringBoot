package com.telekomatrix.m.m.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "liid_and_cin")

public class LiidAndCin implements Serializable{

	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(name = "uuid")
	@Id
	private String id;
	
	@Column(name = "liid", unique=true)
	private String liid;
	
	@Column(name = "cin", unique=true)
	private String cin;
	
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
	private Set<LatLon> latLon = new HashSet<LatLon>();
	

	public LiidAndCin() {
		super();
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getLiid() {
		return liid;
	}


	public void setLiid(String liid) {
		this.liid = liid;
	}


	public String getCin() {
		return cin;
	}


	public void setCin(String cin) {
		this.cin = cin;
	}


	public Set<LatLon> getLatLon() {
		return latLon;
	}


	public void setLatLon(Set<LatLon> latLon) {
		this.latLon = latLon;
	}
	
	public void addLatLon(LatLon latLon) {
		this.latLon.add(latLon);
		latLon.setLiidAndCin(this);	
	}
}
