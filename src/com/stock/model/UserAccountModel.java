package com.stock.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.stock.util.DBUtil;

public class UserAccountModel {
	private DBUtil db = new DBUtil();

	// 根据用户账号查找账户信息
	public String[] getAccount(String userid) throws SQLException {
		String[] str = new String[2];
		String sql = "select account_balance,last_modify from user_account where user_id=?";
		Connection con = db.getConnection();
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, userid);
		ResultSet rs = pst.executeQuery();
		if (rs.next()) {
			String accountBalance = rs.getString("account_balance");
			String lastModify = rs.getString("last_modify");
			str[0] = accountBalance;
			str[1] = lastModify;
		}
		db.commit();
		db.close();
		return str;
	}

	// 充值账户
	public int chargeAccount(String userid, double charge) throws SQLException {
		int num = 0;
		String sql = "update user_account set account_balance=account_balance+? where user_id=?";
		Connection con = db.getConnection();
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setDouble(1, charge);
		pst.setString(2, userid);
		num = pst.executeUpdate();
		db.commit();
		db.close();
		return num;
	}
}