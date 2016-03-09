package com.stock.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.stock.bean.StockInfoBean;
import com.stock.model.StockQueryModel;

public class ManageStockServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=GBK");
//		String path = request.getContextPath();
		StockQueryModel sqm = new StockQueryModel();
		List<StockInfoBean> list = null;
		try {
			list = sqm.getAllStock();
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("list", list);
		request.getRequestDispatcher("/manageStock.jsp").forward(
				request, response);
	}
}