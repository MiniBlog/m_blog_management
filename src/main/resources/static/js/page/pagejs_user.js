let regExpPasswordStr = "^(?![\\d]+$)(?![a-zA-Z]+$)(?![!@#$%^&*-+=:;,.?]+$)[\\da-zA-Z!@#$%^&*-+=:;,.?]{8,18}$"; /*密码(8-18 numbers,letters or symbols)*/
let regExpPassword = new RegExp(regExpPasswordStr);
new Vue({
	el: '#app',
	data: function () {
		let that = this;
		return {
			queryUrl: webRootAjax + "/user.do",
			tableData: [],
			tableLoading: true,
			tableTotal: 0,
			pageIndex: 1,
			pageSize: 10,
			//filter
			filterForm: {
				name: '',
				email: '',
				create_date: ''
			},
			//dialog
			userFormDialog: false,
			modifyPassFormDialog: false,
			//form
			userForm: {
				uuid: '',
				name: '',
				email: '',
				pass: '',
				pass_confirm: '',
				_isEdit: false
			},
			modifyPassForm: {
				uuid: '',
				name: '',
				email: '',
				org_pass: '',
				pass: '',
				pass_confirm: '',
			},
			//rules
			userRules: {
				name: [
					{required: true, message: '请输入用户名', trigger: 'blur'}
				],
				email: [
					{type: 'email', required: true, message: '请输入邮箱', trigger: 'blur'}
				],
				pass: [
					{
						validator: (rule, value, callback) => {
							if (!that.userForm._isEdit) {
								if (value === '') {
									callback(new Error('请输入密码'));
								} else {
									if (!regExpPassword.test(value)) {
										callback(new Error('密码需包含字母、符号、数字。8-18字符'));
									} else {
										if (that.userForm.pass_confirm !== '') {
											that.$refs['userForm'].validateField('pass_confirm');
										}
										callback();
									}
								}
							} else {
								callback();
							}
						},
						required: true,
						trigger: 'blur'
					}
				],
				pass_confirm: [
					{
						validator: (rule, value, callback) => {
							if (!that.userForm._isEdit) {
								if (value === '') {
									callback(new Error('请再次输入密码'));
								} else if (value !== that.userForm.pass) {
									callback(new Error('两次输入密码不一致!'));
								} else {
									callback();
								}
							} else {
								callback();
							}
						},
						required: true,
						trigger: 'blur'
					}
				]
			},
			modifyPassRules: {
				org_pass: [
					{required: true, message: '请输入原密码', trigger: 'blur'}
				],
				pass: [
					{
						validator: (rule, value, callback) => {
							if (value === '') {
								callback(new Error('请输入密码'));
							} else {
								if (!regExpPassword.test(value)) {
									callback(new Error('密码需包含字母、符号、数字。8-18字符'));
								} else {
									if (that.modifyPassForm.pass_confirm !== '') {
										that.$refs['modifyPassForm'].validateField('pass_confirm');
									}
									callback();
								}
							}
						},
						required: true,
						trigger: 'blur'
					}
				],
				pass_confirm: [
					{
						validator: (rule, value, callback) => {
							if (value === '') {
								callback(new Error('请再次输入密码'));
							} else if (value !== that.modifyPassForm.pass) {
								callback(new Error('两次输入密码不一致!'));
							} else {
								callback();
							}
						},
						required: true,
						trigger: 'blur'
					}
				]
			},
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
		query(pageNum, pageSize) {
			let that = this;
			that.tableLoading = true;
			if (pageNum) {
				//如果指定页码，更新页码
				that.pageIndex = pageNum;
			} else {
				//如果没有指定页码，取当前页码
				pageNum = that.pageIndex;
			}
			if (pageSize) {
				that.pageSize = pageSize
			} else {
				pageSize = that.pageSize;
			}
			let paramMap = that.filterForm;
			paramMap['pageSize'] = pageSize;
			paramMap['pageNum'] = pageNum;
			//查询
			easymGetAjax(that, that.queryUrl, paramMap, (json) => {
				that.tableTotal = json.map.count;
				that.tableData = json.map.list;
				if (!that.tableData && pageNum > 1) {
					that.query(1, pageSize);
				}
			});
		},
		clearQuery() {
			let that = this;
			that.$refs['filterForm'].resetFields();
			that.query(1, this.pageSize);
		},
		pageChange(pageNum) {
			this.query(pageNum, this.pageSize);
		},
		pageSizeChange(pageSize) {
			this.query(this.pageIndex, pageSize);
		},
		indexMethod(index) {
			return index + this.pageSize * (this.pageIndex - 1) + 1;
		},
		//Business
		userDialogSubmit() {
			let that = this;
			that.$refs['userForm'].validate((valid) => {
				if (valid) {
					if (that.userForm._isEdit) {
						let param = that.userForm;
						easymPutAjax(that, webRootAjax + "/user.do", param, (data) => {
							that.$message({
								message: '修改用户成功',
								type: 'success'
							});
							that.userDialogClose();
							that.query();
						});
					} else {
						let param = {};
						param['name'] = that.userForm.name;
						param['email'] = that.userForm.email;
						param['pass'] = hex_md5(that.userForm.pass);
						easymPostAjax(that, webRootAjax + "/user.do", param, (data) => {
							that.$message({
								message: '添加用户成功',
								type: 'success'
							});
							that.userDialogClose();
							that.query();
						});
					}
				} else {
					return false;
				}
			});
		},
		modifyPassSubmit() {
			let that = this;
			that.$refs['modifyPassForm'].validate((valid) => {
				if (valid) {
					let param = {};
					param['uuid'] = that.modifyPassForm.uuid;
					param['pass'] = hex_md5(that.modifyPassForm.pass);
					param['org_pass'] = hex_md5(that.modifyPassForm.org_pass);
					easymPutAjax(that, webRootAjax + "/user.do", param, (data) => {
						that.$message({
							message: '修改密码成功',
							type: 'success'
						});
						that.modifyPassClose();
						that.query();
					});
				} else {
					return false;
				}
			});
		},
		userDialogClose() {
			let that = this;
			that.userFormDialog = false;
			that.$refs['userForm'].resetFields();
		},
		modifyPassClose() {
			let that = this;
			that.modifyPassFormDialog = false;
			that.$refs['modifyPassForm'].resetFields();
		},
		handleEdit(index, row) {
			let that = this;
			that.userForm.email = row['_email'];
			that.userForm.name = row['_name'];
			that.userForm.uuid = row['uuid'];
			that.userForm._isEdit = true;
			that.userFormDialog = true;
		},
		handleModifyPass(index, row) {
			let that = this;
			that.modifyPassForm.uuid = row['uuid'];
			that.modifyPassForm.name = row['_name'];
			that.modifyPassForm.email = row['_email'];
			that.modifyPassFormDialog = true;
		},
		handleDelete(index, row) {
			let that = this;
			that.$confirm('此操作将永久删除该用户, 是否继续?', '提示', {
				confirmButtonText: '确定',
				cancelButtonText: '取消',
				type: 'warning'
			}).then(() => {
				let param = {};
				param['uuid'] = row['uuid'];
				easymDeleteAjax(that, webRootAjax + "/user.do", param, (data) => {
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
