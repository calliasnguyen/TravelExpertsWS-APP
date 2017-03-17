package com.TravelExperts.Model;



import java.sql.Date;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.Proxy;


@Entity
@Table(name = "packages")
//@IdClass(Package.class)

//NEED TO USE JSONIGNOREPROPERTIES, and PROXY to initialize JSON format for retrieving Customer's by ID
@JsonIgnoreProperties(ignoreUnknown = false)
@Proxy(lazy = false)
public class Package {

	public Package () {}
	
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name = "packageid")

private Integer packageid;

//NOTE DOES NOT LIKE CAPITALIZED LETTERS AS IT MAKES A _

@Column(name ="pkgname")
private String packageName;

@Column(name = "pkgstartdate")
private Date packageStartDate;


@Column(name = "pkgenddate")
private Date packageEndDate;

@Column(name = "pkgdesc")
private String packageDescription;

@Column(name = "pkgbaseprice")
private Double packageBasePrice;

@Column(name = "pkgagencycommission")
private Double packageAgencyCommission;

public Integer getPackageid() {
	return packageid;
}

public void setPackageid(Integer packageid) {
	this.packageid = packageid;
}

public String getPackageName() {
	return packageName;
}

public void setPackageName(String packageName) {
	this.packageName = packageName;
}

public Date getPackageStartDate() {
	return packageStartDate;
}

public void setPackageStartDate(Date packageStartDate) {
	this.packageStartDate = packageStartDate;
}

public Date getPackageEndDate() {
	return packageEndDate;
}

public void setPackageEndDate(Date packageEndDate) {
	this.packageEndDate = packageEndDate;
}

public String getPackageDescription() {
	return packageDescription;
}

public void setPackageDescription(String packageDescription) {
	this.packageDescription = packageDescription;
}

public Double getPackageBasePrice() {
	return packageBasePrice;
}

public void setPackageBasePrice(Double packageBasePrice) {
	this.packageBasePrice = packageBasePrice;
}

public Double getPackageAgencyCommission() {
	return packageAgencyCommission;
}

public void setPackageAgencyCommission(Double packageAgencyCommission) {
	this.packageAgencyCommission = packageAgencyCommission;
}

//@Override
//public String toString() {return this.packageDescription.toString();}

}
