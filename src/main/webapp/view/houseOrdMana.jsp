<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@  taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<title>订单管理 - 房屋租赁后台管理系统</title>
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
				<div id="box_border">
					<div id="box_center">
						<form id="selectForm" action="/indent/selIndent.do" method="post">
							<input type="hidden" name="pageNum" value="${pageNum }">
							<div style="float: left; padding-left: 20px;">
								<h4>搜索</h4>
								<input type="text" id="selectBid" name="indentId"
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
				<h1>订单管理</h1>
				<table id="houseIndentTable"
					class="table table-bordered table-striped table-condensed">
					<thead>
						<tr>
							<th>订单编号</th>
							<th>订单信息</th>
							<th>房屋价格</th>
							<th>订单价格</th>
							<th>折扣</th>
							<th>天数</th>
							<th>顾客编码</th>
							<th>订单时间</th>
							<th>订单状态</th>
							<th>操作</th>

						</tr>
					</thead>
					<tbody>
						<c:forEach items="${IndentList }" var="b">
							<tr>
								<td>${b.indId }</td>
								<td>${b.indInfo }</td>
								<td>￥${b.houMoney }</td>
								<td>￥${b.indMoney }</td>
								<td>${b.indDiscount }</td>
								<td>${b.indDay }</td>
								<td>${b.cusId }</td>
								<td><fmt:formatDate value="${b.indDate }"
										pattern="yyyy-MM-dd HH:mm:ss" /></td>
								<td>${b.indType }</td>
								<td>
									<button name="confirmBtn" class="btn btn-primary"
									<c:if test="${b.indType != '审核中' }">disabled</c:if>
										onclick="entryBtn('${b.indId }')">确认</button>
									<button name="deleteBtn" class="btn btn-danger"
										<c:if test="${b.indType != '审核中' }">disabled</c:if>
										onclick="delBtn('${b.indId }')">删除</button>
								</td>
							</tr>
						</c:forEach>
					</tbody>
					<tfoot>
						<tr>
							<td colspan="4"><a
								href="/indent/selIndent.do?pageSign=minus&pageNum=${pageNum }">上一页</a></td>
							<td colspan="6"><a
								href="/indent/selIndent.do?pageSign=add&pageNum=${pageNum }">下一页</a></td>
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
			/* var confirmButton = document.getElementsByName('confirmBtn');
			var thvalue = document.getElementsByName('iType');
			var deleteButton = document.getElementsByName('deleteBtn');
			for (var i = 0; i < confirmButton.length; i++) {
				if (thvalue[i].innerText == "已确认") {
					confirmButton[i].disabled = true;
					deleteButton[i].disabled = true;
				}
			} */
			$("#selectBtn").bind("click", function() {
				var selectValue = $("#selectBid").val();
				if (selectValue != null) {
					$("#selectForm").submit();
				}
			});
		});

		function entryBtn(indentNum) {
			 $.ajax({
				url : "/indent/updateIndent.do",
				type : 'post',
				data : {
					"indId" : indentNum,"inx":"1"
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
		}
		function delBtn(indentNum) {
			$.ajax({
				url : "/indent/delIndent.do",
				type : "post",
				data : {
					"indId" : indentNum,"inx":"2"
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