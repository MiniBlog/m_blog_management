package com.luzhoumin.mblog.management.interceptor;


import cn.hutool.core.util.StrUtil;
import com.luzhoumin.mblog.management.pojo.MSysLogRequest;
import com.luzhoumin.mblog.management.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * 拦截器
 */
public class Interceptor implements HandlerInterceptor {

	private static Logger logger = LoggerFactory.getLogger(Interceptor.class);

	String[] noLoginPathPattens = new String[]{"/error", "/login", ".do"};

	/**
	 * 在请求处理之前进行调用（Controller方法调用之前）
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// 只有返回true才会继续向下执行，返回false取消当前请求
		logger.info(">>>Interceptor>>>>>>>在请求处理之前进行调用（Controller方法调用之前）");
		response.addHeader("x-frame-options", "SAMEORIGIN");
//		//1.请求日志
//		logRequest(request);
		//2.请求地址拦截
		String requestPath = HttpServletUtil.getRequestPath(request);
		if (StrUtil.containsAny(requestPath, noLoginPathPattens)) {
			return true;
		}
		//3.登录拦截
		return loginIntercept(request, response);
	}

	/**
	 * 记录请求日志
	 *
	 * @param request
	 */
	private void logRequest(HttpServletRequest request) {
		MSysLogRequest mSysLogRequest = new MSysLogRequest();
		String userName = StrUtil.toString(SessionUtil.getSessionLoginUserName());
		String userUuid = StrUtil.toString(SessionUtil.getSessionLoginUserUuid());
		mSysLogRequest.setUserName(userName);
		mSysLogRequest.setUserUuid(userUuid);
		mSysLogRequest.setSource("b");
		mSysLogRequest.setPath(request.getRequestURL().toString());
		mSysLogRequest.setQuery(request.getQueryString());
		mSysLogRequest.setParams(ConvertUtil.requestToString(request));
		mSysLogRequest.setIp(IPUtil.getRemoteIp(request));
		mSysLogRequest.setCreateDate(new Date());
		LogUtil.logRequest(mSysLogRequest);
	}

	/**
	 * 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		//获取当前域名和Ajax用域名
		String webRoot = HttpServletUtil.getCurrentCompleteDomainName();
		request.setAttribute("webRoot", webRoot);
		request.setAttribute("webRootAjax", webRoot);
		request.setAttribute("webRootCdnStatic", webRoot);
	}

	/**
	 * 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//		logger.info(">>>Interceptor>>>>>>>在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）");
	}

	/**
	 * 登录拦截
	 *
	 * @param request
	 * @param response
	 * @return
	 */
	private boolean loginIntercept(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String requestPath = HttpServletUtil.getRequestPath(request);
		if (SessionUtil.getSessionLoginUserUuid() == null) {
			logger.info("====登录状态 未登录[拦截成功" + requestPath + "]====");
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<script>");
			out.println("window.open ('" + HttpServletUtil.getCurrentCompleteDomainName() + "/login.html','_top')");
			out.println("</script>");
			out.println("</html>");
			return false;
		}
		return true;
	}

}
