package com.TravelExperts.Model;



import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.hibernate.annotations.Proxy;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.ScopedProxyMode;



@Entity
@Table(name="agents")

//NEED TO USE JSONIGNOREPROPERTIES, and PROXY to initialize JSON format for retrieving Agent's by ID
//error parsing using jackson for individual ID's
@JsonIgnoreProperties(ignoreUnknown = false)
@Proxy(lazy = false)


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
	@NotEmpty(message="Agent First Name cannot be empty!")
	@Length(max=19, message="Agent First Name cannot be larger than 19 characters!")
	private String agtFirstName;
	
	@Column(name="agtmiddleinitial")
	@NotEmpty(message="Agent Middle Initial cannot be empty!")
	@Size(min = 1, max = 2, message="Middle Initial cannot be more than 2 characters!")
	private String agtMiddleInitial;
	
	@Column(name="agtlastname")
	@Length(max=19, message="Last name cannot be longer than 20 characters!")
	@NotEmpty(message="Agent Last Name cannot be empty!")
	private String agtLastName;
	
	@Column(name="agtbusphone")
	@NotEmpty(message="Agent Business Phone cannot be empty!")
	private String agtBusPhone;
	
	@Column(name="agtemail")
	@Length(max=45, message="Email cannot be longer than 45 characters!")
	@NotEmpty(message="Agent Email cannot be empty!")
	private String agtEmail;
	
	@Column(name="agtposition")
	@NotEmpty(message="Agent Position cannot be empty")
	private String agtPosition;
	
	@Column(name="agencyid")
	@Min(value=0)
	@Max(value=3 )
	private Integer agencyid;
	
	//Added this to the database on myphpadmin
	@Column(name="agtauthorization")
	private String agtAuthorization;
	
	
	
	 @JsonIgnore // Never sending out the agent Authorization 
	public String getAgentAuthorization() {
		return agtAuthorization;
	}

	public void setAgentAuthorization(String agtAuthorization) {
		this.agtAuthorization = agtAuthorization;
	}
	
	

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
