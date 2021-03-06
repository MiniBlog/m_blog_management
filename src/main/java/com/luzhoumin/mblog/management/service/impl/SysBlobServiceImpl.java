package com.luzhoumin.mblog.management.service.impl;

import com.github.pagehelper.util.StringUtil;
import com.luzhoumin.mblog.management.mapper.BlobMapper;
import com.luzhoumin.mblog.management.mapper.generate.TMbBlobMapper;
import com.luzhoumin.mblog.management.pojo.TMbBlob;
import com.luzhoumin.mblog.management.service.SysBlobService;
import com.luzhoumin.mblog.management.service.SequenceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class SysBlobServiceImpl implements SysBlobService {

	@Resource
	private BlobMapper blobMapper;
	@Resource
	private TMbBlobMapper tMbBlobMapper;
	@Resource
	private SequenceService sequenceService;

	/**
	 * 获取附件信息
	 */
	@Override
	public Map<String, Object> getBlobInfo(String blobId) {
		log.info("SysBlobServiceImpl,getBlobInfo:start");

		if (StringUtil.isEmpty(blobId)) {
			log.info("SysBlobServiceImpl,getBlobInfo:end.<INCOMPLETE_PARAMETERS>");
			return null;
		}

		//获取附件信息
		Map<String, Object> blobInfo = null;
		List<Map<String, Object>> blobList = blobMapper.getBlobInfo(blobId);
		if (blobList != null && blobList.size() > 0) {
			blobInfo = blobList.get(0);
		}

		log.info("SysBlobServiceImpl,getBlobInfo:end");
		return blobInfo;
	}

	/**
	 * 保存附件信息
	 */
	@Override
	public String saveBlobData(Map<String, String> mapParams) {

		log.info("saveBlobData 开始");
		String blobName = mapParams.get("blobName");
		String blobOriginalName = mapParams.get("blobOriginalName");
		String blobAddress = mapParams.get("blobAddress");

		if (StringUtil.isEmpty(blobName) || StringUtil.isEmpty(blobOriginalName) || StringUtil.isEmpty(blobAddress)) {
			log.info("INCOMPLETE_PARAMETERS");
			log.info("saveBlobData 结束");
			return "";
		}

		Date nowDate = new Date();
		//生成附件ID
		String blobId = sequenceService.getSequence("BLOB_ID");
		String userId = mapParams.get("userId");

		TMbBlob tEuBlob = new TMbBlob();
		//附件id
		tEuBlob.setBlob(blobId);
		//附件名称
		tEuBlob.setName(blobName);
		//附件原始名称
		tEuBlob.setOriginalName(blobOriginalName);
		//附件地址
		tEuBlob.setAddress(blobAddress);
		tEuBlob.setCreateBy(userId);
		tEuBlob.setCreateDate(nowDate);
		tEuBlob.setUpdateBy(userId);
		tEuBlob.setUpdateDate(nowDate);

		int ret = tMbBlobMapper.insertSelective(tEuBlob);
		if (ret <= 0) {
			return "";
		}

		log.info("saveBlobData 结束");
		return blobId;
	}
}
