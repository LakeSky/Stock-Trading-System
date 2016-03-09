package com.stock.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stock.bean.StockInfoBean;
import com.stock.model.StockQueryModel;

public class PricePageQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = request.getParameter("page"); // 从页面获得要显示的页码
		StockQueryModel sqm = new StockQueryModel(); // 实例化了一个分页查询的模型 M层
		List<StockInfoBean> list = null;
		int pageNum = 1; // 显示第几页
		int pageTotal = 0; // 总页数
		int pageContent = 3; // 每页显示记录条数
		int count = 0; // 数据库总记录数
		try {
			count = sqm.count(); // 通过模型类的方法获得数据库记录总数
			if (count > 0) {
				pageTotal = count / pageContent; // 计算页数
				if (pageTotal * pageContent != count) { // 处理余数
					pageTotal = pageTotal + 1;
				}
			}
			if (page != null) { // 如果获得的显示页码值不为空
				pageNum = Integer.parseInt(page); // 做数据类型的转换
			}
			list = sqm.pageListStockPrice(pageNum, pageContent); // 调用模型，进行分页查询，返回分页显示的数据
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("pageTotal", pageTotal);
		request.setAttribute("list", list);
		request.getRequestDispatcher("../priceQuery.jsp").forward(request,
				response);
	}
}