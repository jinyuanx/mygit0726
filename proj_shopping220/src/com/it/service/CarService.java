package com.it.service;

import java.util.List;

import com.it.bean.GoodsDetails;
import com.it.bean.GoodsInfo;

/**
 * 
 * Title:���ﳵ�ķ����� Description:com.it.service.CarService.java Copyright: Copyright
 * (c) j2se zxySoft Company: zxySoft
 * 
 * @author zxy
 */
public class CarService {

	List<GoodsDetails> car;

	public CarService(List<GoodsDetails> car) {
		super();
		this.car = car;
	}

	public CarService() {
		super();
		// TODO Auto-generated constructor stub
	}

	// ���ָ����Ʒ�����ﳵ
	/**
	 * 1 �Ƿ��ǵ�һ����ӣ� �� ֱ����� 2 ����Ѿ����ˣ��޸�����
	 * 
	 * @param goodsInfo
	 */

	public void add2Car(GoodsInfo goodsInfo) {

		for (GoodsDetails goodsDetails : car) {
			// 1 ����Ѿ����ˣ��޸��������жϱ��һ�£����һֱ���޸�����
			if (goodsDetails.getGoodsInfo().getGoods_Id()
					.equals(goodsInfo.getGoods_Id())) {
				goodsDetails.setCount(goodsDetails.getCount() + 1);

				return;

			}
		}

		// �ǵ�һ����ӣ�

		car.add(new GoodsDetails(goodsInfo, 1));

	}

	// ɾ��ָ����Ʒ

	public void del2Car(GoodsInfo goodsInfo) {

		for (GoodsDetails goodsDetails : car) {

			if (goodsDetails.getGoodsInfo().getGoods_Id()
					.equals(goodsInfo.getGoods_Id())) {

				car.remove(goodsDetails);
				return;
			}

		}

	}

	// �޸�ָ����Ʒ������

	public void upd2Car(GoodsInfo goodsInfo, int count) {

		for (GoodsDetails goodsDetails : car) {

			if (goodsDetails.getGoodsInfo().getGoods_Id()
					.equals(goodsInfo.getGoods_Id())) {

				goodsDetails.setCount(count);

			}
		}

	}
	// ��չ��ﳵ
	
	public void cls(){
		
		car.clear();
	}

}
