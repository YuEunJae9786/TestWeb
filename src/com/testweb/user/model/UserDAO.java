package com.testweb.user.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.testweb.jdbc.util.JdbcUtil;

public class UserDAO {

	private static UserDAO instance = new UserDAO();
	
	private UserDAO() {
		
		try {
			InitialContext ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/oracle");
			
		} catch (NamingException e) {
			System.out.println("드라이버 호출 에러");
		}
			
	}
	
	public static UserDAO getInstance() {
		return instance;
	}
	
	// 멤버변수
	DataSource ds;
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	// 회원가입 메서드
	public void join(UserVO vo) {
		
		String sql ="insert into users values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setInt(4, vo.getPhone1());
			pstmt.setInt(5, vo.getPhone2());
			pstmt.setInt(6, vo.getPhone3());
			pstmt.setString(7, vo.getEmail1());
			pstmt.setString(8, vo.getEmail2());
			pstmt.setString(9, vo.getAddress1());
			pstmt.setString(10, vo.getAddress2());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
	}
	
	// 로그인 메서드
	public int login(String id, String pw) {
		int result = 0;
		
		String sql = "select * from users where id = ? and pw = ?";
		
		try {
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = 1;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		
		return result;
	}
	
	// 내 정보 반환 메서드
	public UserVO getInfo(String id) {
		UserVO vo = null;
		
		String sql = "select * from users where id = ?";
		
		try {
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				String name = rs.getString("name");
				int phone1 = rs.getInt("phone1");
				int phone2 = rs.getInt("phone2");
				int phone3 = rs.getInt("phone3");
				String email1 = rs.getString("email1");
				String email2 = rs.getString("email2");
				String address1 = rs.getString("address1");
				String address2 = rs.getString("address2");
				
				vo = new UserVO(id, null, name, phone1, phone2, phone3, email1, email2, address1, address2);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		return vo;
	}

	// 내 정보 변경 메서드
	public void update(UserVO vo) {
		
		String sql = "update users set pw=?, name=?, phone1=?, phone2=?, phone3=?, email1=?, email2=?, address1=?, address2=? where id = ?";
		
		try {
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPw());
			pstmt.setString(2, vo.getName());
			pstmt.setInt(3, vo.getPhone1());
			pstmt.setInt(4, vo.getPhone2());
			pstmt.setInt(5, vo.getPhone3());
			pstmt.setString(6, vo.getEmail1());
			pstmt.setString(7, vo.getEmail2());
			pstmt.setString(8, vo.getAddress1());
			pstmt.setString(9, vo.getAddress2());
			pstmt.setString(10, vo.getId());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		
	}

	// 회원 탈퇴 메서드
	public void delete(String id) {
		
		String sql = "delete from users where id = ?";
		
		try {
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
	}
}


