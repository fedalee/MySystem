package com.wabacus.util;

import java.sql.*;

import com.wabacus.config.Config;

public class OracleConnection {

	public Connection connection = null;
	
	
	/**
	 * 获取数据库连接
	 * @return
	 */
	public Connection getConnection(){
		if(connection==null)
			connection = Config.getInstance().getDataSource("").getConnection();
		return connection;
	}
	
	
	/**
	 * 释放资源
	 * @param conn
	 * @param pstmt
	 * @param rs
	 */
    public  void closeAll( Connection conn, Statement pstmt, ResultSet rs ) {
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
            	e.printStackTrace();
            }
        }
    }
    
    
	
}

