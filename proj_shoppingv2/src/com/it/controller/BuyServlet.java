package com.it.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.it.bean.GoodsDetails;
import com.it.bean.GoodsInfo;
import com.it.dao.GoodsData;
import com.it.service.CarService;
import com.it.service.GoodsImpl;
import com.it.service.IGoods;

/**
 * Servlet implementation class BuyServlet
 */
@WebServlet({ "/BuyServlet", "/buy.do" })
public class BuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1 ���ñ����ʽ
		 request.setCharacterEncoding("utf-8");
		 //2 ��ȡҳ����Ϣ
		 String goods_Id = request.getParameter("goods_Id");
		 String opt = request.getParameter("opt");
		 String count = request.getParameter("count");
		 //3 ���ɶ���
		 GoodsInfo goodsInfo = new GoodsInfo();
		 //����session
		 HttpSession session = request.getSession();
		
			//��ѯ������Ʒ
			
			IGoods igoods = new GoodsImpl();
		 //��ȡ���ﳵ
		 /**
		  * 1 ��һ�������Ʒ
		  * 2 �����������Ʒ
		  */
		 if(session.getAttribute("car")==null){
			 
			 //����session�Ÿ���
			 session.setAttribute("car", new ArrayList<GoodsDetails>());
			 
		 }
		 //��ȡ���ﳵ
		 
		 List<GoodsDetails> car = (List<GoodsDetails>)session.getAttribute("car");
		 
		 //�����ﳵ����һ��ҵ��
		 
		 CarService carService = new CarService(car);
		 //�жϹ���
		 //��չ��ﳵ
		 if("cls".equals(opt)){
			 carService.cls();
			//��ת--��showCar.jsp
			 response.sendRedirect("car/showCar.jsp");
			// response.sendRedirect("showGoods");
			 return;
		 }
		 //�޸Ĺ���
		 if("upd".equals(opt)){
			 int cnt = 0;
			// "",null
			 if(!"".equals(goods_Id) && goods_Id!=null){
			     goodsInfo.setGoods_Id(goods_Id);
			 }
			 if(!"".equals(count) && count!=null){
			     cnt = Integer.parseInt(count);
			 }
			 
			 //�޸Ĺ���
			 carService.upd2Car(goodsInfo, cnt);
			 
			//��ת--��showCar.jsp
			 response.sendRedirect("car/showCar.jsp");
			 return;
		 }
		 //ɾ������
		 if("del".equals(opt)){
			 //"" null
			 if(!"".equals(goods_Id) && goods_Id!=null){
			     goodsInfo.setGoods_Id(goods_Id);
			 }
			 //ִ��ɾ������
			 carService.del2Car(goodsInfo);
			 //��ת--��showCar.jsp
			 response.sendRedirect("car/showCar.jsp");
			 return;
		 }
		 //�����Ʒ
		 if("buy".equals(opt)){
			 //���ҵ���Ʒ
			 //"" null
			 if(!"".equals(goods_Id) && goods_Id!=null){
			     goodsInfo.setGoods_Id(goods_Id);
			 }
			 //GoodsInfo goodsInfo1 = igoods.findGoodsById(goodsInfo);
			 GoodsInfo goodsInfo1 = GoodsData.findById(goodsInfo);
			 //Ĭ���������Ʒ����Ϊ1
			 
			 //ִ����ӹ���
			 carService.add2Car(goodsInfo1, 1);
			 //��ת--��showCar.jsp
			 response.sendRedirect("car/showCar.jsp");
			 
			 return;
		 }
		 
	}

}
