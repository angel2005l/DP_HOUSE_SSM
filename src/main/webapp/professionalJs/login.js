$(function() {
	$("#subBtn").bind("click", function() {
		if (check()) {
			var wId = $("input[name='employeeWid']").val();
			var wPwd = $("input[name='employeeWpwd']").val();
			$.ajax({
				url:'/login.do',
				type:'post',
				data:{userId:wId,userPass:wPwd},
				dataType:'text',
				success:function(result){
					var json = eval("("+result+")")
					if(json.status == 0){
						window.location.href="/index.do";
					}else{
						alert(json.msg);
						window.location.href="/login.jsp";
					}
				}
			})
		}
	})
});

function check() {
	var wId = $("input[name='employeeWid']").val();
	var wPwd = $("input[name='employeeWpwd']").val();
	var flag = true;
	if (wId == null || wId == "") {
		$("#loginWiderr").text("账号为空").css("font-size", 10).css("color",
				"#FF6666");
		flag = false;
	}
	if (wPwd == null || wPwd == "") {
		$("#loginWpwderr").text("密码为空").css("font-size", 10).css("color",
				"#FF6666");
		flag = false;
	}
	return flag;
}