$(function() {
	if(check()){
		
	}
});

function check(){
	$("#subBtn").bind(
			"click",
			function() {
				var wId = $("input[name='employeeWid']").val();
				var wPwd = $("input[name='employeeWpwd']").val();
				var flag = true;
				if (wId == null || wId == "") {
					$("#loginWiderr").text("账号为空").css("font-size", 10).css(
							"color", "#FF6666");
					flag = false;
				}
				if (wPwd == null || wPwd == "") {
					$("#loginWpwderr").text("密码为空").css("font-size", 10).css(
							"color", "#FF6666");
					flag = false;
				}
				if (flag) {
					$("#login-form").submit();
				}
			});
}