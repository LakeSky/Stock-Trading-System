<!--
Designed by Shengze Wei in Chongqing Coded in Fuling
Copyright 2014 Shengze Wei. All rights reserved.
-->
<%@page import="com.stock.bean.UserInfoBean"%>
<%@page contentType="text/html;charset=GBK"%>
<%
	String path = request.getContextPath();
	UserInfoBean uib = (UserInfoBean) session.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
<title>股票信息管理--股票交易系统</title>
<link rel="stylesheet" href="assets/css/styles.css" />
</head>
<body>
	<form method="post" action="<%=path%>/servlet/AddStockServlet">
		<div id="mainlist">
			<h1>股票交易系统</h1>
			<div class="mainlist">
				<h1>
					<span id="sp"> <a href="<%=path%>/servlet/MainServlet">返回主页</a>
						&nbsp;&nbsp;&nbsp;&nbsp;欢迎您：<%=uib.getName()%>&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="<%=path%>/servlet/LogoutServlet">退出系统</a>
					</span>
				</h1>
				<table border="0" id="con">
					<tr>
						<td colspan="2" nowrap class="tdc"><span id="sp">股票信息管理（增加股票）</span>
						</td>
					</tr>
					<tr>
						<td colspan="2" nowrap class="tdc">&nbsp;</td>
					</tr>
					<tr>
						<td width="218" nowrap class="tdr">股票编码：</td>
						<td width="366" nowrap class="tdl"><input type="text"
							class="nt" id="stockId" name="stockId"></td>
					</tr>
					<tr>
						<td nowrap class="tdr">股票名称：</td>
						<td nowrap class="tdl"><input type="text" class="nt"
							id="stockName" name="stockName"></td>
					</tr>
					<tr>
						<td nowrap class="tdr">股票拼音缩写：</td>
						<td nowrap class="tdl"><input type="text" class="nt"
							id="stockPy" name="stockPy"></td>
					</tr>
					<tr>
						<td nowrap class="tdr">初始单价：</td>
						<td nowrap class="tdl"><input type="text" class="nt"
							id="stockPrice" name="stockPrice"></td>
					</tr>
					<tr>
						<td colspan="2" nowrap class="tdc">&nbsp;</td>
					</tr>
					<tr>
						<td colspan="2" nowrap class="tdc"><input type="submit"
							class="sm" value="增加股票" /></td>
					</tr>
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