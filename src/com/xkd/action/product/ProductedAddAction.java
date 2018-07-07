package com.xkd.action.product;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

public class ProductedAddAction extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//获取页面数据
			
			//从dao中想数据库插入一条数据
			
			
			//向前端页面响应
			//响应
			JSONObject json = new JSONObject();
			json.put("statusCode", "200");
			json.put("message", "OK!");
			json.put("navTabId", "productAddPage");
			json.put("rel", "productedList");
			json.put("callbackType", "closeCurrent");
			
			PrintWriter out = resp.getWriter();
			out.println( JSONObject.fromObject( json ) );
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
