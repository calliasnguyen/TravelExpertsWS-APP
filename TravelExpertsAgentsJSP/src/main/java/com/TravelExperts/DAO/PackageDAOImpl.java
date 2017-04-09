package com.TravelExperts.DAO;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.TravelExperts.Model.Package;
import com.TravelExperts.Model.PackageProductSupplier;
import com.TravelExperts.Model.Product;
import com.TravelExperts.Model.ProductSupplier;
import com.TravelExperts.Model.Supplier;

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
		try{
			
		
		session.delete(p);	
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage() + e.getCause());
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public Package grabProductSuppliers(int id) {
		
		Package p = null;
		
		try{
		Session session = this.sessionFactory.getCurrentSession();
		
		//Grab the package for the id supplied
		p = (Package) session.load(Package.class, new Integer(id));
		
		
		//grab the productsupplierID's  for the package
		String grabPackageProductSupplierID = "Select pps from PackageProductSupplier as pps where pps.packageId= :packageId";
		Query query = session.createQuery(grabPackageProductSupplierID);
		query.setInteger("packageId", id);
		
		
		//here is the list of packageproduct supplier for this id
		List<PackageProductSupplier> ppsList = query.list();
		

		
		
		//for each package product supplier, find the productid and supplier id
		for(PackageProductSupplier pps: ppsList)
		{
			//grabbing the product and suppliers for all pps
			String grabProductSupplier = "Select ps from ProductSupplier as ps where ps.productSupplierId = :productSupplierId";
			Query query2 = session.createQuery(grabProductSupplier);
			query2.setInteger("productSupplierId", pps.getProductSupplierId());
			
			//get the productid and supplier id for the package product supplier
			ProductSupplier ps = (ProductSupplier) query2.list().get(0);
			
			//setting the pps (packageProductSupplier) productid and supplier id by grabbing it from
			//product supplier
			
			Hibernate.initialize(ps);
			
			
			/////////////////////////////////GETTING PRODUCT NAME////////////////////////////////
			//get product name
			String getProduct = "Select p from Product as p where p.productId = :productId";
			Query getProductName = session.createQuery(getProduct);
			getProductName.setInteger("productId", ps.getProductId());
			
			//get the product name from the product get the 0th index
			Product product = (Product) getProductName.list().get(0);
			
			//setting the product name for the package
			pps.setProdName(product.getProductName());
			
			
			/////////////////////////////Getting Supplier NAME///////////////////////////////////
			//get supplier name query
			String getSupplier = "Select s from Supplier as s where s.supplierId = :supplierId";
			Query getSupplierName = session.createQuery(getSupplier);
			getSupplierName.setInteger("supplierId", ps.getSupplierId());
			
			//get the supplier name from the query result
			Supplier supplier = (Supplier) getSupplierName.list().get(0);
			
			
			//setting the supplier name for the package
			pps.setSupplierName(supplier.getSupplierName());
			
		
		}
		
		
		Hibernate.initialize(ppsList);
		p.setPackageProductSupplier(ppsList);
		
		
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		
		
		return p;
	}

	
}
