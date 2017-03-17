package com.TravelExperts.Model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;

import javax.persistence.PrimaryKeyJoinColumn;

import javax.persistence.Table;


@Entity
@Table(name="bookings")
public class Booking implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Booking() {}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "bookingid")
	private Integer bookingId;
	
	@Column(name = "bookingdate")
	private Date bookingDate;
	
	
	@Column(name = "bookingno")
	private String bookingNumber;
	
	@Column(name = "travelercount")
	private Integer travelerCount;
	
	
	@Column(name = "customerid")
	private Integer customerid;
	
	@Column(name = "triptypeid")
	private String tripTypeId;
	
	
	@Column(name = "packageid")
	 private Integer packageid;
	
	
	//This gets rid of the table constraint for entities (so that you can use Package p)
	@ManyToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn(name="packageid", referencedColumnName="packageid")
	private Package p;
	
	public Package getPackage()
	{
		return p;
	}
	
	public void setPackage(Package p)
	{
		this.p = p;
	}
	
	

	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getBookingNumber() {
		return bookingNumber;
	}

	public void setBookingNumber(String bookingNumber) {
		this.bookingNumber = bookingNumber;
	}

	public Integer getTravelerCount() {
		return travelerCount;
	}

	public void setTravelerCount(Integer travelerCount) {
		this.travelerCount = travelerCount;
	}

	public Integer getCustomerid() {
		return customerid;
	}

	public void setCustomerid(Integer customerid) {
		this.customerid = customerid;
	}

	public String getTripTypeId() {
		return tripTypeId;
	}

	public void setTripTypeId(String tripTypeId) {
		this.tripTypeId = tripTypeId;
	}

	public Integer getPackageId() {
		return packageid;
	}

	public void setPackageId(Integer packageid) {
		this.packageid = packageid;
	}




	

	
}



