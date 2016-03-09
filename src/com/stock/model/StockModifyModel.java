package com.stock.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.stock.util.DBUtil;

public class StockModifyModel {
	private DBUtil db = new DBUtil();

	/**
	 * 增加股票信息
	 * 
	 * @param stockId
	 * @param stockName
	 * @param stockPy
	 * @return
	 * @throws SQLException
	 */
	public int addStockInfo(String stockId, String stockName, String stockPy)
			throws SQLException {
		int num = 0;
		String sql = "insert into stock_info (stock_id,stock_name,stock_py) values (?,?,?)";
		Connection con = db.getConnection();
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, stockId);
		pst.setString(2, stockName);
		pst.setString(3, stockPy);
		num = pst.executeUpdate();
		db.commit();
		db.close();
		return num;
	}

	/**
	 * 增加股票初始价格
	 * 
	 * @param stockId
	 * @param stockPrice
	 * @return
	 * @throws SQLException
	 */
	public int addStockPrice(String stockId, String stockPrice)
			throws SQLException {
		int num = 0;
		String sql = "insert into stock_price (stock_id,last_price) values (?,to_number(?))";
		Connection con = db.getConnection();
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, stockId);
		pst.setString(2, stockPrice);
		num = pst.executeUpdate();
		db.commit();
		db.close();
		return num;
	}

	/**
	 * 删除指定股票的所有信息
	 * 
	 * @param stockid
	 * @return
	 * @throws SQLException
	 */
	public int delStock(String stockid) throws SQLException {
		int a = 0, b = 0, c = 0, d = 0;
		Connection con = db.getConnection();
		String sql1 = "delete from stock_info where stock_id=?";
		String sql2 = "delete from stock_price where stock_id=?";
		String sql3 = "delete from stock_bill where stock_id=?";
		String sql4 = "delete from stock_record where stock_id=?";
		PreparedStatement pst1 = con.prepareStatement(sql1);
		PreparedStatement pst2 = con.prepareStatement(sql2);
		PreparedStatement pst3 = con.prepareStatement(sql3);
		PreparedStatement pst4 = con.prepareStatement(sql4);
		pst1.setString(1, stockid);
		pst2.setString(1, stockid);
		pst3.setString(1, stockid);
		pst4.setString(1, stockid);
		a = pst4.executeUpdate();
		b = pst3.executeUpdate();
		c = pst2.executeUpdate();
		d = pst1.executeUpdate();
		db.commit();
		db.close();
		return a | b | c | d;
	}
}