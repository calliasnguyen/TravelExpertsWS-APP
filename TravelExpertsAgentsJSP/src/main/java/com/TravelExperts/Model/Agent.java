package com.TravelExperts.Model;



import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.ScopedProxyMode;



@Entity
@Table(name="agents")

//trying component and scope to see if this will allow sessions to pass
@Component
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS, value="session")
public class Agent implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="agentid") 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
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
