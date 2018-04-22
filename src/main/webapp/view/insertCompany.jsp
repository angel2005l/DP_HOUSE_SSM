<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath();
%>
<%-- <%
	if (session.getAttribute("EmployeewId") == null || session.getAttribute("EmployeewId").toString() == "") {
		response.sendRedirect("login.jsp");
	}
%> --%>
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
<title>发布房源 - 房屋租赁后台管理系统</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="/style/css/bootstrap.min.css" rel="stylesheet">
<link href="/style/css/bootstrap-responsive.min.css" rel="stylesheet">
<link href="/style/css/site.css" rel="stylesheet">
<link href="/style/css/myStyle.css" rel="stylesheet" />
<script type="text/javascript" src="/style/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="/style/js/jquery.form.js"></script>

<!--[if lt IE 9]><script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
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
				<h1>公司注册模拟</h1>
				<form id="newInHouse" class="form-horizontal" method="post">
					<fieldset>
							<legend>发布公司信息</legend>
					<div class="control-group">
						<label class="control-label" for="newCoName">公司名称</label>
						<div class="controls">
							<input type="text" class="input-xlarge" id="newCoName" name="coName"
								placeholder="请输入公单位名称" /><span id="coNameerr"></span>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="newCoAddCode">单位所属地区编号</label>
						<div class="controls">
							<input type="text" class="input-xlarge" id="newCoAddCode" name="coAddCode"
								placeholder="请输入单位所属地区编号" /><span id="coAddCodeerr"></span>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="newCoType">单位类型</label>
						<div class="controls">
							<select id="newCoType" name="coType">
								<option value="">请选择单位类型</option>
								<option value="个人">个人</option>
								<option value="企业">企业</option>
							</select><span id="coTypeerr"></span>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="newCoUniqueId">单位唯一识别码</label>
						<div class="controls">
							<input type="text" class="input-xlarge" id="newCoUniqueId" name="coUniqueId"
								placeholder="请输入单位唯一识别码" /><span id="coUniqueIderr"></span>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="newCoAdd">单位地址</label>
						<div class="controls">
							<input type="text" class="input-xlarge" id="newCoAdd" name="coAdd"
								placeholder="请输入单位地址" /><span id="coAdderr"></span>
						</div>
					</div>
						</fieldset>
					</form>
					<div class="form-actions">
						<button id="saveBtn" type="button" class="btn btn-primary" >保存</button>
						<button type="reset" class="btn btn-primary">重置</button>
					</div>
			</div>
		</div>
		<ul class="pager">
			<li class="next">
				<h4>房屋租赁后台管理系统1.0</h4>
			</li>
		</ul>
		</div>
<script type="text/javascript" src="/professionalJs/insertCompany.js"></script>
</body>

</html>