package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.daoimpl.StudentDaoImpl;
import com.spring.pojo.StudentPojo;

@Service
public class StudentService
{
	  @Autowired
	  private StudentDaoImpl studentdaoimpl;
	  
      @Transactional
      public String insertstudentdata(StudentPojo obj)
      {
    	  return studentdaoimpl.insertstudentrecord(obj);
      }
      
      @Transactional
      public String updatestudentdata(StudentPojo obj)
      {
    	  return studentdaoimpl.updatestudentrecord(obj);
      }
     
      @Transactional
      public String deletestudentdata(int s_id)
      {
    	  return studentdaoimpl.deletetudentrecord(s_id);
      }
      
      @Transactional
      public StudentPojo show_single_record(int id)
      {
    	  System.out.println(id);
    	  return studentdaoimpl.getsinglerecord(id);
      }
      
      @Transactional
      public List<StudentPojo> show_all_record()
      {
    	  return studentdaoimpl.getallrecord();
      }
      
} 
