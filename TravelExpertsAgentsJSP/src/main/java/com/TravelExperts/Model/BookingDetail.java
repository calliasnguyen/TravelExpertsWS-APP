package com.TravelExperts.Model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.Proxy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Entity
@Table(name="bookingdetails")


@Component
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS, value="session")

//NEED TO USE JSONIGNOREPROPERTIES, and PROXY to initialize JSON format for retrieving Bookingdetails by ID
@JsonIgnoreProperties(ignoreUnknown = false)
@Proxy(lazy = false)

public class BookingDetail implements Serializable {

	/*Default for serializable number */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column (name="bookingdetailid")
	private Integer bookingDetailId;
	
	
	@Column (name="itineraryno")
	private Integer itineraryNumber;
	
	@Column (name="tripstart")
	private Date tripStart;
	
	@Column (name="tripend")
	private Date tripEnd;
	
	@Column (name="description")
	private String description;
	
	@Column (name="destination")
	private String destination;
	
	@Column (name="baseprice")
	private Double basePrice;
	
	
	@Column (name="agencycommission")
	private Double agencyCommission;
	
	
	@Column (name="bookingid")
	private Integer bookingId;
	
	@Column (name="regionid")
	private String regionId;
	
	
	@Column (name="classid")
	private String classId;
	
	@Column(name="feeid")
	private String feeid;
	
	@Column(name="productsupplierid")
	private Integer productSupplierId;

	public Integer getBookingDetailId() {
		return bookingDetailId;
	}

	public void setBookingDetailId(Integer bookingDetailId) {
		this.bookingDetailId = bookingDetailId;
	}

	public Integer getItineraryNumber() {
		return itineraryNumber;
	}

	public void setItineraryNumber(Integer itineraryNumber) {
		this.itineraryNumber = itineraryNumber;
	}

	public Date getTripStart() {
		return tripStart;
	}

	public void setTripStart(Date tripStart) {
		this.tripStart = tripStart;
	}

	public Date getTripEnd() {
		return tripEnd;
	}

	public void setTripEnd(Date tripEnd) {
		this.tripEnd = tripEnd;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(Double basePrice) {
		this.basePrice = basePrice;
	}

	public Double getAgencyCommission() {
		return agencyCommission;
	}

	public void setAgencyCommission(Double agencyCommission) {
		this.agencyCommission = agencyCommission;
	}

	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	public String getRegionId() {
		return regionId;
	}

	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public String getFeeid() {
		return feeid;
	}

	public void setFeeid(String feeid) {
		this.feeid = feeid;
	}

	public Integer getProductSupplierId() {
		return productSupplierId;
	}

	public void setProductSupplierId(Integer productSupplierId) {
		this.productSupplierId = productSupplierId;
	}
	
	
	

}
