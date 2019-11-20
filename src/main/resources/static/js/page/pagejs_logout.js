var seconds = 5;
var timer;

$(function () {
	timer = setInterval("countdownRun()", 1000);
});

function countdownRun() {
	--seconds;
	$("#info").text(seconds + '秒后返回首页...');
	if (seconds < 1) {
		location.href = webRoot + "/index.html";
	}
}