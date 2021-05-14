package com.johnp.locationweb.service;

import java.util.List;

import com.johnp.locationweb.entities.Location;

public interface ILocationService {

	List<Location> getallLocations();

	Location saveLocation(Location location);

	Location findByLocationId(int id);

	void updateLocation(Location loc);

	void deleteByLocationId(int id);

}
