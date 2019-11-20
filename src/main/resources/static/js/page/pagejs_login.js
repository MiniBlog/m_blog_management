$(function () {
	$('.right_part form input').focus(function () {
		$(this).siblings('span').addClass('move')
	});
	$('.right_part form input').blur(function () {
		if ($(this).val() === '') {
			$(this).siblings('span').removeClass('move')
		}
	});
});

/*项目检查*/
function checkLoginItems(id) {
	//登录邮箱检查
	if (id === "userName" || id === "ALL") {
		var userName = $("#userName").val().trim();
		if (userName === "") {
			showErrorMsg("userName", "请输入用户名");
			return false;
		} else {
			hideErrorMsg("userName");
		}
	}
	//登录密码检查
	if (id === "userPass" || id === "ALL") {
		var userPass = $("#userPass").val();
		if (userPass === "") {
			showErrorMsg("userPass", "请输入密码");
			return false;
		} else {
			hideErrorMsg("userPass");
		}
	}
	return true;
}

function showErrorMsg(type, message) {
	$("#" + type + "_error_div").css("visibility", "visible");
	$("#" + type + "_error").text(message);
}

function hideErrorMsg(type) {
	$("#" + type + "_error_div").css("visibility", "hidden");
	$("#" + type + "_error").text("");
}

$(".loginBtn").click(function () {
	if (checkLoginItems("ALL")) {
		var data1 = hex_md5($("#userName").val());
		var userName = $("#userName").val();
		var data2 = hex_md5($("#userPass").val());
		var userPass = hex_md5(data1 + data2);
		var returnUrl = getUrlParam("returnUrl");
		var params = {
			userName: userName,
			userPass: userPass,
			returnUrl: returnUrl
		};
		myPostAjax(webRootAjax + "/login.do", params, (data) => {
			if (data.success) {
				window.location.href = data.str;
			} else {
				showErrorMsg(data.obj, data.msg);
			}
		})
	}
	return false;
});
