package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.Student;
import com.util.DBTransaction;

public class AddDataDao
{
	
	DBTransaction db = new DBTransaction("jdbc:oracle:thin:@localhost:1521:xe","Nandu","f8hpf","student");
	
	public int addData(Student std)
	{
		int count = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		con = db.getConnection();
		String sql="insert into "+db.getTableName()+" values(?,?)";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,std.getId());
			pstmt.setString(2, std.getName());
			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return count;
		
	}

	public ArrayList<Student> showStudent()
	{
		ArrayList<Student> arrStd = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		con=db.getConnection();
		
		try {
			pstmt = con.prepareStatement("select * from "+db.getTableName());
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				Student std = new Student(rs.getInt(1),rs.getString(2));
				
				arrStd.add(std);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return arrStd;
	}
	
	
	
}
