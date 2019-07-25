package com.it.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.it.bean.Users;
import com.it.service.IUsers;
import com.it.service.UsersImpl;

/**
 * Servlet implementation class UsersServlet
 */
@WebServlet({ "/UsersServlet", "/user.do", "/user" })
public class UsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersServlet() {
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
	        //  1 ���ñ����ʽ
		   request.setCharacterEncoding("utf-8");
		   //2��ȡҳ����Ϣ
		      //  2-1 ��ȡopt
		   String opt = request.getParameter("opt");
		     // 2-2��ȡֵ ע�ᣬ�޸�
		   String user_name = request.getParameter("user_name");
		   String user_age = request.getParameter("user_age");
		   String user_weight = request.getParameter("user_weight");
		   //��¼
		   String user_id = request.getParameter("user_id");
		  //  3 ���ɶ���
		   Users users = new Users();
		  //  4 service
		   IUsers iUsers = new UsersImpl();
		    //�������
		   
		   boolean flag = false;
		   //��Ž����
		   List<Users> listU = null;
		   //�������˽��лỰ����
		   //����session
		   HttpSession session = request.getSession();
		   
		  // 5 ����opt��ֵ�����ж�ִ���ض��Ĺ���
		   //�޸�
		   if("upd".equals(opt)){
			   //"" null js
			   users.setUser_id(Integer.parseInt(user_id));
			   users.setUser_name(user_name);
			   users.setUser_age(Integer.parseInt(user_age));
			   users.setUser_weight(Double.parseDouble(user_weight));
			  //2  ִ���޸�
			   flag = iUsers.updUsers(users);
			   
			   //ok
			    if(flag){
			    	response.sendRedirect("user.do?opt=queryAll");
			    }
			    else{
			    	response.sendRedirect("error.html");
			    }
			   
			   return;
		   }
		   //��ѯ����
		   if("findById".equals(opt)){
			   
			   //��ֵ
			   //1 ��ֵ
			   users.setUser_id(Integer.parseInt(user_id));
			   //2 ִ�в�ѯ����
			   Users users2 = iUsers.findUsersById(users);
			   //���ݽ��������ת
			   /**
			    * user.do---->users2--->findById.jsp--->��Users2չʾ����
			    * 
			    * �����������ͬһ������
			    * ת����ת
			    * �ȴ�ֵ
			    * ����ת
			    * 
			    */
			   if(users2!=null){
				   //��ֵ
				   request.setAttribute("users", users2);
				   //��ת
				   request.getRequestDispatcher("/users/findById.jsp").forward(request, response);
				   
			   }
			   
			   
			   return;
		   }
		   //��ѯ����
		   if("queryAll".equals(opt)){
			   //ģ����ѯ
			  // "" null
			   if (!"".equals(user_name) && user_name != null) {
					users.setUser_name(user_name);
				}
				if (!"".equals(user_age) && user_age != null) {
					users.setUser_age(Integer.parseInt(user_age));
				}
			   
			   //��ѯ����
			   listU = iUsers.queryAllUsers(users);
			   //
			   /**չʾ����
			    * View--->queryAllUsers.jsp
			    * jsp��չʾ��listU������϶����е���������
			    * user.do--->servlet
			    * queryAllUsers.jsp--->jsp
			    * 
			    * ����web���֮��Ҫ��������listU
			    * listU���� user.do---����queryAllUsers.jsp--��֮����Ȼ�Ǹ�����
			    */
			   //�Ѷ������request��
			   request.setAttribute("listU", listU);
			     //��ת
			     //����ת��
			   request.getRequestDispatcher("users/queryAllUsers.jsp").forward(request, response);
			   
			     
			   
			   return;
		   }
		   //��¼
		   if("login".equals(opt)){
			   
			   //1 ��ֵ
			   users.setUser_id(Integer.parseInt(user_id));
			   users.setUser_age(Integer.parseInt(user_age));
			   //2 ִ�е�¼
			   flag =  iUsers.login(users);
			
			 //ok
		    if(flag){
		    	//��ҳ--��չʾ������Ϣ--��queryAll.do
		    	//user.do?opt=queryAll
		    	//response.sendRedirect("index.html");
		    	
		    	//response.sendRedirect("user.do?opt=queryAll");
		    	//����ֵ
		    	session.setAttribute("users", users);
		    	response.sendRedirect("index.jsp");
		    }
		    else{
		    	response.sendRedirect("users/login.html");
		    }
			   return;
		   }
		   //ע��
		   if("reg".equals(opt)){
			   
			   //1 ��ֵ
			   
			   users.setUser_name(user_name);
			   users.setUser_age(Integer.parseInt(user_age));
			   users.setUser_weight(Double.parseDouble(user_weight));
			   
			   //2 ִ����ӹ���
			   flag = iUsers.addUsers(users);
			   //ok
			    if(flag){
			    	response.sendRedirect("users/login.html");
			    }
			    else{
			    	response.sendRedirect("error.html");
			    }
			   return;
		   }
		
	}

}
