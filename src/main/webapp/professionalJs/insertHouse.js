$(function() {
	$("#saveBtn").bind("click", function() {
		if (check()) {
			$("#newInHouse").ajaxSubmit({
				url : "/house/add.do",
				type : 'post',
				success : function(result) {
					var data = eavl("("+result+")");
					/*
					 * if(resulu.status==0){ alert() }
					 */
					alert(data.msg);
					if(data.status == 0){
						location.reload();
					}else{
						return ;
					}
					console.log(result)
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

	// 判断房屋信息不为空
	if (houseInfo == null || houseInfo == "") {
		$("#houseInfoerr").text("房屋信息不为空").css("font-size", 10).css("color",
				"#FF6666");
		flag = false;
	}
	// 判断房屋地址不为空
	if (houseAdd == null || houseAdd == "") {
		$("#houseAdderr").text("房屋地址不为空").css("font-size", 10).css("color",
				"#FF6666");
		flag = false;
	}
	// 判断房屋类型不为空
	if (houseType == null || houseType == "") {
		$("#houseTypeerr").text("房屋类型不为空").css("font-size", 10).css("color",
				"#FF6666");
		flag = false;
	}
	// 判断房屋出售方式不为空 select
	if (houseSell == null || houseSell == "") {
		$("#houseSellerr").text("未选择出售方式").css("font-size", 10).css("color",
				"#FF6666");
		flag = false;
	}
	// 判断房屋占地面积不为空
	if (houseFloor == null || houseFloor == "") {
		$("#houseFloorerr").text("房屋占地面积不为空").css("font-size", 10).css("color",
				"#FF6666");
		flag = false;
	}
	// 判断房屋住宅面积不为空
	if (houseBuild == null || houseBuild == "") {
		$("#houseBuilderr").text("房屋住宅面积不为空").css("font-size", 10).css("color",
				"#FF6666");
		flag = false;
	}
	// 判断房屋价格不为空
	if (houseMoney == null || houseMoney == "") {
		$("#houseMoneyerr").text("房屋出售价格不为空").css("font-size", 10).css("color",
				"#FF6666");
		flag = false;
	}
	// 判断卧室数量
	if (houseBed == null || houseBed == "") {
		$("#houseBederr").text("未选择卧室数量").css("font-size", 10).css("color",
				"#FF6666");
		flag = false;
	}
	// 判断浴室数量
	if (houseBath == null || houseBath == "") {
		$("#houseBatherr").text("未选择浴室数量").css("font-size", 10).css("color",
				"#FF6666");
		flag = false;
	}
	// 判断客厅数量
	if (houseLiving == null || houseLiving == "") {
		$("#houseLivingerr").text("未选择客厅数量").css("font-size", 10).css("color",
				"#FF6666");
		flag = false;
	}
	return flag;
}