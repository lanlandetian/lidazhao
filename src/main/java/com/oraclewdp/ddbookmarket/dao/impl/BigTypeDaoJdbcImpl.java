package com.oraclewdp.ddbookmarket.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.oraclewdp.ddbookmarket.dao.BigTypeDao;
import com.oraclewdp.ddbookmarket.model.BigType;
import com.oraclewdp.ddbookmarket.util.DBUtil;

public class BigTypeDaoJdbcImpl implements BigTypeDao {

	@Override
	public boolean asve(String name) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "insert into t_big_type values(default,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, name);
			int ret = stmt.executeUpdate();
			if(ret>0) {
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.free(stmt, conn);
		}
		
		return false;
	}

	@Override
	public List<BigType> findAll() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();
			String sql = "select * from t_big_type";
			rs = stmt.executeQuery(sql);
			List<BigType> ls = new ArrayList<>();
			while(rs.next()) {
				BigType bigType = new BigType();
				bigType.setId(rs.getInt("id"));
				bigType.setName(rs.getString("name"));
				ls.add(bigType);
			}
			return ls;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.free(rs, stmt, conn);
		}
		return null;
	}

}
