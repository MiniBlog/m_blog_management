package com.luzhoumin.mblog.management.controller;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.luzhoumin.mblog.management.pojo.AjaxJson;
import com.luzhoumin.mblog.management.service.SysUserService;
import com.luzhoumin.mblog.management.util.HttpServletUtil;
import com.luzhoumin.mblog.management.util.SessionUtil;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@RestController
public class LoginController {

	@Resource
	SysUserService sysUserService;

	@RequestMapping("/login.html")
	public ModelAndView loginPage() {
		log.info("LoginController,loginPage:start");
		ModelAndView modelAndView = new ModelAndView("login/login");
		log.info("LoginController,loginPage:end");
		return modelAndView;
	}

	@RequestMapping("/logout.html")
	public void logoutPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		log.info("LoginController,logoutPage:start");
		SessionUtil.clearSessionAttrs();
		response.sendRedirect(HttpServletUtil.getCurrentCompleteDomainName() + "/login.html");
		log.info("LoginController,logoutPage:end");
	}

	@RequestMapping("/login.do")
	public void ajaxLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.info("LoginController,ajaxLogin:start");
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
		HttpServletUtil.ajaxResponse(response, aj);
		log.info("LoginController,ajaxLogin:end");
	}
}
