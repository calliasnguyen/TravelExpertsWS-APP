package com.TravelExperts.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.Proxy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "customers")
@Component //also used for sessions
@Scope("session") // used for sessions
//NEED TO USE JSONIGNOREPROPERTIES, and PROXY to initialize JSON format for retrieving Customer's by ID
@JsonIgnoreProperties(ignoreUnknown = false)
@Proxy(lazy = false)
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "customerid")
	private Integer customerId;
	
	@Column(name = "custfirstname")
	private String customerFirstName;
	
	@Column(name = "custlastname")
	private String customerLastName;
	
	@Column(name = "custaddress")
	private String customerAddress;
	
	@Column(name = "custcity")
	private String customerCity;
	
	@Column(name = "custprov")
	private String customerProvince;
	
	@Column(name = "custpostal")
	private String customerPostal;
	
	
	//allowed to be null
	@Column(name = "custcountry")
	private String customerCountry;
	
	
	//allowed to be null
	@Column(name="custhomephone")
	private String customerHomePhone;
	
	@Column(name="custbusphone")
	private String customerBusPhone;
	
	@Column(name="custemail")
	private String customerEmail;
	
	
	//allowed to be null
	@Column(name="agentid")
	private Integer agentId;
	
	
	
	
	//This gets rid of the table constraint for entities (so that you can have a list of bookings for a customer)
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn(name="customerid", referencedColumnName="customerid")
	@JsonIgnore //here for if a customer does not have bookings... ignore this for json format
	@Transient // dont look for this in the database
	private List<Booking> bookings;
	
	public List<Booking> getBooking()
	{
		return bookings;
	}
	
	public void setBookings(List<Booking> bookings)
	{
		this.bookings = bookings;
	}
	
	
	
	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerFirstName() {
		return customerFirstName;
	}

	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}

	public String getCustomerLastName() {
		return customerLastName;
	}

	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerCity() {
		return customerCity;
	}

	public void setCustomerCity(String customerCity) {
		this.customerCity = customerCity;
	}

	public String getCustomerProvince() {
		return customerProvince;
	}

	public void setCustomerProvince(String customerProvince) {
		this.customerProvince = customerProvince;
	}

	public String getCustomerPostal() {
		return customerPostal;
	}

	public void setCustomerPostal(String customerPostal) {
		this.customerPostal = customerPostal;
	}

	public String getCustomerCountry() {
		return customerCountry;
	}

	public void setCustomerCountry(String customerCountry) {
		this.customerCountry = customerCountry;
	}

	public String getCustomerHomePhone() {
		return customerHomePhone;
	}

	public void setCustomerHomePhone(String customerHomePhone) {
		this.customerHomePhone = customerHomePhone;
	}

	public String getCustomerBusPhone() {
		return customerBusPhone;
	}

	public void setCustomerBusPhone(String customerBusPhone) {
		this.customerBusPhone = customerBusPhone;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public Integer getAgentId() {
		return agentId;
	}

	public void setAgentId(Integer agentId) {
		this.agentId = agentId;
	}
	
	
}
