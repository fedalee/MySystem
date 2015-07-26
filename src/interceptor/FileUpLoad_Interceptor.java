package interceptor;

import java.io.PrintWriter;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;

import com.wabacus.system.intercept.AbsFileUploadInterceptor;

public class FileUpLoad_Interceptor extends AbsFileUploadInterceptor
{
   

    @Override
	public boolean beforeDisplayFileUploadInterface(HttpServletRequest request,
			Map<String, String> mFormAndConfigValues, PrintWriter out) {
		// TODO Auto-generated method stub
		return super.beforeDisplayFileUploadInterface(request, mFormAndConfigValues,
				out);
	}


	@Override
	public boolean beforeFileUpload(HttpServletRequest request,FileItem fileitemObj, Map<String, String> mFormAndConfigValues,PrintWriter out) {
    		
    		try {
    		
    		String filename = fileitemObj.getName();
    		
    		
    		 System.out.println("--------------原文件名："+filename);
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
    		System.out.println("--------------原文件名："+filename);
    		mFormAndConfigValues.put(SAVEVALUE_KEY, filename);   	
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
    @Override
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
