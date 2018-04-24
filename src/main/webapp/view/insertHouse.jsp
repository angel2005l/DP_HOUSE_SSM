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
				<h1>房源发布</h1>
				<form id="newInHouse"  class="form-horizontal" method="post" enctype="multipart/form-data">
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
<script type="text/javascript" src="/professionalJs/insertHouse.js"></script>
</body>

</html>