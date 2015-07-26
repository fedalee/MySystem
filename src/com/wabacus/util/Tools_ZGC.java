package com.wabacus.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Tools_ZGC {
	
	public static double ceDianCalculator(List<Double> l)
	{
		Iterator<Double> itr=l.iterator();
		List<Double> ll=new ArrayList<Double>();
		
		//remove null entries
		while(itr.hasNext())
		{
			double tmp=itr.next();
			if(tmp>0)
			{
				ll.add(tmp);
			}
		}
		//System.out.println("After null removal :"+ll);
		Iterator<Double> itrr=ll.iterator();
		
		int n=ll.size();
		double total=0;
		while(itrr.hasNext())
		{
			
			total+=Math.pow(10, itrr.next()/10);
			
		}
		double totall=total/n;
		
		//System.out.println("n is "+n+"\n total is :"+total+ "\ntotal devided by n is "+totall);
		
		double finalResult=Math.log10(totall)*10;
		
		return finalResult;
	}

}
