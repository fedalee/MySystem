package com.wabacus.util;

import java.sql.*;

public class UserDefinedDatabaseOperations {
	
	
	public static void main(String[] args) throws SQLException {
		
	
		syshxinghaoshuliang("航行试验");
		syshsuoyouxinghao("航行试验");
		syshxinghaoshuliang("码头试验");
		syshsuoyouxinghao("码头试验");
	}
	
	public static int ketishuliang(String querySql) throws SQLException {	
		
		OracleConnection oracleConnection = new OracleConnection();
		Connection con = oracleConnection.getConnection();
		Statement st = null;
		ResultSet rs = null;
		int length = 0;
		try{
			st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs = st.executeQuery(querySql);
			rs.last(); 
			length = rs.getRow();
			System.out.println(length);
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			oracleConnection.closeAll(con, st, rs);
		}
		return length;
	}
	
	public static int syshxinghaoshuliang(String querySql) throws SQLException {
		
		OracleConnection oracleConnection = new OracleConnection();
		Connection con = oracleConnection.getConnection();
		Statement st = null;
		ResultSet rs = null;
		int length = 0;
		try{
			st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs = st.executeQuery(querySql);
			rs.last(); 
			length = rs.getRow();
			System.out.println(length);
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			oracleConnection.closeAll(con, st, rs);
		}
		return length;
	}
	
	public static String syshsuoyouxinghao(String querySql) throws SQLException {
		
		OracleConnection oracleConnection = new OracleConnection();
		Connection con = oracleConnection.getConnection();
		Statement st = null;
		ResultSet rs = null;
		String suoyouxinghaoString = null;
		try{
			st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs = st.executeQuery(querySql);
			while (rs.next()) {
				String xinghao = rs.getString("xinghao");
				if (suoyouxinghaoString == null)
					suoyouxinghaoString = xinghao;
				else suoyouxinghaoString = suoyouxinghaoString + "," + xinghao;
			}
			System.out.println(suoyouxinghaoString);
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			oracleConnection.closeAll(con, st, rs);
		}
		return suoyouxinghaoString;
	}







}

