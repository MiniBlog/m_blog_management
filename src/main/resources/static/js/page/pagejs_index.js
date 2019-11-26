let topHeightExceptTabContent = 135;	//Tab内容距离顶部的距离
let vm = new Vue({
	el: '#app',
	data: {
		currentTabName: '',
		tabList: []
	},
	methods: {
		//打开菜单
		openMenu(menu) {
			let that = this;
			//为了避免再js中调用的时候that为空，取不到tabList变量。
			let tabList = that.tabList || window.vm.tabList;
			if (menu) {
				for (let i = 0; i < tabList.length; i++) {
					let tab = tabList[i];
					//如果已经打开，切换到该标签页
					if (tab["name"] === menu["_key"]) {
						$(".el-tabs__nav").children().eq(i).click();
						return;
					}
				}
				//如果没有打开
				var url = menu["_href"];
				if (url.indexOf("?") > -1) {
					url += "&__menuTabId=" + menu["_key"];
				} else {
					url += "?__menuTabId=" + menu["_key"];
				}
				if (!url) {
					this.$message.error('该菜单没有配置url属性');
					return;
				}
				if (!(url.startsWith("http://") || url.startsWith("https://"))) {
					if (url.startsWith("/")) {
						url = webRoot + url;
					} else {
						url = webRoot + "/" + url;
					}
				}
				tabList.push({
					label: menu["_title"],
					name: menu["_key"],
					url: url,
				});
				//切换到刚添加的tab
				setTimeout(() => {
					$(".el-tabs__nav").children().last().click();
				}, 0);
			} else {
				console.error("获取不到该菜单信息。[" + name + "]");
			}
		},
		//菜单点击事件
		menuClick(name) {
			let that = this;
			let menu = plainMenuMap[name];
			that.openMenu(menu);
		},
		//Tab关闭事件
		removeTab(name) {
			let that = this;
			for (let i = 0; i < that.tabList.length; i++) {
				var tab = that.tabList[i];
				//如果已经打开，切换到该标签页
				if (tab["name"] === name) {
					that.tabList.splice(i, 1);
					setTimeout(function () {
						//只有关闭的标签页是当前打开的标签页，并且标签页数量不为0时，进行切换标签页
						if (that.currentTabName === name && that.tabList.length > 0) {
							//如果关闭的标签页后面还有标签页，切换到后面这个标签页
							if (i < that.tabList.length) {
								$(".el-tabs__nav").children().eq(i).click();
							} else {
								//如果关闭的标签页后面没有，切换到前面这个标签页
								$(".el-tabs__nav").children().eq(i - 1).click();
							}
						}
					}, 0);
				}
			}
		},
		//点击Tab页
		tabClick(tab) {
			//调整TabPane高度
			setTimeout(function () {
				$(".el-tab-pane").height(document.documentElement.clientHeight - topHeightExceptTabContent);
			}, 0);
		}
	},
	mounted: function () {
		let that = this;
		$(that.$refs.app).height(document.documentElement.clientHeight);
		window.onresize = () => {
			$(that.$refs.app).height(document.documentElement.clientHeight);
			$(".el-tab-pane").height(document.documentElement.clientHeight - topHeightExceptTabContent);
		};
		$('#loading').fadeOut();
		$('#app').fadeIn();
		//默认打开第一个菜单
		let keys = Object.keys(plainMenuMap);
		if (keys && keys.length > 0) {
			that.openMenu(plainMenuMap[keys[0]]);
		}
	}
});

//js中打开菜单
function openMenu(key, title, href) {
	let menu = {};
	menu['_key'] = key;
	menu['_title'] = title;
	menu['_href'] = href;
	vm.$options.methods.openMenu(menu);
}

//关闭tab页
function closeMenuTab(tabId) {
	setTimeout(function () {
		$("div#tab-" + tabId + ">span").click();
	});
}

//赋值vue对象给window
window.vm = vm;