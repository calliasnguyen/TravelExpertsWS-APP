package hello;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bookingdetails")
public class BookingDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer bookingDetailId;
	
	@Column(name="itineraryno")
	private Integer itineraryNumber;
	
	@Column(name="tripstart")
	private Date tripStartDate;
	
	@Column(name="tripend")
	private Date tripEndDate;
	
	@Column(name="description")
	private String description;
	
	@Column(name="destination")
	private String destination;
	
	@Column(name="baseprice")
	private Double basePrice;
	
	@Column(name="agencycommission")
	private Double agencyCommission;
	
	@Column(name="bookingid")
	private Integer bookinId;
	
	@Column(name="regionid")
	private String regionId;
	
	@Column(name="classid")
	private String classId;
	
	@Column(name="feeid")
	private String feeId;
	
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

	public Date getTripStartDate() {
		return tripStartDate;
	}

	public void setTripStartDate(Date tripStartDate) {
		this.tripStartDate = tripStartDate;
	}

	public Date getTripEndDate() {
		return tripEndDate;
	}

	public void setTripEndDate(Date tripEndDate) {
		this.tripEndDate = tripEndDate;
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

	public Integer getBookinId() {
		return bookinId;
	}

	public void setBookinId(Integer bookinId) {
		this.bookinId = bookinId;
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

	public String getFeeId() {
		return feeId;
	}

	public void setFeeId(String feeId) {
		this.feeId = feeId;
	}

	public Integer getProductSupplierId() {
		return productSupplierId;
	}

	public void setProductSupplierId(Integer productSupplierId) {
		this.productSupplierId = productSupplierId;
	}
	

}
