package com.stock.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stock.bean.UserInfoBean;

public class CheckLoginFilter implements Filter {

	@Override
	public void init(FilterConfig fConfig) throws ServletException {

	}

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		HttpSession session = request.getSession();
		String pathadd = request.getContextPath();
		String ss = request.getRequestURI();
		UserInfoBean user = (UserInfoBean) session.getAttribute("user");
		if (user == null && !ss.endsWith("login.jsp")
				&& !ss.endsWith("register.jsp") && !ss.endsWith("image.jsp")) {
			response.sendRedirect(pathadd + "/login.jsp");
			return;
		}
		try {
			chain.doFilter(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}