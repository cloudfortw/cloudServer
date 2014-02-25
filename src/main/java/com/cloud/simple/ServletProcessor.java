package com.cloud.simple;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;


public class ServletProcessor {
	public static final String web_root = System.getProperty("user.dir");
	public static final String package_path = "src.main.java.com.cloud.simple.";
	public void process(Request request, Response response) throws ClassNotFoundException, InstantiationException, IllegalAccessException, ServletException, IOException {
		String servletName = getServletName(request);
		if("".equals(servletName)){
			servletName = "DispatchServlet";
		}
		File file = new File(web_root);
		URL url = file.toURI().toURL();
		URL[] urls = new URL[]{url};
		System.out.println(package_path + servletName);
		System.out.println(web_root);
		URLClassLoader urlClassLoader = new URLClassLoader(urls);
		Class<DispatchServlet> servletClass = (Class<DispatchServlet>) urlClassLoader.loadClass(package_path + servletName);
		DispatchServlet servlet = servletClass.newInstance();
		System.out.println(servlet.getString());
		servlet.doService(request, response);
	}

	public String getServletName(Request request) {
		String url = request.getURI();
		return request.getURI().substring(1, url.length());
	}
}
