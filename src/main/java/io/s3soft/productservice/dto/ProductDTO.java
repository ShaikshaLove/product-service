package io.s3soft.productservice.dto;

import java.util.Date;

public class ProductDTO {
	private String productName;
	private String description;
	private Double mrp;
	private Double price;
	private Integer    avialableQuantity;
	private String category;
	private Date manufactureDate;
	private Long soldUnits;
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getMrp() {
		return mrp;
	}
	public void setMrp(Double mrp) {
		this.mrp = mrp;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getAvialableQuantity() {
		return avialableQuantity;
	}
	public void setAvialableQuantity(Integer avialableQuantity) {
		this.avialableQuantity = avialableQuantity;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Date getManufactureDate() {
		return manufactureDate;
	}
	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}
	public Long getSoldUnits() {
		return soldUnits;
	}
	public void setSoldUnits(Long soldUnits) {
		this.soldUnits = soldUnits;
	}
	@Override
	public String toString() {
		return "ProductDTO [productName=" + productName + ", description=" + description + ", mrp=" + mrp + ", price="
				+ price + ", avialableQuantity=" + avialableQuantity + ", category=" + category + ", manufactureDate="
				+ manufactureDate + ", soldUnits=" + soldUnits + "]";
	}
	public ProductDTO() {
		super();
	}
}
