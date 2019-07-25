package com.it.servlet;

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
import com.it.data.GoodData;
import com.it.service.CarService;

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
		String goods_Id =request.getParameter("goods_Id");
		String opt = request.getParameter("opt");
		String count = request.getParameter("count");
		//3 ���ɶ���
		GoodsInfo goodsInfo = new GoodsInfo();
		
		//5 ���ﳵ
		List<GoodsDetails> car = null;
		//����session
		
		HttpSession session = request.getSession();
		
		
		//�Ƿ��ǵ�һ�ι�����Ʒ
		
		if(session.getAttribute("car")==null){
			
			
			car = new ArrayList<GoodsDetails>();
			session.setAttribute("car", car);
		}
		//����ֱ�Ӵ�session��ȡ
				car = (List<GoodsDetails>)session.getAttribute("car");
		
		//4 //��������һ��service
				CarService carService = new CarService(car);
				//��չ��ﳵ
				if("cls".equals(opt)){
					//ִ��
					carService.cls();
					//��ת
					response.sendRedirect("show.do");
					return;
				}
			//�޸�
			if("upd".equals(opt)){
				//"" null
				goodsInfo.setGoods_Id(goods_Id);
				//ִ��
				carService.upd2Car(goodsInfo, Integer.parseInt(count));
				//��ת
				response.sendRedirect("car/showCar.jsp");
				
				return;
			}
			//ɾ��
				if("del".equals(opt)){
					
					//"" null
					goodsInfo.setGoods_Id(goods_Id);
					//ִ��
					carService.del2Car(goodsInfo);
					//��ת
					response.sendRedirect("car/showCar.jsp");
					
					return;
				}
				
				
		//buy
		if("buy".equals(opt)){
			
			GoodsInfo  goodsInfo2 = GoodData.getGoodsInfo(goods_Id);
			
			//ִ��
			carService.add2Car(goodsInfo2);
			
			//��ת
			response.sendRedirect("car/showCar.jsp");
		
			return;
		}
		
	}

}
