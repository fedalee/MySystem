package interceptor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;




import com.sun.org.apache.regexp.internal.recompile;
import com.wabacus.config.Config;
import com.wabacus.config.component.application.report.ReportBean;
import com.wabacus.system.ReportRequest;
import com.wabacus.system.component.application.report.configbean.editablereport.AbsEditableReportEditDataBean;
import com.wabacus.system.dataset.update.action.AbsUpdateAction;
import com.wabacus.system.dataset.update.precondition.AbsExpressionBean;
import com.wabacus.system.intercept.AbsInterceptorDefaultAdapter;

public class Keyanguanglizhuangjiaku_Interceptor extends AbsInterceptorDefaultAdapter {

	@Override
	public int doSavePerAction(ReportRequest rrequest, ReportBean rbean,
			Map<String, String> mRowData, Map<String, String> mParamValues,
			AbsUpdateAction action, AbsEditableReportEditDataBean editbean) {
		// TODO Auto-generated method stub
		
		
        
        String chushengriqi = mRowData.get("chushengriqi");
        Date testDate = new Date(chushengriqi);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd ");
        //输出数据为2010-09-09
        System.out.println(format.format(testDate));
        System.out.println("****************"+format.format(testDate));
        mRowData.put("chushengriqi",format.format(testDate));
        
        
        return super.doSavePerAction(rrequest, rbean, mRowData, mParamValues, action,
				editbean);
	}

}
