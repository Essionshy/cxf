package com.tingyu.idcard.cxf.util;

import java.io.IOException;
import java.io.InputStream;

/**
 * 
 * @author Essionshy
 *
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {
	private static String driver = null;
	private static String url = null;
	private static String user = null;
	private static String password = null;

	public static Connection connection = null;
	public static PreparedStatement preparedStatement = null;
	private static ResultSet resultSet = null;
	static {
		// 声明配置类
		Properties properties = new Properties();
		Class<?> clazz = JDBCUtils.class;
		// 加载配置文件
		InputStream inStream = clazz.getResourceAsStream("/db.properties");
		try {
			properties.load(inStream);
			driver = properties.getProperty("jdbc.driver");
			url = properties.getProperty("jdbc.url");
			user = properties.getProperty("jdbc.user");
			password = properties.getProperty("jdbc.password");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private JDBCUtils() {};

	public static Connection getConnection() 
	{

		try 
		{
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		return connection;
	}

	public static PreparedStatement createPreparedStatement(String sql, Object[] params) {

		try {
			preparedStatement = getConnection().prepareStatement(sql);
			if (params != null) 
			{
				for (int i = 0; i < params.length; i++) 
				{
					preparedStatement.setObject(i + 1, params[i]);
				}
			}

		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return preparedStatement;
	}

	public static ResultSet executeQuery(String sql, Object[] params) 
	{
		PreparedStatement preparedStatement = null;
		try 
		{
			preparedStatement = createPreparedStatement(sql, params);
			resultSet = preparedStatement.executeQuery();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return resultSet;
	}

	/**
	 *  Close()方法，释放资源 
	 * @param resultSet
	 * @param preparedStatement
	 * @param connection
	 */
	public static void close(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection) {
		if (resultSet != null) 
		{
			try 
			{
				resultSet.close();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		if (preparedStatement != null) 
		{
			try 
			{
				preparedStatement.close();
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		if (connection != null) 
		{
			try 
			{
				connection.close();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}

	}	
}
