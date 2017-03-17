package com.TravelExperts.Agents;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.TravelExperts.Service.PackageService;
import com.TravelExperts.Model.Package;

@RequestMapping(value = "/Package")
@Controller
public class PackageController{
	
	@Autowired 
	PackageService packageService;
	
	
	//Get Method to grab all packages
	@RequestMapping(value="/", method=RequestMethod.GET)
	public @ResponseBody
	List<Package> getPackageList()
	{
		List<Package> packageList = null;
		try{
			packageList = packageService.listPackage();
		}catch(Exception e){
			e.printStackTrace();
		}
		return packageList;
	}
	
	//Get method for specific Package
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Package> getPackageById(@PathVariable("id") Integer id)
	{
		Package p = packageService.getPackageById(id);
		return new ResponseEntity<Package>(p, HttpStatus.OK);
	}
	
	
	//Update a package  Post request
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public ResponseEntity<Package> updatePackage(@RequestBody Package p)
	{
		packageService.updatePackage(p);
		return new ResponseEntity<Package>(p, HttpStatus.ACCEPTED);
	}
	
	//Add a new Package
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public ResponseEntity<Package> addPackage(@RequestBody Package p)
	{
		packageService.addPackage(p);
		return new ResponseEntity<Package>(p, HttpStatus.ACCEPTED);
	}
	
	//Remove a Package by ID
	@RequestMapping(value="/remove/{id}", method=RequestMethod.POST)
	public ResponseEntity<?> removePackage(@PathVariable("id") Integer id)
	{//bug to fix the response strings
		packageService.removePackage(id);
		return new ResponseEntity<String>("",HttpStatus.ACCEPTED);
	}
	
}
