package com.TravelExperts.Service;

import java.util.List;

import com.TravelExperts.Model.Package;

public interface PackageService {

	
	public List<Package> listPackage();
	public void addPackage(Package p);
	public void updatePackage(Package p);
	public void removePackage(int id);
	public Package getPackageById(int id);
	
}
