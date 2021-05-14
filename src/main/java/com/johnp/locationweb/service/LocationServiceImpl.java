package com.johnp.locationweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johnp.locationweb.dao.ILocationDao;
import com.johnp.locationweb.entities.Location;

@Service
public class LocationServiceImpl implements ILocationService {

	@Autowired
	ILocationDao iLocationDao;

	@Override
	public List<Location> getallLocations() {
		return iLocationDao.findAll();
	}

	@Override
	public Location saveLocation(Location location) {
		return iLocationDao.save(location);
	}

	@Override
	public Location findByLocationId(int id) {
		return iLocationDao.findById(id).get();
	}

	@Override
	public void updateLocation(Location loc) {
		 iLocationDao.save(loc);
	}

	@Override
	public void deleteByLocationId(int id) {
		iLocationDao.deleteById(id);
	}
	
}
