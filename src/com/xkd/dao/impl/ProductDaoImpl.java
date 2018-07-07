package com.xkd.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xkd.dao.ProductDao;
import com.xkd.model.Product;
import com.xkd.util.C3P0Util;

public class ProductDaoImpl implements ProductDao{

	@Override
	public List<Product> queryAll(Integer pageNum, Integer pageRow) throws SQLException {
		Connection conn = null;
		List<Product> list = new ArrayList<Product>();
		Product pro = null;
		try {
			conn = C3P0Util.getConnection();
			String sql = " select  pro.*, typ.name tName "
							+ " from `t_product` pro "
							+ " left join `t_p_type` typ on pro.type = typ.id "
							+ " order by pro.id asc "
							+ " limit ?, ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, (pageNum - 1) * pageRow);
			ps.setInt(2, pageRow);
			
			ResultSet rs = ps.executeQuery();
			while( rs.next() ){
				pro = new Product();
				pro.setId( rs.getInt("id") );
				pro.setName( rs.getString("name") );
				pro.setBrand( rs.getString("brand") );
				pro.setPower( rs.getInt("power") );
				pro.settName( rs.getString("tName") );
				list.add(pro);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally{
			C3P0Util.close(conn);
		}
		return list;
	}

	@Override
	public Integer countNum() throws SQLException {
		Connection conn = null;
		Integer totalRow = 0;
		try {
			conn = C3P0Util.getConnection();
			String sql = " select COUNT(*) totalRow from `t_product` pro ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if( rs.next() )totalRow = rs.getInt("totalRow");
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally{
			C3P0Util.close(conn);
		}
		return totalRow;
	}

	@Override
	public void delete(Integer id) throws SQLException {
		Connection conn = null;
		try {
			conn = C3P0Util.getConnection();
			String sql = " delete from `t_product` where id = ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally{
			C3P0Util.close(conn);
		}
	}
	
}
