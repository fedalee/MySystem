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
public class JiaoChuanDataUpdate implements com.wabacus.system.serveraction.IServerAction{
	
	public static String  CopyXinghao(String xinghao,String xinghaoID,String suoshu,String table,String yuanjieduan,String xianjieduan)
	{
		
		System.out.println("^^^^^xinghao^^^^^^"+xinghao+"^^^^^^^^^^^^^^^^^^^^^^^");
		System.out.println("^^^^^suoshu^^^^^^"+suoshu+"^^^^^^^^^^^^^^^^^^^^^^^");
		List cols=new ArrayList();
		cols.add("XINGHAO");
		cols.add("SUOSHUJIEDUAN");
		List values=new ArrayList(); 
		values.add(xinghao);
		values.add(yuanjieduan);
		Dao dao=Dao.getInstance();
		List result=dao.getRecoed(table,cols,values);
	
		//System.out.println("^^^^^^^^^^^^^^^^^^^^^^"+result+"^^^^^^^^^^^^^^^^^^^^^^^^");
		List updateCol=new ArrayList();
		List updateValue=new ArrayList();

		if(result.size()>0)
		{
			Map m=(Map) result.get(0);
			System.out.println("~~~~~~~~"+m);
			
			Iterator itr=m.keySet().iterator();
			while(itr.hasNext())
			{
				String key=(String)itr.next(); 
				//System.out.println("Key is :"+key);
				String value=(String)m.get(key);
				//System.out.println("Value si :"+value);	
				if(!key.equals("ID")&&!key.equals("SUOSHU")&&!key.equals("SUOSHUJIEDUAN"))
				{
					updateCol.add(key);
					if(value==null){updateValue.add("");}
					else
					{updateValue.add(value);}
				}								
			}
			List newcols=new ArrayList();
			newcols.add("SUOSHU");
			newcols.add("SUOSHUJIEDUAN");
			List newvalues=new ArrayList(); 
			newvalues.add(suoshu);
			newvalues.add(xianjieduan);	
			
			
			
			if(dao.update(table,newcols,newvalues,updateCol,updateValue).contains("SUCCESS"))
			{
				String zzNengLiTable[] = new String[] {  
	                "ZBGL_ZBJBXX_STXN_DDGJ","ZBGL_ZBJBXX_STXN_DHNL","ZBGL_ZBJBXX_STXN_HSCJJL",
	                "ZBGL_ZBJBXX_STXN_SSDKQC","ZBGL_ZBJBXX_STXN_TXNL","ZBGL_ZBJBXX_STXN_XTFYSJ",
	                "ZBGL_ZBJBXX_STXN_YLFXHBJJL","ZBGL_ZBJBXX_STXN_YSLGJ","ZBGL_ZBJBXX_STXN_ZCCPFW",
	                "ZBGL_ZBJBXX_STXN_ZCJL","ZBGL_ZBJBXX_STXN_ZSCXGCFW","ZBGL_ZBJBXX_STXN_ZSMBZYJL"
	                   };
					for(int i=0;i<zzNengLiTable.length;i++)
					{
		                String temp = zzNengLiTable[i];
		                System.out.println("0000000000000000"+temp);
					    if(!JiaoChuanDataCopy.CopyData(suoshu,xinghaoID,temp, yuanjieduan, xianjieduan))
					    {
					    	 System.out.println("00000000000000000000000000000000000000000000"+temp);
					    	return "数据复制失败";
					    }
					    	
					}
			}
			else {
				return "数据复制失败";
			}
			return "数据复制成功";
			
			
		}
		else {
			return yuanjieduan+"没有"+suoshu+"的相关数据";
		}
		
	}




	public String executeServerAction(HttpServletRequest arg0,
			HttpServletResponse arg1, List<Map<String, String>> arg2) {
		// TODO Auto-generated method stub
		System.out.println(arg2.get(0).get("suoshu")+"@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@22"+arg2.get(0).get("jieduan"));
		
		return CopyXinghao(arg2.get(0).get("xinghao"),arg2.get(0).get("xinghaoID"),arg2.get(0).get("suoshu"),arg2.get(0).get("table"),arg2.get(0).get("yuanjieduan"),arg2.get(0).get("xianjieduan"));
		

	}


	public String executeSeverAction(ReportRequest arg0,
			IComponentConfigBean arg1, List<Map<String, String>> arg2,
			Map<String, String> arg3) {
		// TODO Auto-generated method stub
		System.out.println(arg2.get(0).get("suoshu")+"@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@22"+arg2.get(0).get("jieduan"));
		return CopyXinghao(arg2.get(0).get("xinghao"),arg2.get(0).get("xinghaoID"),arg2.get(0).get("suoshu"),arg2.get(0).get("table"),arg2.get(0).get("yuanjieduan"),arg2.get(0).get("xianjieduan"));
	
	}

}
