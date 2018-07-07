package com.xkd.action.product;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xkd.dao.ProductDao;
import com.xkd.dao.impl.ProductDaoImpl;

import net.sf.json.JSONObject;

public class ProductedDeleteAction extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String pid = req.getParameter("pid");
			
			ProductDao pd = new ProductDaoImpl();
			pd.delete( Integer.parseInt(pid) );
			
			//响应
			JSONObject json = new JSONObject();
			json.put("statusCode", "200");
			json.put("message", "删除成功");
			json.put("navTabId", "productedList");
			json.put("rel", "");
			
			PrintWriter out = resp.getWriter();
			out.println( JSONObject.fromObject( json ) );
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
