package com.TravelExperts.Model;



import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date; //THIS MIGHT BE THE PROBLEM 
import java.util.List;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.Proxy;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.junit.experimental.theories.Theories;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Component;


@Entity
@Table(name = "packages")


//NEED TO USE JSONIGNOREPROPERTIES, and PROXY to initialize JSON format for retrieving Customer's by ID
@JsonIgnoreProperties(ignoreUnknown = false)
@Proxy(lazy = false)


//trying component and scope to see if this will allow sessions to pass
@Component
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS, value="session")
public class Package implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Package () {}
	
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name = "packageid")
private Integer packageid;

//NOTE DOES NOT LIKE CAPITALIZED LETTERS AS IT MAKES A _

@Column(name ="pkgname")
@NotEmpty(message = "Package Name must not be empty!")
private String packageName;

@DateTimeFormat(iso=ISO.DATE)
@NotNull (message = "Package must have start date")
@Column(name = "pkgstartdate")
private Date packageStartDate;

@DateTimeFormat(iso=ISO.DATE)
@NotNull (message = "Package must have end date")
@Column(name = "pkgenddate")
private Date packageEndDate;


@NotEmpty(message = "Package must have a description")
@Column(name = "pkgdesc")
@Length(max = 45, message="Description cannot be longer than 45 words!")
private String packageDescription;

@Column(name = "pkgbaseprice")
//@Size(min = (int) packageAgencyCommission)
@Min(value= 1)
@NotNull (message = "Package must have a base price")
private Double packageBasePrice;

@Min(value= 1)
@NotNull (message = "Package must have some sort of commission")
@Column(name = "pkgagencycommission")
private Double packageAgencyCommission;

@Transient
private List<PackageProductSupplier> packageProductSupplier;

@Transient
@JsonIgnore
private String formattedPackageStartDate;

@Transient
@JsonIgnore
private String formattedPackageEndDate;




public String getFormattedPackageStartDate() {
	formattedPackageStartDate = new SimpleDateFormat("dd-MMM-yyyy").format(packageStartDate);
	return formattedPackageStartDate;
}



public String getFormattedPackageEndDate() {
	formattedPackageEndDate = new SimpleDateFormat("dd-MMM-yyyy").format(packageEndDate);
	return formattedPackageEndDate;
}



public List<PackageProductSupplier> getPackageProductSupplier() {
	return packageProductSupplier;
}

public void setPackageProductSupplier(List<PackageProductSupplier> packageProductSupplier) {
	this.packageProductSupplier = packageProductSupplier;
}

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
