package com.it.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.it.bean.GoodsInfo;
import com.it.dao.GoodsData;
import com.it.service.GoodsImpl;
import com.it.service.IGoods;

/**
 * Servlet implementation class ShowGoodsServlet
 */
@WebServlet({ "/ShowGoodsServlet", "/showGoods" })
public class ShowGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowGoodsServlet() {
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
		
		response.setCharacterEncoding("utf-8");
		/*GoodsInfo goodsInfo = new GoodsInfo();
		//��ѯ������Ʒ
		
		IGoods igoods = new GoodsImpl();*/
		
	//	List<GoodsInfo> goods = igoods.queryAllGoods(goodsInfo );
		//GoodsData.findById(goodsInfo);
		List<GoodsInfo> goods = GoodsData.goods;
		//�洢��request��
		request.setAttribute("goods", goods);
		//��ת--��forward
		request.getRequestDispatcher("goods/showGoods.jsp").forward(request, response);
				
	}

}
