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

import java.util.Iterator;
import java.util.Map;

import com.wabacus.config.component.application.report.ReportBean;
import com.wabacus.system.ReportRequest;
import com.wabacus.system.component.application.report.configbean.editablereport.AbsEditableReportEditDataBean;
import com.wabacus.system.component.application.report.configbean.editablereport.EditableReportDeleteDataBean;
import com.wabacus.system.component.application.report.configbean.editablereport.EditableReportInsertDataBean;
import com.wabacus.system.component.application.report.configbean.editablereport.EditableReportUpdateDataBean;
import com.wabacus.system.intercept.AbsInterceptorDefaultAdapter;

public class IdentifierGenerator_Interceptor extends AbsInterceptorDefaultAdapter
{
    public int doSavePerRow(ReportRequest rrequest,ReportBean rbean,Map<String,String> mRowData,Map<String,String> mParamValues,
            AbsEditableReportEditDataBean editbean)
    {
        String message="";
        if(editbean instanceof EditableReportInsertDataBean)
        {//对本条记录做添加操作
            message="正在添加记录：\n";
            System.out.print(message);
            if(mRowData!=null)//mRowData中存放了本条记录各列的值
            {
            	//因为页面中id这一列的displaytype是optional，即未显示，也就没设置值，所以mRowData没有响应的key，因此必须先设置key
            	mRowData.put("id",IdentifierGenerator.getStringId()); 
                Iterator itKeys=mRowData.keySet().iterator();
                while(itKeys.hasNext())
                {
                    String key=(String)itKeys.next();
                    String value=(String)mRowData.get(key);
                    System.out.print("["+key+"="+value+"]\n");
                }

            }
        }
        return super.doSavePerRow(rrequest,rbean,mRowData,mParamValues,editbean);
    }
}
