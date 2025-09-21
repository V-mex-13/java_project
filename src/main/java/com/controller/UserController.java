package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.bean.User;
import com.dao.UserDao;

@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String action = request.getParameter("action");
	
	if(action.equalsIgnoreCase("signup"))
	{
		User u = new User();
		u.setName(request.getParameter("name"));
		u.setEmail(request.getParameter("email"));
		u.setMobile(request.getParameter("mobile"));
		u.setPassword(request.getParameter("password"));
		UserDao.signupUser(u);
		request.setAttribute("msg","signup Successfully");
		request.getRequestDispatcher("login.jsp").forward(request, response);
		
	}
	
	}

}
