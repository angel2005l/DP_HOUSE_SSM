$(function() {
	$("#saveBtn").bind("click", function() {
		if (check()) {
			$("#newInHouse").ajaxSubmit({
				url : "/company/insCompany.do",
				type : 'post',
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
					alert("未获得服务器响应")
				}
			})
		}
	});
	//	
	// var object= {
	// url:url, //form提交数据的地址
	// type:type, //form提交的方式(method:post/get)
	// target:target, //服务器返回的响应数据显示的元素(Id)号
	// beforeSerialize:function(){} //序列化提交数据之前的回调函数
	// beforeSubmit:function(){}, //提交前执行的回调函数
	// success:function(){}, //提交成功后执行的回调函数
	// error:function(){}, //提交失败执行的函数
	// dataType:null, //服务器返回数据类型
	// clearForm:true, //提交成功后是否清空表单中的字段值
	// restForm:true, //提交成功后是否重置表单中的字段值，即恢复到页面加载时的状态
	// timeout:6000 //设置请求时间，超过该时间后，自动退出请求，单位(毫秒)。
	//		 
	// }
})

function check() {
	var coName = $("#newCoName").val();
	var coAddCode = $("#newCoAddCode").val();
	var coType = $("#newCoType").val();
	var coUniqueId = $("#newCoUniqueId").val();
	var coAdd = $("#newCoAdd").val();
	var flag = true;

	// 判断房屋信息不为空
	if (coName == null || coName == "") {
		$("#coNameerr").text("单位名称不为空").css("font-size", 10).css("color",
				"#FF6666");
		flag = false;
	}
	// 判断房屋地址不为空
	if (coAddCode == null || coAddCode == "") {
		$("#coAddCodeerr").text("所属地区号不为空").css("font-size", 10).css("color",
				"#FF6666");
		flag = false;
	}
	// 判断房屋类型不为空
	if (coType == null || coType == "") {
		$("#coTypeerr").text("单位性质未选择").css("font-size", 10).css("color",
				"#FF6666");
		flag = false;
	}
	// 判断房屋出售方式不为空 select
	if (coUniqueId == null || coUniqueId == "") {
		$("#coUniqueIderr").text("单位唯一识别码不为空").css("font-size", 10).css(
				"color", "#FF6666");
		flag = false;
	}
	// 判断房屋占地面积不为空
	if (coAdd == null || coAdd == "") {
		$("#coAdderr").text("单位地址不为空").css("font-size", 10).css("color",
				"#FF6666");
		flag = false;
	}
	return flag;
}