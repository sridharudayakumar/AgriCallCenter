package com.callcenter.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.callcenter.dao.LoginDao;



/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("username");
		String passWord = request.getParameter("password");
		//PrintWriter out = response.getWriter();
		//ArrayList<CountTemp> counttempList = new ArrayList<CountTemp>();
		String role = LoginDao.checkLoginSession(userName, passWord);

		if (role !=null ) {
			HttpSession session = request.getSession();

			session.setAttribute("userName", userName);
			session.setAttribute("passWord", passWord);
			System.out.println(session.getId());

			/*	ArrayList<CaseNumbers> counttempList = new ArrayList<CaseNumbers>();
			try {
				counttempList= PatientDao.findCaseNumbers();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/

			request.setAttribute("message", "");
			if (role.equals("Administrator"))
			{
				session.setAttribute("role", role);
				System.out.println(userName);
				session.setAttribute("userName", userName);
				//	session.setAttribute("counttempList", counttempList);
				request.getRequestDispatcher("admin.jsp").forward(request, response);
			} else if (role.equals("Agri Officer")){
				session.setAttribute("role", role);
				session.setAttribute("userName", userName);
				//session.setAttribute("counttempList", counttempList);
				request.getRequestDispatcher("agriofficer.jsp").forward(request, response);

			}else if (role.equals("Tele Caller")){
				session.setAttribute("role", role);
				session.setAttribute("userName", userName);
				//	session.setAttribute("counttempList", counttempList);
				request.getRequestDispatcher("telecaller.jsp").forward(request, response);
			}


		} else {
			String errortext = "Invalid Username or Password";
			request.setAttribute("message", errortext);

			request.getRequestDispatcher("login.jsp").forward(request, response);
			//response.sendRedirect("login.jsp");
		}
	}

}
