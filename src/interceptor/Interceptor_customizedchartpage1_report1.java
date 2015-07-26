/* 
 * Copyright (C) 2010-2013 星星<349446658@qq.com>
 * 
 * This file is part of Wabacus 
 * 
 * Wabacus is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package interceptor;

import java.util.ArrayList;

import com.wabacus.config.component.application.report.ReportBean;
import com.wabacus.config.component.application.report.ReportDataSetValueBean;
import com.wabacus.system.ReportRequest;
import com.wabacus.system.intercept.AbsInterceptorDefaultAdapter;
import com.wabacus.system.intercept.ReportDataBean;

public class Interceptor_customizedchartpage1_report1 extends AbsInterceptorDefaultAdapter
{
    public Object beforeLoadData(ReportRequest rrequest,ReportBean rbean,Object typeObj,String sql)
    {
        //因为完全由开发人员自己提供图表数据，所以不需执行在<sql/>中配置的脚本加载报表的数据，这里返回一个空list即可
        if(typeObj instanceof ReportDataSetValueBean) return new ArrayList();//当前是在加载报表数据，则直接返回空list，因为完全由开发人员提供图表数据
        return sql;
    }

    public void beforeDisplayReportData(ReportRequest rrequest,ReportBean rbean,ReportDataBean reportDataBean)
    {
        super.beforeDisplayReportData(rrequest,rbean,reportDataBean);
        StringBuffer chartDataBuf=new StringBuffer();
        chartDataBuf
                .append("<chart caption='Annual Revenue' subcaption='In Million $' xaxisname='Year' PYaxisname='Sales in M$' SYAxisName='Cost as % of Revenue' decimals='0' numberPrefix='$' numberSuffix='M' sNumberSuffix='%'>");
        chartDataBuf.append("<categories>");
        chartDataBuf.append("<category label='2001' />");
        chartDataBuf.append("<category label='2002' />");
        chartDataBuf.append("<category label='2003' />");
        chartDataBuf.append("<category label='2004' />");
        chartDataBuf.append("<category label='2005' />");
        chartDataBuf.append("</categories>");
        
        chartDataBuf.append("<dataset seriesName='Product A' color='AFD8F8' showValues='0'>");
        chartDataBuf.append("<set value='30' />");
        chartDataBuf.append("<set value='26' />");
        chartDataBuf.append("<set value='29' />");
        chartDataBuf.append("<set value='31' />");
        chartDataBuf.append("<set value='34' />");
        chartDataBuf.append("</dataset>");
        chartDataBuf.append("<dataset seriesName='Product B' color='F6BD0F' showValues='0'>");
        chartDataBuf.append("<set value='21' />");
        chartDataBuf.append("<set value='28' />");
        chartDataBuf.append("<set value='39' />");
        chartDataBuf.append("<set value='41' />");
        chartDataBuf.append("<set value='24' />");
        chartDataBuf.append("</dataset>");
        chartDataBuf.append("<dataset seriesName='Product B' color='F6BD0F' showValues='0'>");
        chartDataBuf.append("<set value='21' />");
        chartDataBuf.append("<set value='28' />");
        chartDataBuf.append("<set value='39' />");
        chartDataBuf.append("<set value='41' />");
        chartDataBuf.append("<set value='24' />");
        chartDataBuf.append("</dataset>");
        chartDataBuf.append("<dataset seriesName='Product B' color='F6BD0F' showValues='0'>");
        chartDataBuf.append("<set value='21' />");
        chartDataBuf.append("<set value='28' />");
        chartDataBuf.append("<set value='39' />");
        chartDataBuf.append("<set value='41' />");
        chartDataBuf.append("<set value='24' />");
        chartDataBuf.append("</dataset>");
        chartDataBuf.append("<dataset seriesName='Product B' color='F6BD0F' showValues='0'>");
        chartDataBuf.append("<set value='21' />");
        chartDataBuf.append("<set value='28' />");
        chartDataBuf.append("<set value='39' />");
        chartDataBuf.append("<set value='41' />");
        chartDataBuf.append("<set value='24' />");
        chartDataBuf.append("</dataset>");
        chartDataBuf.append("<dataset seriesName='Product B' color='F6BD0F' showValues='0'>");
        chartDataBuf.append("<set value='21' />");
        chartDataBuf.append("<set value='28' />");
        chartDataBuf.append("<set value='39' />");
        chartDataBuf.append("<set value='41' />");
        chartDataBuf.append("<set value='24' />");
        chartDataBuf.append("</dataset>");
        chartDataBuf.append("<dataset seriesName='Product B' color='F6BD0F' showValues='0'>");
        chartDataBuf.append("<set value='21' />");
        chartDataBuf.append("<set value='28' />");
        chartDataBuf.append("<set value='39' />");
        chartDataBuf.append("<set value='41' />");
        chartDataBuf.append("<set value='24' />");
        chartDataBuf.append("</dataset>");
        chartDataBuf.append("<dataset seriesName='Product B' color='F6BD0F' showValues='0'>");
        chartDataBuf.append("<set value='21' />");
        chartDataBuf.append("<set value='28' />");
        chartDataBuf.append("<set value='39' />");
        chartDataBuf.append("<set value='41' />");
        chartDataBuf.append("<set value='24' />");
        chartDataBuf.append("</dataset>");
        chartDataBuf.append("<dataset seriesName='Product B' color='F6BD0F' showValues='0'>");
        chartDataBuf.append("<set value='21' />");
        chartDataBuf.append("<set value='28' />");
        chartDataBuf.append("<set value='39' />");
        chartDataBuf.append("<set value='41' />");
        chartDataBuf.append("<set value='24' />");
        chartDataBuf.append("</dataset>");

        chartDataBuf.append("</chart>");
        reportDataBean.setChartDataString(chartDataBuf.toString());
    }

}
