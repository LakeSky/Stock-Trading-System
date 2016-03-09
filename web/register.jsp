<!--
Designed by Shengze Wei in Chongqing Coded in Fuling
Copyright 2014 Shengze Wei. All rights reserved.
-->
<%@ page contentType="text/html;charset=GBK"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<title>注册页面--股票交易</title>
<link rel="stylesheet" href="assets/css/styles.css" />
<script type="text/javascript" src="<%=path%>/assets/js/register.js"></script>
</head>
<body>
	<form method="post" action="RegisterServlet">
		<div id="umain">
			<h1>股票交易系统</h1>
			<div class="register">
				<h1>欢迎您注册账户</h1>
				<table width="100%" border="0">
					<tr>
						<td nowrap class="tdr">*用户账户：</td>
						<td class="tdl" nowrap><input type="text" id="userid"
							name="userid"></td>
						<td nowrap>（必填）</td>
					</tr>
					<tr>
						<td nowrap class="tdr">*密码：</td>
						<td class="tdl" nowrap><input type="password" id="password"
							name="password"></td>
						<td nowrap>（必填）</td>
					</tr>
					<tr>
						<td nowrap class="tdr">*确认密码：</td>
						<td class="tdl" nowrap><input type="password" id="passwordag"
							name="passwordag"></td>
						<td nowrap>（必填）</td>
					</tr>
					<tr>
						<td width="36%" nowrap class="tdr">*姓名：</td>
						<td class="tdl" width="40%" nowrap><input type="text"
							id="name" name="name"></td>
						<td width="24%" nowrap>（必填）</td>
					</tr>
					<tr>
						<td nowrap class="tdr">性别：</td>
						<td class="tdl" nowrap><label>&nbsp;&nbsp;<input
								type="radio" name="sex" value="1"> 男&nbsp;&nbsp; <input
								type="radio" name="sex" value="2"> 女
						</label></td>
						<td nowrap>&nbsp;</td>
					</tr>
					<tr>
						<td nowrap class="tdr">出生年月：</td>
						<td nowrap class="tdl"><label> &nbsp;&nbsp;<select
								name="birthdayYear">
									<option value="1990">1990</option>
									<option value="1991">1991</option>
									<option value="1992">1992</option>
									<option value="1993">1993</option>
									<option value="1994">1994</option>
									<option value="1995">1995</option>
									<option value="1996">1996</option>
									<option value="1997">1997</option>
									<option value="1998">1998</option>
									<option value="1999">1999</option>
									<option value="2000">2000</option>
							</select> 年 <select name="birthdayMonth">
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
									<option value="6">6</option>
									<option value="7">7</option>
									<option value="8">8</option>
									<option value="9">9</option>
									<option value="10">10</option>
									<option value="11">11</option>
									<option value="12">12</option>
							</select> 月
						</label></td>
						<td nowrap>&nbsp;</td>
					</tr>
					<tr>
						<td nowrap class="tdr">*电子邮箱：</td>
						<td nowrap class="tdl"><input type="text" id="email"
							name="email"></td>
						<td nowrap>（必填）</td>
					</tr>
					<tr>
						<td nowrap class="tdr">*手机号码：</td>
						<td class="tdl" nowrap><input type="text" id="telephone"
							name="telephone"></td>
						<td nowrap>（必填）</td>
					</tr>
					<tr>
						<td colspan="3"><input type="submit" value="注 册" onclick="return check()"></td>
					</tr>
				</table>

			</div>
		</div>
	</form>
	<footer>
		<div id="fd1" align="center">Copyright 2014 Shengze Wei. All
			rights reserved.</div>
	</footer>
</body>
</html>