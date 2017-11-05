package com.techm.cache.dto;

import java.util.Date;

/**
 * Country class Maps to REF_COUNTRY
 * @author Niks
 *
 */
public class Country {
	private final String CONST_TABLE_NAME="COUNTRY";
	private Long id;
	private String code;
	private String name;
	private int status;
	private Date lastModified;
	private int modifiedBy;
	
	Country(){}
	
	public Country(Long id, String code, String name, int status, Date lastModified, int modifiedBy) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.status = status;
		this.lastModified = lastModified;
		this.modifiedBy = modifiedBy;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getLastModified() {
		return lastModified;
	}
	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}
	public int getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	
}
