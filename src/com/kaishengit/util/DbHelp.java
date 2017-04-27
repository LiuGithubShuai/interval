package com.kaishengit.util;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;


public class DbHelp {
	
	public static Connection getConnection(){
		return ConnectionManager.getConnection();
	}
	
	public static <T> T query(String sql, ResultSetHandler<T> rsh, Object... params){
		
		Connection connection = getConnection();
		
		try {
			QueryRunner queryRunner = new QueryRunner();		
			return queryRunner.query(connection, sql, rsh, params);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(connection);
		}
		return null;
	}

	private static void close(Connection connection) {
		if(connection != null){
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
