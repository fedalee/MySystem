package interceptor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.DataCopy;
import com.DataUpdate;
import com.JiaoChuanDataUpdate;
import com.wabacus.config.component.application.report.ReportBean;
import com.wabacus.system.ReportRequest;
import com.wabacus.system.component.application.report.configbean.editablereport.AbsEditableReportEditDataBean;
import com.wabacus.system.component.application.report.configbean.editablereport.EditableReportInsertDataBean;
import com.wabacus.system.component.application.report.configbean.editablereport.EditableReportUpdateDataBean;
import com.wabacus.system.dataset.update.action.AbsUpdateAction;
import com.wabacus.system.datatype.CDateType;
import com.wabacus.system.intercept.AbsInterceptorDefaultAdapter;
import com.wabacus.system.intercept.AbsPageInterceptor;
import com.wabacus.util.Dao;
import com.wabacus.util.IdentifierGenerator;

public class ZhuangBeiYanZhiXiBoInterceptor extends AbsInterceptorDefaultAdapter {

	@Override
	public int doSave(ReportRequest rrequest, ReportBean rbean,
			AbsEditableReportEditDataBean editbean) {
		
		if(editbean instanceof EditableReportInsertDataBean)
		{
			List<Map<String,String>> data = rrequest.getLstInsertedData("xiboshiyanPopup");
			List<Map<String, String>> pdata=rrequest.getLstInsertedParamValues(rbean);
			
			
			super.doSave(rrequest, rbean, editbean);
			



			String xibozhuangtai=(String)data.get(0).get("xibozhuangtai");
			if(xibozhuangtai.equals("进行中")){

				 List<String> queryCol=new ArrayList<String>();
					queryCol.add("XIANHAO");
					queryCol.add("SUOSHUXINGHAO");
					List<String> queryValue=new ArrayList<String>();
					queryValue.add(data.get(0).get("xianhao"));
					queryValue.add(pdata.get(0).get("xinghao"));
					List<String> newCol=new ArrayList<String>();
					newCol.add("JIEDUAN");
					List<String> newValue=new ArrayList<String>();
					newValue.add("系泊试验阶段-进行中");
				    Dao.getInstance().update("zbgl_zbjbxx_xianhao", queryCol, queryValue, newCol, newValue);
			
			
			
			} 
			
			
			return WX_RETURNVAL_SUCCESS;
		}
		else if(editbean instanceof EditableReportUpdateDataBean){
			List<Map<String,String>> input=rrequest.getLstUpdatedData("xiboshiyanPopup");
			System.out.println(input);
			String xibozhuangtai=(String)input.get(0).get("xibozhuangtai");
			String xibozhuangtai_old=(String)input.get(0).get("xibozhuangtai__old");
			System.out.println("1111111111"+xibozhuangtai+xibozhuangtai_old);
			if(xibozhuangtai.equals("已完成")&&xibozhuangtai_old.equals("进行中")){

				 List<String> queryCol=new ArrayList<String>();
					queryCol.add("XIANHAO");
					queryCol.add("SUOSHUXINGHAO");
					List<String> queryValue=new ArrayList<String>();
					queryValue.add(input.get(0).get("xianhao"));
					queryValue.add(input.get(0).get("xinghao"));
					
					List<String> newCol=new ArrayList<String>();
					newCol.add("JIEDUAN");
					List<String> newValue=new ArrayList<String>();
					newValue.add("系泊试验阶段-已完成");
				    Dao.getInstance().update("zbgl_zbjbxx_xianhao", queryCol, queryValue, newCol, newValue);
			
			
			
			} else if (xibozhuangtai.equals("进行中")&&xibozhuangtai_old.equals("已完成")) {
				 List<String> queryCol=new ArrayList<String>();
					queryCol.add("XIANHAO");
					queryCol.add("SUOSHUXINGHAO");
					List<String> queryValue=new ArrayList<String>();
					queryValue.add(input.get(0).get("xianhao"));
					queryValue.add(input.get(0).get("xinghao"));
					
					List<String> newCol=new ArrayList<String>();
					newCol.add("JIEDUAN");
					List<String> newValue=new ArrayList<String>();
					newValue.add("系泊试验阶段-进行中");
				    Dao.getInstance().update("zbgl_zbjbxx_xianhao", queryCol, queryValue, newCol, newValue);
				
				
			}
				//return WX_RETURNVAL_SUCCESS;
			}

		return super.doSave(rrequest, rbean, editbean);
		}
}