package com.sharad.Footwears.modal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;
@Entity
public class productmodel {
	@Id
	@Size(min=2,max=20)
	private String pid;
	@Size(min=2,max=30)
	private String pname;
	@Size(min=2,max=20)
	private String categoryid;
	@Size(min=2,max=20)
	private String supplierid;
	@Size(min=2,max=400)
	private String description;
	private int quantity;
	private double cost;
	@Transient
	MultipartFile productimage;
	
	public MultipartFile getProductimage() {
		return productimage;
	}
	public void setProductimage(MultipartFile productimage) 
	{
		this.productimage = productimage;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(String categoryid) {
		this.categoryid = categoryid;
	}
	public String getSupplierid() {
		return supplierid;
	}
	public void setSupplierid(String supplierid) {
		this.supplierid = supplierid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	

}
