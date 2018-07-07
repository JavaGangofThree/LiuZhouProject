package com.xkd.action.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xkd.dao.ProductDao;
import com.xkd.dao.impl.ProductDaoImpl;
import com.xkd.model.Product;

/**
 * 产品主页
 * @author waver
 *
 */
public class ProductedListAction extends HttpServlet{
	private Integer totalPage;//总页数
	private Integer totalRow;//总条数
	private Integer pageRow;//每页显示条数
	private Integer pageNum;//页码
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		pageRow = 8;
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//查询所有的产品列表
		try {
			//获取页面传入的页码（字符串）
			String pageNumStr = req.getParameter("pageNum");
			
			//用户点击页码
			if( pageNumStr != null ){
				pageNum = Integer.parseInt(pageNumStr);
			}else{
				pageNum = 1;
			}
			
			
			ProductDao pd = new ProductDaoImpl();
			totalRow = pd.countNum();
			//计算总页数
			totalPage = (totalRow % pageRow) == 0 ? totalRow / pageRow : (totalRow / pageRow) + 1;
			
			//分页查询产品list
			List<Product> list = pd.queryAll(pageNum, pageRow);
			
			
			
			
			req.setAttribute("totalRow", totalRow);
			req.setAttribute("totalPage", totalPage);
			req.setAttribute("pageNum", pageNum);
			req.setAttribute("pageRow", pageRow);
			
			req.setAttribute("productList", list);
			req.getRequestDispatcher("/WEB-INF/page/product/list.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}










