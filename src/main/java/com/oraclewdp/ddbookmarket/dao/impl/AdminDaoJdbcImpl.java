package com.oraclewdp.ddbookmarket.dao.impl;

import com.oraclewdp.ddbookmarket.dao.AdminDao;
import com.oraclewdp.ddbookmarket.model.Admin;

import com.oraclewdp.ddbookmarket.util.DBUtil;
import com.oraclewdp.ddbookmarket.util.Md5Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class AdminDaoJdbcImpl implements AdminDao {
    @Override
    public boolean find(Admin admin) {
      Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
//        try {
//       conn = DBUtil.getConnection();
//            String sql = "select pwd from t_admin where name=? ";
//            stmt=conn.prepareStatement(sql);
//            stmt.setString(1,admin.getName());
//            stmt.setString(2, Md5Util.getEncryptedPwd(admin.getPwd(),"utf-8"));
//
//            rs = stmt.executeQuery();
//            if(rs.next()) {
//                String dbPwd=rs.getString(1);
//            return Md5Util.validPasswd(admin.getPwd(),dbPwd);
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }finally {
//            DBUtil.free(rs, stmt, conn);
//        }
        try {
            conn = DBUtil.getConnection();
            String sql = "select pwd from t_admin where name=? ";
            stmt=conn.prepareStatement(sql);
            stmt.setString(1,admin.getName());
            rs = stmt.executeQuery();
            if(rs.next()) {
                String dbPwd=rs.getString(1);
                return Md5Util.validPasswd(admin.getPwd(),dbPwd);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.free(rs, stmt, conn);
        }
        return false;
    }
}
