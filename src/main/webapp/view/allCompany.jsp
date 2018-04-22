<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@  taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<title>公司管理 - 房屋租赁后台管理系统</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="/style/css/bootstrap.min.css" rel="stylesheet">
<link href="/style/css/bootstrap-responsive.min.css" rel="stylesheet">
<link href="/style/css/site.css" rel="stylesheet">
<script type="text/javascript" src="/style/js/jquery-3.1.1.js"></script>
<script type="text/javascript">
	
</script>
<style type="text/css">
#houseIndentTable th {
	text-align: center;
}

#houseIndentTable tfoot td {
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
						<form id="selectForm" action="/company/selCompany.do"
							method="post">
							<input type="hidden" name="pageNum" value="${pageNum }">
							<div style="float: left; padding-left: 20px;">
								<h4>搜索</h4>
								<input type="text" id="selectBid" name="coId"
									class="ui_input_txt02" placeholder="请输入公司编号" /> <input
									type="text" id="selectBid" name="simpleName"
									class="ui_input_txt02" placeholder="请输入公司简称编号" />
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
				<h1>公司管理</h1>
				<table id="houseIndentTable"
					class="table table-bordered table-striped table-condensed">
					<thead>
						<tr>
							<th>单位编号</th>
							<th>单位别名</th>
							<th>单位名称</th>
							<th>所属地区号</th>
							<th>性质</th>
							<th>单位唯一识别码</th>
							<th>单位地址</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${companyList }" var="b">
							<tr>
								<td>${b.coId }</td>
								<td>${b.coSimpleName }</td>
								<td>${b.coName }</td>
								<td>${b.coAddCode }</td>
								<td>${b.coType }</td>
								<td>${b.coUniqueId }</td>
								<td>${b.coAdd }</td>
								<td>
									<button name="confirmBtn" class="btn btn-primary"
										<c:if test="${b.coSimpleName != null and b.coSimpleName != '' }">disabled</c:if>
										onclick="entryBtn('${b.coId }')">确认</button>
									<button name="deleteBtn" class="btn btn-danger"
										<c:if test="${b.coSimpleName != null and b.coSimpleName != '' }">disabled</c:if>
										onclick="delBtn('${b.coId }')">删除</button>
								</td>
							</tr>
						</c:forEach>
					</tbody>
					<tfoot>
						<tr>
							<td colspan="4"><a
								href="/company/selCompany.do?pageSign=minus&pageNum=${pageNum }">上一页</a></td>
							<td colspan="4"><a
								href="/company/selCompany.do?pageSign=add&pageNum=${pageNum }">下一页</a></td>
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
			$("#selectBtn").bind("click", function() {
				var selectValue = $("#selectBid").val();
				if (selectValue != null) {
					$("#selectForm").submit();
				}
			});
		});

		function entryBtn(coId) {
			var simpleName = prompt('请输入公司简称（四位大写字母）');

			/* 	if(a){alert('success')}

				else{alert('返回上一个alert')} */
			if (simpleName !=null &&simpleName != '' && simpleName.length == 4) {
				$.ajax({
					url : "/company/uptCompany.do",
					type : 'post',
					data : {
						"coId" : coId,
						"simpleName" : simpleName
					},
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

				});
			}else{
				alert("公司简称不符合要求");
				return;
			}
		}
		function delBtn(coId) {
			$.ajax({
				url : "/company/delCompany.do",
				type : "post",
				data : {
					"coId" : coId,
				},
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
	</script>
</body>

</html>