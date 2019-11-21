new Vue({
	el: '#app',
	data: {
		fileList: [],
		dialogImageUrl: '',
		dialogVisible: false,
		disabled: false
	},
	methods: {
		handleRemove(file) {
			console.log(file);
		},
		handlePictureCardPreview(file) {
			this.dialogImageUrl = file.url;
			this.dialogVisible = true;
		},
		handleDownload(file) {
			var blobId = file.response.map.blobId;
			location.href = webRootAjax + "/file/download.do?blobId=" + blobId;
		}
	},
	mounted: function () {
		$('#loading').fadeOut();
		$('#app').fadeIn();
	}
});
