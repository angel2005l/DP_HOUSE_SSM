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
<title>房屋详情-房屋租赁后台管理系统</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="/style/css/bootstrap.min.css" rel="stylesheet">
<link href="/style/css/bootstrap-responsive.min.css" rel="stylesheet">
<link href="/style/css/site.css" rel="stylesheet">
<script type="text/javascript" src="/style/js/jquery-3.1.1.js"></script>
<script type="text/javascript">
	$(function() {
		var permission = $
		{
			sessionScope.EmployeewPer
		}
		;
		if (permission == 2) {
			$("#sellIndex").attr("hidden", "false");
			$("#indent").attr("hidden", "false");
			$("#insertHouse").attr("hidden", "false");
			$("#budget").attr("hidden", "false");
		} else if (permission == 1) {
			$("#adminIndex").attr("hidden", "false");
			$("#employee").attr("hidden", "false");
		}
	});
</script>
<style type="text/css">
#houseInfotable tbody tr th {
	text-align: center;
	width: 60px;
}

#houseInfotable tbody tr td {
	text-align: center;
	width: 100px;
}

#houseInfotable tbody tr td bttton {
	text-align: left;
}
</style>
<script type="text/javascript">
	$(function() {
		//方法代替
		/* var btntype = $('#houseType').html();
		var flag = false;
		if (btntype != "出租" || btntype != "出售" || btntype != "转租") {
			flag = true;
		}
		if (flag) {
			$("#deleteBtn").attr("disabled", true);
		} */
		var houseTypeLen = $("#houseType").text().length;
		var deleteBtn = $("#deleteBtn")
		if (houseTypeLen > 2) {
			deleteBtn.attr("disabled", true);
		}
	});
	function btn_delete(num) {
		$.ajax({
			url : "/house/delHouse.do",
			type : "post",
			data : {
				"houId" : num
			},
			success : function(data) {
				var result = eval("(" + data + ")");
				alert(result.msg);
				if (result.status == 0) {
					window.location.href = "/house/selHouse.do";
				} else {
					return;
				}
			},
			error : function() {
				alert("服务器异常");
			}
		})

	}
	function btn_back() {
		window.history.go(-1);
	}
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
							<li><a>欢迎 ,<span>${userName }</span></a></li>
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
				<h1>租房详情</h1>
				<div>
					<table id="houseInfotable"
						class="table table-bordered table-striped">
						<thead>

						</thead>
						<tbody>
							<tr>
								<td rowspan="4" width="260px" height="180px">
									<div>
										<img src="/upLoadFiles/${h.houImg }" alt="房屋图片" />
									</div>
								</td>
								<th>房屋编号</th>
								<td>${h.houId }</td>
								<th>状态</th>
								<td id="houseType">${h.houType }</td>

							</tr>
							<tr>

								<th>房屋信息</th>
								<td>${h.houName }</td>
								<th>住宅面积</th>
								<td>${h.houBuild }</td>
							</tr>
							<tr>

								<th>地址</th>
								<td>${h.houAdd }</td>
								<th>价格</th>
								<td>${h.houMoney }</td>
							</tr>
							<tr>

								<th>类型</th>
								<td>${h.houType },${h.houBed }室,${h.houLiving }厅,${h.houBath }卫</td>
								<th>发布人编号</th>
								<td>${h.empId}</td>
							</tr>

							<tr>
								<td></td>
								<td colspan="2"><button id="deleteBtn"
										class="btn btn-danger" type="button"
										onclick="btn_delete('${h.houId}')">删除</button></td>
								<td colspan="2"><button type="button"
										class="btn btn-primary" onclick="btn_back();">返回</button></td>
							</tr>
						</tbody>
					</table>
				</div>
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