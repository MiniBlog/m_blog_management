new Vue({
	el: '#app',
	data: function () {
		let that = this;
		return {
			queryUrl: webRootAjax + "/module-list.do",
			tableData: [],
			tableLoading: true,
			tableTotal: 0,
			pageIndex: 1,
			pageSize: 10,
			//filter
			filterForm: {
				uid: '',
				name: '',
				create_date: ''
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
			vueGetAjax(that, that.queryUrl, paramMap, (json) => {
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
		handleEdit(index, row) {
			let that = this;
			let moduleId = row['id'];
			let moduleName = row['_name'];
			parent.openMenu("edit-module-" + moduleId, "编辑模块:" + moduleName, webRoot + "/add-module.html?moduleId=" + moduleId);
		},
		handleDelete(index, row) {
			let that = this;
			that.$confirm('此操作将永久删除该模块, 是否继续?', '提示', {
				confirmButtonText: '确定',
				cancelButtonText: '取消',
				type: 'warning'
			}).then(() => {
				let param = {};
				param['id'] = row['id'];
				vueDeleteAjax(that, webRootAjax + "/module.do", param, (data) => {
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
