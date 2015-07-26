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

import com.wabacus.config.component.application.report.ReportBean;
import com.wabacus.system.ReportRequest;
import com.wabacus.system.commoninterface.IReportPersonalizePersistence;

/**
 * 这里为了简单起见，全部是保存在session中，具体开发时，开发人员可以将它们保存在数据库或本地文件中，以便永久保留用户的相关操作
 */
public class TestReportPersonalizePersistenceImpl implements IReportPersonalizePersistence
{
    /**
     * 加载本报表保存的上次列拖动操作后的列顺序
     */
    public String loadColOrderData(ReportRequest rrequest,ReportBean rbean)
    {
        return (String)rrequest.getRequest().getSession().getAttribute(rbean.getPageBean().getId()+rbean.getId()+"_colorderdata");
    }

    /**
     * 存储此报表列拖动后的顺序
     */
    public void storeColOrderData(ReportRequest rrequest,ReportBean rbean,String colOrder)
    {
        rrequest.getRequest().getSession().setAttribute(rbean.getPageBean().getId()+rbean.getId()+"_colorderdata",colOrder);
    }

    /**
     * 加载用户对本报表进行列选择后显示的列
     */
    public String loadColSelectedData(ReportRequest rrequest,ReportBean rbean)
    {
        return (String)rrequest.getRequest().getSession().getAttribute(rbean.getPageBean().getId()+rbean.getId()+"_colselecteddata");
    }

    /**
     * 存储此报表列选择后显示的列
     */
    public void storeColSelectedData(ReportRequest rrequest,ReportBean rbean,String colSelectedData)
    {
        rrequest.getRequest().getSession().setAttribute(rbean.getPageBean().getId()+rbean.getId()+"_colselecteddata",colSelectedData);
    }

    /**
     * 加载用户上次点击列标题进行列排序后的列及排序类型
     */
    public String loadOrderByCol(ReportRequest rrequest,ReportBean rbean)
    {
        return (String)rrequest.getRequest().getSession().getAttribute(rbean.getPageBean().getId()+rbean.getId()+"_orderbycol");
    }

    /**
     * 当用户点击本报表列标题进行列排序后的排序列及排序类型
     */
    public void storeOrderByCol(ReportRequest rrequest,ReportBean rbean,String orderByCol)
    {
        rrequest.getRequest().getSession().setAttribute(rbean.getPageBean().getId()+rbean.getId()+"_orderbycol",orderByCol);
    }
}
