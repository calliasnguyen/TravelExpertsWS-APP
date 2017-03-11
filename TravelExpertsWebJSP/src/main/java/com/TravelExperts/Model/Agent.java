package com.TravelExperts.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name="agents")
//THIS JSONIGNOREPROPERTIES is used to resolve conflicts with Hibernate and JSON properties
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
public class Agent implements Serializable  {
	
	
	@Id
	@Column(name="agentid") 
	private Integer agentId;
	
	@Column(name="agtfirstname")
	private String agtFirstName;
	
	@Column(name="agtmiddleinitial")
	private String agtMiddleInitial;
	
	@Column(name="agtlastname")
	private String agtLastName;
	
	@Column(name="agtbusphone")
	private String agtBusPhone;
	
	@Column(name="agtemail")
	private String agtEmail;
	
	@Column(name="agtposition")
	private String agtPosition;
	
	@Column(name="agencyid")
	private Integer agencyid;
	
	

	public Integer getAgentId() {
		return agentId;
	}

	public void setAgentId(Integer agentId) {
		this.agentId = agentId;
	}

	public String getAgtFirstName() {
		return agtFirstName;
	}

	public void setAgtFirstName(String agtFirstName) {
		this.agtFirstName = agtFirstName;
	}

	public String getAgtMiddleInitial() {
		return agtMiddleInitial;
	}

	public void setAgtMiddleInitial(String agtMiddleInitial) {
		this.agtMiddleInitial = agtMiddleInitial;
	}

	public String getAgtLastName() {
		return agtLastName;
	}

	public void setAgtLastName(String agtLastName) {
		this.agtLastName = agtLastName;
	}

	public String getAgtBusPhone() {
		return agtBusPhone;
	}

	public void setAgtBusPhone(String agtBusPhone) {
		this.agtBusPhone = agtBusPhone;
	}

	public String getAgtEmail() {
		return agtEmail;
	}

	public void setAgtEmail(String agtEmail) {
		this.agtEmail = agtEmail;
	}

	public String getAgtPosition() {
		return agtPosition;
	}

	public void setAgtPosition(String agtPosition) {
		this.agtPosition = agtPosition;
	}

	public Integer getAgencyid() {
		return agencyid;
	}

	public void setAgencyid(Integer agencyid) {
		this.agencyid = agencyid;
	}
	

}
