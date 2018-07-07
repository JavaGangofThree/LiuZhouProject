package com.xkd.util;

import java.beans.PropertyVetoException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Util {
	private static String driverName = null;
	private static String url = null;
	private static String user = null;
	private static String password = null;
	
	private static ComboPooledDataSource ds = null;
	//连接池中保留的最小连接数
	private static Integer minPoolSize = null;
	//连接池中保留的最大连接数。Default: 15
	private static Integer maxPoolSize = null;
	//初始化时获取连接，取值应在minPoolSize与maxPoolSize之间。
	private static Integer initialPoolSize = null;
	//最大空闲时间,?秒内未使用则连接被丢弃。若为0则永不丢弃。Default: 0
	private static Integer maxIdleTime = null;
	
	
	
	
	static{
		try {
			File propFile = new File(C3P0Util.class.getResource(".").getPath() + "c3p0.properties");
			InputStream in = new FileInputStream(propFile);
			Properties prop = new Properties();
			prop.load(in);
			
			//获取properties文件中的基本配置信息
			driverName = prop.getProperty("driverName");
			url = prop.getProperty("url");
			user = prop.getProperty("user");
			password = prop.getProperty("password");
			
			//获取c3p0配置
			minPoolSize = Integer.parseInt( prop.getProperty("minPoolSize") );
			maxPoolSize = Integer.parseInt( prop.getProperty("maxPoolSize") );
			initialPoolSize = Integer.parseInt( prop.getProperty("initialPoolSize") );
			maxIdleTime = Integer.parseInt( prop.getProperty("maxIdleTime") );
			
			//创建cep0对象
			ds = new ComboPooledDataSource();
			//设置基本配置信息
			ds.setJdbcUrl(url);
			ds.setUser(user);
			ds.setPassword(password);
			
			//设置c3p0配置信息
			ds.setMinPoolSize(minPoolSize);
			ds.setMaxPoolSize(maxPoolSize);
			ds.setInitialPoolSize(initialPoolSize);
			ds.setMaxIdleTime(maxIdleTime);
			
			
			ds.setDriverClass(driverName);
			
//			Class.forName(driverName);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取数据库连接
	 * @return
	 */
	public static Connection getConnection(){
		Connection conn = null;
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 关闭数据库连接
	 * @param conn	数据库连接
	 */
	public static void close(Connection conn){
		try {
			if( conn != null )conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
}
