package com.wabacus.util;

public class CeDianBean implements Comparable<CeDianBean> {
	@Override
	public String toString() {
		return "CeDianBean [name=" + name + ", value=" + value + "]";
	}
	private String name;
	private int value;
	public String getName() {
		return name;
	}
	public float getValue() {
		return value;
	}
	public CeDianBean(String n)
	{
		name=n;
		if(n.equals("SHIHZ")){ value=10 ;}
		else if(n.equals("SHIERDIANWUHZ" )){ value= (int)12.5 ;}
		else if(n.equals("SHILIUHZ") ){ value=16 ;}
		else if(n.equals("ERSHIHZ" )){ value=20 ;}
		else if(n.equals("ERSHIWUHZ") ){ value=25 ;}
		else if(n.equals("SANSHIYIDIANWUHZ") ){ value=(int) 31.5 ;}
		else if(n.equals("SISHIHZ") ){ value=40 ;}
		else if(n.equals("WUSHIHZ" )){ value=50 ;}
		else if(n.equals("LIUSHISANHZ") ){ value=63 ;}
		else if(n.equals("BASHIHZ" )){ value=80 ;}
		else if(n.equals("YIBAIHZ")){ value=100 ;}
		else if(n.equals("YIBAIERSHIWUHZ") ){ value=125 ;}
		else if(n.equals("YIBAILIUSHIHZ" )){ value=160 ;}
		else if(n.equals("ERBAIHZ" )){ value=200 ;}
		else if(n.equals("ERBAIWUSHIHZ" )){ value=250 ;}
		else if(n.equals("SANBAIYISHIWUHZ") ){ value=315 ;}
		else if(n.equals("SIBAIHZ" )){ value=400 ;}
		else if(n.equals("WUBAIHZ") ){ value=500 ;}
		else if(n.equals("LIUBAISANSHIHZ" )){ value=630 ;}
		else if(n.equals("BABAIHZ" )){ value=800 ;}
		else if(n.equals("YIQIANHZ")){ value=1000 ;}
		else if(n.equals("YIQIANERBAIWUSHIHZ" )){ value=1250 ;}
		else if(n.equals("YIQIANLIUBAIHZ" )){ value=1600 ;}
		else if(n.equals("ERQIANHZ" )){ value=2000 ;}
		else if(n.equals("ERQIANWUBAIHZ" )){ value=2500 ;}
		else if(n.equals("SANQIANYIBAIWUSHIHZ" )){ value=3150 ;}
		else if(n.equals("SIQIANHZ" )){ value=4000 ;}
		else if(n.equals("WUQIANHZ" )){ value=5000 ;}
		else if(n.equals("LIUQIANSANBAIHZ" )){ value=6300 ;}
		else if(n.equals("BAQIANHZ" )){ value=8000 ;}
		else if(n.equals("YIWANHZ")){ value=10000 ;}

		else{ value=0; }
		System.out.println("the value is  "+value);
	}


	public int compareTo(CeDianBean o) {
		// TODO Auto-generated method stub
		if(this.value-o.getValue()>0)return 1;
		else if(this.value-o.getValue()<0)return -1;
		else return 0;
	}

}
