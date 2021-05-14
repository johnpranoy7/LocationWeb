package com.johnp.locationweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.johnp.locationweb.dao.ILocationDao;
import com.johnp.locationweb.entities.Location;

@RestController
@RequestMapping("/locationrest")
public class LocationRestController {
	
	/*
	 * http://localhost:8080/locationweb/locationrest/location/
	 */	
	
	@Autowired
	ILocationDao iLocationDao;
	
	@GetMapping("/location")
	public List<Location> getLocation() {
		return iLocationDao.findAll();
	}
	
	@PutMapping("/location")
	public Location updateLocation(@RequestBody Location loc) {
		return iLocationDao.save(loc);
	}
	
	@PostMapping("/location")
	public Location CreateLocation(@RequestBody Location loc) {
		return iLocationDao.save(loc);
	}
	
	@GetMapping("/location/{id}")
	public Location getOneLocation(@PathVariable int id)
	{
		return iLocationDao.findById(id).get();
	}
	
	@DeleteMapping("/location/{id}")
	public String deleteOneLocation(@PathVariable int id)
	{
		try {
			iLocationDao.deleteById(id);
		} catch (Exception e) {
			System.out.println("Unable to delete");
			return null;
		}
		return "The Location with" + id + "deleted successfully";
	}
	
}
