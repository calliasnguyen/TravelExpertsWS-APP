package com.TravelExperts.Model;

import java.io.Serializable;
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
import javax.validation.constraints.Size;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.Proxy;

import org.hibernate.validator.constraints.NotEmpty;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;


@Entity
@Table(name = "customers")


@Component //also used for sessions
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS, value="session") // used for sessions

//NEED TO USE JSONIGNOREPROPERTIES, and PROXY to initialize JSON format for retrieving Customer's by ID
@JsonIgnoreProperties(ignoreUnknown = false)
@Proxy(lazy = false)
public class Customer implements Serializable {
	
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "customerid")
	private Integer customerId;
	
	@Column(name = "custfirstname")
	@NotEmpty(message = "Customer First Name must not be empty!")
	private String customerFirstName;
	
	@Column(name = "custlastname")
	@NotEmpty(message = "Customer Last Name must not be empty!")
	private String customerLastName;
	
	@Column(name = "custaddress")
	@NotEmpty(message = "Customer address cannot be empty!")
	private String customerAddress;
	
	@Column(name = "custcity")
	@NotEmpty(message = "Customer city cannot be empty!")
	private String customerCity;
	
	@Column(name = "custprov")
	@NotEmpty(message = "Customer Province cannot be empty!")
	@Size(min=1, max=2, message="Province Code cannot be larger than 2 characters")
	private String customerProvince;
	
	@Column(name = "custpostal")
	@NotEmpty(message = "Customer Postal Code cannot be empty!")
	private String customerPostal;
	
	
	//allowed to be null
	@Column(name = "custcountry")
	private String customerCountry;
	
	
	//allowed to be null
	@Column(name="custhomephone")
	private String customerHomePhone;
	
	@Column(name="custbusphone")
	@NotEmpty(message="Customer Business Phone cannot be empty!")
	private String customerBusPhone;
	
	@Column(name="custemail")
	@NotEmpty(message="Customer email cannot be empty!")
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
	
	
	
	//This gets rid of the table constraint for entities (so that you can have an agent for a customer)
//	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@PrimaryKeyJoinColumn(name="agentid", referencedColumnName="agentId")
//	@JsonIgnore //here for if a customer does not have agent... ignore this for json format

	
	@Transient //don't look in the database for this agent
	private Agent agent;
	
	
	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public List<Booking> getBooking()
	{		
//		final BookingDAO bookingDAO = new bookingDao;
//		bookingDAO.getBookingById(104);
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
