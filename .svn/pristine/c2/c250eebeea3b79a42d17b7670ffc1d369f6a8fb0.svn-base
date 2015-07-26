package com.wabacus.util;

import java.sql.*;

import com.wabacus.config.Config;

public class GetConnectionByWabacus {

	public static Connection connection = null;
	
	
	/**
	 * 获取数据库连接
	 * @return
	 */
	public static Connection getConnection(){
		connection = Config.getInstance().getDataSource("").getConnection();
		return connection;
	}
	
	
	/**
	 * 释放资源
	 * @param conn
	 * @param pstmt
	 * @param rs
	 */
    public static void closeAll( Connection conn, Statement pstmt, ResultSet rs ) {
        /*  如果rs不空，关闭rs  */
        if(rs != null){
            try { 
            	rs.close();
            	rs = null;
            } 
            catch (SQLException e) {
            	e.printStackTrace();
            }
        }
        /*  如果pstmt不空，关闭pstmt  */
        if(pstmt != null){
            try { 
            	pstmt.close();
            	pstmt = null;
            } catch (SQLException e) {
            	e.printStackTrace();
            }
        }
        /*  如果conn不空，关闭conn  */
        if(conn != null){
            try {
				conn.close();
				conn = null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
        }
    }
    
}

