package interceptor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.DataUpdate;
import com.sun.org.apache.commons.collections.StaticBucketMap;
import com.wabacus.config.component.application.report.ReportBean;
import com.wabacus.system.ReportRequest;
import com.wabacus.system.component.application.report.configbean.editablereport.AbsEditableReportEditDataBean;
import com.wabacus.system.component.application.report.configbean.editablereport.EditableReportInsertDataBean;
import com.wabacus.system.dataset.update.action.AbsUpdateAction;
import com.wabacus.system.intercept.AbsInterceptorDefaultAdapter;
import com.wabacus.system.dataset.update.action.rationaldb.AbsRationalDBUpdateAction;
import com.wabacus.util.Dao;
import com.wabacus.util.IdentifierGenerator;

public class Zhuangbeiweixiu_Interceptor extends AbsInterceptorDefaultAdapter {

	static int flag = 0;
	String weixiujieduan = "";
	@Override
	public int doSavePerAction(ReportRequest rrequest, ReportBean rbean,
			Map<String, String> mRowData, Map<String, String> mParamValues,
			AbsUpdateAction action, AbsEditableReportEditDataBean editbean) {
		// TODO Auto-generated method stub
		 if(action instanceof AbsRationalDBUpdateAction)
	     {//当前执行的脚本是配置的SQL语句或存储过程
			  System.out.print("正在执行sql语句："+((AbsRationalDBUpdateAction)action).getSqlsp()+"，保存的记录为：");
	            
	            if(((AbsRationalDBUpdateAction)action).getSqlsp().contains("zbgl_zxsy_zdzs")&&flag==0)
	            {
	            	if(mRowData!=null)//mRowData中存放了本条记录各列的值
	    	        {
	            		
	                   String value=(String)mRowData.get("weixiujieduan");
	    	           mRowData.put("weixiujieduan",value+"前");
	    	           flag = 1;
	    	        }
	            }else  if(((AbsRationalDBUpdateAction)action).getSqlsp().contains("zbgl_zxsy_zdzs")&&flag==1)
	            {
	            	if(mRowData!=null)//mRowData中存放了本条记录各列的值
	    	        {
	            		String value=(String)mRowData.get("weixiujieduan");
		    	        mRowData.put("weixiujieduan",formatString(value)+"后");
		    	        flag = 0;
	    	        }
	            }
	            
	            if(((AbsRationalDBUpdateAction)action).getSqlsp().contains("zbgl_zxsy_shebei")&&flag==0)
	            {
	            	if(mRowData!=null)//mRowData中存放了本条记录各列的值
	    	        {
	                   String value=(String)mRowData.get("weixiujieduan");
	    	           mRowData.put("weixiujieduan",formatString(value)+"前");
	    	           flag = 1;
	    	        }
	            }else if(((AbsRationalDBUpdateAction)action).getSqlsp().contains("zbgl_zxsy_shebei")&&flag==1)
	            {
	            	if(mRowData!=null)//mRowData中存放了本条记录各列的值
	    	        {
	            		String value=(String)mRowData.get("weixiujieduan");
		    	        mRowData.put("weixiujieduan",formatString(value)+"后");
		    	        flag = 0;
	    	        }
	            }
	            if(((AbsRationalDBUpdateAction)action).getSqlsp().contains("zbgl_zxsy_mtsy")&&flag==0)
	            {
	            	if(mRowData!=null)//mRowData中存放了本条记录各列的值
	    	        {
	            		
	                   String value=(String)mRowData.get("weixiujieduan");
	    	           mRowData.put("weixiujieduan",formatString(value)+"前");
	    	           flag = 1;
	    	        }
	            }else  if(((AbsRationalDBUpdateAction)action).getSqlsp().contains("zbgl_zxsy_mtsy")&&flag==1)
	            {
	            	if(mRowData!=null)//mRowData中存放了本条记录各列的值
	    	        {
	            		String value=(String)mRowData.get("weixiujieduan");
		    	        mRowData.put("weixiujieduan",formatString(value)+"后");
		    	        flag = 0;
	    	        }
	            }
	            if(((AbsRationalDBUpdateAction)action).getSqlsp().contains("zbgl_zxsy_hxsy")&&flag==0)
	            {
	            	if(mRowData!=null)//mRowData中存放了本条记录各列的值
	    	        {
	            		
	                   String value=(String)mRowData.get("weixiujieduan");
	    	           mRowData.put("weixiujieduan",formatString(value)+"前");
	    	           flag = 1;
	    	        }
	            }else  if(((AbsRationalDBUpdateAction)action).getSqlsp().contains("zbgl_zxsy_hxsy")&&flag==1)
	            {
	            	if(mRowData!=null)//mRowData中存放了本条记录各列的值
	    	        {
	            		String value=(String)mRowData.get("weixiujieduan");
		    	        mRowData.put("weixiujieduan",formatString(value)+"后");
		    	        flag = 0;
	    	        }
	            }
	     }
	        
	        
		return super.doSavePerAction(rrequest, rbean, mRowData, mParamValues, action,
				editbean);
	}
	@Override
	public int doSave(ReportRequest rrequest, ReportBean rbean,
			AbsEditableReportEditDataBean editbean) {
		
		
		save(rrequest, rbean, editbean, "前");
		save(rrequest, rbean, editbean, "后");
		
		return super.doSave(rrequest, rbean, editbean);
	}
	String formatString(String str)
	{
		return str.substring(0,str.length()-1);
	}
	void save(ReportRequest rrequest, ReportBean rbean,AbsEditableReportEditDataBean editbean,String flag)
	{
		if(editbean instanceof EditableReportInsertDataBean)
		{
			List<Map<String,String>> pdata = rrequest.getLstInsertedData("zhuangbeiweixiu_report_detail");
			Map<String,Object> gdata=new HashMap<String,Object>();
			
			
			List<String> cols=new ArrayList<String>();
			
			String value=pdata.get(0).get("suoshuxinghao");
			gdata =Dao.getInstance().getRecord("ZBGL_ZBYZ_XINGHAOXINXI",value); 
			String suoshu=(String)gdata.get("ID");
			List<String> stxncols=new ArrayList<String>();
			
			stxncols.add("id");
			stxncols.add("suoshu");
		//	stxncols.add("xianhao");
			stxncols.add("xinghao");
			stxncols.add("suoshujieduan");
			
	
			List<String> stxnvalues=new ArrayList<String>();
			String id=IdentifierGenerator.getStringId();
			stxnvalues.add(id);
			stxnvalues.add(suoshu);
		//	stxnvalues.add(data.get(0).get("xianhao"));
			stxnvalues.add(pdata.get(0).get("suoshuxinghao"));
			stxnvalues.add(pdata.get(0).get("weixiujieduan")+flag);
			
			Dao.getInstance().insert("zbgl_zbyz_shitingxingneng", stxncols, stxnvalues);
			
			String xianjieduan=pdata.get(0).get("weixiujieduan")+flag;
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!"+pdata.get(0).get("weixiujieduan")+flag);
			String yuanjieduan="交船阶段";
			
			DataUpdate.Copy(suoshu,"ZBGL_ZBYZ_SHITINGXINGNENG",yuanjieduan,xianjieduan);
		
			String xianhao=pdata.get(0).get("suoshuxianhao");
			List<String> queryCol=new ArrayList<String>();
			queryCol.add("ID");
			List<String> queryValue=new ArrayList<String>();
			queryValue.add(id);
			List<String> newCol=new ArrayList<String>();
			newCol.add("XIANHAO");
			List<String> newValue=new ArrayList<String>();
			newValue.add(xianhao);
		    Dao.getInstance().update("ZBGL_ZBYZ_SHITINGXINGNENG", queryCol, queryValue, newCol, newValue);
		    
		    List<String> queryCols=new ArrayList<String>();
			queryCols.add("SUOSHU");
			queryCols.add("SUOSHUJIEDUAN");
			List<String> queryValues=new ArrayList<String>();
			queryValues.add(suoshu);
			queryValues.add(pdata.get(0).get("weixiujieduan")+flag);
			List<String> newCols=new ArrayList<String>();
			newCols.add("SUOSHUXIANHAO");
			List<String> newValues=new ArrayList<String>();
			newValues.add(xianhao);
		    Dao.getInstance().update("ZBGL_ZBJBXX_STXN_ZSMBZYJL", queryCols, queryValues, newCols, newValues);
		}
	}

}
