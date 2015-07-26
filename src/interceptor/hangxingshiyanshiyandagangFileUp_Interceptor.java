package interceptor;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;

public class hangxingshiyanshiyandagangFileUp_Interceptor extends GaizhuangguochengFileupInterceptor{

	public hangxingshiyanshiyandagangFileUp_Interceptor() {
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean beforeDisplayFileUploadInterface(HttpServletRequest request,
			Map<String, String> mFormAndConfigValues, PrintWriter out) {
		// TODO Auto-generated method stub
		return super.beforeDisplayFileUploadInterface(request, mFormAndConfigValues,
				out);
	}

	@Override
	public boolean beforeDisplayFileUploadPrompt(HttpServletRequest request,
			List lstFieldItems, Map<String, String> mFormAndConfigValues,
			String failedMessage, PrintWriter out) {
		// TODO Auto-generated method stub
		super.setLeibie("航行试验试验大纲");
		super.setreprotID("hangxingshiyanshiyandagang_report");
		super.setpageID("zhendongzaosheng_tabs");
		return super.beforeDisplayFileUploadPrompt(request, lstFieldItems,
				mFormAndConfigValues, failedMessage, out);
	}

	@Override
	public boolean beforeFileUpload(HttpServletRequest request,
			FileItem fileitemObj, Map<String, String> mFormAndConfigValues,
			PrintWriter out) {
		// TODO Auto-generated method stub
		return super.beforeFileUpload(request, fileitemObj, mFormAndConfigValues, out);
	}

}
