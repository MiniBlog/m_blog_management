function easymAjax(_vue_that, type, url, param, successCallback, errorCallback) {
	const loading = _vue_that.$loading({
		lock: true,
		text: 'Loading',
		spinner: 'el-icon-loading',
		background: 'rgba(255, 255, 255, 0.85)'
	});
	if (param && type === 'put') {
		param['_method'] = "PUT"
	}
	if (param && type === 'delete') {
		param['_method'] = "DELETE"
	}
	return $.ajax({
		url: url,
		type: type,
		data: param,
		async: false,
		dataType: "json",
		success: (data, textStatus) => {
			loading.close();
			if (data.success) {
				if (successCallback) {
					successCallback(data, textStatus);
				}
			} else {
				_vue_that.$message({
					showClose: true,
					message: "操作失败. " + data.msg,
					type: 'error',
					duration: 10
				});
			}
		},
		error: (XMLHttpRequest, textStatus, errorThrown) => {
			loading.close();
			_vue_that.$message({
				showClose: true,
				message: "操作失败. " + errorThrown,
				type: 'error',
				duration: 10
			});
			if (errorCallback) {
				errorCallback(XMLHttpRequest, textStatus, errorThrown);
			}
		}
	});
}

function easymGetAjax(_vue_that, url, data, successCallback, errorCallback) {
	return easymAjax(_vue_that, "get", url, data, successCallback, errorCallback);
}

function easymPostAjax(_vue_that, url, data, successCallback, errorCallback) {
	return easymAjax(_vue_that, "post", url, data, successCallback, errorCallback);
}

function easymPutAjax(_vue_that, url, data, successCallback, errorCallback) {
	return easymAjax(_vue_that, "put", url, data, successCallback, errorCallback);
}

function easymDeleteAjax(_vue_that, url, data, successCallback, errorCallback) {
	return easymAjax(_vue_that, "delete", url, data, successCallback, errorCallback);
}

function ajax(type, url, param, successCallback, errorCallback) {
	if (param && type === 'put') {
		param['_method'] = "PUT"
	}
	if (param && type === 'delete') {
		param['_method'] = "DELETE"
	}
	return $.ajax({
		url: url,
		type: type,
		data: param,
		async: false,
		dataType: "json",
		success: (data, textStatus) => {
			if (successCallback) {
				successCallback(data, textStatus);
			}
		},
		error: (XMLHttpRequest, textStatus, errorThrown) => {
			if (errorCallback) {
				errorCallback(XMLHttpRequest, textStatus, errorThrown);
			}
		}
	});
}

function myGetAjax(url, data, successCallback, errorCallback) {
	return ajax("get", url, data, successCallback, errorCallback);
}

function myPostAjax(url, data, successCallback, errorCallback) {
	return ajax("post", url, data, successCallback, errorCallback);
}

function myPutAjax(url, data, successCallback, errorCallback) {
	return ajax("put", url, data, successCallback, errorCallback);
}

function myDeleteAjax(url, data, successCallback, errorCallback) {
	return ajax("delete", url, data, successCallback, errorCallback);
}

function getUrlParam(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); // 构造一个含有目标参数的正则表达式对象
	var r = window.location.search.substr(1).match(reg);  // 匹配目标参数
	if (r != null) return unescape(r[2]);
	return null; // 返回参数值
}