package interceptor;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import com.wabacus.config.Config;
import com.wabacus.config.component.application.report.ReportBean;
import com.wabacus.system.ReportRequest;
import com.wabacus.system.intercept.AbsInterceptorDefaultAdapter;
import com.wabacus.system.intercept.ReportDataBean;

public class Tubiaoxianshi_Interceptor extends AbsInterceptorDefaultAdapter {

	@Override
	public void beforeDisplayReportData(ReportRequest rrequest,
			ReportBean rbean, ReportDataBean reportDataBean) {
		// TODO Auto-generated method stub
		super.beforeDisplayReportData(rrequest, rbean, reportDataBean);

		 Map<String, String> result = new HashMap<String,String>();
		 result =(Map<String, String>)rrequest.getRequest().getSession().getAttribute("shujufenxitubiaoshuju");
		 
		StringBuffer chartDataBuf = new StringBuffer();
		chartDataBuf
				.append("<chart caption='测点对比' subcaption='HZ' xaxisname='测点标志' PYaxisname='Sales in M$' SYAxisName='Cost as % of Revenue' decimals='0' numberPrefix='$' numberSuffix='M' sNumberSuffix='%'>");
		chartDataBuf.append("<categories>");
		chartDataBuf.append("<category label='10HZ' />");
		chartDataBuf.append("<category label='12.5HZ' />");
		chartDataBuf.append("<category label='16HZ' />");
		chartDataBuf.append("<category label='20HZ' />");
		chartDataBuf.append("<category label='25HZ' />");
		chartDataBuf.append("<category label='31.5HZ' />");
		chartDataBuf.append("<category label='40HZ' />");
		chartDataBuf.append("<category label='50HZ' />");
		chartDataBuf.append("<category label='63HZ' />");
		chartDataBuf.append("<category label='80HZ' />");
		chartDataBuf.append("<category label='100HZ' />");
		chartDataBuf.append("<category label='125HZ' />");
		chartDataBuf.append("<category label='160HZ' />");
		chartDataBuf.append("<category label='200HZ' />");
		chartDataBuf.append("<category label='250HZ' />");
		chartDataBuf.append("<category label='315HZ' />");
		chartDataBuf.append("<category label='400HZ' />");
		chartDataBuf.append("<category label='500HZ' />");
		chartDataBuf.append("<category label='630HZ' />");
		chartDataBuf.append("<category label='800HZ' />");
		chartDataBuf.append("<category label='1000HZ' />");
		chartDataBuf.append("<category label='1250HZ' />");
		chartDataBuf.append("<category label='1600HZ' />");
		chartDataBuf.append("<category label='2000HZ' />");
		chartDataBuf.append("<category label='2500HZ' />");
		chartDataBuf.append("<category label='3150HZ' />");
		chartDataBuf.append("<category label='4000HZ' />");
		chartDataBuf.append("<category label='5000HZ' />");
		chartDataBuf.append("<category label='6300HZ' />");
		chartDataBuf.append("<category label='8000HZ' />");
		chartDataBuf.append("<category label='10000HZ' />");
		chartDataBuf.append("<category label='12500HZ' />");
		chartDataBuf.append("<category label='16000HZ' />");
		chartDataBuf.append("<category label='20000HZ' />");
		chartDataBuf.append("<category label='25000HZ' />");
		chartDataBuf.append("<category label='31500HZ' />");
		chartDataBuf.append("<category label='40000HZ' />");
		chartDataBuf.append("<category label='50000HZ' />");
		chartDataBuf.append("</categories>");

		Connection conn= Config.getInstance().getDataSource("ds_oracle").getConnection();
        String sql=null;
        
        Statement stmt=null;
        try {
			stmt=conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
		for(int i=0;i<result.size();i++)
		{
			chartDataBuf
			.append("<dataset seriesName='"+Integer.toString(i)+"' color='"+Integer.toHexString(255-i*32)+Integer.toHexString(16+i*32)+Integer.toHexString(255-i*32)+"' showValues='0'>");
			sql = String.format("select * from ZBGL_ZXSY_CEDIAN where id='%s'",result.get(Integer.toString(i)));
			System.out.println("****"+sql);
			try {
				ResultSet rs=stmt.executeQuery(sql);
				rs.next();
				for(int j=0;j<38;j++)
				{
					chartDataBuf.append("<set value='"+rs.getString(6+j)+"' />");
					
				}
				chartDataBuf.append("</dataset>");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	

		chartDataBuf.append("</chart>");
		System.out.println("****"+chartDataBuf);
		reportDataBean.setChartDataString(chartDataBuf.toString());
	
	}


}
