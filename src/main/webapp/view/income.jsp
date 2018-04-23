<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath();
%>
<%-- <%
	if (session.getAttribute("EmployeewId") == null || session.getAttribute("EmployeewId").toString() == "") {
		response.sendRedirect("login.jsp");
	}
%> --%>
<!DOCTYPEhtml>
<!--[ifltIE7]><htmllang="en"class="ie6ielt7ielt8ielt9"><![endif]-->
<!--[ifIE7]><htmllang="en"class="ie7ielt8ielt9"><![endif]-->
<!--[ifIE8]><htmllang="en"class="ie8ielt9"><![endif]-->
<!--[ifIE9]><htmllang="en"class="ie9"><![endif]-->
<!--[if(gtIE9)|!(IE)]><!-->
<html lang="en">
<!--<![endif]-->

<head>
<meta charset="utf-8">
<title>收支消息</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="/style/css/bootstrap.min.css" rel="stylesheet">
<link href="/style/css/bootstrap-responsive.min.css" rel="stylesheet">
<link href="/style/css/site.css" rel="stylesheet">
<script type="text/javascript" src="/style/js/jquery-3.1.1.js"></script>

<style type="text/css">
#IndentTableth {
	text-align: center;
}

#IndentTabletd {
	text-align: center;
}

#indentId {
	white-space: normal;
	width: 100px;
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
						<form id="selectForm" action="/finance/selFinance.do"
							method="post">
							<input type="hidden" name="pageNum" value="${pageNum }">
							<div style="float: left; padding-left: 20px;">
								<h4>搜索</h4>
									<input type="text" id="selectBid" name="finId"
										class="ui_input_txt02" placeholder="请输入财务编号" />
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
				<h1>收支消息</h1>
				<table class="table table-bordered table-striped table-condensed">
					<thead>
						<tr>
							<th>财务编号</th>
							<th>财务类型</th>
							<th>交易日期</th>
							<th>金额（元）</th>
							<th>相关订单号</th>
						</tr>
					</thead>
					<c:forEach items="${finList }" var="finInfo">
						<tr>
							<td id="indentId">${finInfo.finId }</td>
							<td>${finInfo.finType }</td>
							<td><fmt:formatDate value="${finInfo.finDate }" pattern="yyyy-MM-dd" /></td>
							<td>${finInfo.finMoney }</td>
							<td>${finInfo.indId }</td>
						</tr>
					</c:forEach>
				</table>
				<div class="pagination">
					<ul>
						<li class="disabled"><a
							href="/finance/selFinance.do?pageSign=minus&pageNum=${pageNum }">&laquo;</a></li>
						<li class="active"><a href="#"> 1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a
							href="/finance/selFinance.do?pageSign=add&pageNum=${pageNum }">&raquo;</a></li>
					</ul>
				</div>
			</div>
		</div>
		<ul class="pager">
			<li class="next">
				<h4>房屋租赁后台管理系统1.0</h4>
			</li>
		</ul>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/site.js"></script>
</body>
</html>