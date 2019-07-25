package com.it.service;

import java.util.List;

import com.it.bean.GoodsDetails;
import com.it.bean.GoodsInfo;

/**
 * ���ﳵ
 * 
 * ��������һ����
 * Title:
 * Description:com.it.service.CarService.java
 * Copyright: Copyright (c) j2se zxySoft
 * Company: zxySoft
 * @author zxy
 */
public class CarService {

	List<GoodsDetails> car ;

	public List<GoodsDetails> getCar() {
		return car;
	}

	public void setCar(List<GoodsDetails> car) {
		this.car = car;
	}

	public CarService(List<GoodsDetails> car) {
		super();
		this.car = car;
	}

	public CarService() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	 //���ָ����Ʒ�����ﳵ
	/**
	 * 1 ѭ���������ﳵ
	 *   �ж��Ƿ��ǵ�һ�����
	 *      a.������ǣ����޸�����
	 *      b.����ǣ����¼ӵ����ﳵ
	 *      
	 */
	
	public void add2Car(GoodsInfo goodsInfo,int count){
		
		//ѭ���������ﳵ
		
		for (GoodsDetails goodsDetails : car) {
			//�Ѿ��������
			 if(goodsDetails.getGoodsInfo().getGoods_Id().equals(goodsInfo.getGoods_Id())){
				 
				 //�޸�����
				 goodsDetails.setCount(goodsDetails.getCount()+count);
				 return;
			 }
		}
		//��һ����Ӹ���Ʒ
		
		car.add(new GoodsDetails(goodsInfo,count));
		
	}

	 //ɾ��ָ����Ʒ
	/**
	 *  1 ѭ���������ﳵ
	 *   ��ѯ��Ʒ����Ƿ�һ�£����һ����ӳ����Ƴ�
	 * @param goodsInfo
	 */
	public void del2Car(GoodsInfo goodsInfo){
		
		for (GoodsDetails goodsDetails : car) {
			 if(goodsDetails.getGoodsInfo().getGoods_Id().equals(goodsInfo.getGoods_Id())){
				 
				 car.remove(goodsDetails);
				 return;
			 }
			
		}
		
		
		
	}
	 //�޸�ָ����Ʒ������
	/**
	 *  1 ѭ���������ﳵ
	 *   
	 *     ��ѯ��Ʒ����Ƿ�һ�£����һ�����޸ĸ���Ʒ������
	 * @param goodsInfo
	 * @param count
	 */
	
	public void upd2Car(GoodsInfo goodsInfo,int count){
		
		for (GoodsDetails goodsDetails : car) {
			 if(goodsDetails.getGoodsInfo().getGoods_Id().equals(goodsInfo.getGoods_Id())){
				 
				 goodsDetails.setCount(count);
				 return;
			 }
		}
		
		
	}
	
	 //��չ��ﳵ

	public void cls(){
		car.clear();
	}
}
