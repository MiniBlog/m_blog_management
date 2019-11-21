package com.luzhoumin.mblog.management.controller;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.luzhoumin.mblog.management.pojo.AjaxJson;
import com.luzhoumin.mblog.management.service.SysUserService;
import com.luzhoumin.mblog.management.util.HttpServletUtil;
import com.luzhoumin.mblog.management.util.SessionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Login 登陆
 *
 * @auther Jacob
 */
@RestController
public class LoginController {

	private static Logger logger = LoggerFactory.getLogger(LoginController.class);
	@Resource
	SysUserService sysUserService;

	@RequestMapping("/login.html")
	public ModelAndView pageLogin() {
		logger.info("**************** LoginController,pageLogin:start ****************");
		logger.info("**************** LoginController,pageLogin:end ****************");
		return new ModelAndView("login/login");
	}

	@RequestMapping("/logout.html")
	public void pageLogout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		logger.info("**************** LoginController,pageLogout:start ****************");
		SessionUtil.clearSessionAttrs();
		logger.info("**************** LoginController,pageLogout:end ****************");
		response.sendRedirect(HttpServletUtil.getCurrentCompleteDomainName() + "/login.html");
	}

	@RequestMapping("/login.do")
	public void ajaxLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("**************** LoginController,ajaxLogin:start ****************");
		AjaxJson aj = new AjaxJson();
		String userName = request.getParameter("userName");
		String userPass = request.getParameter("userPass");
		String returnUrl = request.getParameter("returnUrl");
		if (StrUtil.isEmpty(returnUrl)) {
			returnUrl = HttpServletUtil.getCurrentCompleteDomainName() + "/index.html";
		}
		aj.setStr(returnUrl);
		Map<String, Object> userInfo = sysUserService.getUserInfo(userName);
		if (userInfo == null) {
			//用户不存在
			aj.setMsg("用户不存在");
			aj.setObj("userName");
			aj.setSuccess(false);
		} else {
			String dbUserName = StrUtil.toString(userInfo.get("_name"));
			String dbUserPass = StrUtil.toString(userInfo.get("_pass"));
			String dbUserUid = StrUtil.toString(userInfo.get("_uid"));
			String data1 = SecureUtil.md5(dbUserName);
			String data2 = SecureUtil.md5(data1 + dbUserPass);
			if (data2.equals(userPass)) {
				//登陆成功
				SessionUtil.setSessionLoginUserUid(dbUserUid);
				SessionUtil.setSessionLoginUserName(dbUserName);
				aj.setSuccess(true);
			} else {
				//密码不对
				aj.setMsg("用户名或密码错误");
				aj.setObj("userPass");
				aj.setSuccess(false);
			}
		}
		logger.info("**************** LoginController,ajaxLogin:start ****************");
		HttpServletUtil.ajaxResponse(response, aj);
	}
}
