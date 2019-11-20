package com.luzhoumin.mblog.management.util;

import cn.hutool.core.util.StrUtil;
import com.luzhoumin.mblog.management.constant.MBlogConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

/**
 * Created on October 10, 2019
 * Description: IP工具类
 *
 * @author <a href="mailto:zmlu1996@gmail.com">Jacob Lu</a>
 * @since 1.8
 */
public class IPUtil {

	private static Logger logger = LoggerFactory.getLogger(IPUtil.class);

	/**
	 * 获取用户实际IP地址
	 *
	 * @param request 当前请求对象
	 * @return 实际IP地址
	 */
	public static String getRemoteIp(HttpServletRequest request) {
		String ip = request.getHeader("X-Forwarded-For");
		logger.trace("当前IP来源[X-Forwarded-For], 值[{}]", ip);
		if (!StrUtil.isEmpty(ip) && !MBlogConstant.UNKNOWN.equalsIgnoreCase(ip)) {
			//多次反向代理后会有多个ip值，第一个ip才是真实ip
			int index = ip.indexOf(',');
			if (index != -1) {
				return ip.substring(0, index);
			} else {
				return ip;
			}
		}
		ip = request.getHeader("X-Real-IP");
		logger.trace("当前IP来源[X-Real-IP], 值[{}]", ip);
		if (!StrUtil.isEmpty(ip) && !MBlogConstant.UNKNOWN.equalsIgnoreCase(ip)) {
			return ip;
		}
		if (StrUtil.isEmpty(ip) || MBlogConstant.UNKNOWN.equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
			logger.trace("当前IP来源[Proxy-Client-IP], 值[{}]", ip);
		}
		if (StrUtil.isEmpty(ip) || MBlogConstant.UNKNOWN.equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
			logger.trace("当前IP来源[WL-Proxy-Client-IP], 值[{}]", ip);
		}
		if (StrUtil.isEmpty(ip) || MBlogConstant.UNKNOWN.equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
			logger.trace("当前IP来源[HTTP_CLIENT_IP], 值[{}]", ip);
		}
		if (StrUtil.isEmpty(ip) || MBlogConstant.UNKNOWN.equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
			logger.trace("当前IP来源[HTTP_X_FORWARDED_FOR], 值[{}]", ip);
		}
		if (StrUtil.isEmpty(ip) || MBlogConstant.UNKNOWN.equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
			logger.trace("当前IP来源[getRemoteAddr], 值[{}]", ip);
		}
		if ("0:0:0:0:0:0:0:1".equals(ip)) {
			String ipv4FromLocal = getSystemLocalIP();
			if (StrUtil.isNotEmpty(ipv4FromLocal)) {
				ip = ipv4FromLocal;
			}
		}
		return ip;
	}

	/*获取本地win的IP*/
	private static InetAddress getWinLocalIp() {
		try {
			return InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			return null;
		}
	}

	/*获取本地unix的IP*/
	private static InetAddress getUnixLocalIp() {
		InetAddress ia = null;
		try {
			Enumeration<?> e1 = NetworkInterface.getNetworkInterfaces();
			while (e1.hasMoreElements()) {
				NetworkInterface ni = (NetworkInterface) e1.nextElement();
				if (ni.getName().equals("eth0")) {
					Enumeration<?> e2 = ni.getInetAddresses();
					while (e2.hasMoreElements()) {
						ia = (InetAddress) e2.nextElement();
					}
					break;
				}
			}
		} catch (SocketException e) {
			return null;
		}
		return ia;
	}

	/*判断是哪种系统然后获取当前IP*/
	public static String getSystemLocalIP() {
		InetAddress inetAddress;
		String osname = System.getProperty("os.name");
		//针对window系统
		if (osname.toLowerCase().startsWith("windows")) {
			inetAddress = getWinLocalIp();
		} else {//针对unix系统
			inetAddress = getUnixLocalIp();
		}
		return inetAddress != null ? inetAddress.getHostAddress() : null;
	}
}
