package com.luzhoumin.mblog.management.util;

import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

import static com.luzhoumin.mblog.management.constant.EasyMConstant.LIST_DEFAULT_PAGE_SIZE;

/**
 * 分页工具类
 */
public class PageHelperUtil {

	private static Logger logger = LoggerFactory.getLogger(PageHelperUtil.class);

	/**
	 * 添加分页
	 *
	 * @param pageNum
	 * @param pageSize -1时，无分页
	 */
	public static void addPaging(int pageNum, int pageSize) {
		if (pageSize != -1) {
			logger.info("有分页：pageNum[" + pageNum + "] pageSize[" + pageSize + "] ");
			//验证pageSize是否正整数
			if (pageSize <= 0) {
				pageSize = 1;
			}
			//验证pageNum是否正整数
			if (pageNum <= 0) {
				pageNum = 1;
			}
			//添加分页插件(第三个参数:true表示需要统计总数 false表示不需要统计总数)
			PageHelper.startPage(pageNum, pageSize, false);
		}
	}

	/**
	 * request中获取pageSize
	 *
	 * @param request
	 * @return
	 */
	public static int getPageSize(HttpServletRequest request) {
		String numStr = request.getParameter("pageSize");
		if (StrUtil.isEmpty(numStr)) {
			return LIST_DEFAULT_PAGE_SIZE;
		} else {
			return NumberUtil.parseInt(numStr);
		}
	}

	/**
	 * request中获取pageNum
	 *
	 * @param request
	 * @return
	 */
	public static int getPageNum(HttpServletRequest request) {
		String numStr = request.getParameter("pageNum");
		if (StrUtil.isEmpty(numStr)) {
			return 1;
		} else {
			return NumberUtil.parseInt(numStr);
		}
	}
}
