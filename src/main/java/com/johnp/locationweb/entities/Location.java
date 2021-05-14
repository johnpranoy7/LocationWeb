package com.johnp.locationweb.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Location {
	@Id
	int id;
	String area;
	String city;
	String areatype;
	
	public String getAreatype() {
		return areatype;
	}
	public void setAreatype(String areatype) {
		this.areatype = areatype;
	}
	public int getlocationId() {
		return id;
	}
	public void setlocationId(int locationId) {
		this.id = locationId;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@Override
	public String toString() {
		return "Location [id=" + id + ", area=" + area + ", city=" + city + ", areatype=" + areatype + "]";
	}	
}
