
package com.service;

import java.util.ArrayList;

import com.bean.Student;
import com.dao.AddDataDao;


public class DataService 
{
	AddDataDao dao = new AddDataDao();
	public int addData(Student std)
	{		
		return(dao.addData(std));
	}
	
	
	public ArrayList<Student> showStudent()
	{
		return (dao.showStudent());
	}
	
	
	
	
}
