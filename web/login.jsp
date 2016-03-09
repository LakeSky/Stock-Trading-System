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
<title>登陆页面--股票交易系统</title>
<link rel="stylesheet" href="<%=path%>/assets/css/styles.css">
<script language="javascript">
	function loadimage() {
		document.getElementById("randImage").src = "image.jsp?" + Math.random();
	}
	function check() {
		var userid = document.getElementById("userid").value;
		var password = document.getElementById("password").value;
		var rand = document.getElementById("rand").value;
		if (userid.length == 0) {
			alert("请输入账号！");
			return false;
		}
		if (password.length == 0) {
			alert("请输入密码！");
			return false;
		}
		if (rand.length == 0) {
			alert("请输入验证码！");
			return false;
		}
	}
</script>
</head>
<body>
	<form method="post" action="LoginServlet">
		<div id="umain">
			<h1>股票交易系统</h1>
			<div class="login">
				<h1>欢迎登陆</h1>
				<p>
					<input type="text" name="userid" placeholder="用户帐号">
				</p>
				<p>
					<input type="password" name="password" placeholder="密码">
				</p>
				<p>
					<input type="text" name="rand" placeholder="验证码">
				</p>
				<p>
					<img alt="验证码" name="randImage" id="randImage" src="image.jsp"
						width="60" height="20" border="1" align="absmiddle">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
						href="javascript:loadimage();">看不清点我</a>
				</p>
				<p>
					<input type="submit" value="登 陆" onclick="return check()">
				</p>
				<p>
					<input type="button" value="注 册"
						onclick="javascrtpt:window.location.href='register.jsp'">
				</p>
			</div>
		</div>
	</form>
	<footer>
		<div id="fd1" align="center">Copyright 2014 Shengze Wei. All
			rights reserved.</div>
	</footer>
</body>
</html>