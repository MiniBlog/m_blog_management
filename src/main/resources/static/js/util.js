function vueAjax(that, type, url, param, successCallback, errorCallback) {
	const loading = that.$loading({
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
				that.$message({
					showClose: true,
					message: "操作失败. " + data.msg,
					type: 'error',
					duration: 10
				});
			}
		},
		error: (XMLHttpRequest, textStatus, errorThrown) => {
			loading.close();
			that.$message({
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

function vueGetAjax(that, url, data, successCallback, errorCallback) {
	return vueAjax(that, "get", url, data, successCallback, errorCallback);
}

function vuePostAjax(that, url, data, successCallback, errorCallback) {
	return vueAjax(that, "post", url, data, successCallback, errorCallback);
}

function vuePutAjax(that, url, data, successCallback, errorCallback) {
	return vueAjax(that, "put", url, data, successCallback, errorCallback);
}

function vueDeleteAjax(that, url, data, successCallback, errorCallback) {
	return vueAjax(that, "delete", url, data, successCallback, errorCallback);
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

//获取当前Tab页id
function getMenuTabId() {
	return getUrlParam("__menuTabId");
}
//关闭当前Tab页
function closeThisMenuTab() {
	parent.closeMenuTab(getMenuTabId());
}