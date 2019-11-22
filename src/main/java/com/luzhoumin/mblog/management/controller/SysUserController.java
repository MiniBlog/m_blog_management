package com.luzhoumin.mblog.management.controller;

import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import com.luzhoumin.mblog.management.pojo.AjaxJson;
import com.luzhoumin.mblog.management.pojo.MSysUser;
import com.luzhoumin.mblog.management.service.SysSequenceService;
import com.luzhoumin.mblog.management.service.SysUserService;
import com.luzhoumin.mblog.management.util.ConvertUtil;
import com.luzhoumin.mblog.management.util.HttpServletUtil;
import com.luzhoumin.mblog.management.util.PageHelperUtil;
import com.luzhoumin.mblog.management.util.SessionUtil;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@RestController
@RequestMapping("/sys")
public class SysUserController {

	@Resource
	SysUserService sysUserService;
	@Resource
	SysSequenceService sysSequenceService;

	@RequestMapping("/user.html")
	public ModelAndView userListPage() {
		log.info("SysUserController,userListPage:start");
		ModelAndView modelAndView = new ModelAndView("user/user");
		log.info("SysUserController,userListPage:end");
		return modelAndView;
	}

	@GetMapping("/user.do")
	public void ajaxGetUserList(HttpServletRequest request, HttpServletResponse response) {
		log.info("SysUserController,ajaxGetUserList:start");
		AjaxJson aj = new AjaxJson();
		try {
			Map<String, String> paramMap = ConvertUtil.requestToMap(request);
			Map<String, Object> data = sysUserService.getUserList(paramMap, PageHelperUtil.getPageNum(request), PageHelperUtil.getPageSize(request));
			aj.setMap(data);
			aj.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("SysUserController,ajaxGetList", e);
			aj.setSuccess(false);
			aj.setMsg(e.getMessage());
		}
		HttpServletUtil.ajaxResponse(response, aj);
		log.info("SysUserController,ajaxGetUserList:end");
	}

	@PostMapping("/user.do")
	public void ajaxAddUser(MSysUser user, HttpServletResponse response) {
		log.info("SysUserController,ajaxAddUser:start");
		AjaxJson aj = new AjaxJson();
		try {
			String uid = sysSequenceService.getSequence("USER_ID");
			user.setUid(uid);
			boolean b = sysUserService.addUser(user);
			aj.setSuccess(b);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("SysUserController,ajaxAddUser", e);
			aj.setSuccess(false);
			aj.setMsg(e.getMessage());
		}
		HttpServletUtil.ajaxResponse(response, aj);
		log.info("SysUserController,ajaxAddUser:end");
	}

	@PutMapping("/user.do")
	public void ajaxModifyUser(MSysUser user, HttpServletRequest request, HttpServletResponse response) {
		log.info("SysUserController,ajaxModifyUser:start");
		AjaxJson aj = new AjaxJson();
		try {
			String loginUser = StrUtil.toString(SessionUtil.getSessionLoginUserName());
			Date now = new Date();

			user.setUpdateBy(loginUser);
			user.setUpdateDate(now);

			String new_pass = user.getPass();
			String org_pass = request.getParameter("org_pass");
			if (StrUtil.isNotEmpty(org_pass)) {
				MSysUser userInfoInDb = sysUserService.getUserInfoById(user.getId());
				if (userInfoInDb == null) {
					//用户不存在
					aj.setMsg("用户不存在");
					aj.setSuccess(false);
				} else {
					int dbUserId = userInfoInDb.getId();
					String dbUserPass = StrUtil.toString(userInfoInDb.getPass());
					if (dbUserPass.equals(org_pass)) {
						//密码正确
						user = new MSysUser();
						user.setId(dbUserId);
						user.setPass(new_pass);
						aj.setSuccess(sysUserService.modifyUser(user));
					} else {
						//密码不对
						aj.setMsg("原密码错误");
						aj.setSuccess(false);
					}
				}
			} else {
				aj.setSuccess(sysUserService.modifyUser(user));
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("SysUserController,ajaxModifyUser", e);
			aj.setSuccess(false);
			aj.setMsg(e.getMessage());
		}
		HttpServletUtil.ajaxResponse(response, aj);
		log.info("SysUserController,ajaxModifyUser:end");
	}

	@DeleteMapping("/user.do")
	public void ajaxDeleteUser(HttpServletRequest request, HttpServletResponse response) {
		log.info("SysUserController,ajaxDeleteUser:start");
		AjaxJson aj = new AjaxJson();
		try {

			String id = request.getParameter("id");
			if (StrUtil.isNotEmpty(id)) {
				MSysUser userInfoInDb = sysUserService.getUserInfoById(NumberUtil.parseInt(id));
				if (userInfoInDb == null) {
					//用户不存在
					aj.setMsg("用户不存在");
					aj.setSuccess(false);
				} else {
					aj.setSuccess(sysUserService.deleteUser(userInfoInDb));
				}
			} else {
				//参数不全
				aj.setMsg("缺少参数id.");
				aj.setSuccess(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("SysUserController,ajaxDeleteUser", e);
			aj.setSuccess(false);
			aj.setMsg(e.getMessage());
		}
		HttpServletUtil.ajaxResponse(response, aj);
		log.info("SysUserController,ajaxDeleteUser:end");
	}
}
