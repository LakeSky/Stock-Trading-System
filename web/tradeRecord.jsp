<!--
Designed by Shengze Wei in Chongqing Coded in Fuling
Copyright 2014 Shengze Wei. All rights reserved.
-->
<%@page import="com.stock.bean.TradeRecordBean"%>
<%@page import="com.stock.bean.UserInfoBean"%>
<%@page import="java.util.List"%>
<%@page import="com.stock.bean.StockInfoBean"%>
<%@page contentType="text/html;charset=GBK"%>
<%
	String path = request.getContextPath();
	UserInfoBean uib = (UserInfoBean) session.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
<title>交易记录查询--股票交易系统</title>
<link rel="stylesheet" href="<%=path%>/assets/css/styles.css" />
</head>
<body>
	<form method="post" action="">
		<div id="mainlist">
			<h1>股票交易系统</h1>
			<div class="mainlist">
				<h1>
					<span id="sp"> <a href="<%=path%>/servlet/MainServlet">返回主页</a>
						&nbsp;&nbsp;&nbsp;&nbsp;欢迎您：<%=uib.getName()%>&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="<%=path%>/servlet/LogoutServlet">退出系统</a>
					</span>
				</h1>
				<table width="600" border="1" id="con">
					<tr>
						<td colspan="7" nowrap class="tdc"><span id="sp">交易记录查询</span>
						</td>
					</tr>
					<tr>
						<td width="81" nowrap class="tdc"><span id="sp">股票编码</span></td>
						<td width="81" nowrap class="tdc"><span id="sp">股票名称</span></td>
						<td width="81" nowrap class="tdc"><span id="sp">交易单价</span></td>
						<td width="81" nowrap class="tdc"><span id="sp">交易数量</span></td>
						<td width="81" nowrap class="tdc"><span id="sp">购买用户</span></td>
						<td width="81" nowrap class="tdc"><span id="sp">卖出用户</span></td>
						<td width="84" nowrap class="tdc"><span id="sp">交易时间</span></td>
					</tr>
					<%
						List<TradeRecordBean> list = (List<TradeRecordBean>) request
								.getAttribute("list"); //查询的记录信息
						if (list != null) {
							for (int i = 0; i < list.size(); i++) { // 对记录信息做循环显示
								TradeRecordBean trb = (TradeRecordBean) list.get(i);
					%>
					<tr>
						<td nowrap class="tdc"><%=trb.getStockid()%></td>
						<td nowrap class="tdc"><%=trb.getStockName()%></td>
						<td nowrap class="tdc"><%=trb.getStockPrice()%></td>
						<td nowrap class="tdc"><%=trb.getTradeNumber()%></td>
						<td nowrap class="tdc"><%=trb.getBuyuserid()%></td>
						<td nowrap class="tdc"><%=trb.getSaleuserid()%></td>
						<td nowrap class="tdc"><%=trb.getTradeTime()%></td>
					</tr>
					<%
						}
						}
					%>
				</table>
				<br /> <br />
			</div>
		</div>
	</form>
	<footer>
		<div id="fd1" align="center">Copyright &copy; 2014 Shengze Wei.
			All rights reserved.</div>
	</footer>
</body>
</html>