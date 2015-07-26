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

public class ZhuangBeiYanZhiJianZaoJiHuaInterceptor extends AbsInterceptorDefaultAdapter {

	@Override
	public int doSave(ReportRequest rrequest, ReportBean rbean,
			AbsEditableReportEditDataBean editbean) {
		
		if(editbean instanceof EditableReportInsertDataBean)
		{
			List<Map<String,String>> data = rrequest.getLstInsertedData("jianzaojihuaPopup");
			List<Map<String, String>> pdata=rrequest.getLstInsertedParamValues(rbean);
			
			
			super.doSave(rrequest, rbean, editbean);


			String jianzaozhuangtai=(String)data.get(0).get("jianzaozhuangtai");
			if(jianzaozhuangtai.equals("进行中")){

				 List<String> queryCol=new ArrayList<String>();
					queryCol.add("XIANHAO");
					queryCol.add("SUOSHUXINGHAO");
					List<String> queryValue=new ArrayList<String>();
					queryValue.add(data.get(0).get("xianhao"));
					queryValue.add(pdata.get(0).get("xinghao"));
					List<String> newCol=new ArrayList<String>();
					newCol.add("JIEDUAN");
					List<String> newValue=new ArrayList<String>();
					newValue.add("建造计划阶段-进行中");
				    Dao.getInstance().update("zbgl_zbjbxx_xianhao", queryCol, queryValue, newCol, newValue);
			
			
			
			} 
			
			
			return WX_RETURNVAL_SUCCESS;
		}
		else if(editbean instanceof EditableReportUpdateDataBean){
			List<Map<String,String>> input=rrequest.getLstUpdatedData("jianzaojihuaPopup");
			System.out.println(input);
			String jianzaozhuangtai=(String)input.get(0).get("jianzaozhuangtai");
			String jianzaozhuangtai_old=(String)input.get(0).get("jianzaozhuangtai__old");
			System.out.println("1111111111"+jianzaozhuangtai+jianzaozhuangtai_old);
			if(jianzaozhuangtai.equals("已完成")&&jianzaozhuangtai_old.equals("进行中")){

				 List<String> queryCol=new ArrayList<String>();
					queryCol.add("XIANHAO");
					queryCol.add("SUOSHUXINGHAO");
					List<String> queryValue=new ArrayList<String>();
					queryValue.add(input.get(0).get("xianhao"));
					queryValue.add(input.get(0).get("xinghao"));
					List<String> newCol=new ArrayList<String>();
					newCol.add("JIEDUAN");
					List<String> newValue=new ArrayList<String>();
					newValue.add("建造计划阶段-已完成");
				    Dao.getInstance().update("zbgl_zbjbxx_xianhao", queryCol, queryValue, newCol, newValue);
			
			
			
			} else if (jianzaozhuangtai.equals("进行中")&&jianzaozhuangtai_old.equals("已完成")) {
				 List<String> queryCol=new ArrayList<String>();
					queryCol.add("XIANHAO");
					queryCol.add("SUOSHUXINGHAO");
					List<String> queryValue=new ArrayList<String>();
					queryValue.add(input.get(0).get("xianhao"));
					queryValue.add(input.get(0).get("xinghao"));
					
					List<String> newCol=new ArrayList<String>();
					newCol.add("JIEDUAN");
					List<String> newValue=new ArrayList<String>();
					newValue.add("建造计划阶段-进行中");
				    Dao.getInstance().update("zbgl_zbjbxx_xianhao", queryCol, queryValue, newCol, newValue);
				
				
			} 
				//return WX_RETURNVAL_SUCCESS;
			}

		return super.doSave(rrequest, rbean, editbean);
		}
}