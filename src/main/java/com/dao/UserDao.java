package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bean.User;
import com.util.ProjectUtil;

public class UserDao {
	public static void signupUser(User u) {
		try {
			Connection conn = ProjectUtil.creatConnection();
			String sql = "insert into user(name,email,mobile,password) value(?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, u.getName());
			pst.setString(2, u.getEmail());
			pst.setString(3, u.getMobile());
			pst.setString(4, u.getPassword());
			pst.executeUpdate();
			System.out.println(pst);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public static boolean checkEmail(String email) 
	{
		System.out.println(email);
		boolean flag = false;
try {
	Connection conn = ProjectUtil.creatConnection();
	String sql = "select * from user where email=?";
	PreparedStatement pst = conn.prepareStatement(sql);
	pst.setString(1, email);
	ResultSet rs = pst.executeQuery();
	
	if(rs.next()) {
		flag =true;
	}
pst.setString(1, email);

} catch (Exception e) {
	// TODO: handle exception
}

		return flag;

	}
	
	//second method
	public static  User  loginUser(String email) 
	{
		System.out.println(email);
		User u =null;
try {
	Connection conn = ProjectUtil.creatConnection();
	String sql = "select * from user where email=?";
	PreparedStatement pst = conn.prepareStatement(sql);
	pst.setString(1, email);
	ResultSet rs = pst.executeQuery();
	
	if(rs.next()) {
	u= new User();
	u.setUid(rs.getInt("uid"));
	u.setName(rs.getString("name"));
	u.setEmail(rs.getString("email"));
	u.setMobile(rs.getString("mobile"));
	u.setPassword(rs.getString("password"));
	}
pst.setString(1, email);

} catch (Exception e) {
	// TODO: handle exception
}

		return u;

	}
//	m
	public static void changepassword(String email,String password)
	{
		try {
	
		
			Connection conn = ProjectUtil.creatConnection();
			String sql ="update user set password=? where email=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, password);
			pst.setString(2, email);
			pst.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}


}
