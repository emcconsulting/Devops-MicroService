package com.emc.ps.appmod.tnt.utilities.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * The persistent class for the inventory database table.
 * 
 */
@Entity
@Table(name = "Inventory")
public class InventoryEntity implements Serializable {

	private static final long serialVersionUID = 1901032963789044117L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Integer amortizable;

	@Column(name = "assigned_to_id")
	private Integer asignedToId;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date buyDate;

	private BigDecimal cost;

	@Column(name = "department_id")
	private Integer departmentId;

	private String description;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "insert_date")
	private Date insertDate;

	private String location;

	private String model;

	@Column(name = "owner_id")
	private Integer ownerId;

	private String provider;

	private String ram;

	private Integer renting;

	@Column(name = "serial_number")
	private String serialNumber;

	private String speed;

	private String storage;

	private String trademark;

	private String type;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "update_date")
	private Date updateDate;

	public InventoryEntity() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAmortizable() {
		return this.amortizable;
	}

	public void setAmortizable(Integer amortizable) {
		this.amortizable = amortizable;
	}

	public Integer getAsignedToId() {
		return this.asignedToId;
	}

	public void setAsignedToId(Integer asignedToId) {
		this.asignedToId = asignedToId;
	}

	public Date getBuyDate() {
		return this.buyDate;
	}

	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}

	public BigDecimal getCost() {
		return this.cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public Integer getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getInsertDate() {
		return this.insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getOwnerId() {
		return this.ownerId;
	}

	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}

	public String getProvider() {
		return this.provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getRam() {
		return this.ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public Integer getRenting() {
		return this.renting;
	}

	public void setRenting(Integer renting) {
		this.renting = renting;
	}

	public String getSerialNumber() {
		return this.serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getSpeed() {
		return this.speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

	public String getStorage() {
		return this.storage;
	}

	public void setStorage(String storage) {
		this.storage = storage;
	}

	public String getTrademark() {
		return this.trademark;
	}

	public void setTrademark(String trademark) {
		this.trademark = trademark;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}