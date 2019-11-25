package com.luzhoumin.mblog.management.interceptor;


import cn.hutool.core.util.StrUtil;
import com.luzhoumin.mblog.management.pojo.TMbLogRequest;
import com.luzhoumin.mblog.management.util.*;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class Interceptor implements HandlerInterceptor {

	String[] noLoginPathPattens = new String[]{"/error", "/login", ".do"};

	/**
	 * 在请求处理之前进行调用（Controller方法调用之前）
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// 只有返回true才会继续向下执行，返回false取消当前请求
		log.info(">>>Interceptor>>>>>>>在请求处理之前进行调用（Controller方法调用之前）");
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
		TMbLogRequest tMbLogRequest = new TMbLogRequest();
		String userName = StrUtil.toString(SessionUtil.getSessionLoginUserName());
		String userUuid = StrUtil.toString(SessionUtil.getSessionLoginUserUid());
		tMbLogRequest.setUserName(userName);
		tMbLogRequest.setUserUuid(userUuid);
		tMbLogRequest.setSource("b");
		tMbLogRequest.setPath(request.getRequestURL().toString());
		tMbLogRequest.setQuery(request.getQueryString());
		tMbLogRequest.setParams(ConvertUtil.requestToString(request));
		tMbLogRequest.setIp(IPUtil.getRemoteIp(request));
		tMbLogRequest.setCreateDate(new Date());
		LogUtil.logRequest(tMbLogRequest);
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
//		log.info(">>>Interceptor>>>>>>>在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）");
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
		if (SessionUtil.getSessionLoginUserUid() == null) {
			log.info("====登录状态 未登录[拦截成功" + requestPath + "]====");
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
