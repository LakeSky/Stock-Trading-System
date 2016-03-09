package com.stock.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.stock.bean.StockInfoBean;
import com.stock.bean.TradeRecordBean;
import com.stock.util.DBUtil;

public class StockQueryModel {
	private DBUtil db = new DBUtil();

	/**
	 * 查询所有股票信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<StockInfoBean> getAllStock() throws Exception {
		String sql = "select e.stock_id,(select stock_name from stock_info t where t.stock_id=e.stock_id) stock_name,e.last_price from stock_price e";
		Connection con = db.getConnection();
		PreparedStatement pst = con.prepareStatement(sql);
		List<StockInfoBean> stockList = new ArrayList<StockInfoBean>();
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			String stockid = rs.getString("stock_id");
			String stockName = rs.getString("stock_name");
			String stockPrice = rs.getString("last_price");
			stockList.add(new StockInfoBean(stockid, stockName, null,
					stockPrice, null));
		}
		db.commit();
		db.close();
		return stockList;
	}

	/**
	 * 查询记录总数
	 * 
	 * @return
	 * @throws Exception
	 */
	public int count() throws Exception {
		int ret = 0;
		Connection con = db.getConnection();
		Statement stmt = con.createStatement();
		String sql = "select count(*) from stock_info order by stock_id";
		ResultSet rs = stmt.executeQuery(sql);
		if (rs.next()) {
			ret = rs.getInt(1);
		}
		db.commit();
		db.close();
		return ret;
	}

	/**
	 * 分页查询
	 * 
	 * @param page
	 *            显示的页码
	 * @param pageContent
	 *            每页的容量
	 * @return
	 * @throws Exception
	 */
	public List<StockInfoBean> pageListStockPrice(int page, int pageContent)
			throws Exception {
		int startNum = (page - 1) * pageContent + 1; // 计算起始记录点
		int endNum = page * pageContent; // 计算终止的记录点
		String sql = "select * from (select t.*,rownum rn from(select stock_id,(select stock_name from stock_info g where g.stock_id=t.stock_id) as stock_name,last_price from stock_price t order by stock_id) t where rownum<=? ) where rn>=?";
		Connection con = db.getConnection();
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, String.valueOf(endNum));
		pst.setString(2, String.valueOf(startNum));
		List<StockInfoBean> stockList = new ArrayList<StockInfoBean>();
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			String stockid = rs.getString("stock_id");
			String stockName = rs.getString("stock_name");
			String stockPrice = rs.getString("last_price");
			stockList.add(new StockInfoBean(stockid, stockName, null,
					stockPrice, null));
		}
		db.commit();
		db.close();
		return stockList;
	}

	/**
	 * 通过搜索内容查找股票信息
	 * 
	 * @param searchConnent
	 * @return
	 * @throws Exception
	 */
	public List<StockInfoBean> searchQuery(String searchConnent)
			throws Exception {
		String sql = "select e.stock_id,(select stock_name from stock_info t where t.stock_id=e.stock_id) stock_name,e.last_price from stock_price e where e.stock_id like ? or(select stock_name from stock_info t where t.stock_id=e.stock_id) like ? or (select stock_py from stock_info t where t.stock_id=e.stock_id) like ? order by e.stock_id";
		Connection con = db.getConnection();
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, "%" + searchConnent + "%");
		pst.setString(2, "%" + searchConnent + "%");
		pst.setString(3, "%" + searchConnent + "%");
		List<StockInfoBean> stockList = new ArrayList<StockInfoBean>();
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			String stockid = rs.getString("stock_id");
			String stockName = rs.getString("stock_name");
			String stockPrice = rs.getString("last_price");
			stockList.add(new StockInfoBean(stockid, stockName, null,
					stockPrice, null));
		}
		db.commit();
		db.close();
		return stockList;
	}

	/**
	 * 查询用户现有股票
	 * 
	 * @param userid
	 * @return
	 * @throws Exception
	 */
	public List<StockInfoBean> getOwnStock(String userid) throws Exception {
		String sql = "select stock_id,(select stock_name from stock_info t where t.stock_id=e.stock_id) stock_name,stocknum,(select last_price from stock_price p where p.stock_id=e.stock_id) stock_price from now e where user_id=?";
		Connection con = db.getConnection();
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, userid);
		List<StockInfoBean> stockList = new ArrayList<StockInfoBean>();
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			String stockid = rs.getString("stock_id");
			String stockName = rs.getString("stock_name");
			String stockNum = rs.getString("stocknum");
			String stockPrice = rs.getString("stock_price");
			stockList.add(new StockInfoBean(stockid, stockName, null,
					stockPrice, stockNum));
		}
		db.commit();
		db.close();
		return stockList;
	}
	
	/**
	 * 查询用户股票交易记录
	 * @param userid
	 * @return
	 * @throws Exception
	 */
	public List<TradeRecordBean> getStockRecord(String userid) throws Exception {
		String sql = "select stock_id,(select e.stock_name from stock_info e where e.stock_id=t.stock_id) stock_name,stock_price,buyuser_id,selluser_id,trade_number,trade_time from stock_record t where t.buyuser_id=? or t.selluser_id=? order by stock_id";
		Connection con = db.getConnection();
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, userid);
		pst.setString(2, userid);
		List<TradeRecordBean> list = new ArrayList<TradeRecordBean>();
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			String stockid = rs.getString("stock_id");
			String stockName = rs.getString("stock_name");
			String stockPrice = rs.getString("stock_price");
			String buyuserid = rs.getString("buyuser_id");
			String saleuserid = rs.getString("selluser_id");
			String tradeNumber = rs.getString("trade_number");
			String tradeTime = rs.getString("trade_time");
			list.add(new TradeRecordBean(stockid, stockName, stockPrice, tradeNumber, buyuserid, saleuserid, tradeTime));
		}
		db.commit();
		db.close();
		return list;
	}
}