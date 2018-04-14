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
<title>发布房源 - 房屋租赁后台管理系统</title>
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
</head>

<body>
<script type="text/javascript">
	$(function() {
		$("#saveBtn").bind("click", function() {
			var houseInfo = $("#newHouseInfo").val();
			var houseAdd = $("#newHouseAdd").val();
			var houseType = $("#newHouseType").val();
			var houseSell = $("#newHouseSell").val();
			var houseFloor = $("#newHouseFloor").val();
			var houseBuild = $("#newHouseBuild").val();
			var houseMoney = $("#newHouseMoney").val();
			var houseBed = $("#newHouseBed").val();
			var houseBath = $("#newHouseBath").val();
			var houseLiving = $("#newHouseLiving").val();
			var flag = true;
			
			 //判断房屋信息不为空
			if (houseInfo == null || houseInfo == "") {
				$("#houseInfoerr").text("房屋信息不为空").css("font-size", 10)
						.css("color", "#FF6666");
				flag = false;
			}
			//判断房屋地址不为空
			if (houseAdd == null || houseAdd == "") {
				$("#houseAdderr").text("房屋地址不为空").css("font-size", 10)
						.css("color", "#FF6666");
				flag = false;
			}
			//判断房屋类型不为空
			if (houseType == null || houseType == "") {
				$("#houseTypeerr").text("房屋类型不为空").css("font-size", 10)
						.css("color", "#FF6666");
				flag = false;
			}
			//判断房屋出售方式不为空 select
			if (houseSell == null || houseSell == "") {
				$("#houseSellerr").text("未选择出售方式").css("font-size", 10)
						.css("color", "#FF6666");
				flag = false;
			}
			//判断房屋占地面积不为空
			if (houseFloor == null || houseFloor == "") {
				$("#houseFloorerr").text("房屋占地面积不为空").css("font-size",
						10).css("color", "#FF6666");
				flag = false;
			}
			//判断房屋住宅面积不为空
			if (houseBuild == null || houseBuild == "") {
				$("#houseBuilderr").text("房屋住宅面积不为空").css("font-size",
						10).css("color", "#FF6666");
				flag = false;
			}
			//判断房屋价格不为空
			if (houseMoney == null || houseMoney == "") {
				$("#houseMoneyerr").text("房屋出售价格不为空").css("font-size",
						10).css("color", "#FF6666");
				flag = false;
			}
			//判断卧室数量
			if (houseBed == null || houseBed == "") {
				$("#houseBederr").text("未选择卧室数量").css("font-size", 10)
						.css("color", "#FF6666");
				flag = false;
			}
			//判断浴室数量
			if (houseBath == null || houseBath == "") {
				$("#houseBatherr").text("未选择浴室数量").css("font-size", 10)
						.css("color", "#FF6666");
				flag = false;
			}
			//判断客厅数量
			if (houseLiving == null || houseLiving == "") {
				$("#houseLivingerr").text("未选择客厅数量").css("font-size",
						10).css("color", "#FF6666");
				flag = false;
			} 
			if (flag) {
				
				$("#newInHouse").submit();
			}
		});
	});
</script>
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
				<h1>房源发布</h1>
				<form id="newInHouse" action="<%=basePath%>/houseController?funParam=2" class="form-horizontal" method="post" enctype="multipart/form-data">
					<fieldset>
							<legend>发布房源信息</legend>
					<div class="control-group">
						<label class="control-label" for="newHouse">房屋信息</label>
						<div class="controls">
							<input type="text" class="input-xlarge" id="newHouseInfo" name="Hinfo"
								placeholder="请输入房屋信息" /><span id="houseInfoerr"></span>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="newHouseAdd">房屋地址</label>
						<div class="controls">
							<input type="text" class="input-xlarge" id="newHouseAdd" name="Hadd"
								placeholder="请输入房源地址" /><span id="houseAdderr"></span>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="newHouseType">房屋类型</label>
						<div class="controls">
								<select id="newHouseType" name="Htype" >
									<option value="">--请选择房屋类型--</option>
									<option value="公寓">公寓</option>
									<option value="民房">民房</option>
									<option value="别墅">别墅</option>
								</select><span id="houseTypeerr"></span>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="newHouseSell">房屋出售方式</label>
						<div class="controls">
							<select id="newHouseSell" name="Hsell">
								<option value="">请选择售卖方式</option>
								<option value="出售">出售</option>
								<option value="出租">出租</option>
								<option value="转售">转售</option>
							</select><span id="houseSellerr"></span>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="newHouse">房屋相关面积</label>
						<div class="controls">
							<input type="text" class="input-xlarge" id="newHouseFloor" name="Hfloor"
								placeholder="请输入占地面积" /><span id="houseFloorerr"></span>
						</div>
						<br />
						<div class="controls">
							<input type="text" class="input-xlarge" id="newHouseBuild" name="Hbuild"
								placeholder="请输入住宅面积" /><span id="houseBuilderr"></span>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="newHouseType">房屋售卖金额</label>
						<div class="controls">
							<input type="text" class="input-xlarge" id="newHouseMoney" name="Hmoney"
								placeholder="请输入售卖金额" /><span id="houseMoneyerr"></span>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="newHouseNum">房间数量</label>
						<div class="controls">
							卧室&nbsp;&nbsp;<select id="newHouseBed" name="Hbed">
								<option value="">请选择卧室数</option>
								<option value="0">0</option>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5及以上</option>
							</select><span id="houseBederr" ></span> <br /> <br />
							 浴室&nbsp;&nbsp;<select id="newHouseBath" name="Hbath">
								<option value="">请选择浴室数</option>
								<option value="0">0</option>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4及以上</option>
							</select><span id="houseBatherr"></span> <br /> <br />
							客厅&nbsp;&nbsp;<select id="newHouseLiving" name="Hliving">
								<option value="">请选择客厅数</option>
								<option value="0">0</option>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3及以上</option>
							</select><span id="houseLivingerr"></span>
						</div>
						</div>
					<div class="control-group">
							<label class="control-label" for="newHousePhoto">房屋图片</label>
							<div class="controls">
								<input class="input-file" id="newHousePhoto" type="file" name="housephoto"/>
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
</body>

</html>