package com.spring.dao;

import java.util.List;

import com.spring.pojo.StudentPojo;

public interface StudentDao 
{
	public String insertstudentrecord(StudentPojo obj);
	
    public String updatestudentrecord(StudentPojo obj);
	
	public String deletetudentrecord(int s_id);
	
	public StudentPojo getsinglerecord(int s_id);

	public List<StudentPojo> getallrecord();
}
