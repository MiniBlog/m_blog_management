package com.luzhoumin.mblog.management.service.impl;

import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import com.luzhoumin.mblog.management.service.FileService;
import com.luzhoumin.mblog.management.service.SysBlobService;
import com.luzhoumin.mblog.management.util.ConvertUtil;
import com.luzhoumin.mblog.management.util.PropertiesUtil;
import com.luzhoumin.mblog.management.util.SessionUtil;
import com.luzhoumin.mblog.management.util.UploadUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * BlobServiceImpl
 */
@Service
public class FileServiceImpl implements FileService {

	private static Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

	@Resource
	private SysBlobService sysBlobService;

	/**
	 * 文件上传(对外统一接口)
	 * @param request
	 * @return
	 */
	@Override
	public Map<String, Object> uploadFile(HttpServletRequest request){

		//转换request
		MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) request;

		Map<String, Object> fileInfo = new HashMap<String, Object>();

		//文件上传处理
		try {
			//附件ID
			String blobId = "";
			Iterator<String> itr = mRequest.getFileNames();
			while (itr.hasNext()) {
				MultipartFile mpf = mRequest.getFile(itr.next());

				//check文件类型
				logger.info("文件类型[" + mpf.getContentType() + "]");
				String allowFileType = mRequest.getParameter("allowFileType");
				if (StrUtil.isNotEmpty(allowFileType)){
					String[] fileTypes = allowFileType.split("-");
					String[] fileNames = mpf.getOriginalFilename().split("\\.");
					String uploadFileType = fileNames[fileNames.length-1];
					boolean fileTypeAllowFlag = false;
					for (int i = 0; i < fileTypes.length; i++) {
						if (uploadFileType.toLowerCase().equals(fileTypes[i].toLowerCase())) {
							fileTypeAllowFlag = true;
							break;
						}
					}
					if (fileTypeAllowFlag==false) {
						//格式不允许
						fileInfo.put("success", "false");
						fileInfo.put("message", "FILE_TYPE_ERROR");
						return fileInfo;
					}
				}

				//check文件大小
				logger.info("文件大小[" + mpf.getSize() + "]");
				String allowFileSize = mRequest.getParameter("allowFileSize");
				Integer fileSize = 3;
				if (StrUtil.isNotEmpty(allowFileSize)){
					fileSize = Integer.parseInt(allowFileSize);
				}
				if(mpf.getSize() > fileSize*1024*1024){
					//文件大于指定大小(默认3M)
					fileInfo.put("success", "false");
					fileInfo.put("message", "FILE_SIZE_ERROR");
					return fileInfo;
				}

				//调用文件服务器的接口，将文件上传到文件服务器上
				String fileOriginalName = mpf.getOriginalFilename();
				fileInfo.put("blobOriginalName", fileOriginalName);

				//文件上传
				byte[] fileBytes = IoUtil.readBytes(mpf.getInputStream());
				JSONObject fileObj = UploadUtil.uploadFile(fileBytes, fileOriginalName);
				if (fileObj!=null) {
					//获取新的MD5文件名
					String fileActualName = StrUtil.toString(fileObj.get("fileActualName"));
					String filePath = StrUtil.toString(fileObj.get("filePath"));
					if (StrUtil.isNotEmpty(fileActualName) && StrUtil.isNotEmpty(filePath)){
						//文件上传成功，保存附件数据
						//HTTP请求参数准备
						Map<String, String> mapParams = new HashMap<String, String>();
						mapParams.put("blobName", fileActualName);
						mapParams.put("blobOriginalName", fileOriginalName);
						mapParams.put("blobAddress", filePath);
						mapParams.put("userId", StrUtil.toString(SessionUtil.getSessionLoginUserName()));

						blobId = sysBlobService.saveBlobData(mapParams);
						fileInfo.put("blobId", blobId);
						fileInfo.put("blobName", fileActualName);
						fileInfo.put("blobAddress", filePath);
					}
				}
			}

			if (StrUtil.isNotEmpty(blobId)) {
				fileInfo.put("success", "true");
				fileInfo.put("message", "UPLOAD_SUCCESS");
			}else{
				fileInfo.put("success", "false");
				fileInfo.put("message", "UPLOAD_ERROR");
			}
		} catch (Exception e) {
			e.printStackTrace();
			fileInfo.put("success", "false");
			fileInfo.put("message", "SYSTEM_ERROR");
		}

		return fileInfo;
	}

	/**
	 * 文件下载(对外统一接口)
	 * @param request
	 * @param response
	 */
	@Override
	public void downloadFile(HttpServletRequest request , HttpServletResponse response){

		String blobId = request.getParameter("blobId");

		if (StrUtil.isNotEmpty(blobId)) {
			Map<String, String> mapParams = new HashMap<String, String>();
			mapParams.put("blobId", blobId);

			Map<String, Object> blobInfo = sysBlobService.getBlobInfo(blobId);
			if (blobInfo!=null) {
				String blobAddress = StrUtil.toString(blobInfo.get("_address"));
				String blobName = StrUtil.toString(blobInfo.get("_name"));
				String originalBlobName = StrUtil.toString(blobInfo.get("_original_name"));

				String cdnDomainNameFile = PropertiesUtil.getDomainName("cdnDomainNameFile");
				String fileUrl = cdnDomainNameFile + "/" + blobAddress + blobName;
				if (UploadUtil.checkFileExist(blobAddress, blobName)){
					UploadUtil.downloadFile(response, originalBlobName, fileUrl);
				}
			}
		}
	}
}
