package com.TravelExperts.Model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="packages_products_suppliers")
public class PackageProductSupplier {

	
	@Id
	@Column(name="productsupplierid") 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer ProductSupplierId;
	
	
	@Column(name="packageid") 
	private Integer packageId;

	
	
	@Transient
	private String prodName;
	
	@Transient
	private String supplierName;
	
	



	public String getProdName() {
		return prodName;
	}


	public void setProdName(String prodName) {
		this.prodName = prodName;
	}


	public String getSupplierName() {
		return supplierName;
	}


	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}


	public Integer getProductSupplierId() {
		return ProductSupplierId;
	}


	public void setProductSupplierId(Integer productSupplierId) {
		ProductSupplierId = productSupplierId;
	}


	public Integer getPackageId() {
		return packageId;
	}


	public void setPackageId(Integer packageId) {
		packageId = packageId;
	}
	
	
}
