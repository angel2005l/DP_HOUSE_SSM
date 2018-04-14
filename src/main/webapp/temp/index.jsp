<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath();
%>
<%
	if (session.getAttribute("EmployeewId") == null || session.getAttribute("EmployeewId").toString() == "") {
		response.sendRedirect("login.jsp");
	}
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
<title>主页 - 房屋租赁后台管理系统</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap-responsive.min.css" rel="stylesheet">
<link href="css/site.css" rel="stylesheet">
<link href="css/myStyle.css" rel="stylesheet" />
<!--[if lt IE 9]><script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
<script type="text/javascript" src="js/jquery-3.1.1.js"></script>
<script type="text/javascript">
	$(function() {
		var permission = ${sessionScope.EmployeewPer };
		if (permission == 2) {
			$("#sellIndex").attr("hidden", "false");
			$("#indent").attr("hidden", "false");
			$("#insertHouse").attr("hidden", "false");
			$("#budget").attr("hidden", "false");
			$("#sellPanelh2").attr("hidden", "false");
			$("#sellPanel").hide();
		}else if(permission == 1){
			$("#adminIndex").attr("hidden", "false");
			$("#employee").attr("hidden", "false");
		}
	});
</script>
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
							<li><a>欢迎 ,<span>${sessionScope.EmployeewName }</span></a></li>
							<li><a href="<%=basePath%>/login.jsp">登出</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="span3">
				<div class="well" style="padding: 8px 0;">
					<ul class="nav nav-list">
						<li class="nav-header">菜单</li>
							<li id="sellIndex">
								<a href="<%=basePath%>/houseController?funParam=1"><i class="icon-home"></i> 主页</a>
							</li>
							<li id="adminIndex" >
								<a href="<%=basePath%>/houseController?funParam=5"><i class="icon-home"></i> 主页</a>
							</li>
							<li>
								<a href="<%=basePath%>/houseController?funParam=4"><i class="icon-list-alt"></i> 房源信息</a>
							</li>
							<li id="indent">
								<a href="<%=basePath%>/indentABargainController?funParam=1"><i class="icon-folder-open"></i> 订单信息</a>
							</li>
							<li id="insertHouse">
								<a href="<%=basePath%>/insertHouse.jsp"><i class="icon-check"></i> 发布房源信息</a>
							</li>
							<li id="budget">
								<a href="<%=basePath%>/indentABargainController?funParam=5"><i class="icon-envelope"></i> 收支消息</a>
							</li>
							<li>
								<a href="<%=basePath%>/bargainSearch.jsp"><i class="icon-file"></i> 合同管理</a>
							</li>
							<li id="employee">
								<a href="<%=basePath%>/employeeController?funParam=3"><i class="icon-book"></i> 员工管理</a>
							</li>
					<li class="nav-header">账户设置</li>
						<li>
							<a href="#"><i class="icon-user"></i> 个人信息</a>
						</li>
					</ul>
				</div>
			</div>
			<div class="span9">
				<h1>主页</h1>
				<div style="color: #CCCC99" class="hero-unit mydivbimg">
					<h3>
						欢迎 <span style="color: #CC0033; text-decoration: underline">${sessionScope.EmployeewName }</span>
						登录系统

					</h3>
					<p>您将体验便捷的房屋租赁管理服务</p>
				</div>
				<h2 id = "sellPanelh2">消息</h2>
				<div id = "sellPanel" class="well summary">
					<ul>
						<li><a href="<%=basePath%>/indentABargainController?funParam=1"><span class="count">${sellIndentNum }</span>
								订单</a></li>
						<li><a href="<%=basePath%>/houseController?funParam=4"><span
								class="count">${sellHouseNum }</span> 发布房源</a></li>
						<li><a href="<%=basePath%>/indentABargainController?funParam=5"><span class="count">${sellIncomeNum }</span>
								收支消息</a></li>
						
					</ul>
				</div>
				<h2>房源信息</h2>
				<table class="table table-bordered table-striped">
					<thead>
						<tr>
							<th>房屋编号</th>
							<th>房屋住宅面积</th>
							<th>房源地址</th>
							<th>房屋类型</th>
							<th>详情</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${requestScope.houseList }" var="houseInfo">
							<tr>
								<td>${houseInfo.hId }</td>
								<td>${houseInfo.hBuild }平米</td>
								<td>${houseInfo.hAdd }</td>
								<td>${houseInfo.hType },${houseInfo.hBed }室,${houseInfo.hLiving }厅,${houseInfo.hBath }卫</td>
								<td><a
									href="<%=basePath %>/houseController?funParam=3&selectHid=${houseInfo.hId}"
									class="view-link">详情</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<ul class="pager">
					<li class="next"><a
						href="<%=basePath%>/houseController?funParam=4">更多 &rarr;</a></li>
				</ul>

			</div>
		</div>
		<ul class="pager">
			<li class="next">
				<h4>房屋租赁后台管理系统1.0</h4>
			</li>
		</ul>
	</div>
</body>
</html>