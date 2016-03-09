/**
 * Designed by Shengze Wei in Chongqing Coded in Fuling
 * Copyright 2014 Shengze Wei. All rights reserved.
 */
package com.stock.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stock.model.UserInfoModel;

public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=GBK");
		PrintWriter out = response.getWriter();
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String birthday = request.getParameter("birthdayYear") + "-"
				+ request.getParameter("birthdayMonth");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		UserInfoModel ua = new UserInfoModel();
		int n = 0;
		try {
			n = ua.appendUser(userid, password, name, sex, birthday, email,
					telephone);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (n == 0)
			out.print("<script>alert('注册失败，可能您的输入有误或用户账号已经存在！');location.href='register.jsp';</script>");
		else
			out.print("<script>alert('恭喜你，注册成功！');location.href='login.jsp';</script>");
	}
}