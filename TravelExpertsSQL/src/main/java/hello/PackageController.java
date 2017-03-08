package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hello.Package;
import hello.PackageRepository;

@Controller
@RequestMapping(path = "/package")
public class PackageController {
	@Autowired
	public PackageRepository packageRepository;
	
	
//GET REQUEST... Grab all Packages	
	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Package> getAllPackages() 
	{
		//this will return XML or JSON format
		return packageRepository.findAll();
	}

	
	
//GET REQUEST.. Grab package by PackageID
	@GetMapping(path = "/{packageid}")
	public @ResponseBody Package getPackagesbyId(@PathVariable("packageid") Integer packageid) 
	{
		//this will return XML or JSON format
		Package temp = packageRepository.GrabPackage(packageid); 
		return temp;
	}
	
}
