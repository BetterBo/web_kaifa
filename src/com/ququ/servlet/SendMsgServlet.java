package com.ququ.servlet;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ququ.tools.HttpUtil;

/**
 * Servlet implementation class SendMsgServlet
 */
public class SendMsgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendMsgServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String mobile = request.getParameter("phoneNumber");
		System.out.println(mobile);
		
		Random r = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 6; i++) {
			sb.append(r.nextInt(10));
		}
		String code = sb.toString();
		request.getSession().setAttribute("code", code);
		String url = "http://v.juhe.cn/sms/send?mobile="+mobile+"&tpl_id=17886&tpl_value=%23code%23%3D"+code+"&key=d787d38ca75c8ddb3fec4e2ed8618a3a";
		String httpGet = HttpUtil.httpGet(url);
		
		Gson gson = new Gson();
		String json = gson.toJson(httpGet);
		response.getWriter().append(json);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
