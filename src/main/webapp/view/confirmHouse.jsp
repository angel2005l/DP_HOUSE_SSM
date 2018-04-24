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
						<form id="selectForm" action="/house/selComfirmHouse.do" method="post">
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
						class="table table-bordered table-striped table-condensed">
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
							<c:forEach items="${confirmHouse }" var="houseInfo">
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
									<td><button name="confirmBtn" class="btn btn-primary"
											onclick="entryBtn('${houseInfo.houId }')">审核</button>
										<button name="deleteBtn" class="btn btn-danger"
											onclick="delBtn('${houseInfo.houId }')">删除</button></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div class="pagination">
						<ul>
							<li class="disabled"><a
								href="/house/selComfirmHouse.do?pageSign=minus&pageNum=${pageNum }">&laquo;</a></li>
							<li class="active"><a href="#">1</a></li>
							<li><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#">4</a></li>
							<li><a
								href="/house/selComfirmHouse.do?pageSign=add&pageNum=${pageNum }">&raquo;</a></li>
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
	<script type="text/javascript">
		function entryBtn(houId) {
			$.ajax({
				url : "/house/updateHouStatus.do",
				type : "post",
				data : {
					"houId" : houId,"status":'已审核'
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

		function delBtn(houId) {
			$.ajax({
				url : "/house/delHouse.do",
				type : "post",
				data : {"houId":houId},
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
	</script>
</body>

</html>