package com.it.dao;

import java.util.ArrayList;
import java.util.List;

import com.it.bean.GoodsInfo;

/**
 * 
 * Title:
 * Description:com.it.dao.GoodsData.java
 * Copyright: Copyright (c) j2se zxySoft
 * Company: zxySoft
 * @author zxy
 */
public class GoodsData {
	
	public static List<GoodsInfo> goods = new ArrayList<GoodsInfo>();
//queryAll
	  static{
		  
		  goods.add(new GoodsInfo("sp001", "ţ��", "80"));
		  goods.add(new GoodsInfo("sp002", "���", "180"));
		  goods.add(new GoodsInfo("sp003", "ƻ��", "8888"));
		  goods.add(new GoodsInfo("sp004", "�㽶", "5"));
		  goods.add(new GoodsInfo("sp005", "���", "8"));
		  
		  
	  }
	  
	  //findById
	  
	  
	  public static GoodsInfo findById(GoodsInfo goodsInfo){
		  
		  for (GoodsInfo goodsInfos : goods) {
			  if(goodsInfos.getGoods_Id().equals(goodsInfo.getGoods_Id())){
				  
				  return goodsInfos;
			  }
				  
				  
		}
		  
		  return null;
	  }
	  
	  
}
