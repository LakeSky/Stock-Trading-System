package com.stock.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stock.bean.TradeRecordBean;
import com.stock.bean.UserInfoBean;
import com.stock.model.StockQueryModel;

public class TradeRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=GBK");
		HttpSession session = request.getSession();
		String userid = ((UserInfoBean)session.getAttribute("user")).getUserid();
		StockQueryModel sqm = new StockQueryModel();
		List<TradeRecordBean> list = null;
		try {
			list = sqm.getStockRecord(userid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("list", list);
		request.getRequestDispatcher("/tradeRecord.jsp").forward(
				request, response);
	}
}