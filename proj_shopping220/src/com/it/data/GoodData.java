package com.it.data;

import java.util.ArrayList;
import java.util.List;

import com.it.bean.GoodsInfo;

/**
 * 
 * Title:ģ�����ݿ��
 * Description:com.it.data.GoodData.java
 * Copyright: Copyright (c) j2se zxySoft
 * Company: zxySoft
 * @author zxy
 */
public class GoodData {
	
	public static List<GoodsInfo> goodsInfo= new ArrayList<GoodsInfo>();
	
	static{
		
		goodsInfo.add(new GoodsInfo("gd001", "�ʼǱ�����", "7000"));
		goodsInfo.add(new GoodsInfo("gd002", "��ԥ��", "1"));
		goodsInfo.add(new GoodsInfo("gd003", "����", "4"));
		goodsInfo.add(new GoodsInfo("gd004", "��Ϊ�ֻ�p20", "8000"));
		goodsInfo.add(new GoodsInfo("gd005", "�����ֻ�", "4000"));
		
		
	}
	
	
	//����һ��ͨ����ŵõ���Ʒ����ķ���
	
	public static GoodsInfo getGoodsInfo(String goods_Id){
		
		for (GoodsInfo goodsInfo2 : goodsInfo) {
			
			if(goodsInfo2.getGoods_Id().equals(goods_Id)){
				
				return goodsInfo2;
			}
		}
		
		return null;
	}
	

}
