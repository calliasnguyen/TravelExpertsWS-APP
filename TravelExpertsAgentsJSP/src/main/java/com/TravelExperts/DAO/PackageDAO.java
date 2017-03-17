package com.TravelExperts.DAO;

import java.util.List;
import com.TravelExperts.Model.Package;

public interface PackageDAO {

	
	public List<Package> listPackages();
	public void addPackage(Package p);
	public void updatePackage(Package p);
	public Package getPackageById(int id);
	public void removePackage(int id);
	
}
