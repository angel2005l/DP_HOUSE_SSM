<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	if (session.getAttribute("userId") == null || session.getAttribute("userId").toString() == "") {
		response.sendRedirect("/login.jsp");
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
<link href="/style/css/bootstrap.min.css" rel="stylesheet">
<link href="/style/css/bootstrap-responsive.min.css" rel="stylesheet">
<link href="/style/css/site.css" rel="stylesheet">
<link href="/style/css/myStyle.css" rel="stylesheet" />
<!--[if lt IE 9]><script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
<script type="text/javascript" src="/style/js/jquery-3.1.1.js"></script>
</head>
<body>
	<div  class="container">
		<div class="navbar">
			<div class="navbar-inner">
				<div class="container">
					<a class="btn btn-navbar" data-toggle="collapse"
						data-target=".nav-collapse"> <span class="icon-bar"></span> <span
						class="icon-bar"></span> <span class="icon-bar"></span>
					</a> <a class="brand" href="/index.do">Admin</a>
					<div class="nav-collapse">
						<ul class="nav">
							<li><a href="/index.do">主页</a></li>
							<li><a href=>帮助</a></li>
						</ul>
						<ul class="nav pull-right">
							<li><a>欢迎 ,<span>${userName }</span></a></li>
							<li><a href="/logout.do">登出</a></li>
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
						<c:forEach items="${funcs.data }" var="b" varStatus="s">
							<li><a href="${b.funUrl }"><i class="${b.funIcon }"></i>${b.funName }</a></li>
						</c:forEach>
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
				<h2 id="sellPanelh2">消息</h2>
				<div id="sellPanel" class="well summary">
					<ul>
						<li><a href="javascript:void(0);"><span class="count">${indentCount }</span>
								订单</a></li>
						<li><a href="javascript:void(0);"><span class="count">${houseCount }</span>
								发布房源</a></li>
						<li><a href="javascript:void(0);"><span class="count">${financeCount }</span>
								收支消息</a></li>

					</ul>
				</div>
				<%-- <h2>房源信息</h2>
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
								<td><a href="" class="view-link">详情</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<ul class="pager">
					<li class="next"><a href="">更多 &rarr;</a></li>
				</ul> --%>

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