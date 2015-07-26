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
package dataSource.optionList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wabacus.system.ReportRequest;
import com.wabacus.system.dataset.select.common.AbsCommonDataSetValueProvider;
import com.wabacus.util.Dao;

public class CeDianMingCheng extends AbsCommonDataSetValueProvider
{

	public List<Map<String,String>> getLstSelectBoxOptions(ReportRequest rrequest,Map<String,String> mParentInputboxValues)
	{
		List<Map<String,String>> lstResults=new ArrayList<Map<String,String>>();
		
		List<Map<String,String>> result=Dao.getInstance().getRecord("XTSZ_JBXXWH_CEDIANGUANLI");
        Map<String,String> mOptionTmp=null;
        //Boolean empty=false;
		for(Map<String,String> m:result)
		{
			
            mOptionTmp=new HashMap<String,String>();
            mOptionTmp.put("label",m.get("CEDIANMINGCHENG"));
            mOptionTmp.put("value",m.get("CEDIANMINGCHENG"));
            lstResults.add(mOptionTmp);
		}
		//System.out.println("m")
		
		if(lstResults.isEmpty())
		{

			mOptionTmp=new HashMap<String,String>();
			mOptionTmp.put("label", "暂无设备！");
			lstResults.add(mOptionTmp);
			
		}
		
		System.out.println(lstResults);

		return lstResults;//依赖的父输入框没有选中数据，则本子选择框也不显示选项


	}

	public Map<String,String> getAutoCompleteColumnsData(ReportRequest arg0,Map<String,String> arg1)
	{
		return null;
	}

	public List<Map<String,String>> getDynamicColGroupDataSet(ReportRequest arg0)
	{
		return null;
	}

	public List<Map<String,String>> getLstTypePromptOptions(ReportRequest arg0,String arg1)
	{
		return null;
	}

}
