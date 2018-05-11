package com.example.msuser.dao.impl;
//package com.example.dao.impl;
//
//import java.sql.*;
//import java.util.stream.Stream;
//
//import javax.sql.DataSource;
//
//import com.example.beans.User;
//import com.example.dao.UserDAO;
//
//public class JdbcUserDAO implements UserDAO {
//
//	private DataSource dataSource;
//
//	public void setDataSource(DataSource dataSource) {
//		this.dataSource = dataSource;
//	}
//
//	@Override
//	public void insert(User user) {
//		Connection conn = null;
//		Statement stmt = null;
//		String sql = "";
//		ResultSet rs = null;
//		
//		try {
//			conn = DriverManager.getConnection("jdbc:odbc:userstable");
//			PreparedStatement ps = conn.prepareStatement("insert into [Sheet1$] (username, name, dateCreated, userGroup) VALUES (?,?,?,?)");
//			ps.setString(1, user.getUsername());
//			ps.setString(2, user.getName());
//			ps.setDate(3, user.getDateCreated());
//			ps.executeUpdate();
//			ps.close();
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//			
//		} finally {
//			if (conn != null) {
//				try {
//					conn.close();
//				} catch (SQLException e) {}
//			}
//		}
//	}
//
//	@Override
//	public User findByUsername(String username) {
//		return null;
//	}
//
//	@Override
//	public boolean usernameAvailable(String username) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public Stream<User> getAllUsersStream() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//}
