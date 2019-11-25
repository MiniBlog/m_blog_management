new Vue({
	el: '#app',
	data: function () {
		let that = this;
		return {
			queryUrl: webRootAjax + "/sys/menu.do",
			queryPlantUrl: webRootAjax + "/menuPlant.do",
			tableData: [],
			tablePlantData: {},
			tableLoading: true,
			menuFormDialog: false,
			menuForm: {
				id: '',
				parent: '',
				group: false,
				title: '',
				key: '',
				icon: '',
				href: '',
				order: 0,
				edFlag: true,
				_isEdit: false
			},
			menuRules: {
				title: [
					{required: true, message: '请输入标题', trigger: 'blur'}
				],
				key: [
					{required: true, message: '请输入主键', trigger: 'blur'}
				],
				icon: [
					{required: true, message: '请选择图标', trigger: 'blur'}
				],
				href: [
					{
						validator: (rule, value, callback) => {
							if (!that.menuForm.group && value === "") {
								callback(new Error('请输入链接'));
							} else {
								callback();
							}
						},
						trigger: 'blur'
					}
				]
			}
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
		//查询列表
		query() {
			let that = this;
			//查询
			vueGetAjax(that, that.queryUrl, {}, (json) => {
				that.tableData = json.list;
			});
			//查询平面
			vueGetAjax(that, that.queryPlantUrl, {}, (json) => {
				that.tablePlantData = json.list;
			});
		},
		//Business
		menuDialogSubmit() {
			let that = this;
			that.$refs['menuForm'].validate((valid) => {
				if (valid) {
					let param = that.menuForm;
					if (that.menuForm._isEdit) {
						vuePutAjax(that, webRootAjax + "/sys/menu.do", param, (data) => {
							that.$message({
								message: '修改菜单成功',
								type: 'success'
							});
							that.menuDialogClose();
							that.query();
						});
					}else {
						vuePostAjax(that, webRootAjax + "/sys/menu.do", param, (data) => {
							that.$message({
								message: '添加菜单成功',
								type: 'success'
							});
							that.menuDialogClose();
							that.query();
						});
					}
				} else {
					return false;
				}
			});
		},
		menuDialogClose() {
			let that = this;
			that.menuFormDialog = false;
			that.menuForm.order = 0;
			that.$refs['menuForm'].resetFields();
		},
		//编辑
		handleEdit(index, row) {
			let that = this;
			that.menuForm.id = row['id'];
			that.menuForm.group = row['_group'];
			that.menuForm.title = row['_title'];
			that.menuForm.icon = row['_icon'];
			that.menuForm.key = row['_key'];
			that.menuForm.parent = row['_parent'];
			that.menuForm.href = row['_href'];
			that.menuForm.order = row['_order'];
			that.menuForm.edFlag = row['ed_flag'];
			that.menuForm._isEdit = true;
			that.menuFormDialog = true;
		},
		//删除
		handleDelete(index, row) {
			let that = this;
			that.$confirm('此操作将永久删除该菜单, 是否继续?', '提示', {
				confirmButtonText: '确定',
				cancelButtonText: '取消',
				type: 'warning'
			}).then(() => {
				let param = {};
				param['id'] = row['id'];
				vueDeleteAjax(that, webRootAjax + "/sys/menu.do", param, (data) => {
					that.$message({
						type: 'success',
						message: '删除成功!'
					});
					that.query();
				});
			}).catch(() => {
				this.$message({
					type: 'info',
					message: '已取消删除'
				});
			});
		}
	},
	mounted: function () {
		this.initStyle();
		$('#loading').fadeOut();
		$('#app').fadeIn();
		this.query();
	}
});
