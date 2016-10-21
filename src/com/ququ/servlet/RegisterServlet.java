package com.ququ.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		String nickname = request.getParameter("form-nickname");
		String password = request.getParameter("form-password");
		String ensure_password = request.getParameter("form-ensure_password");
		String username = request.getParameter("form-username");
		int result = uid.insert(nickname, password,ensure_password,username);
		
		HttpSession session = request.getSession();
		if(result==1){
			session.setAttribute("result", "³É¹¦");
			session.setAttribute("link", "<a href='Login.jsp'>·µ»ØµÇÂ¼ </a>");	
		}else{
			session.setAttribute("result", "Ê§°Ü");
		}
		response.sendRedirect("RegisterResult.jsp");
		
		
		
	}

}
