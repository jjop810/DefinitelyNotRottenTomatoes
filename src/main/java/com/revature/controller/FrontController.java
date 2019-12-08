package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;
import org.apache.log4j.Logger;

import com.revature.delegates.FrontControllerDelegate;

public class FrontController extends DefaultServlet {
	private Logger log = Logger.getLogger(FrontController.class);
	private RequestDispatcher rh = new RequestDispatcher();
	
	private void process(HttpServletRequest req, HttpServletResponse resp)
		throws IOException, ServletException {
		String uriSansContext = req.getRequestURI()
				.substring(req.getContextPath().length());
		log.trace(uriSansContext);
		if(uriSansContext.startsWith("/static")) {
			log.trace("Handling static content with Default Servlet");
			super.doGet(req, resp);
		} else {
			log.trace("Not static");
			FrontControllerDelegate fd = rh.dispatch(req, resp);
			if(fd != null) {
				fd.process(req, resp);
			} else {
				resp.sendError(HttpServletResponse.SC_NOT_FOUND);
				//resp.sendError(404);
			}
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		process(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		process(req, resp);
	}
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		process(req, resp);
	}
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		process(req, resp);
	}
	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		process(req, resp);
	}

	
}
