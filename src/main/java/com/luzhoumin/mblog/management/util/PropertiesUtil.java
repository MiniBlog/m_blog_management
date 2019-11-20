package com.luzhoumin.mblog.management.util;

import com.github.pagehelper.util.StringUtil;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * 读取配置文件工具类
 */
public class PropertiesUtil {

	/**
	 * 获取HTTP请求路径配置内容
	 * @param configKey
	 * @return
	 */
	public static String getHttpRequestPath(String configKey){
		String httpRequestDomainName = "";
		String httpRequestPath = getConfigValue("http-request-path.properties", configKey);

		if (httpRequestPath.contains("${http_request_domain_name_1}"))
		{
			httpRequestDomainName = getDomainName("http_request_domain_name_1");
			httpRequestPath = httpRequestPath.replace("${http_request_domain_name_1}", httpRequestDomainName);
		}
		else if (httpRequestPath.contains("${http_request_domain_name_2}"))
		{
			httpRequestDomainName = getDomainName("http_request_domain_name_2");
			httpRequestPath = httpRequestPath.replace("${http_request_domain_name_2}", httpRequestDomainName);
		}
		else if (httpRequestPath.contains("${http_request_domain_name_3}"))
		{
			httpRequestDomainName = getDomainName("http_request_domain_name_3");
			httpRequestPath = httpRequestPath.replace("${http_request_domain_name_3}", httpRequestDomainName);
		}
		else if (httpRequestPath.contains("${http_request_domain_name_4}"))
		{
			httpRequestDomainName = getDomainName("http_request_domain_name_4");
			httpRequestPath = httpRequestPath.replace("${http_request_domain_name_4}", httpRequestDomainName);
		}
		else if (httpRequestPath.contains("${http_request_domain_name_5}"))
		{
			httpRequestDomainName = getDomainName("http_request_domain_name_5");
			httpRequestPath = httpRequestPath.replace("${http_request_domain_name_5}", httpRequestDomainName);
		}
		else if (httpRequestPath.contains("${http_request_domain_name_6}"))
		{
			httpRequestDomainName = getDomainName("http_request_domain_name_6");
			httpRequestPath = httpRequestPath.replace("${http_request_domain_name_6}", httpRequestDomainName);
		}
		else if (httpRequestPath.contains("${http_request_domain_name_7}"))
		{
			httpRequestDomainName = getDomainName("http_request_domain_name_7");
			httpRequestPath = httpRequestPath.replace("${http_request_domain_name_7}", httpRequestDomainName);
		}
		else if (httpRequestPath.contains("${http_request_domain_name_8}"))
		{
			httpRequestDomainName = getDomainName("http_request_domain_name_8");
			httpRequestPath = httpRequestPath.replace("${http_request_domain_name_8}", httpRequestDomainName);
		}
		else if (httpRequestPath.contains("${http_request_domain_name_9}"))
		{
			httpRequestDomainName = getDomainName("http_request_domain_name_9");
			httpRequestPath = httpRequestPath.replace("${http_request_domain_name_9}", httpRequestDomainName);
		}

		return httpRequestPath;
	}

	/**
	 * 获取domain-name.properties配置
	 * @param configKey
	 * @return
	 */
	public static String getDomainName(String configKey){
		return getConfigValue("domain-name.properties", configKey);
	}

	/**
	 * 获取配置文件内容
	 * @param configFileName
	 * @param configKey
	 * @return
	 */
	private static String getConfigValue(String configFileName, String configKey) {
		String configValue = "";
		InputStream is = null;
		try {
			is = PropertiesUtil.class.getClassLoader().getResourceAsStream(configFileName);
			Properties p = new Properties();
			p.load(new InputStreamReader(is,"UTF-8"));
			if (p.containsKey(configKey)){
				configValue = p.getProperty(configKey);
				if (StringUtil.isNotEmpty(configValue)) {
					//去除人为因素的空格
					configValue = configValue.trim();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return configValue;
	}
}
