package com.luzhoumin.mblog.management.util;

import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;

import static com.luzhoumin.mblog.management.constant.MBlogConstant.LIST_DEFAULT_PAGE_SIZE;

/**
 * 分页工具类
 */
@Slf4j
public class PageHelperUtil {

	/**
	 * 添加分页
	 *
	 * @param pageNum
	 * @param pageSize -1时，无分页
	 */
	public static void addPaging(int pageNum, int pageSize) {
		if (pageSize != -1) {
			log.info("有分页：pageNum[" + pageNum + "] pageSize[" + pageSize + "] ");
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
