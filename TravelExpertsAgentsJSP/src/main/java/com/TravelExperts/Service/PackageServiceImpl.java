package com.TravelExperts.Service;

import java.util.List;

import javax.transaction.Transactional;

import com.TravelExperts.DAO.PackageDAO;
import com.TravelExperts.Model.Package;

public class PackageServiceImpl implements PackageService {

	
	private PackageDAO packageDAO;
	
	public void setPackageDao(PackageDAO packageDAO)
	{
		this.packageDAO = packageDAO;
	}
	
	@Transactional
	@Override
	public List<Package> listPackage() {
		
		return this.packageDAO.listPackages();
	}

	@Transactional
	@Override
	public void addPackage(Package p) {
		this.packageDAO.addPackage(p);
	}

	@Transactional
	@Override
	public void updatePackage(Package p) {
		this.packageDAO.updatePackage(p);
		
	}

	@Transactional
	@Override
	public void removePackage(int id) {
		this.packageDAO.removePackage(id);
		
	}

	@Transactional
	@Override
	public Package getPackageById(int id) {
	
		return this.packageDAO.getPackageById(id);
	}

	
	
	
}
