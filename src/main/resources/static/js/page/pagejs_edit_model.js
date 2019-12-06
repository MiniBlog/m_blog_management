$.base64.utf8encode = true;

new Vue({
	el: '#app',
	data: function () {
		let that = this;
		return {
			module_id: '',
			module_uid: '',
			module_name: '',
			module_type: '',
			module_note: '',
			cmHTML: null,
			cmCSS: null,
			cmJS: null,
			cmPARAM: null,
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
			param['type'] = that.module_type;
			param['template'] = that.cmHTML.getValue();
			param['css'] = that.cmCSS.getValue();
			param['js'] = that.cmJS.getValue();
			param['param'] = that.cmPARAM.getValue();
			param['note'] = that.module_note;
			if (that.module_id) {
				//如果有id，说明是修改
				param['id'] = that.module_id;
				vuePutAjax(that, webRootAjax + "/module.do", param, data => {
					if (data.success) {
						//保存成功
						that.$alert('模块修改成功', '消息', {
							confirmButtonText: '确定',
							showClose: false,
							callback: () => {
								// closeThisMenuTab();
							}
						});
					} else {
						that.$message({
							showClose: true,
							message: "模块修改失败. " + data.msg,
							type: 'error',
							duration: 10
						});
					}
				})
			} else {
				//如果没有id，说明是添加
				vuePostAjax(that, webRootAjax + "/module.do", param, data => {
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
		previewClick() {
			let that = this;
			let moduleId = that.module_id;
			let moduleName = that.module_name;
			let previewParam = $.base64.encode(that.module_param);
			parent.openMenu("preview-module-" + moduleId, "预览模块:" + moduleName, webRoot + "/preview-module.html?moduleId=" + moduleId + "&previewParam=" + previewParam);

		}
	},
	mounted: function () {
		let that = this;
		//init param
		that.moduleId = getUrlParam("moduleId");
		myGetAjax(webRootAjax + "/module.do", {moduleId: that.moduleId}, data => {
			if (data.success) {
				let map = data.map;
				that.module_id = map.id;
				that.module_uid = map.uid;
				that.module_name = map.name;
				that.module_type = map.type;
				that.module_note = map.note;

				that.cmHTML = CodeMirror(document.getElementById("module_template"), {
					value: map.template,
					lineNumbers: true,
					mode: {
						name: "htmlmixed",
						scriptTypes: [{
							matches: /\/x-handlebars-template|\/x-mustache/i,
							mode: null
						},
							{
								matches: /(text|application)\/(x-)?vb(a|script)/i,
								mode: "vbscript"
							}]
					},
				});
				that.cmHTML.setSize('auto', '100%');
				that.cmCSS = CodeMirror(document.getElementById("module_css"), {
					value: map.css,
					lineNumbers: true,
					mode: "css"
				});
				that.cmCSS.setSize('auto', '100%');
				that.cmJS = CodeMirror(document.getElementById("module_js"), {
					value: map.js,
					lineNumbers: true,
					mode: "javascript"
				});
				that.cmJS.setSize('auto', '100%');
				that.cmPARAM = CodeMirror(document.getElementById("module_param"), {
					value: map.param,
					lineNumbers: true,
					mode: "application/json"
				});
				that.cmPARAM.setSize('auto', '100%');
			}
		});
		//init style start
		that.initStyle();
		$('#loading').fadeOut();
		$('#app').fadeIn();
	}
});
