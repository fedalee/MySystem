/* 
 * Copyright (C) 2010-2012 星星<349446658@qq.com>
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
package com.wabacus.util;

import java.util.List;

import com.wabacus.config.component.application.report.AbsReportDataPojo;
import com.wabacus.config.component.application.report.ColBean;
import com.wabacus.config.component.application.report.ReportBean;
import com.wabacus.system.ReportRequest;
import com.wabacus.system.component.application.report.abstractreport.AbsReportType;
import com.wabacus.system.intercept.AbsInterceptorDefaultAdapter;
import com.wabacus.system.intercept.RowDataBean;

public class Interceptor_controlpagedisplaypage1Report1 extends AbsInterceptorDefaultAdapter
{

    public void beforeDisplayReportDataPerRow(ReportRequest rrequest,ReportBean rbean,RowDataBean rowDataBean)
    {
        if(rowDataBean.getRowindex()<0)
        {//当前正在显示标题部分
            /**
             * 下面在数据标题行前面插入一行动态的标题行
             */
            String insertedHtml="<tr><td colspan='"+rowDataBean.getColspans()+"' align='center' bgcolor='#dddddd'><font size='3'><b>动态插入的报表标题行</b></font></td></tr>";
            rowDataBean.setInsertDisplayRowHtml(insertedHtml);
        }else if(rowDataBean.getRowindex()==Integer.MAX_VALUE)
        {//当前是显示完最后一行记录后的调用
            String insertedHtml="<tr>";
            for(int i=0;i<rowDataBean.getColspans();i++)
            {
                System.out.println(i+"|||"+((ColBean)rowDataBean.getLstColBeans().get(i)));
                insertedHtml+="<td align='center' bgcolor='#dddddd'><font size='3'><b>"+((ColBean)rowDataBean.getLstColBeans().get(i)).getLabel(rrequest)+"</b></font></td>";
            }
            insertedHtml+="</tr>";
            rowDataBean.setInsertDisplayRowHtml(insertedHtml);
        }else
        {//显示数据行
            AbsReportType reportTypeObj=rrequest.getDisplayReportTypeObj(rbean.getId());
            List<AbsReportDataPojo> lstData=reportTypeObj.getLstReportData();//所有报表数据的容器
            if(lstData.size()>0)
            {//报表有数据
                Object dataObj=lstData.get(rowDataBean.getRowindex());//取到即将显示记录的数据对象
                String currentSex=(String)rowDataBean.getColData("sex");//取到当前记录的性别列
                currentSex=currentSex==null?"":currentSex.trim();
                String displayedsex=reportTypeObj.getReportRequest().getStringAttribute("DISPLAYED_SEX");//上一条记录显示的性别
                if(displayedsex==null||!displayedsex.equals(currentSex))
                {//如果还没有显示记录，或者当前正要显示的记录的性别和上一条不是同一个性别，则说明开始显示新的性别的记录（这是因为查询报表的SQL语句中已经按性别排了序）
                    reportTypeObj.getReportRequest().setAttribute("DISPLAYED_SEX",currentSex);//存下当前记录显示的性别，以便后面显示其它记录时比较
                    int[] tmp=getRecordCntAndTotalAges(reportTypeObj,lstData,currentSex);
                    float avgage=0;
                    if(tmp[0]>0) avgage=tmp[1]/tmp[0];
                    StringBuffer insertedHtmlBuf=new StringBuffer();
                    insertedHtmlBuf.append("<tr><td colspan='"+rowDataBean.getColspans()+"' align='center' bgcolor='#eeeeee'>");
                    insertedHtmlBuf.append("<font size='3'><b>"+currentSex+"性员工列表</b></font>");
                    insertedHtmlBuf.append("&nbsp;&nbsp;&nbsp;&nbsp;【记录数："+tmp[0]+"；平均年龄"+avgage+"】");
                    insertedHtmlBuf.append("</td></tr>");
                    rowDataBean.setInsertDisplayRowHtml(insertedHtmlBuf.toString());
                }
            }
        }
    }

    
    private int[] getRecordCntAndTotalAges(AbsReportType reportTypeObj,List<AbsReportDataPojo> lstData,String sex)
    {
        int recordcnt=0,totalage=0;
        for(AbsReportDataPojo dataObjTmp:lstData)
        {
            if(dataObjTmp==null) continue;
            String currentSex=dataObjTmp.getColStringValue("sex");//取到当前记录的性别列
            if(sex.equals(currentSex))
            {
                recordcnt++;
                String age=dataObjTmp.getColStringValue("age");//取到当前记录的年龄列数据
                if(age==null||age.trim().equals("")) continue;
                totalage+=Integer.parseInt(age.trim());
            }
        }
        return new int[]{recordcnt,totalage};
    }
}

