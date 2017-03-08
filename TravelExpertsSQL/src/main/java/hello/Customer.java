package hello;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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
	
	@Column(name = "custcountry")
	private String customerCountry;
	
	@Column(name="custhomephone")
	private String customerHomePhone;
	
	@Column(name="custbusphone")
	private String customerBusPhone;
	
	@Column(name="custemail")
	private String customerEmail;
	
	@Column(name="agentid")
	private Integer agentId;
	
	
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
