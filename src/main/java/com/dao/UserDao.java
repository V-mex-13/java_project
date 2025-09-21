package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.bean.User;
import com.util.ProjectUtil;

public class UserDao {
public static void signupUser(User u) {
	try {
		Connection conn = ProjectUtil.creatConnection();
		String sql ="insert into user(name,email,mobile,password) value(?,?,?,?)";
		PreparedStatement pst =conn.prepareStatement(sql);
		pst.setString(1,u.getName());
		pst.setString(2,u.getEmail());
		pst.setString(3,u.getMobile());
		pst.setString(2,u.getPassword());
		pst.executeUpdate();
		System.out.println(pst);
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}
}
