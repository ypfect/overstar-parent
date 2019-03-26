package com.overstar.elasticsearch.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Iterator;

@Component
@ServletComponentScan
@WebFilter(urlPatterns = "/*", filterName = "requestLogFilter")
public class RequestLogFilter implements Filter {

	public static final Logger logger = LoggerFactory.getLogger(RequestLogFilter.class);

	// request日志格式
	private static final String LOG_FORMAT = "url[{}], method[{}], params[{}], spendtime[{}]ms.";

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		long start = System.currentTimeMillis();

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		// 请求URL
		StringBuffer url = httpRequest.getRequestURL();
		String qstr = httpRequest.getQueryString();
		// 请求方式
		String method = httpRequest.getMethod();
		if (RequestMethod.GET.equals(method) && qstr != null && qstr.length() > 0) {
			url.append("?").append(qstr);
		}
		// http请求里面的post参数列表
		String params = getRequestParams(httpRequest);
		try {
			chain.doFilter(httpRequest, response);
		} finally {
			// 请求花费时间
			long spend = System.currentTimeMillis() - start;
			logger.info(LOG_FORMAT, url, method, params, spend);
		}
	}

	@Override
	public void destroy() {
	}

	private String getRequestParams(HttpServletRequest request) {
		StringBuilder result = new StringBuilder();
		Iterator<String> keyIterator = request.getParameterMap().keySet().iterator();
		while (keyIterator.hasNext()) {
			String key = keyIterator.next();
			result.append(key).append("=").append(request.getParameter(key)).append(",");
		}
		return result.length() > 0 ? result.substring(0, result.length() - 1) : result.toString();
	}

}
