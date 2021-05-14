package com.johnp.locationweb.dao;


import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.johnp.locationweb.entities.Location;


public interface ILocationDao extends JpaRepository<Location, Integer> {

	
	@Query("SELECT l.areatype, count(l.areatype) FROM Location l GROUP BY l.areatype")
	public List<Object[]> pdfByAreaType();
	
	/*
	 * @Query(value = "select location.id, count(location.areatype) from location",
	 * nativeQuery=true) public Map<Integer, String> pdfByAreaType();
	 */
}
