<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/indent/insIndent.do" method="post">
		<table>
			<tr>
				<td>房屋编号</td>
				<td><input type="text" name="houId"></td>
			</tr>
			<tr>
				<td>折扣</td>
				<td><input type="text" name="indDiscount"></td>
			</tr>
			<tr>
				<td>日期</td>
				<td><input type="text" name="day"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="提交"></td>
			</tr>
		</table>
	</form>
</body>
</html>