package com.stock.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.stock.bean.StockInfoBean;
import com.stock.model.StockQueryModel;

public class SearchQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=GBK");
		StockQueryModel sqm = new StockQueryModel();
		String searchConnent = request.getParameter("queryKey").toUpperCase();
		List<StockInfoBean> list = null;
		try {
			list = sqm.searchQuery(searchConnent);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("list", list);
		request.getRequestDispatcher("../searchQuery.jsp").forward(request,
				response);
	}
}