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
import javax.servlet.http.HttpSession;

import com.stock.bean.UserInfoBean;
import com.stock.model.UserInfoModel;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=GBK");
		HttpSession session = request.getSession();
		String pathadd = request.getContextPath();
		PrintWriter out = response.getWriter();
		String rand = (String) session.getAttribute("rand");
		String input = request.getParameter("rand");
		if (rand.equals(input)) {
			String userid = request.getParameter("userid");
			String password = request.getParameter("password");
			UserInfoModel ua = new UserInfoModel();
			UserInfoBean uib = null;
			try {
				uib = ua.checkLogin(userid, password);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (uib == null)
				out.print("<script>alert('登陆失败！');location.href='login.jsp';</script>");
			else {
				session.setAttribute("user", uib);
				// System.out.println("登陆成功！");
				response.sendRedirect(pathadd + "/servlet/MainServlet");
			}
		} else {
			out.print("<script>alert('请输入正确的验证码！');location.href='login.jsp';</script>");
			// System.out.println("验证码填写错误！");
		}
	}
}