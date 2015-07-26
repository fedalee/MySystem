package com;

/*import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;*/
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.wabacus.config.component.IComponentConfigBean;
import com.wabacus.config.xml.XmlElementBean;
import com.wabacus.system.ReportRequest;
import com.wabacus.system.buttons.AbsButtonType;
import com.wabacus.system.buttons.AbsEditableReportButton;
import com.wabacus.util.Dao;
import com.wabacus.util.IdentifierGenerator;


//@yuanjieduan：复制该阶段的数据
//@xianjieduan:数据复制到该阶段
public class DataCopy {
	
	static boolean  CopyData(String suoshu,String table,String yuanjieduan,String xianjieduan)
	{
		
		System.out.println("^^^^^^^^^^^"+suoshu+"^^^^^^^^^^^^^^^^^^^^^^^");
		System.out.println("^^^^^^^^^^^"+yuanjieduan+xianjieduan+"^^^^^^^^^^^^^^^^^^^^^^^");
		List cols=new ArrayList();
		cols.add("SUOSHU");
		cols.add("SUOSHUJIEDUAN");
		List values=new ArrayList(); 
		values.add(suoshu);
		values.add(yuanjieduan);
		Dao dao=Dao.getInstance();
		List result=dao.getRecoed(table,cols,values);
		if(result.size()<=0)
		{
			return true;
		}
	
		List insertCol=new ArrayList();
		List insertValue=new ArrayList();
		IdentifierGenerator ig=new IdentifierGenerator();
		String id =ig.getRandomString(32);
		cols.add("ID");
		values.add(id);
		
		for(int i=0;i<result.size();i++)
		{
			insertCol.clear();
			insertValue.clear();
			Map m=(Map) result.get(i);
			System.out.println("~~~~~~~~"+m);
			
			Iterator itr=m.keySet().iterator();
			while(itr.hasNext())
			{
				String key=(String)itr.next(); 
				//System.out.println("Key is :"+key);
				String value=(String)m.get(key);
				//System.out.println("Value si :"+value);	
				if(!key.equals("SUOSHU")&&!key.equals("SUOSHUJIEDUAN")&&!key.equals("ID"))
				{
					insertCol.add(key);
					if(value==null){insertValue.add("");}
					else
					{insertValue.add(value);}
				}	
			}
			
             insertCol.add("SUOSHU");
             insertValue.add(suoshu);
             insertCol.add("SUOSHUJIEDUAN");
             insertValue.add(xianjieduan);
             insertCol.add("ID");
             insertValue.add(id);
             if(!(dao.insert(table,insertCol,insertValue).contains("SUCCESS")))
     			return false;
		}
		return true;
	
		
	}

}
