// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SQLInteceptor.java

package interceptor;

import com.wabacus.system.ReportRequest;
import com.wabacus.system.intercept.AbsPageInterceptor;
import com.wabacus.util.Dao;
import java.io.PrintStream;
import java.util.*;

public class SQLInteceptor extends AbsPageInterceptor
{

    public SQLInteceptor()
    {
    }

    public void doEnd(ReportRequest rrequest)
    {
        super.doEnd(rrequest);
    }

    public void doEndSave(ReportRequest rrequest, List lstSaveReportBeans)
    {
        List data = rrequest.getLstInsertedData("zhendongzaosheng_report");
        if(data != null)
        {
            System.out.println(data);
            List cols;
            List values;
            for(Iterator iterator = data.iterator(); iterator.hasNext(); Dao.getInstance().insert("zbgl_zxsy_zdzs_mtsy", cols, values))
            {
                Map r = (Map)iterator.next();
                cols = new ArrayList();
                cols.add("xianhao");
                cols.add("xinghao");
                values = new ArrayList();
                values.add((String)r.get("xianhao"));
                values.add((String)r.get("xinghao"));
            }

        }
        super.doEndSave(rrequest, lstSaveReportBeans);
    }

    public void doStart(ReportRequest rrequest)
    {
        super.doStart(rrequest);
    }

    public void doStartSave(ReportRequest rrequest, List lstSaveReportBeans)
    {
        super.doStartSave(rrequest, lstSaveReportBeans);
    }
}