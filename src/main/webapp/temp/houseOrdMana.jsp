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
		<title>订单管理 - 房屋租赁后台管理系统</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<link href="css/bootstrap-responsive.min.css" rel="stylesheet">
		<link href="css/site.css" rel="stylesheet">
		<script type="text/javascript" src="js/jquery-3.1.1.js"></script>
		<script type="text/javascript">
			$(function() {
				var permission = ${sessionScope.EmployeewPer };
				if (permission == 2) {
					$("#sellIndex").attr("hidden", "false");
					$("#indent").attr("hidden", "false");
					$("#insertHouse").attr("hidden", "false");
					$("#budget").attr("hidden", "false");
				}else if(permission == 1){
					$("#adminIndex").attr("hidden", "false");
					$("#employee").attr("hidden", "false");
		}
	});
</script>
		<style type="text/css">
			#houseIndentTable th {
				text-align: center;
			}
			#houseIndentTable tfoot td{
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
				<div id="box_border">
					<div id="box_center">

						<form id="selectForm" action="<%=basePath%>/indentABargainController?funParam=1" method="post">
							<div style="float: left; padding-left: 20px;">
								<h4>搜索</h4>
								<input type="text" id="selectBid" name="indentBid"
									class="ui_input_txt02" placeholder="请输入订单编号" />
								<div style="float: right; padding-left: 20px;">
									<button type="button" id="selectBtn" class="btn btn-primary"
										style="width: 100px;">搜索</button>
								</div>
							</div>
						</form>

					</div>
				</div>
				</div>
				<div class="span9">
					<h1>
						订单管理
					</h1>
					<table id="houseIndentTable" class="table table-bordered table-striped table-condensed">
						<thead>
							<tr>
								<th>
									订单编号
								</th>
								<th>
									房屋详情
								</th>
								<th>
									购买者
								</th>
								<th>
									联系方式
								</th>
								
								<th>
									订单时间
								</th>
								<th>
									订单状态
								</th>
								<th>
								操作
								</th>
								
							</tr>
						</thead>
						<tbody>
						<c:forEach items="${requestScope.IndentList }" var="indentInfo">
							<tr>
								<td>
									${indentInfo.bId }
								</td>
								<td>
									${indentInfo.hInfo }
								</td>
								<td>
									${indentInfo.vName }
								</td>
								<td>
									${indentInfo.vPhone }
								</td>
								<td>
									${indentInfo.bDate }
								</td>
								<td name="iType" >
									${indentInfo.bType }
								</td>
								<td>
									<button name="confirmBtn" class="btn btn-primary" onclick="window.location.href='<%=basePath%>/indentABargainController?funParam=3&Bid=${indentInfo.bId }'">确认</button>
									<button name="deleteBtn" class="btn btn-danger" onclick="window.location.href='<%=basePath%>/indentABargainController?funParam=2&Bid=${indentInfo.bId }'">删除</button>
								</td>
							</tr>
							</c:forEach>
						</tbody>
						<tfoot >
							<tr>
								<td colspan="3" ><a href="<%=basePath %>/indentABargainController?funParam=1&pageSign=minus">上一页</a></td>
								<td colspan="4" ><a href="<%=basePath %>/indentABargainController?funParam=1&pageSign=add">下一页</a></td>
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
			var confirmButton = document.getElementsByName('confirmBtn');
			var thvalue = document.getElementsByName('iType');
			var deleteButton = document.getElementsByName('deleteBtn');
			for (var i = 0; i < confirmButton.length; i++) {
				if (thvalue[i].innerText =="已确认") {
					confirmButton[i].disabled = true;
					deleteButton [i].disabled = true;
				}
			}
			$("#selectBtn").bind("click",function(){
				var selectValue = $("#selectBid").val();
				if(selectValue!=null){
					$("#selectForm").submit();
				}
			});
		});
	</script>
	</body>

</html>