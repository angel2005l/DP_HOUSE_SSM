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
<title>房源信息 - 房屋租赁后台管理系统</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="/style/css/bootstrap.min.css" rel="stylesheet">
<link href="/style/css/bootstrap-responsive.min.css" rel="stylesheet">
<link href="/style/css/site.css" rel="stylesheet">
<script type="text/javascript" src="/style/js/jquery-3.1.1.js"></script>
<script type="text/javascript" src="/style/js/jquery.form.js"></script>
<style type="text/css">
#empInfotable th {
	text-align: center;
}

#empInfotable td {
	text-align: center;
}
</style>

</head>

<body>
	<div class="container">
		<div class="navbar">
			<div class="navbar-inner">
				<div class="container">
					<a class="btn btn-navbar" data-toggle="collapse"
						data-target=".nav-collapse"> <span class="icon-bar"></span> <span
						class="icon-bar"></span> <span class="icon-bar"></span>
					</a> <a class="brand" href="<%=basePath%>/houseController?funParam=1">Admin</a>
					<div class="nav-collapse">
						<ul class="nav">
							<li><a href="<%=basePath%>/houseController?funParam=1">主页</a>
							</li>
							<li><a href=>帮助</a></li>
						</ul>
						<ul class="nav pull-right">
							<li><a>欢迎 ,<span>${userName }</span></a></li>
							<li><a href="<%=basePath%>/login.jsp">登出</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="span2">
				<div class="well" style="padding: 8px 0;">
					<ul class="nav nav-list">
						<li class="nav-header">菜单</li>
						<li id="sellIndex"><a
							href="<%=basePath%>/houseController?funParam=1"><i
								class="icon-home"></i> 主页</a></li>
						<li id="adminIndex"><a
							href="<%=basePath%>/houseController?funParam=5"><i
								class="icon-home"></i> 主页</a></li>
						<li><a href="<%=basePath%>/houseController?funParam=4"><i
								class="icon-list-alt"></i> 房源信息</a></li>
						<li id="indent"><a
							href="<%=basePath%>/indentABargainController?funParam=1"><i
								class="icon-folder-open"></i> 订单信息</a></li>
						<li id="insertHouse"><a href="<%=basePath%>/insertHouse.jsp"><i
								class="icon-check"></i> 发布房源信息</a></li>
						<li id="budget"><a
							href="<%=basePath%>/indentABargainController?funParam=5"><i
								class="icon-envelope"></i> 收支消息</a></li>
						<li><a href="<%=basePath%>/bargainSearch.jsp"><i
								class="icon-file"></i> 合同管理</a></li>
						<li id="employee"><a
							href="<%=basePath%>/employeeController?funParam=3"><i
								class="icon-book"></i> 员工管理</a></li>
						<li class="nav-header">账户设置</li>
						<li><a href="#"><i class="icon-user"></i> 个人信息</a></li>
					</ul>
				</div>
			</div>
			<div class="span9">
				<div id="box_border">
					<div id="box_center">

						<form id="selectForm" action="/employee/selEmployee.do"
							method="post">
							<input type="hidden" name="pageNum" value="${pageNum }">
							<div style="float: left; padding-left: 20px;">
								<h4>搜索</h4>
								<input type="text" id="selectWid" name="empId"
									class="ui_input_txt02" placeholder="请输入员工编号" />
								<div style="float: right; padding-left: 20px;">
									<button type="button" id="selectBtn" class="btn btn-primary"
										style="width: 100px;">搜索</button>
								</div>
							</div>
						</form>
						<form id="excelFile" action="/employee/insEmpInfo.do"
							method="post" enctype="multipart/form-data">
							<div style="float: left; padding-left: 20px;">
								<h4>员工注册</h4>
								<input type="file" id="exceluUpload" name="employeeInfo"
									class="ui_input_txt02" />
								<div style="float: right; padding-left: 20px;">
									<button type="button" id="uploadtBtn" class="btn btn-primary"
										style="width: 100px;">提交</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
			<div class="span9">
				<h1>员工信息</h1>
				<table id="empInfotable"
					class="table table-bordered table-striped table-condensed">
					<thead>
						<tr>
							<th colspan="6"><span>${userCoId }</span>员工信息</th>
						</tr>
						<tr>
							<th colspan="2">员工数：</th>
							<td><span>${empNum }</span>人</td>
							<th colspan="2">公司总成交金额：</th>
							<td>￥<span>${moneyNum }</span></td>
						</tr>
						<tr>
							<th>员工编号</th>
							<th>员工账号</th>
							<th>员工姓名</th>
							<th>电话</th>
							<th>邮箱</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${empList }" var="empInfo">
							<tr>
								<td>${empInfo.empId }</td>
								<td>${empInfo.empAccount }</td>
								<td>${empInfo.empName }</td>
								<td>${empInfo.empPhone }</td>
								<td>${empInfo.empEmail }</td>
								<td>
									<button class="btn btn-primary">详情</button>
									<button name="delete" class="btn btn-danger"
										onclick="delEmp('${empInfo.empId }')">删除</button>
								</td>
							</tr>
						</c:forEach>
					</tbody>
					<tfoot align="center">
						<tr>
							<td colspan="3"><a
								href="/employee/selEmployee.do?pageSign=minus&&pageNum=${pageNum }">上一页</a></td>
							<td colspan="3"><a
								href="/employee/selEmployee.do?pageSign=add&&pageNum=${pageNum }">下一页</a></td>
						</tr>
					</tfoot>
				</table>
			</div>
		</div>
		<ul class="pager">
			<li class="next">
				<h4>房屋租赁后台管理系统1.0</h4>
			</li>
		</ul>
	</div>
	<script>
		$(function() {
			/* 
			var buttonNum = document.getElementsByName('delete');
			var thvalue = document.getElementsByName('money');
			var buttonType = document.getElementsByName('delete');
			for (var i = 0; i < buttonNum.length; i++) {
				if (thvalue[i].innerText != "0.0") {
					buttonType[i].disabled = true;
				}
			} */
			$("#uploadtBtn").bind("click", function() {
				var loadInput = $("#exceluUpload").val();
				if (loadInput != null) {
					//$("#excelFile").submit();
					$("#excelFile").ajaxSubmit({
						url : "/employee/insEmpInfo.do",
						type : "post",
						success : function(data) {
							var result = eval("(" + data + ")");
							alert(result.msg);
							if (result.status == 0) {
								location.reload();
							} else {
								return;
							}
						},
						error : function() {
							alert("服务器异常");
						}
					})
				}
			});
			$("#selectBtn").bind("click", function() {
				var selectInput = $("#selectWid").val();
				if (selectInput != null) {
					$("#selectForm").submit();
				}
			});
		});
		function delEmp(empId) {
			$.ajax({
				url : "/employee/delEmp.do",
				type : "post",
				data : {
					"empId" : empId
				},
				success : function(data) {
					var result = eval("(" + data + ")");
					alert(result.msg)
					if (result.status == 0) {
						location.reload();
					} else {
						return;
					}
				},
				error : function() {
					alert("服务器异常");
				}
			})
		}
	</script>
</body>
</html>