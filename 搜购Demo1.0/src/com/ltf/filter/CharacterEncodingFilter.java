package com.ltf.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

public class CharacterEncodingFilter implements Filter {
	
	private FilterConfig config;
	
    public CharacterEncodingFilter() {
    }
    /**
     * 过滤器生命周期结束时释放资源的方法
     */
	public void destroy() {
		System.out.println("destroy方法调用，过滤器生命周期结束");
	}
	/**
	 * 过滤器执行过滤功能的方法
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String initParameter = config.getInitParameter("Encoding");
		request.setCharacterEncoding(initParameter);
		response.setContentType("text/html;charset=" + initParameter);
		//System.out.println("初始化参数的CharacterEncoding值是："+initParameter);
		chain.doFilter(request, response);
		//System.out.println("过滤器处理完响应内容，再将响应返回给客户端");
	}
	/**
	 * 过滤器初始的方法
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		this.config = fConfig;
		System.out.println("init方法启动，初始化过滤器对象");
	}

}
