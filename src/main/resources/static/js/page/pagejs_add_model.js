new Vue({
	el: '#app',
	data: function () {
		let that = this;
		return {
			module_name: '',
			module_note: '',
			module_template: '',
		}
	},
	methods: {
		//整理高度
		initStyle() {
			let that = this;
			$("#tableRow").height(document.documentElement.clientHeight - $("#topRow").height() - 52);
			window.onresize = () => {
				$("#tableRow").height(document.documentElement.clientHeight - $("#topRow").height() - 52);
			};
		},
		addClick() {
			let that = this;
			let param = {};
			param['name'] = that.module_name;
			param['template'] = that.module_template;
			param['note'] = that.module_note;
			vuePostAjax(that, webRootAjax + "/module.do", param, function (data) {
				if (data.success) {
					//保存成功
					that.$alert('模块添加成功', '消息', {
						confirmButtonText: '确定',
						showClose: false,
						callback: () => {
							closeThisMenuTab();
						}
					});
				} else {
					that.$message({
						showClose: true,
						message: "模块添加失败. " + data.msg,
						type: 'error',
						duration: 10
					});
				}
			})
		}
	},
	mounted: function () {
		this.initStyle();
		$('#loading').fadeOut();
		$('#app').fadeIn();
	}
});
