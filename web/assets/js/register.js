/**
 * Designed by Shengze Wei in Chongqing Coded in Fuling Copyright 2014 Shengze
 * Wei. All rights reserved.
 */
function check() {
	var userid = document.getElementById("userid").value;
	var password = document.getElementById("password").value;
	var passwordag = document.getElementById("passwordag").value;
	var name = document.getElementById("name").value;
	var sex = document.getElementsByName("sex");
	var email = document.getElementById("email").value;
	var telephone = document.getElementById("telephone").value;
	if (userid.length == 0) {
		alert("请输入账号！");
		return false;
	}
	if (password.length == 0) {
		alert("请输入密码！");
		return false;
	}
	if (passwordag.length == 0) {
		alert("请输入确认密码！");
		return false;
	}
	if (name.length == 0) {
		alert("请输入姓名！");
		return false;
	}
	if (sex[0].checked == false && sex[1].checked == false) {
		alert("请选择性别！");
		return false;
	}
	if (email.length == 0) {
		alert("请输入电子邮箱！");
		return false;
	}
	if (telephone.length == 0) {
		alert("请输入电话号码！");
		return false;
	}
	if (password != passwordag) {
		alert("两次密码输入不一致！");
		return false;
	}
	if (!checkEmail(email)) {
		alert("电子邮箱输入不合法！");
		return false;
	}
	if (!checkTel(telephone)) {
		alert("电话号码输入不合法！");
		return false;
	}
}
function checkEmail(email) {
	var str = email;
	var Expression = /\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/;
	var objExp = new RegExp(Expression);
	if (objExp.test(str) == true) {
		return true;
	} else {
		return false;
	}
}
function checkTel(tel) {
	var str = tel;
	var Expression = /((\d{11})|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$)/;
	var objExp = new RegExp(Expression);
	if (objExp.test(str) == true) {
		return true;
	} else {
		return false;
	}
}