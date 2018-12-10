package com.oraclewdp.ddbookmarket.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.oraclewdp.ddbookmarket.dao.BookDao;
import com.oraclewdp.ddbookmarket.model.Book;
import com.oraclewdp.ddbookmarket.util.DBUtil;
import com.oraclewdp.ddbookmarket.util.PageConstant;

public class BookDaoJdbcImpl implements BookDao {

	@Override
	public boolean save(Book book) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement("insert into t_book values(default,?,?,?,?,?,?,?,?)");
			stmt.setString(1, book.getName());
			stmt.setDouble(2, book.getPrice());
			stmt.setString(3, book.getAuthor());
			stmt.setString(4, book.getCbs());
			stmt.setDate(5, new java.sql.Date(book.getCbDate().getTime()));
			stmt.setString(6, book.getDescri());
			stmt.setInt(7, book.getSid());
			stmt.setString(8, book.getPhoto());
			int ret = stmt.executeUpdate();
			if (ret>0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.free(stmt, conn);
		}
		return false;
	}

	@Override
	public List<Book> findAll(int currentPage,String name,int sid) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();
		/*	String sql = "select * from t_book order by id desc limit ";
			//四种情况
			//1啥也不做
	     	if((name == null || name.equals("")) && sid ==-1) {
				//啥也不做
			}
			//2限定name，不限定sid
			if((name != null || name.equals("")) && sid ==-1) {
				sql +=" where name like '%"+name+"%' ";
			}
			//3不限定name但限定sid
			if((name == null || name.equals("")) && sid !=-1) {
				sql +=" where sid="+sid;
			}
			//4即限定name有限定sid
			if((name != null && !name.equals("")) && sid !=-1) {
				sql +=" where name like '%"+name+"%' and sid="+sid;
			}
			*/
			//如果前一个条件起作用，我要加and
			//否则我要加and
			//我们加上一个虚拟的条件，这样没有否则了
			String sql = "select * from t_book  where 1=1 ";
			if(name != null && !name.equals("")) {
				sql +=" and name like '%"+name+"%' ";
			}
			if(sid!=-1) {
				sql+=" and sid="+sid;
			}
			sql += " order by id desc limit " +((currentPage-1)*PageConstant.PAGE_SIZE+1-1)+","+PageConstant.PAGE_SIZE;
			System.out.println(sql);
			rs = stmt.executeQuery(sql);
			List<Book> ls = new ArrayList<>();
			while(rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt("id"));
				book.setName(rs.getString("name"));
				book.setAuthor(rs.getString("author"));
				book.setCbDate(rs.getDate("cbDate"));
				book.setCbs(rs.getString("cbs"));
				book.setDescri(rs.getString("descri"));
				book.setPhoto(rs.getString("photo"));
				book.setPrice(rs.getDouble("price"));
				book.setSid(rs.getInt("sid"));
				ls.add(book);
			}
			return ls;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.free(rs, stmt, conn);
		}
		return null;
	}

	@Override
	public int total(String name,int sid) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();
			String sql = "select count(*) from t_book where 1=1";
			if(name != null && !name.equals("")) {
				sql +=" and name like '%"+name+"%' ";
			}
			if(sid!=-1) {
				sql+=" and sid="+sid;
			}
			rs = stmt.executeQuery(sql);
			List<Book> ls = new ArrayList<>();
			if(rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.free(rs, stmt, conn);
		}
		return 0;
	}

	@Override
	public int del(int id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement("delete from t_book where id="+id);
			int ret = stmt.executeUpdate();
			if (ret>0) {
				return ret;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.free(stmt, conn);
		}
		return 0;
	}

	@Override
	public Book find(int id) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();

			String sql = "select * from t_book  where id=  "+id;


			System.out.println(sql);
			rs = stmt.executeQuery(sql);

			if(rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt("id"));
				book.setName(rs.getString("name"));
				book.setAuthor(rs.getString("author"));
				book.setCbDate(rs.getDate("cbDate"));
				book.setCbs(rs.getString("cbs"));
				book.setDescri(rs.getString("descri"));
				book.setPhoto(rs.getString("photo"));
				book.setPrice(rs.getDouble("price"));
				book.setSid(rs.getInt("sid"));
				return  book;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.free(rs, stmt, conn);
		}
		return null;
	}

	@Override
	public boolean update(Book book) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DBUtil.getConnection();
			if(book.getPhoto()==null){//如果用户没有修改图片，表示他不向修改图片
				stmt = conn.prepareStatement("update t_book set name=?,price=?,author=?,cbs=?,cbDate=?,descri=?,sid=? where id=? ");
				stmt.setString(1,book.getName());
				stmt.setDouble(2, book.getPrice());
				stmt.setString(3, book.getAuthor());
				stmt.setString(4, book.getCbs());
				stmt.setDate(5, new java.sql.Date(book.getCbDate().getTime()));
				stmt.setString(6, book.getDescri());
				stmt.setInt(7, book.getSid());
				stmt.setInt(8,book.getId());
			}else{
				stmt = conn.prepareStatement("update t_book set name=?,price=?,author=?,cbs=?,cbDate=?,descri=?,sid=?,photo=? where id=?");
				stmt.setString(1, book.getName());
				stmt.setDouble(2, book.getPrice());
				stmt.setString(3, book.getAuthor());
				stmt.setString(4, book.getCbs());
				stmt.setDate(5, new java.sql.Date(book.getCbDate().getTime()));
				stmt.setString(6, book.getDescri());
				stmt.setInt(7, book.getSid());
				stmt.setString(8, book.getPhoto());
				stmt.setInt(9,book.getId());
			}
			int ret = stmt.executeUpdate();
			if (ret>0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.free(stmt, conn);
		}
		return false;
	}

}
