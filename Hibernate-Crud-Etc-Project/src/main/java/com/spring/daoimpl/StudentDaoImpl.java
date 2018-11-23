package com.spring.daoimpl;

import java.util.List;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.spring.dao.StudentDao;
import com.spring.pojo.StudentPojo;

@Repository
public class StudentDaoImpl implements StudentDao
{
	@Autowired
    SessionFactory sessionfactory;
	
	@Override
	public String insertstudentrecord(StudentPojo obj) 
	{
	    sessionfactory.getCurrentSession().merge(obj);
		return "Inserted SuccessFully";
	}

	@Override
	public StudentPojo getsinglerecord(int s_id) 
	{
			return sessionfactory.getCurrentSession().get(StudentPojo.class, s_id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StudentPojo> getallrecord() 
	{
		return sessionfactory.getCurrentSession().createQuery("from StudentPojo").list();
	}

	@Override
	public String updatestudentrecord(StudentPojo obj) 
	{ 
		sessionfactory.getCurrentSession().update(obj);
		return "Updated SuccessFully";
	}


	@Override
	public String deletetudentrecord(int s_id) 
	{	
		Session session = sessionfactory.getCurrentSession();
		StudentPojo obj = session.load(StudentPojo.class,s_id);
		session.delete(obj);
		return "Deleted SuccessFully";
	}
}