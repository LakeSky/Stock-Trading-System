package com.stock.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.stock.model.StockModifyModel;

public class AddStockServlet extends HttpServlet {
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
		String pathadd = request.getContextPath();
		String stockId = request.getParameter("stockId");
		String stockName = request.getParameter("stockName").toUpperCase();
		String stockPy = request.getParameter("stockPy").toUpperCase();
		String stockPrice = request.getParameter("stockPrice");
		StockModifyModel smm = new StockModifyModel();
		int n = 0, m = 0;
		try {
			n = smm.addStockInfo(stockId, stockName, stockPy);
			if (n != 0) {
				m = smm.addStockPrice(stockId, stockPrice);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (m == 0)
			out.print("<script>alert('添加股票失败！');location.href='" + pathadd
					+ "/servlet/PricePageQueryServlet';</script>");
		else
			out.print("<script>alert('添加股票成功！');location.href='" + pathadd
					+ "/servlet/PricePageQueryServlet';</script>");
	}
}