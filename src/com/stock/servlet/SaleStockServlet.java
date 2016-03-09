package com.stock.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stock.bean.UserInfoBean;
import com.stock.model.StockTradeModel;

public class SaleStockServlet extends HttpServlet {
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
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String pathadd = request.getContextPath();
		String userid = ((UserInfoBean) session.getAttribute("user"))
				.getUserid();
		String stockId = request.getParameter("stockid");
		String tradeNumber = request.getParameter("tradeNumber");
		String tradePrice = request.getParameter("tradePrice");
		StockTradeModel stm = new StockTradeModel();
		int n = 0;
		try {
			n = stm.saleStock(userid, stockId, tradePrice, tradeNumber);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (n == 0)
			out.print("<script>alert('下单失败！');location.href='" + pathadd
					+ "/servlet/MainServlet';</script>");
		else
			out.print("<script>alert('下单成功！');location.href='" + pathadd
					+ "/servlet/MainServlet';</script>");
	}
}