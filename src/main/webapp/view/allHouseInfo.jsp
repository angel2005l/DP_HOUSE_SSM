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
<style type="text/css">
#houseInfotable thead tr th {
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
							<li><a>欢迎 ,<span>${userName}</span></a></li>
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

						<form id="selectForm" action="/house/selHouse.do" method="post">
							<input type="hidden" name="pageNum" value="${pageNum }">
							<div style="float: left; padding-left: 20px;">
								<h4>房屋编号</h4>
								<input type="text" id="selectHid" name="selectHid"
									class="ui_input_txt02" placeholder="请输入房屋编号" value="${hid }" />

							</div>

							<div style="float: left; padding-left: 30px;">
								<h4>房屋类型</h4>
								<select id="selectHtype" name="selectHtype" class="ui_select01">
									<option value="">--请选择--</option>
									<option value="公寓" <c:if test="${type=='公寓' }">checked</c:if>>公寓</option>
									<option value="民房" <c:if test="${type=='民房' }">checked</c:if>>民房</option>
									<option value="别墅" <c:if test="${type=='别墅' }">checked</c:if>>别墅</option>
								</select>

								<!-- 	<h4>状态</h4>
								<select id="selectHsell" name="selectHsell" class="ui_select01">
									<option value="">--请选择--</option>
									<option value="出租">出租</option>
									<option value="出售">出售</option>
									<option value="转售">转售</option>
									<option value="已出售">已出售</option>
									<option value="已出租">已出租</option>
									<option value="已转售">已转售</option>
								</select> -->
							</div>
						</form>
					</div>
				</div>
				<div class="span9">
					<button type="button" id="selectBtn" class="btn btn-primary"
						style="width: 100px;">搜索</button>
				</div>
				<div class="span9">
					<h1>房源信息</h1>
					<table id="houseInfotable"
						class="table table-bordered table-striped">
						<thead>
							<tr>
								<th rowspan="2">房屋编号</th>
								<th rowspan="2">房屋名称</th>
								<th rowspan="2">房屋类型</th>
								<th colspan="2">相关面积</th>
								<th rowspan="2">状态</th>
								<th rowspan="2">价格</th>
								<th rowspan="2">房屋地址</th>
								<th rowspan="2">房屋来源者</th>
								<th rowspan="2">详情</th>
							</tr>

							<tr>
								<th>占地面积</th>
								<th>房屋面积</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${houseList }" var="houseInfo">
								<tr>
									<td>${houseInfo.houId }</td>
									<td>${houseInfo.houName }</td>
									<td>${houseInfo.houType },${houseInfo.houBed }室,${houseInfo.houLiving }厅,${houseInfo.houBath }卫</td>
									<td>${houseInfo.houFloor }</td>
									<td>${houseInfo.houBuild }</td>
									<td>${houseInfo.houStatus }</td>
									<td>${houseInfo.houMoney }</td>
									<td>${houseInfo.houAdd }</td>
									<td>${houseInfo.empId }</td>
									<td><a href="javaScript(0)" class="view-link">详情</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div class="pagination">
						<ul>
							<li class="disabled"><a
								href="/house/selHouse.do?pageSign=minus">&laquo;</a></li>
							<li class="active"><a href="#">1</a></li>
							<li><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#">4</a></li>
							<li><a href="/house/selHouse.do?pageSign=add">&raquo;</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<ul class="pager">
			<li class="next">
				<h4>房屋租赁后台管理系统1.0</h4>
			</li>
		</ul>
	</div>
	<script type="text/javascript" src="/professionalJs/allHouseInfo.js"></script>
</body>

</html>