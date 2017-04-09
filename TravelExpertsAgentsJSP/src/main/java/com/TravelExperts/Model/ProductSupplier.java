package com.TravelExperts.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="products_suppliers")
public class ProductSupplier {

	@Id
	@Column(name="productsupplierid")
	private Integer productSupplierId;
	
	@Column(name="productid")
	private Integer productId;
	
	@Column(name="supplierid")
	private Integer supplierId;

	public Integer getProductSupplierId() {
		return productSupplierId;
	}

	public void setProductSupplierId(Integer productSupplierId) {
		this.productSupplierId = productSupplierId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}
	
	

	
	
	
	
}
