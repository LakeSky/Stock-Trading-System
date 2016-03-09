package com.stock.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.stock.model.StockModifyModel;

public class DeleteStockServlet extends HttpServlet {
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
		String pathadd = request.getContextPath();
		PrintWriter out = response.getWriter();
		String stockid = request.getParameter("stockid");
		int n = 0;
		StockModifyModel smm = new StockModifyModel();
		try {
			n = smm.delStock(stockid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (n == 0)
			out.print("<script>alert('É¾³ý¹ÉÆ±Ê§°Ü£¡');location.href='" + pathadd
					+ "/servlet/ManageStockServlet';</script>");
		else
			out.print("<script>alert('É¾³ý¹ÉÆ±³É¹¦£¡');location.href='" + pathadd
					+ "/servlet/ManageStockServlet';</script>");
	}
}