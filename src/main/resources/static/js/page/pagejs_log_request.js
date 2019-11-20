new Vue({
	el: '#app',
	data: function () {
		let that = this;
		return {
			queryUrl: webRootAjax + "/sys/log/request.do",
			tableData: [],
			tableLoading: true,
			tableTotal: 0,
			pageIndex: 1,
			pageSize: 10,
			//filter
			filterForm: {
				user_name: '',
				path: '',
				create_date: '',
			}
		}
	},
	methods: {
		//整理高度
		initStyle() {
			let that = this;
			$("#tableRow").height(document.documentElement.clientHeight - $("#topRow").height() - 52);
			console.log(that.tableHeight);
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
		}
	},
	mounted: function () {
		this.initStyle();
		$('#loading').fadeOut();
		$('#app').fadeIn();
		this.query();
	}
});
