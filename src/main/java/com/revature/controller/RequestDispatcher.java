package com.revature.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.revature.delegates.FrontControllerDelegate;

public class RequestDispatcher {
	private Logger log = Logger.getLogger(RequestDispatcher.class);
	private Map<String, FrontControllerDelegate> delegateMap;
	{
		delegateMap = new HashMap<String, FrontControllerDelegate>();
		//add delegates
		
	}
	public FrontControllerDelegate dispatch(HttpServletRequest req,
			HttpServletResponse resp) throws IOException, ServletException {
		log.trace("Calling our Request Delegate: "+req.getRequestURI());

		addCorsHeader(req.getRequestURI(), resp);
		if("OPTIONS".equals(req.getMethod())) {
			return (r1, r2) -> {}; 
		}
		StringBuilder switchString = new StringBuilder(req.getRequestURI());
		switchString.replace(0, req.getContextPath().length()+1, "");
		
		if(switchString.indexOf("/")!=-1) {
			req.setAttribute("path",
					switchString.substring(switchString.indexOf("/")+1));
			switchString.replace(switchString.indexOf("/"), switchString.length(), "");
		}
		return delegateMap.get(switchString.toString());
	}
	private void addCorsHeader(String requestURI, HttpServletResponse resp) {
		log.trace("adding headers");
		resp.addHeader("Access-Control-Allow-Origin", "http://localhost:4200");
		resp.addHeader("Vary", "Origin");
        resp.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
        resp.addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
        resp.addHeader("Access-Control-Allow-Credentials", "true");
        resp.addHeader("Access-Control-Max-Age", "1728000");
        resp.addHeader("Produces", "application/json");
	}
}
