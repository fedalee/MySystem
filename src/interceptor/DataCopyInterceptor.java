package interceptor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wabacus.config.component.application.report.ReportBean;
import com.wabacus.system.ReportRequest;
import com.wabacus.system.component.application.report.configbean.editablereport.AbsEditableReportEditDataBean;
import com.wabacus.system.component.application.report.configbean.editablereport.EditableReportInsertDataBean;
import com.wabacus.system.dataset.update.action.AbsUpdateAction;
import com.wabacus.system.intercept.AbsInterceptorDefaultAdapter;
import com.wabacus.system.intercept.AbsPageInterceptor;
import com.wabacus.util.Dao;
import com.wabacus.util.IdentifierGenerator;

public class DataCopyInterceptor extends AbsInterceptorDefaultAdapter {

	@Override
	public int doSave(ReportRequest rrequest, ReportBean rbean,
			AbsEditableReportEditDataBean editbean) {
		
		if(editbean instanceof EditableReportInsertDataBean)
		{
			List<Map<String,String>> data = rrequest.getLstInsertedData("changguixianhaodetail_report");
			List<Map<String, String>> pdata=rrequest.getLstInsertedParamValues(rbean);
			Map<String,Object> gdata=new HashMap<String,Object>();	
			
			String value = pdata.get(0).get("suoshuxinghao");
			gdata =Dao.getInstance().getRecord("zbgl_zbjbxx_xinghao",value);
	
			List<String> cols=new ArrayList<String>();
			List<String> datecols=new ArrayList<String>();
			cols.add("id");
			cols.add("xianhao");
			cols.add("suoshuxinghao");
			cols.add("suoshuleibie");
			cols.add("mingminghao");
			datecols.add("kaigongshijian");
			datecols.add("jiaochuanshijian");
			cols.add("jieduan");
			cols.add("fuyinianxian");
			cols.add("shengchanchang");
			cols.add("liebianzhidui");
			cols.add("beizhu");
			cols.add("GAISHU");
		/*	cols.add("tingxing");
			cols.add("tingchang");
			cols.add("xingkuan");
			cols.add("xingshen");
			cols.add("scjzgd");
	     	cols.add("smctc");
			cols.add("nyctc");
			cols.add("nyctzkzj");
			cols.add("zcpsl");
			cols.add("czpsl");
			cols.add("sxqpsl");
			cols.add("zcztcbfl");
			cols.add("czztcbfl");
			cols.add("spwdyzdkd");
			cols.add("hengqingjiao");
			cols.add("tzscrj");
			cols.add("sxzcztcwxg2");
			cols.add("sxryczztcwxg2");
			cols.add("zuidazifushendu");
			cols.add("jixianshendu");
			cols.add("zdgzsd");
			cols.add("fxtzdgzsd");   */
			cols.add("zongchangdu");
			cols.add("zcdxingkuan");
			cols.add("zcdxingshen");
			cols.add("naiyachuanti");
			cols.add("yuanzhukezhijing");
			cols.add("fasheshuicangcd");
			cols.add("shuichuanmiducd");
			cols.add("wendingyikuandu");
			cols.add("jixianzhihuixian");
			cols.add("zcdjiegouchengyanengli");
			cols.add("naiyachuantizucheng");
			cols.add("naiyachuantizongchang");
			cols.add("chuantijiegoutedian");
			cols.add("fnaiyachuantizucheng");
			cols.add("fnaiyachuantizongchang");
			cols.add("fchuantijiegoutedian");
		
		
			List<String> values=new ArrayList<String>();
			List<String> datevalues=new ArrayList<String>();
			values.add(IdentifierGenerator.getStringId());
			values.add(data.get(0).get("xianhao"));
			values.add(pdata.get(0).get("suoshuxinghao"));
			values.add(pdata.get(0).get("suoshuleibie"));
			values.add(data.get(0).get("mingminghao"));
			datevalues.add(data.get(0).get("kaigongshijian"));
			datevalues.add(data.get(0).get("jiaochuanshijian"));
			values.add("待建造计划阶段");
			values.add(data.get(0).get("fuyinianxian"));
			values.add(data.get(0).get("shengchanchang"));
			values.add(data.get(0).get("liebianzhidui"));
			values.add((String)data.get(0).get("beizhu"));
			values.add((String)gdata.get("GAISHU"));
		/*	checkNull (values,(String)gdata.get("TINGXING"));
			checkNull (values,(String)gdata.get("TINGCHANG"));
			checkNull (values,(String)gdata.get("XINGKUAN"));
			checkNull (values,(String)gdata.get("XINGSHEN"));
			checkNull (values,(String)gdata.get("SCJZGD"));
			checkNull (values,(String)gdata.get("SMCTC"));
			checkNull (values,(String)gdata.get("NYCTC"));
			checkNull (values,(String)gdata.get("NYCTZKZJ"));
			checkNull (values,(String)gdata.get("ZCPSL"));
			checkNull (values,(String)gdata.get("CZPSL"));
			checkNull (values,(String)gdata.get("SXQPSL"));
			checkNull (values,(String)gdata.get("ZCZTCBFL"));
			checkNull (values,(String)gdata.get("CZZTCBFL"));
			checkNull (values,(String)gdata.get("SPWDYZDKD"));
			checkNull (values,(String)gdata.get("HENGQINGJIAO"));
			checkNull (values,(String)gdata.get("TZSCRJ"));
			checkNull (values,(String)gdata.get("SXZCZTCWXG2"));
			checkNull (values,(String)gdata.get("SXRYCZZTCWXG2"));
			checkNull (values,(String)gdata.get("ZUIDAZIFUSHENDU"));
			checkNull (values,(String)gdata.get("JIXIANSHENDU"));
			checkNull (values,(String)gdata.get("ZDGZSD"));
			checkNull (values,(String)gdata.get("FXTZDGZSD"));   */
			checkNull (values,(String)gdata.get("ZONGCHANGDU")); 
			checkNull (values,(String)gdata.get("ZCDXINGKUAN"));
			checkNull (values,(String)gdata.get("ZCDXINGSHEN"));
			checkNull (values,(String)gdata.get("NAIYACHUANTI"));
			checkNull (values,(String)gdata.get("YUANZHUKEZHIJING"));
			checkNull (values,(String)gdata.get("FASHESHUICANGCD"));
			checkNull (values,(String)gdata.get("SHUICHUANMIDUCD"));
			checkNull (values,(String)gdata.get("WENDINGYIKUANDU"));
			checkNull (values,(String)gdata.get("JIXIANZHIHUIXIAN"));
			checkNull (values,(String)gdata.get("ZCDJIEGOUCHENGYANENGLI"));
			checkNull (values,(String)gdata.get("NAIYACHUANTIZUCHENG"));
			checkNull (values,(String)gdata.get("NAIYACHUANTIZONGCHANG"));
			checkNull (values,(String)gdata.get("CHUANTIJIEGOUTEDIAN"));
			checkNull (values,(String)gdata.get("FNAIYACHUANTIZUCHENG"));
			checkNull (values,(String)gdata.get("FNAIYACHUANTIZONGCHANG"));
			checkNull (values,(String)gdata.get("FCHUANTIJIEGOUTEDIAN"));
			
			
			
			
			Dao.getInstance().insert("zbgl_zbjbxx_xianhao", cols, values,datecols,datevalues);
			
			String conditionCol="suoshuxinghao";
			List<Map<String,String>> ztbz=new ArrayList<Map<String,String>>();
			ztbz =Dao.getInstance().getMultiRecord("zbgl_zbjbxx_xinghao_ztbz",conditionCol,value);
			for(Map<String,String> z:ztbz)
			{
				List<String> stbzcols=new ArrayList<String>();
				List<String> stbzvalues=new ArrayList<String>();
				stbzcols.add("id");
				stbzcols.add("suoshuxianhao");
				stbzcols.add("cangduan");
				stbzcols.add("shebeiming");
				stbzvalues.add(IdentifierGenerator.getStringId());
				stbzvalues.add(data.get(0).get("xianhao"));
				stbzvalues.add(z.get("CANGDUAN"));
				stbzvalues.add(z.get("SHEBEIMING"));
				Dao.getInstance().insert("zbgl_zbjbxx_xianhao_stbz", stbzcols, stbzvalues);
			
			}
			
			List<Map<String,String>> yjxt=new ArrayList<Map<String,String>>();
			yjxt =Dao.getInstance().getMultiRecord("zbgl_zbjbxx_xinghao_yijixitong",conditionCol,value);
			for(Map<String,String> y:yjxt)
			{	
				List<String> yjxtcols=new ArrayList<String>();
				List<String> yjxtvalues=new ArrayList<String>();
				yjxtcols.add("id");
				yjxtcols.add("suoshuxianhao");
				yjxtcols.add("yijixitongmingcheng");
				yjxtcols.add("zhuyaogongneng");
				yjxtcols.add("buzhiheanzhuang");
				yjxtcols.add("zhanshujishuxingneng");
				yjxtcols.add("jiekouguanxi");
				yjxtcols.add("qita");
			
				yjxtvalues.add(IdentifierGenerator.getStringId());
				yjxtvalues.add(data.get(0).get("xianhao"));
				yjxtvalues.add(y.get("YIJIXITONGMINGCHENG"));
				yjxtvalues.add(y.get("ZHUYAOGONGNENG"));
				yjxtvalues.add(y.get("BUZHIHEANZHUANG"));
				yjxtvalues.add(y.get("ZHANSHUJISHUXINGNENG"));
				yjxtvalues.add(y.get("JIEKOUGUANXI"));
				yjxtvalues.add(y.get("QITA"));
			
				Dao.getInstance().insert("zbgl_zbjbxx_xianhao_yijixitong", yjxtcols, yjxtvalues);
			}
			
			List<Map<String,String>> ctzd=new ArrayList<Map<String,String>>();
			ctzd =Dao.getInstance().getMultiRecord("zbgl_zbjbxx_xinghao_ctzd",conditionCol,value);
			for(Map<String,String> c:ctzd)
			{	
				List<String> ctzdcols=new ArrayList<String>();
				List<String> ctzdvalues=new ArrayList<String>();
				ctzdcols.add("id");
				ctzdcols.add("suoshuxianhao");
				ctzdcols.add("zhuangtai");
				ctzdcols.add("yijie");
				ctzdcols.add("erjie");
				ctzdcols.add("sanjie");
			
				ctzdvalues.add(IdentifierGenerator.getStringId());
				ctzdvalues.add(data.get(0).get("xianhao"));
				ctzdvalues.add(c.get("ZHUANGTAI"));
			    values=ctzdvalues;
				checkNull (values,(String)c.get("YIJIE"));
				checkNull (values,(String)c.get("ERJIE"));
				checkNull (values,(String)c.get("SANJIE"));
				Dao.getInstance().insert("zbgl_zbjbxx_xianhao_ctzd", ctzdcols, ctzdvalues);
				
			}
			
			List<Map<String,String>> nyctzj=new ArrayList<Map<String,String>>();
			nyctzj =Dao.getInstance().getMultiRecord("zbgl_zbjbxx_xinghao_nyctzj",conditionCol,value);
			for(Map<String,String> n:nyctzj)
			{	
				List<String> nyctzjcols=new ArrayList<String>();
				List<String> nyctzjvalues=new ArrayList<String>();
				nyctzjcols.add("id");
				nyctzjcols.add("suoshuxianhao");
				nyctzjcols.add("jiegouxingshi");
				nyctzjcols.add("syi");
				nyctzjcols.add("wyi");
				nyctzjcols.add("ser");
				nyctzjcols.add("wer");
			
				nyctzjvalues.add(IdentifierGenerator.getStringId());
				nyctzjvalues.add(data.get(0).get("xianhao"));
				nyctzjvalues.add(n.get("JIEGOUXINGSHI"));
			    values=nyctzjvalues;
				checkNull (values,(String)n.get("SYI"));
				checkNull (values,(String)n.get("WYI"));
				checkNull (values,(String)n.get("SER"));
				checkNull (values,(String)n.get("WER"));
				Dao.getInstance().insert("zbgl_zbjbxx_xianhao_nyctzj", nyctzjcols, nyctzjvalues);
				
			}
			
			List<Map<String,String>> kbhd=new ArrayList<Map<String,String>>();
			kbhd =Dao.getInstance().getMultiRecord("zbgl_zbjbxx_xinghao_kbhd",conditionCol,value);
			for(Map<String,String> k:kbhd)
			{	
				List<String> kbhdcols=new ArrayList<String>();
				List<String> kbhdvalues=new ArrayList<String>();
				kbhdcols.add("id");
				kbhdcols.add("suoshuxianhao");
				kbhdcols.add("leixing");
				kbhdcols.add("kebanhoudu");
				kbhdcols.add("syi");
				kbhdcols.add("wyi");
				kbhdcols.add("beizhu");
			
				kbhdvalues.add(IdentifierGenerator.getStringId());
				kbhdvalues.add(data.get(0).get("xianhao"));
				kbhdvalues.add(k.get("LEIXING"));
			    values=kbhdvalues;
			    checkNull (values,(String)k.get("KEBANHOUDU"));
				checkNull (values,(String)k.get("SYI"));
				checkNull (values,(String)k.get("WYI"));
				kbhdvalues.add(k.get("BEIZHU"));
				Dao.getInstance().insert("zbgl_zbjbxx_xianhao_kbhd", kbhdcols, kbhdvalues);
				
			}
			
			List<Map<String,String>> lgjj=new ArrayList<Map<String,String>>();
			lgjj =Dao.getInstance().getMultiRecord("zbgl_zbjbxx_xinghao_lgjj",conditionCol,value);
			for(Map<String,String> l:lgjj)
			{	
				List<String> lgjjcols=new ArrayList<String>();
				List<String> lgjjvalues=new ArrayList<String>();
				lgjjcols.add("id");
				lgjjcols.add("suoshuxianhao");
				lgjjcols.add("leixing");
				lgjjcols.add("syi");
				lgjjcols.add("wyi");
				lgjjcols.add("leigujianju");
			
				lgjjvalues.add(IdentifierGenerator.getStringId());
				lgjjvalues.add(data.get(0).get("xianhao"));
				lgjjvalues.add(l.get("LEIXING"));
			    values=lgjjvalues;
				checkNull (values,(String)l.get("SYI"));
				checkNull (values,(String)l.get("WYI"));
				checkNull (values,(String)l.get("LEIGUJIANJU"));
				Dao.getInstance().insert("zbgl_zbjbxx_xianhao_lgjj", lgjjcols, lgjjvalues);
				
			}
			
			List<Map<String,String>> ctcl=new ArrayList<Map<String,String>>();
			ctcl =Dao.getInstance().getMultiRecord("zbgl_zbjbxx_xinghao_ctcl",conditionCol,value);
			for(Map<String,String> c:ctcl)
			{	
				List<String> ctclcols=new ArrayList<String>();
				List<String> ctclvalues=new ArrayList<String>();
				ctclcols.add("id");
				ctclcols.add("suoshuxianhao");
				ctclcols.add("leixing");
				ctclcols.add("cailiaoleibie");
				ctclcols.add("cailiaoxinghao");
				ctclcols.add("yingyongfanwei");
			
				ctclvalues.add(IdentifierGenerator.getStringId());
				ctclvalues.add(data.get(0).get("xianhao"));
				ctclvalues.add(c.get("LEIXING"));
				ctclvalues.add(c.get("CAILIAOLEIBIE"));
				ctclvalues.add(c.get("CAILIAOXINGHAO"));
				ctclvalues.add(c.get("YINGYONGFANWEI"));
				Dao.getInstance().insert("zbgl_zbjbxx_xianhao_ctcl", ctclcols, ctclvalues);
				
			}
			
			List<Map<String,String>> lgxh=new ArrayList<Map<String,String>>();
			lgxh =Dao.getInstance().getMultiRecord("zbgl_zbjbxx_xinghao_lgxh",conditionCol,value);
			for(Map<String,String> l:lgxh)
			{	
				List<String> lgxhcols=new ArrayList<String>();
				List<String> lgxhvalues=new ArrayList<String>();
				lgxhcols.add("id");
				lgxhcols.add("suoshuxianhao");
				lgxhcols.add("leixing");
				lgxhcols.add("leiguxinghao");
				lgxhcols.add("leiguhao");
				lgxhcols.add("leigubuzhixingshi");
				lgxhcols.add("beizhu");
			
				lgxhvalues.add(IdentifierGenerator.getStringId());
				lgxhvalues.add(data.get(0).get("xianhao"));
				lgxhvalues.add(l.get("LEIXING"));
				lgxhvalues.add(l.get("LEIGUXINGHAO"));
				lgxhvalues.add(l.get("LEIGUHAO"));
				lgxhvalues.add(l.get("LEIGUBUZHIXINGSHI"));
				lgxhvalues.add(l.get("BEIZHU"));
				Dao.getInstance().insert("zbgl_zbjbxx_xianhao_lgxh", lgxhcols, lgxhvalues);
				
			}
			
			List<Map<String,String>> nyctqd=new ArrayList<Map<String,String>>();
			nyctqd =Dao.getInstance().getMultiRecord("zbgl_zbjbxx_xinghao_nyctqd",conditionCol,value);
			for(Map<String,String> n:nyctqd)
			{	
				List<String> nyctqdcols=new ArrayList<String>();
				List<String> nyctqdvalues=new ArrayList<String>();
				nyctqdcols.add("id");
				nyctqdcols.add("suoshuxianhao");
				nyctqdcols.add("jiegouquyu");
				nyctqdcols.add("zhongmianyingli");
				nyctqdcols.add("zongmianyingli");
				nyctqdcols.add("linjieyali");
				nyctqdcols.add("beizhu");
			
				nyctqdvalues.add(IdentifierGenerator.getStringId());
				nyctqdvalues.add(data.get(0).get("xianhao"));
				nyctqdvalues.add(n.get("JIEGOUQUYU"));
				values=nyctqdvalues;
				checkNull (values,(String)n.get("ZHONGMIANYINGLI"));
				checkNull (values,(String)n.get("ZONGMIANYINGLI"));
				checkNull (values,(String)n.get("LINJIEYALI"));
				nyctqdvalues.add(n.get("BEIZHU"));
				Dao.getInstance().insert("zbgl_zbjbxx_xianhao_nyctqd", nyctqdcols, nyctqdvalues);
				
			}
		
			return WX_RETURNVAL_SUCCESS;
		}
		return super.doSave(rrequest, rbean, editbean);
	}
	public void checkNull (List values,String value)
	{
	
			values.add((value==null)? "":value);
	}
}
