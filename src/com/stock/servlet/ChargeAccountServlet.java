/**
 * Designed by Shengze Wei in Chongqing Coded in Fuling
 * Copyright 2014 Shengze Wei. All rights reserved.
 */
package com.stock.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stock.bean.UserInfoBean;
import com.stock.model.UserAccountModel;
import com.stock.model.UserInfoModel;

public class ChargeAccountServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=GBK");
		HttpSession session = request.getSession();
		String pathadd = request.getContextPath();
		String userid = ((UserInfoBean) session.getAttribute("user"))
				.getUserid();
		double charge = Double.parseDouble(request.getParameter("charge"));
		UserAccountModel uam = new UserAccountModel();
		try {
			uam.chargeAccount(userid, charge);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		UserInfoModel uim = new UserInfoModel();
		session.removeAttribute("user");
		UserInfoBean uib = null;
		try {
			uib = (UserInfoBean) uim.getUser(userid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		session.setAttribute("user", uib);
		response.sendRedirect(pathadd + "/servlet/MainServlet");
	}
}