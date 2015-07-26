package interceptor;

import java.sql.SQLException;
import java.util.*;

import com.wabacus.config.component.application.report.ReportBean;
import com.wabacus.system.ReportRequest;
import com.wabacus.system.component.application.report.configbean.editablereport.AbsEditableReportEditDataBean;
import com.wabacus.system.dataset.update.action.AbsUpdateAction;
import com.wabacus.system.intercept.AbsInterceptorDefaultAdapter;
import com.wabacus.util.Dao;
import com.wabacus.util.IdentifierGenerator;
import com.wabacus.util.Lihuafeng;

public class InsertColInterceptor extends AbsInterceptorDefaultAdapter {

	public int doSavePerAction(ReportRequest rrequest, ReportBean rbean,
			Map<String, String> mRowData, Map<String, String> mParamValues,
			AbsUpdateAction action, AbsEditableReportEditDataBean editbean) {
		
		super.doSavePerAction(rrequest, rbean, mRowData, mParamValues, action,
				editbean);
		// TODO Auto-generated method stub
		//sSystem.out.println("AAAAAAAAAAAAAA"+mRowData+action.getExecuteSql(rrequest, mRowData, mParamValues)+mParamValues);
		
		if(mParamValues!=null)
		{
			System.out.println("所属id ： "+ mParamValues.get("id"));
			System.out.println("开始年度 ：" + mRowData.get("kaishiniandu"));
			System.out.println("结束年度 ：" + mParamValues);
			String id = mParamValues.get("id");
			String kaishi = mRowData.get("kaishiniandu");
			String jieshu = mRowData.get("jieshuniandu");
			int start = Integer.parseInt(kaishi);
			int end = Integer.parseInt(jieshu);
			String charu = null;
	   		Integer tmp = null;
	   		Integer tmp_2 = null;
	   		
	   		for(int i = start ; i <= end ; i++){
	   			
	   				tmp = new Integer(i);
		   			tmp_2 = new Integer(i+1);
		   			String rand = IdentifierGenerator.getStringId();
		   			charu = "insert into zbgl_kygl_niandujihua (id,suoshuid,kaishiniandu,jieshuniandu) values('"+rand+"','"+id+"','"+tmp.toString()+"','"+tmp_2.toString()+"')";
		   			System.out.println(charu);
		   			try {
						Lihuafeng.dongtailie(charu);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	   			}
	   			
	   		
		}
//		Dao dao=Dao.getInstance();
//		String kaishiS=mRowData.get("kaishiniandu");
//		String jieshuS=mRowData.get("jieshuniandu");
//		int start = Integer.parseInt(kaishiS);
//		int end = Integer.parseInt(jieshuS);
		return WX_RETURNVAL_SUCCESS;
	}

/*	@Override
	public int doSavePerRow(ReportRequest rrequest, ReportBean rbean,
			Map<String, String> mRowData, Map<String, String> mParamValues,
			AbsEditableReportEditDataBean editbean) {
		// TODO Auto-generated method stub
		super.doSavePerRow(rrequest, rbean, mRowData, mParamValues, editbean);
		System.out.println("AAAAAAAAAAAAAA"+mRowData);
	//	{zhouqi=null, id=null, jieshuniandu=111111, kaishiniandu=1234, qihao=null};
		String kaishiS=mRowData.get("kaishiniandu");
		String jieshuS=mRowData.get("jieshuniandu");
		Dao dao=Dao.getInstance();
		getExecuteSql();
		List col=new ArrayList();
		col.add("KAISHINIANDU");
		col.add("JIESHUNIANDU");
		List value=new ArrayList();
		value.add(kaishiS);
		value.add(jieshuS);
		
		
		List result=dao.getRecoed("ZBGL_KYGL_NIANDU", col, value);
		System.out.println("AAAAAAAAAAAAAA"+ result);
		
		
		return WX_RETURNVAL_SUCCESS;
	}
*/
	
	
}
