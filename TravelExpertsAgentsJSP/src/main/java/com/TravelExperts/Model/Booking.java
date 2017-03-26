package com.TravelExperts.Model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import javax.persistence.Table;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.Proxy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;


@Entity
@Table(name="bookings")

@Component
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS, value="session")
public class Booking implements Serializable{

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
	private Integer bookingCustomerId;
	
	@Column(name = "triptypeid")
	private String tripTypeId;
	
	
	@Column(name = "packageid")
	 private Integer bookingPackageId;
	
	@Transient //this is to ignore any instance variables not in the database
	private String formattedDate;
	
	public String getformattedDate()
	{
		formattedDate = new SimpleDateFormat("dd-MMM-yyy").format(bookingDate);
		return formattedDate;
	}
	
	//This gets rid of the table constraint for entities (so that you can use Package p)
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn(name="packageid", referencedColumnName="packageid")
	@JsonIgnore
	@Transient //ignores package in the database until necessary
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
		return bookingCustomerId;
	}

	public void setCustomerid(Integer customerid) {
		this.bookingCustomerId = customerid;
	}

	public String getTripTypeId() {
		return tripTypeId;
	}

	public void setTripTypeId(String tripTypeId) {
		this.tripTypeId = tripTypeId;
	}

	public Integer getPackageId() {
		return bookingPackageId;
	}

	public void setPackageId(Integer packageid) {
		this.bookingPackageId = packageid;
	}




	

	
}



