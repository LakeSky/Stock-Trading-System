package com.stock.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.stock.util.DBUtil;

public class StockTradeModel {
	private DBUtil db = new DBUtil();

	/**
	 * 买家下单
	 * 
	 * @param userid
	 * @param stockid
	 * @param stockPrice
	 * @param stockNumber
	 * @return
	 * @throws SQLException
	 */
	public int buyStock(String userid, String stockid, String stockPrice,
			String stockNumber) throws SQLException {
		int num = 0;
		String sql = "insert into stock_bill(trade_id,tradeuser_id,stock_id,stock_price,stock_number,untrade_number,trade_type,trade_status) values (seq_stock_bill.nextval,?,to_number(?),to_number(?),to_number(?),to_number(?),1,0)";
		Connection con = db.getConnection();
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, userid);
		pst.setString(2, stockid);
		pst.setString(3, stockPrice);
		pst.setString(4, stockNumber);
		pst.setString(5, stockNumber);
		num = pst.executeUpdate();
		db.commit();
		db.close();
		return num;
	}

	/**
	 * 卖家下单
	 * 
	 * @param userid
	 * @param stockid
	 * @param stockPrice
	 * @param stockNumber
	 * @return
	 * @throws SQLException
	 */
	public int saleStock(String userid, String stockid, String stockPrice,
			String stockNumber) throws SQLException {
		int num = 0;
		String sql = "insert into stock_bill(trade_id,tradeuser_id,stock_id,stock_price,stock_number,untrade_number,trade_type,trade_status) values (seq_stock_bill.nextval,?,to_number(?),to_number(?),to_number(?),to_number(?),2,0)";
		Connection con = db.getConnection();
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, userid);
		pst.setString(2, stockid);
		pst.setString(3, stockPrice);
		pst.setString(4, stockNumber);
		pst.setString(5, stockNumber);
		num = pst.executeUpdate();
		db.commit();
		db.close();
		return num;
	}
}