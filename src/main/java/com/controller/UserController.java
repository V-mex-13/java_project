package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

import java.io.IOException;

import com.bean.User;
import com.dao.UserDao;

@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("signup")) {

			Boolean flag = UserDao.checkEmail(request.getParameter("email"));
			System.out.println(flag);
			if (flag == false) {
				if (request.getParameter("password").equals(request.getParameter("confirmPassword"))) {

					User u = new User();
					u.setName(request.getParameter("name"));
					u.setEmail(request.getParameter("email"));
					u.setMobile(request.getParameter("mobile"));
					u.setPassword(request.getParameter("password"));
					UserDao.signupUser(u);
					request.setAttribute("msg", "signup Successfully");
					request.getRequestDispatcher("login.jsp").forward(request, response);

				} else {

					request.setAttribute("msg", "your password is not mache");
					request.getRequestDispatcher("signup.jsp").forward(request, response);

				}
			} else {

				request.setAttribute("msg", "your  account is allredy exist");
				request.getRequestDispatcher("signup.jsp").forward(request, response);

			}

		} else if (action.equalsIgnoreCase("login")) {
			System.out.println("innnnnnnnnnnn");
			User u = UserDao.loginUser(request.getParameter("email"));
			if (u != null) {
				if (u.getPassword().equals(request.getParameter("password"))) {

					HttpSession session = request.getSession();
					session.setAttribute("u", u);
					request.getRequestDispatcher("index.jsp").forward(request, response);

				} else {
					System.out.println(u.getPassword());
					System.out.println(request.getAttribute("password"));
					request.setAttribute("msg", "incorrect password");
					request.getRequestDispatcher("login.jsp").forward(request, response);

				}
			} else {
				request.setAttribute("msg", "email not registered");
				request.getRequestDispatcher("signup.jsp").forward(request, response);

			}
		} else if (action.equalsIgnoreCase("change-password")) {
			System.out.println(request.getParameter("oldpassword"));
			System.out.println(request.getParameter("newpassword"));
			System.out.println(request.getParameter("cpassword"));
		
			HttpSession session = request.getSession();
			 User u = (User) session.getAttribute("u");
			System.out.println(u);
			if (u.getPassword().equals(request.getParameter("oldpassword"))) {
				
				if (request.getParameter("newpassword").equals(request.getParameter("cpassword"))) {
					if (!request.getParameter("oldpassword").equals(request.getParameter("newpassword"))) {
						
						
						UserDao.changepassword(u.getEmail(), request.getParameter("newpassword"));
						response.sendRedirect("logout.jsp");

					} else {
						request.setAttribute("msg", "your new password cont be your old password");
						request.getRequestDispatcher("change-password.jsp").forward(request, response);
					}
				} else {
					request.setAttribute("msg", "your new password and conform new password  does not mach");
					request.getRequestDispatcher("change-password.jsp").forward(request, response);
				}
			} else {
				request.setAttribute("msg", "your password i incarect");
				request.getRequestDispatcher("change-password.jsp").forward(request, response);
			}
		}

	}



}
