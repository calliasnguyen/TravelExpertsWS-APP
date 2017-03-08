package hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity //make a table out of this class
@Table(name="agents")
public class Agents {

	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private Integer agentid;
	private String agtfirstname;
	private String agtmiddleinitial;
	private String agtlastname;
	private String agtbusphone;
	private String agtemail;
	private String agtposition;
	private Integer agencyid;

	public Integer getAgentid() {
		return agentid;
	}

	public void setAgentid(Integer agentid) {
		this.agentid = agentid;
	}

	public String getAgtfirstname() {
		return agtfirstname;
	}

	public void setAgtfirstname(String agtfirstname) {
		this.agtfirstname = agtfirstname;
	}

	public String getAgtmiddleinitial() {
		return agtmiddleinitial;
	}

	public void setAgtmiddleinitial(String agtmiddleinitial) {
		this.agtmiddleinitial = agtmiddleinitial;
	}

	public String getAgtlastname() {
		return agtlastname;
	}

	public void setAgtlastname(String agtlastname) {
		this.agtlastname = agtlastname;
	}

	public String getAgtbusphone() {
		return agtbusphone;
	}

	public void setAgtbusphone(String agtbusphone) {
		this.agtbusphone = agtbusphone;
	}

	public String getAgtemail() {
		return agtemail;
	}

	public void setAgtemail(String agtemail) {
		this.agtemail = agtemail;
	}

	public String getAgtposition() {
		return agtposition;
	}

	public void setAgtposition(String agtposition) {
		this.agtposition = agtposition;
	}

	public Integer getAgencyid() {
		return agencyid;
	}

	public void setAgencyid(Integer agencyid) {
		this.agencyid = agencyid;
	}
	
	
	
}