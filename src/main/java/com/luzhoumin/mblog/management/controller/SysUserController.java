package com.luzhoumin.mblog.management.controller;

import cn.hutool.core.util.StrUtil;
import com.luzhoumin.mblog.management.pojo.AjaxJson;
import com.luzhoumin.mblog.management.pojo.MSysUser;
import com.luzhoumin.mblog.management.service.UserService;
import com.luzhoumin.mblog.management.util.ConvertUtil;
import com.luzhoumin.mblog.management.util.HttpServletUtil;
import com.luzhoumin.mblog.management.util.PageHelperUtil;
import com.luzhoumin.mblog.management.util.SessionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;

/**
 * Created on September 24, 2019
 * Description:
 *
 * @author <a href="mailto:zmlu1996@gmail.com">Jacob Lu</a>
 * @since 1.8
 */
@RestController
@RequestMapping("/sys")
public class SysUserController {
	private static Logger logger = LoggerFactory.getLogger(SysUserController.class);

	@Resource
	UserService userService;

	@GetMapping("/user.html")
	public ModelAndView list() {
		logger.info("**************** SysUserController,list:start ****************");
		logger.info("**************** SysUserController,list:end ****************");
		return new ModelAndView("user/user");
	}

	@GetMapping("/user.do")
	public void ajaxGetList(HttpServletRequest request, HttpServletResponse response) {
		logger.info("**************** SysUserController,ajaxGetList:start ****************");
		AjaxJson aj = new AjaxJson();
		try {
			Map<String, String> paramMap = ConvertUtil.requestToMap(request);
			Map<String, Object> data = userService.getUserList(paramMap, PageHelperUtil.getPageNum(request), PageHelperUtil.getPageSize(request));
			aj.setMap(data);
			aj.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("SysUserController,ajaxGetList", e);
			aj.setSuccess(false);
			aj.setMsg(e.getMessage());
		}
		HttpServletUtil.ajaxResponse(response, aj);
		logger.info("**************** SysUserController,ajaxGetList:end ****************");
	}

	@PostMapping("/user.do")
	public void ajaxAddUser(MSysUser user, HttpServletResponse response) {
		logger.info("**************** SysUserController,ajaxAddUser:start ****************");
		AjaxJson aj = new AjaxJson();
		try {
			boolean b = userService.addUser(user);
			aj.setSuccess(b);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("SysUserController,ajaxAddUser", e);
			aj.setSuccess(false);
			aj.setMsg(e.getMessage());
		}
		HttpServletUtil.ajaxResponse(response, aj);
		logger.info("**************** SysUserController,ajaxAddUser:end ****************");
	}

	@PutMapping("/user.do")
	public void ajaxModifyUser(MSysUser user, HttpServletRequest request, HttpServletResponse response) {
		logger.info("**************** SysUserController,ajaxModifyUser:start ****************");
		AjaxJson aj = new AjaxJson();
		try {
			String loginUser = StrUtil.toString(SessionUtil.getSessionLoginUserName());
			Date now = new Date();

			user.setUpdateBy(loginUser);
			user.setUpdateDate(now);

			String new_pass = user.getPass();
			String org_pass = request.getParameter("org_pass");
			if (StrUtil.isNotEmpty(org_pass)) {
				MSysUser userInfoInDb = userService.getUserInfoByUuid(user.getUuid());
				if (userInfoInDb == null) {
					//用户不存在
					aj.setMsg("用户不存在");
					aj.setSuccess(false);
				} else {
					String dbUserUuid = StrUtil.toString(userInfoInDb.getUuid());
					String dbUserPass = StrUtil.toString(userInfoInDb.getPass());
					if (dbUserPass.equals(org_pass)) {
						//密码正确
						user = new MSysUser();
						user.setUuid(dbUserUuid);
						user.setPass(new_pass);
						aj.setSuccess(userService.modifyUser(user));
					} else {
						//密码不对
						aj.setMsg("原密码错误");
						aj.setSuccess(false);
					}
				}
			} else {
				aj.setSuccess(userService.modifyUser(user));
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("SysUserController,ajaxModifyUser", e);
			aj.setSuccess(false);
			aj.setMsg(e.getMessage());
		}
		HttpServletUtil.ajaxResponse(response, aj);
		logger.info("**************** SysUserController,ajaxModifyUser:end ****************");
	}

	@DeleteMapping("/user.do")
	public void ajaxDeleteUser(HttpServletRequest request, HttpServletResponse response) {
		logger.info("**************** SysUserController,ajaxDeleteUser:start ****************");
		AjaxJson aj = new AjaxJson();
		try {

			String uuid = request.getParameter("uuid");
			if (StrUtil.isNotEmpty(uuid)) {
				MSysUser userInfoInDb = userService.getUserInfoByUuid(uuid);
				if (userInfoInDb == null) {
					//用户不存在
					aj.setMsg("用户不存在");
					aj.setSuccess(false);
				} else {
					aj.setSuccess(userService.deleteUser(userInfoInDb));
				}
			} else {
				//参数不全
				aj.setMsg("缺少参数uuid.");
				aj.setSuccess(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("SysUserController,ajaxDeleteUser", e);
			aj.setSuccess(false);
			aj.setMsg(e.getMessage());
		}
		HttpServletUtil.ajaxResponse(response, aj);
		logger.info("**************** SysUserController,ajaxDeleteUser:end ****************");
	}
}
