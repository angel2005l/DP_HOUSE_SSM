<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath();
%>

<!DOCTYPE html>
<!--[if lt IE 7 ]><html lang="en" class="ie6 ielt7 ielt8 ielt9"><![endif]-->
<!--[if IE 7 ]><html lang="en" class="ie7 ielt8 ielt9"><![endif]-->
<!--[if IE 8 ]><html lang="en" class="ie8 ielt9"><![endif]-->
<!--[if IE 9 ]><html lang="en" class="ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html lang="en">
	<!--<![endif]-->

	<head>
		<meta charset="utf-8">
		<title>登录 - 房屋租赁后台管理系统</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<link href="css/bootstrap-responsive.min.css" rel="stylesheet">
		<link href="css/site.css" rel="stylesheet">
		<script type="text/javascript" src="js/jquery-3.1.1.js"></script>
		<script type="text/javascript">
			$( function() {
				$("#subBtn").bind("click",function(){
				var wId = $("input[name='employeeWid']").val();
				var wPwd = $("input[name='employeeWpwd']").val();
				var flag = true;
				if (wId == null || wId == "") {
					$("#loginWiderr").text("账号为空").css("font-size",
							10).css("color", "#FF6666");
					flag = false;
				}
				if (wPwd == null || wPwd == "") {
					$("#loginWpwderr").text("密码为空").css("font-size",
							10).css("color", "#FF6666");
					flag = false;
				}
				if(flag){
					$("#login-form").submit();
				}
				});
			});
		</script>
	</head>

	<body>
		<div id="login-page" class="container">
			<h3>欢迎访问房屋租赁管理系统</h3>
			<form id="login-form" class="well" action="<%=basePath %>/employeeController?funParam=1" method="post">
				<input type="text" class="span2" name="employeeWid" placeholder="请输入账号" />
				<span id="loginWiderr"></span><br />
				<input type="password" class="span2" name="employeeWpwd" placeholder="请输入密码" />
				<span id="loginWpwderr"></span><br />
				<label class="checkbox"> <input type="checkbox" /> 记住我 </label>
				<button type="button" id="subBtn" class="btn btn-primary">确定</button>
				<button type="button" class="btn">忘记密码</button>
			</form>
		</div>
		<ul class="pager">
			<li class="next">
				<h4>房屋租赁后台管理系统1.0</h4>
			</li>
		</ul>
		<script src="js/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script src="js/site.js"></script>
	</body>

</html>