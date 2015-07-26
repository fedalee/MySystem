package com.wabacus.util;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;

import com.wabacus.config.Config;


//implement as singleton
public class Dao {
	private static Dao instance=null;
	private Dao(){}
	public static Dao getInstance()
	{
		if(instance==null)
		{
			return new Dao();
		}
		else return instance;
	}
	public Connection getConnection(){

		Connection connection = Config.getInstance().getDataSource("").getConnection();
		return connection;
	}

	public String insert(String table,List<String> cols,List<String> values) 
	{
		System.out.println(cols);

		StringBuffer sql=new StringBuffer("insert into ");
		sql.append(table);
		sql.append("(");
		Iterator<String> itrC=cols.iterator();
		while(itrC.hasNext())
		{

			sql.append(itrC.next());
			sql.append(",");
		}
		int last=sql.length();
		sql.deleteCharAt(last-1);
		sql.append(") values(");
		Iterator<String> itrV=values.iterator();
		while(itrV.hasNext())
		{

			sql.append("'");
			sql.append(itrV.next());
			sql.append("'");
			sql.append(",");
		}
		int last1=sql.length();
		sql.deleteCharAt(last1-1);
		sql.append(")");
		System.out.println("LLLLLLLLLLLL"+sql.toString());


		Connection conn=getConnection();
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql.toString());
			System.out.println(rs);
			rs.close();
			stmt.close();
			conn.close();
			return "SUCCESS"+sql.toString();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "FAIL"+sql.toString();
		}
		finally
		{	

		}


	}
	
	public String insert(String table,List<String> cols,List<String> values,List<String>dateCol,List<String>dateValue) 
	{
		System.out.println(cols);

		StringBuffer sql=new StringBuffer("insert into ");
		sql.append(table);
		sql.append("(");
		Iterator<String> itrC=cols.iterator();
		Iterator<String> itrDateC=dateCol.iterator();
		while(itrC.hasNext())
		{

			sql.append(itrC.next());
			sql.append(",");
		}
		while(itrDateC.hasNext())
		{

			sql.append(itrDateC.next());
			sql.append(",");
		}
		int last=sql.length();
		sql.deleteCharAt(last-1);
		sql.append(") values(");
		Iterator<String> itrV=values.iterator();
		Iterator<String> itrDateV=dateValue.iterator();
		while(itrV.hasNext())
		{

			sql.append("'");
			sql.append(itrV.next());
			sql.append("'");
			sql.append(",");
		}
		while(itrDateV.hasNext())
		{
			sql.append("to_date(");
			sql.append("'");
			sql.append(itrDateV.next());
			sql.append("','yyyy-mm-dd'");
			sql.append(")");
			sql.append(",");
		}
		int last1=sql.length();
		sql.deleteCharAt(last1-1);
		sql.append(")");
		System.out.println("LLLLLLLLLLLL"+sql.toString());


		Connection conn=getConnection();
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql.toString());
			System.out.println(rs);
			rs.close();
			stmt.close();
			conn.close();
			return "SUCCESS"+sql.toString();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "FAIL"+sql.toString();
		}
		finally
		{	

		}


	}
	
	public Map<String,Object> getRecord (String table,String value){
		Map<String,Object> result=new HashMap<String,Object>();		
		StringBuffer sql=new StringBuffer("select * from ");
		sql.append(table);
		sql.append(" where xinghao='");
		sql.append(value);
		sql.append("'");
		Connection conn=getConnection();
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql.toString());
			rs.next();
			ResultSetMetaData data = rs.getMetaData();
			for (int i = 1;i<=data.getColumnCount();i++){
				//System.out.println("列名："+data.getColumnName(i));
				//System.out.println("类型："+data.getColumnTypeName(i));
				//System.out.println("列值："+rs.getString(data.getColumnName(i)));
				//System.out.println(" ");
				//if(data.getColumnTypeName(i).equals("VARCHAR2"))
				{
					result.put(data.getColumnName(i), rs.getString(data.getColumnName(i)));}
				//else if(data.getColumnTypeName(i).equals("VARCHAR2"))
				{}



			}

			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{	

		}

		return result;
	}		
	public List<Map<String, String>> getMultiRecord (String table,String conditionCol,String value){
		List<Map<String,String>> results=new ArrayList<Map<String,String>>();		
		StringBuffer sql=new StringBuffer("select * from ");
		sql.append(table);
		sql.append(" where ");
		sql.append(conditionCol);
		sql.append(" ='");
		sql.append(value);
		sql.append("'");
		Connection conn=getConnection();
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql.toString());
			ResultSetMetaData metaData = rs.getMetaData();
			while(rs.next())
			{
				Map<String, String> result=new HashMap<String,String>();
				for(int j=1;j<=metaData.getColumnCount();j++)
				{
					
					System.out.println("列名 ： "+metaData.getColumnName(j));
					System.out.println("列值 ： "+rs.getString(metaData.getColumnName(j)));
					result.put(metaData.getColumnName(j), rs.getString(metaData.getColumnName(j)));
				}
				results.add(result);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{	

		}

		return results;
	}		
	public List<Map<String,String>> getRecoed(String table ,List<String> conditionCol,
			List<String> conditionValue)
			{
		List<Map<String,String>> result=new ArrayList<Map<String,String>>();
		StringBuffer sql=new StringBuffer("select * from ");
		sql.append(table);
		sql.append(" where ");
		for(int i=0;i<conditionCol.size();i++)
		{
			sql.append(conditionCol.get(i));
			sql.append("= ");
			sql.append("'");
			sql.append(conditionValue.get(i));
			sql.append("'");
			sql.append(" and ");
		}
		int last=sql.length();
		sql.deleteCharAt(last-1);
		sql.deleteCharAt(last-2);
		sql.deleteCharAt(last-3);
		sql.deleteCharAt(last-4);

		System.out.println(sql.toString());

		Connection conn=getConnection();
		Statement stmt = null;
		
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql.toString());
			ResultSetMetaData metaData = rs.getMetaData();

			while(rs.next())
			{
				Map<String,String> m=new HashMap<String,String>();
				for(int j=1;j<=metaData.getColumnCount();j++)
				{
					//System.out.println("列名 "+metaData.getColumnName(j));
					//System.out.println("列值 "+rs.getString(metaData.getColumnName(j)));
					m.put(metaData.getColumnName(j), rs.getString(metaData.getColumnName(j)));
				}
				result.add(m);

			}
			System.out.println(rs);
			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		finally
		{	

		}

		return result;
			}
	
	//overload
	public List<Map<String,String>> getRecord(String table)
			{
		List<Map<String,String>> result=new ArrayList<Map<String,String>>();
		StringBuffer sql=new StringBuffer("select * from ");
		sql.append(table);	

		System.out.println(sql.toString());

		Connection conn=getConnection();
		Statement stmt = null;
		
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql.toString());
			ResultSetMetaData metaData = rs.getMetaData();

			while(rs.next())
			{
				Map<String,String> m=new HashMap<String,String>();
				for(int j=1;j<=metaData.getColumnCount();j++)
				{
					//System.out.println("列名 "+metaData.getColumnName(j));
					//System.out.println("列值 "+rs.getString(metaData.getColumnName(j)));
					m.put(metaData.getColumnName(j), rs.getString(metaData.getColumnName(j)));
				}
				result.add(m);

			}
			System.out.println(rs);
			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		finally
		{	

		}

		return result;
			}

	public String update (String table,List queryCol,List queryValue,List newCol,List newValue)	
	{
		System.out.println(queryCol);

		StringBuffer sql=new StringBuffer("update ");
		sql.append(table);
		sql.append(" set ");
		Iterator<String> itrC=newCol.iterator();
		Iterator<String> itrV=newValue.iterator();		
		
		while(itrC.hasNext())
		{

			sql.append(itrC.next());
			sql.append(" = ");
			sql.append("'");
			sql.append(itrV.next());
			sql.append("'");
			sql.append(",");
		}		
		int last1=sql.length();
		sql.deleteCharAt(last1-1);
		sql.append(" where ");
		for(int i=0;i<queryCol.size();i++)
		{
			sql.append(queryCol.get(i));
			sql.append("= ");
			sql.append("'");
			sql.append(queryValue.get(i));
			sql.append("'");
			sql.append(" and ");
		}
		
		int lastTwo=sql.length();
		sql.deleteCharAt(lastTwo-1);
		sql.deleteCharAt(lastTwo-2);
		sql.deleteCharAt(lastTwo-3);
		sql.deleteCharAt(lastTwo-4);
		System.out.println("000000000000000000000000000000000000000000"+sql.toString());
		


		Connection conn=getConnection();
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql.toString());
			System.out.println(rs);
			rs.close();
			stmt.close();
			conn.close();
			return "SUCCESS"+sql.toString();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "FAIL"+sql.toString();
		}
		finally
		{	

		}
	}
	
	public ResultSet exeSql (String sql) throws SQLException	
	{
		
		Connection conn=getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);			
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		finally
		{	
			rs.close();
			stmt.close();
			conn.close();
		}
	}





}
