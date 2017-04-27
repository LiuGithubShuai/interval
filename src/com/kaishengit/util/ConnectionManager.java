package com.kaishengit.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

import com.kaishengit.exception.DataSourceAccessException;

public class ConnectionManager {

	private static BasicDataSource dataSource = new BasicDataSource();
	
	static{
		Properties properties = new Properties();
		
		try {
			properties.load(ConnectionManager.class.getClassLoader().getResourceAsStream("config.properties"));
			
			dataSource.setDriverClassName(properties.getProperty("jdbc.driver"));
			dataSource.setUrl(properties.getProperty("jdbc.url"));
			dataSource.setUsername(properties.getProperty("jdbc.username"));
			dataSource.setPassword(properties.getProperty("jdbc.password"));
			
			dataSource.setInitialSize(5);
			dataSource.setMaxIdle(20);
			dataSource.setMinIdle(5);
			dataSource.setMaxWaitMillis(5000);
			
			
		} catch (IOException e) {
			e.printStackTrace();
			throw new DataSourceAccessException("读取配置文件失败");
		}
	}
	
	
	public static DataSource getDataSource(){
		return dataSource;
	}
	
	public static Connection getConnection(){
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataSourceAccessException("连接数据库失败");
		}
	}
	
}
