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

import java.io.PrintWriter;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;

import com.wabacus.system.intercept.AbsFileUploadInterceptor;

public class TestFileUploadInterceptor extends AbsFileUploadInterceptor
{
    public boolean beforeDisplayFileUploadInterface(HttpServletRequest request,Map<String,String> mFormAndConfigValues,PrintWriter out)
    {
        String inputboxid=null;
        String param_no=null;
        String param_name=null;
        String param_txtno=null;
        String oldvalue=null;
        String testfieldname=null;
        if(mFormAndConfigValues!=null)
        {//当前是因为上传失败时显示上传界面
            inputboxid=mFormAndConfigValues.get("INPUTBOXID");
            if(inputboxid!=null&&!inputboxid.trim().equals(""))
            {//当前是在显示文件上传输入框的文件上传界面（注意这个时候不能从request中取如下值，因为这个时候的表单不是普通的表单，而是enctype="multipart/form-data"，必须从mFormAndConfigValues中取传过来的数据）
                param_no=mFormAndConfigValues.get("param_no");
                param_name=mFormAndConfigValues.get("param_name");
                param_txtno=mFormAndConfigValues.get("param_txtno");
                oldvalue=mFormAndConfigValues.get("OLDVALUE");
            }
           testfieldname=mFormAndConfigValues.get("testfieldname");
            System.out.println("当前是上传失败后再次显示的文件上传界面.........");
        }else
        {//当前是第一次访问上传界面
            inputboxid=request.getParameter("INPUTBOXID");
       //     if(inputboxid!=null&&!inputboxid.trim().equals(""))
        //    {//当前是在显示文件上传输入框的文件上传界面
       //         param_no=request.getParameter("param_no");
        //         param_name=request.getParameter("param_name");
        //        param_txtno=request.getParameter("param_txtno");
        //        oldvalue=request.getParameter("OLDVALUE");
       //     }
           testfieldname=request.getParameter("testfieldname");
            System.out.println("当前是第一次点击文件上传输入框显示的文件上传界面.........");
        }
     //   if(inputboxid!=null&&!inputboxid.trim().equals(""))
     //   {//打印报表fileuploadpage1.report5的文件上传输入框<inputbox 中inputboxparams="param_no=@{no}&amp;param_name=@{name}&amp;param_txtno=condition{txtno}"配置的动态参数值
     //       out.println("传过来的值依次为：<b>工号</b>："+param_no+";<b>姓名</b>："+param_name+";<b>工号查询条件</b>："+param_txtno+";<b>输入框旧值</b>："+oldvalue+"<hr>");
     //  }
        testfieldname=testfieldname==null?"":testfieldname.trim();
        out.println("备注：<input type='text' name='testfieldname' value='"+testfieldname+"'><hr>");
        return true;
    }

    public boolean beforeFileUpload(HttpServletRequest request,FileItem fileitemObj, Map<String, String> mFormAndConfigValues,PrintWriter out) {
    		
    		try {
    		
    		String filename = fileitemObj.getName();
    		
    		// System.out.println("--------------原文件名："+filename);
    		if (filename != null && !filename.trim().equals("")) {   	
    		int pos = filename.lastIndexOf("\\");   		
    		filename = filename.substring(pos + 1);  	
    		String[] filenameSplit = filename.split("\\.");   		
    		if(filenameSplit!=null && filenameSplit.length > 0){  	
    		Calendar ca = Calendar.getInstance();   		
    		filename = filenameSplit[0] + "(" + ca.get(Calendar.YEAR)  	
    		+ (ca.get(Calendar.MONTH) + 1) + ca.get(Calendar.DATE)   	
    		+ ca.get(Calendar.HOUR_OF_DAY)  		
    		+ ca.get(Calendar.MINUTE) + ca.get(Calendar.SECOND)   	
    		+ ")" + "." + filenameSplit[1];   	
    		// + ca.get(Calendar.MILLISECOND)   	
    		mFormAndConfigValues.put(FILENAME_KEY, filename);   	
    		}
    		}   
    		} catch (Exception e) {   
    		e.printStackTrace();   	
   		}
        		return true;// 表示由框架自动完成文件上传功能   	
    		}
    
    	
    /**
     * 所有文件上传后的成功/失败提示信息，如果返回空，则系统自动给出提示信息
     */
    public boolean beforeDisplayFileUploadPrompt(HttpServletRequest request,List lstFieldItems,Map<String,String> mFormAndConfigValues,
            String failedMessage,PrintWriter out)
    {
        if(lstFieldItems==null||lstFieldItems.size()==0) return true;
        FileItem fItemTmp;
        StringBuffer fileNamesBuf=new StringBuffer();
        for(int i=0;i<lstFieldItems.size();i++)
        {
            fItemTmp=(FileItem)lstFieldItems.get(i);
            if(fItemTmp.isFormField()) continue;//如果是普通表单域
            fileNamesBuf.append(fItemTmp.getName()).append(";");
        }
        if(fileNamesBuf.charAt(fileNamesBuf.length()-1)==';') fileNamesBuf.deleteCharAt(fileNamesBuf.length()-1);
        if(failedMessage!=null&&!failedMessage.trim().equals(""))
        {//如果上传失败
            out.println("<h4>温馨提示：上传文件"+fileNamesBuf.toString()+"失败，"+failedMessage+"</h4>");
        }else
        {//上传成功
            out.println("<script language='javascript'>");
            out.println("alert('上传文件"+fileNamesBuf.toString()+"成功');");

            String inputboxid=mFormAndConfigValues.get("INPUTBOXID");
            if(inputboxid!=null&&!inputboxid.trim().equals(""))
            {//如果是文件上传输入框的上传，则自动关闭上传界面
                String name=mFormAndConfigValues.get("param_name");
                name=name+"["+fileNamesBuf.toString()+"]";
                out.println("selectOK('"+name+"','name',null,true);");
            }
            out.println("</script>");
        }
        return false;//框架不自动提示成功或失败
    }

}
