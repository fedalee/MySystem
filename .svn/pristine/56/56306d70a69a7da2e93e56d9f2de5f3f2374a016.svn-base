package interceptor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wabacus.config.component.application.report.AbsReportDataPojo;
import com.wabacus.config.component.application.report.ReportBean;
import com.wabacus.system.ReportRequest;
import com.wabacus.system.intercept.AbsInterceptorDefaultAdapter;
import com.wabacus.system.intercept.ReportDataBean;

public class SjfxTubiaoxianshi_Interceptor extends AbsInterceptorDefaultAdapter {

	@Override
	public void beforeDisplayReportData(ReportRequest rrequest,
			ReportBean rbean, ReportDataBean reportDataBean) {
		// TODO Auto-generated method stub
		super.beforeDisplayReportData(rrequest, rbean, reportDataBean);
		 Map<String, String> result = new HashMap<String,String>();
		 result.clear();
		List<AbsReportDataPojo> colList = reportDataBean.getReportTypeObj().getLstReportData();
		for(int i=0;i<colList.size();i++)
		{
			AbsReportDataPojo abs = colList.get(i);
			result.put(Integer.toString(i), (String)abs.getColValue("id"));
		}
		rrequest.getRequest().getSession().setAttribute("shujufenxitubiaoshuju",result);
	
	}


}
