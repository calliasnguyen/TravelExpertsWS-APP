package com.TravelExperts.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.TravelExperts.Model.Package;

public class PackageDAOImpl implements PackageDAO {

	private static final Logger logger = LoggerFactory.getLogger(PackageDAOImpl.class);
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf)
	{
		this.sessionFactory=sf;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Package> listPackages() {
		
		Session session = this.sessionFactory.getCurrentSession();
		List<Package> packageList = session.createQuery("From Package").list();
		for(Package p:packageList){
			logger.info("Package List::" + p);
		}
		return packageList;
	}

	@Override
	public void addPackage(Package p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Package has been successfully added into the database " + p);
		
	}

	@Override
	public void updatePackage(Package p) {
	 Session session = this.sessionFactory.getCurrentSession();
	 session.update(p);
	 logger.info("Package has been successfully updated in the database " + p);
	 	
	}

	@Override
	public Package getPackageById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Package p = (Package) session.load(Package.class, new Integer(id));
		logger.info("Package has been loaded successfully");
		return p;
	}

	@Override
	public void removePackage(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Package p = (Package) session.load(Package.class, new Integer(id));
		session.delete(p);	
	}

}
