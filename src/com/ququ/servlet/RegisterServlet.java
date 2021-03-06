package com.ququ.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.ququ.dao.UserInfoDao;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserInfoDao uid = new UserInfoDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String nickname = request.getParameter("form-nickname");
		String password = request.getParameter("form-password");
		String ensure_password = request.getParameter("form-ensure_password");
		String username = request.getParameter("form-username");
//		System.out.println(nickname);
		HttpSession session = request.getSession();
		int result = 0;
		if(password.equals(ensure_password)){
			result = uid.insert(nickname, password,username);
		}else{
			Gson gson = new Gson();
			String json = gson.toJson(result);
			response.getWriter().append(json);
			
		}
		
		if(result==1){
			response.sendRedirect("login.html");
		}else{
			response.sendRedirect("register.html");
		}
		
		
		
	}

}
