package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager{
	/*
	 * データベース接続情報
	 * URL
	 */
	private static final String URL = "";
	/*
	 * ユーザー
	 */
	private static final String USER = "root";
	/*
	 * パスワード
	 */
	private static final String PASSWORD = "password";
	
	public static Connection getConnection()throws SQLException,ClassNotFoundException{
		//JDBC
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(URL,USER,PASSWORD);
	}
}
