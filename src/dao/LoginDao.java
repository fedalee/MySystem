package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.wabacus.util.GetConnectionByWabacus;
import entity.UserBean;


public class LoginDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	/**
	 * 用户验证方法
	 * 
	 * @param userName
	 * @param password
	 * @return Users
	 */
	public UserBean validUser(String userName, String password) {
		
		// 用户
		UserBean user = null;
		
		// 查询语句
		String sql = "select * from xtsz_yhgl_user where userName=? and password=?";
		try {
			conn = GetConnectionByWabacus.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, userName);
			pstmt.setString(2, password);

			rs = pstmt.executeQuery();

			// 封装信息
			if (rs.next()) {
				user = new UserBean();
				user.setId(rs.getString("id"));
				user.setUserName(rs.getString("userName"));
				user.setPassword(rs.getString("password"));
				user.setRealName(rs.getString("realName"));
				user.setRole(rs.getString("role"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			GetConnectionByWabacus.closeAll(conn, pstmt, rs);
		}
		return user;
	}
}
