package com.johnp.locationweb.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.johnp.locationweb.dao.ILocationDao;
import com.johnp.locationweb.entities.Location;
import com.johnp.locationweb.service.ILocationService;
import com.johnp.locationweb.util.IEmail;
import com.johnp.locationweb.util.IReport;

@Controller
public class LocationController {

@Autowired
ILocationDao iLocationDao;
	
@Autowired
ILocationService iLocationService;

@Autowired
IEmail iemail;

@Autowired
IReport ireport;

@Autowired
ServletContext context;

@RequestMapping("/allLocations")
public String showallLocations(ModelMap modalmap)
{
	String path=context.getRealPath("/");
	System.out.println(path);
	List<Location> Locations = iLocationService.getallLocations();
	List<Object[]>  reportData = iLocationDao.pdfByAreaType();
	ireport.generatePieChart(path, reportData);
	//List<Object[]> reportData = reportdao.pdfByAreaType();
	modalmap.addAttribute("locations", Locations);
	return "allLocations";
}

@RequestMapping("/createLocation")
public String createLocation()
{
	return "createLocation";
}

@RequestMapping(value = "/saveLocation", method = RequestMethod.POST)
public String saveLocation(@ModelAttribute("Location") Location location, ModelMap modelmap)
{
	//System.out.println(location);
	Location savedLocation = iLocationService.saveLocation(location);
	iemail.sendEmail("stevenkiller1@gmail.com","Location Saved","Hi"+savedLocation.getlocationId()+ "Welcome to Location Project");
	modelmap.addAttribute("message", "Location saved with id:" + savedLocation.getlocationId());
	return "createLocation";
}

@RequestMapping(value="/editLocation",method = RequestMethod.GET )
public String editLocation(@RequestParam("id") String id, ModelMap modelMap) {
	Location loc =  iLocationService.findByLocationId(Integer.parseInt(id));
	System.out.println("edit Location:"+ loc);
	modelMap.addAttribute("location", loc);
	return "editLocation";
}

@RequestMapping(value = "/updateLocation", method = RequestMethod.GET)
public String updateLocation(@ModelAttribute("location") Location loc)
{
	System.out.println("updateLocation:" + loc);
	iLocationService.updateLocation(loc);
	System.out.println("update loc");
	return "redirect:allLocations";
}

@RequestMapping("/deleteLocation")
public String deleteLocation(@RequestParam("id") String id,ModelMap modelmap) {
	iLocationService.deleteByLocationId(Integer.parseInt(id));
	modelmap.addAttribute("message","Location with id:" + id + " is deleted");
	return "redirect:allLocations";
}
}
