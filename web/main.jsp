<!--
Designed by Shengze Wei in Chongqing Coded in Fuling
Copyright 2014 Shengze Wei. All rights reserved.
-->
<%@page import="java.util.List"%>
<%@page import="com.stock.bean.StockInfoBean"%>
<%@page import="com.stock.bean.UserInfoBean"%>
<%@page contentType="text/html;charset=GBK"%>
<%
	String path = request.getContextPath();
	UserInfoBean uib = (UserInfoBean) session.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
<title>业务菜单--股票交易系统</title>
<link rel="stylesheet" href="<%=path%>/assets/css/styles.css" />
</head>
<body>
	<form method="post" action="">
		<div id="mainlist">
			<h1>股票交易系统</h1>
			<div class="mainlist">
				<h1>
					<span id="sp">
						<span id="sp">
							欢迎您：<%=uib.getName()%>&nbsp;&nbsp;&nbsp;&nbsp;
							<a href="<%=path%>/servlet/LogoutServlet">退出系统</a>
					</span>
					</span>
				</h1>
				<div>
					<table width="250" border="0" id="con1">
						<tr>
							<td width="117" nowrap class="tdr"></td>
							<td width="117" nowrap class="tdl"></td>
						</tr>
						<tr>
							<td colspan="2" nowrap class="tdc">您的账户资金</td>
						</tr>
						<tr>
							<td colspan="2" nowrap class="tdc"><%=uib.getAccountBalance()%></td>
						</tr>
						<tr>
							<td colspan="2" nowrap class="tdc">&nbsp;</td>
						</tr>
						<tr>
							<td colspan="2" nowrap class="tdc">
								<span id="sp">请选择业务类型</span>
							</td>
						</tr>
						<tr>
							<td colspan="2" nowrap class="tdc">&nbsp;</td>
						</tr>
						<tr>
							<td colspan="2" nowrap class="tdc">
								<a href="<%=path%>/servlet/PricePageQueryServlet">实时股价查询</a>
							</td>
						</tr>
						<tr>
							<td colspan="2" nowrap class="tdc">
								<a href="<%=path%>/chargeAccount.jsp">帐户充值</a>
							</td>
						</tr>
						<tr>
							<td colspan="2" nowrap class="tdc">
								<a href="<%=path%>/servlet/TradeRecordServlet">股票交易记录查询</a>
							</td>
						</tr>
						<tr>
							<td colspan="2" nowrap class="tdc">
								<a href="<%=path%>/servlet/ManageStockServlet">股票信息管理</a>
							</td>
						</tr>
						<tr>
							<td colspan="2" nowrap class="tdc">&nbsp;</td>
						</tr>

					</table>
					<table width="550" border="0" id="con2">
						<tr>
							<td colspan="6" nowrap class="tdc">
								<span id="sp">您持有的股票信息</span>
							</td>
						</tr>
						<tr>
							<td width="86" nowrap class="tdc">股票编码</td>
							<td width="86" nowrap class="tdc">股票名称</td>
							<td width="86" nowrap class="tdc">持有数量</td>
							<td width="86" nowrap class="tdc">最新单价</td>
							<td width="86" nowrap class="tdc">市值金额</td>
							<td width="86" nowrap class="tdc">相关操作</td>
						</tr>
						<%
						List<StockInfoBean> list = (List<StockInfoBean>) request
								.getAttribute("ownlist"); //查询的记录信息
						if (list != null) {
							for (int i = 0; i < list.size(); i++) { // 对记录信息做循环显示
								StockInfoBean si = (StockInfoBean) list.get(i);
								String salelink = path + "/saleStock.jsp?stockid="
										+ si.getStockid();
					%>
						<tr>
						<td width="86" nowrap class="tdc"><%=si.getStockid()%></td>
						<td width="86" nowrap class="tdc"><%=si.getStockName()%></td>
						<td width="86" nowrap class="tdc"><%=si.getStockNum()%></td>
						<td width="86" nowrap class="tdc"><%=si.getStockPrice()%></td>
						<td width="86" nowrap class="tdc"><%=Double.parseDouble(si.getStockPrice())*Double.parseDouble(si.getStockNum())%></td>
						<td width="86" nowrap class="tdc"><a href="<%=salelink%>">卖出</a></td>
					</tr>
					<%
						}
						}
					%>
					</table>
				</div>
			</div>
		</div>
	</form>
	<footer>
		<div id="fd1" align="center">Copyright 2014 Shengze Wei. All
			rights reserved.</div>
	</footer>
</body>
</html>