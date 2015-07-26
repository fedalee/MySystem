package com;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.wabacus.system.ReportRequest;
import com.wabacus.util.ValidateTools;

public class ShujuJiaoyan {
    public static boolean isNotEmpty(ReportRequest rrequest,String value,Map<String,Object> mValues,List<String> lstErrorMessages)
    {
    	String sql=String.format("select * FROM XTSZ_JBXXWH_DANWEI WHERE DANWEIMINGCHENG='%s'",value);
    	Statement stmt=null;
    	
    	Connection conn = rrequest.getConnection();
    	
    	try {
			stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			
			if(rs.next())
			{
				return true;
			}
			else
			{
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        return false;
    }
}
