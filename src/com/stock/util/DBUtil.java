package com.stock.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:ORCL";
//	private String url = "jdbc:oracle:thin:@192.168.56.1:1521:ORCL";
	private String user = "ps";
	private String psw = "ps";
	private Connection con = null;

	public Connection getConnection() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, psw);
			con.setAutoCommit(false); // 关闭自动提交
			if (con == null)
				throw new Exception("获取数据库连接失败！");
		} catch (SQLException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public void commit() {
		try {
			con.commit();// 手动提交
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}