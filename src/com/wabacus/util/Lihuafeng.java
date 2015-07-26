package com.wabacus.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Lihuafeng {
public static void dongtailie(String querySql) throws SQLException {	
		
		OracleConnection oracleConnection = new OracleConnection();
		Connection con = oracleConnection.getConnection();
		Statement st = null;

		try{
			st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			st.execute(querySql);

		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(st != null){
				st.close();
			}
			if(con != null){
				con.close();
			}
		}
		
	}
}
