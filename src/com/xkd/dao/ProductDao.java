package com.xkd.dao;

import java.sql.SQLException;
import java.util.List;

import com.xkd.model.Product;

public interface ProductDao {
	/**查询所有的产品*/
	public List<Product> queryAll(Integer pageNum, Integer pageRow)throws SQLException;
	
	/**
	 * 查询总条数
	 * @return
	 * @throws SQLException
	 */
	public Integer countNum()throws SQLException;
	
	public void delete(Integer id)throws SQLException;
}
