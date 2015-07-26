package interceptor;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.wabacus.system.ReportRequest;
import com.wabacus.system.intercept.AbsPageInterceptor;
import com.wabacus.util.Dao;

public class GetIdInterceptor extends AbsPageInterceptor{
	 String xianhao;
	 String zhuangtai;
	 // 通过name可以清楚看到拦截器调用两次，主表一次，从表一次
	 String name;
	 String suoshushebei;
	public void doStart(ReportRequest rrequest) {
		//System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		//rrequest.addParamToUrl("aaa", "bbb", true);
		HttpServletRequest request=rrequest.getRequest();
		HttpSession session= request.getSession();
		xianhao=request.getParameter("suoshuxianhao");
		zhuangtai=request.getParameter("zhuangtai");
		name=request.getParameter("name");
		suoshushebei=request.getParameter("suoshushebei");
		System.out.println("状态 ："+zhuangtai+"\n");
		System.out.println("舷号 ："+xianhao+"\n");
		System.out.println("name ："+name+"\n");
		System.out.println("suoshushebei ："+suoshushebei+"\n");
/*		if(xianhao!=null&&zhuangtai!=null)
		{*/
			List<String> cols=new ArrayList<String>();
			List<String> values=new ArrayList<String>();
			cols.add("SUOSHUXIANHAO");
			cols.add("XIANHAOZHUANGTAI");
			values.add(xianhao);
			values.add(zhuangtai);
			List<Map<String,String>> result= Dao.getInstance().getRecoed("ZBGL_ZXSY_SHEBEI", cols, values);
			System.out.println("The result is : \n"+result);
			for(Map<String,String> m:result)
			{
				
				/*一定要用session ！！！因为配置文件用了主从报表，那么框架把拦截器在主表和从表中各调用一次，其实我们要用的是主表的URL
				 * 不过框架同时也会读取从表的URL ，这样的话将输入存在request中的数据就会被从表读取的数据覆盖（其实从表中根本读不到
				 * 想要的数据，全是null。所以要把数据存在session中，因为要遍历result，所以如果是空的话，根本不可能在session中存入
				 * 数据，也就是说只有再重新选择舷号/状态的时候session里的值就会被覆盖调，这种情况只有用户打开了新的界面才可以。而且所
				 * 有的CRUD操作前，页面都将被刷新，所以即使是用户同时开两个页面都不会出问题）
				 * */
/*				session.setAttribute(m.get("JIEDUAN"), m.get("ID"));*/
				
				
				
				/*
				 * 有想到更好的办法！！！在从报表只要把@shuoshuxianhao和@xianhaozhuangtai传过来，就不用session。
				 * 毕竟用session在逻辑上不是很对。
				 * */
				request.setAttribute(m.get("JIEDUAN"), m.get("ID"));
				
			}
			System.out.println("台架： "+request.getAttribute("taijia"));
/*		}*/
		
		
		//System.out.print(" \n\n\n\n\n  end of GetIdInterceptor ");
		
		/*super.doStart(rrequest);*/
	}

	@Override
	public void doEnd(ReportRequest rrequest) {
		// TODO Auto-generated method stub
		//doStart(rrequest);
		//super.doEnd(rrequest);
		
	}
	

}
