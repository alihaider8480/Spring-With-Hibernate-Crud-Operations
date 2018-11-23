package com.spring.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="student")
public class StudentPojo 
{ 
	@Id
	@Column(name="S_ID") 
	private int id;

    @Column(name="S_Name")
	private String name; 
	
    @Column(name="S_Cell")
    private String phone;
     
    @Column(name="S_Address")
    private String address;

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}    
}
