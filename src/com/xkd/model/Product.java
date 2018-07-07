package com.xkd.model;

/**
 * 产品模型
 * @author waver
 *
 */
public class Product {
	private Integer id;
	//产品编号
	private String name;
	private String brand;
	private Integer power;
	private String tName;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Integer getPower() {
		return power;
	}
	public void setPower(Integer power) {
		this.power = power;
	}
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + "]";
	}
	
	
}
