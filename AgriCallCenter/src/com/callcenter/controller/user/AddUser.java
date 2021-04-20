package com.callcenter.controller.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.callcenter.dao.UserDao;
import com.callcenter.dto.User;




/**
 * Servlet implementation class AddUserController
 */
@WebServlet("/AddUser")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String SuccessText = "";
		session.setAttribute("SuccessText", SuccessText);
		String FailureText = "";
		session.setAttribute("FailureText", FailureText);
		request.getRequestDispatcher("RegisterUser.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();

		String SuccessText = "";
		session.setAttribute("SuccessText", SuccessText);
		String FailureText = "";
		session.setAttribute("FailureText", FailureText);

		try {
			User user = new User();

			user.setFirstName(request.getParameter("firstName"));
			user.setLastName(request.getParameter("lastName"));
			user.setEmail(request.getParameter("email"));
			user.setPassword(request.getParameter("password"));
			user.setRole(request.getParameter("role"));
			user.setStatus("active");


			int result = UserDao.insertUser(user);
			System.out.println(result);
			if (result > 0) {

				 SuccessText = "User Registered";
				session.setAttribute("SuccessText", SuccessText);

				request.getRequestDispatcher("RegisterUser.jsp").forward(request, response);

			} else {


				FailureText = "Registration Failed due to duplicate email id";
				session.setAttribute("FailureText", FailureText);

				request.getRequestDispatcher("RegisterUser.jsp").forward(request, response);
				//request.getRequestDispatcher("RegisterUser.jsp").forward(request, response);
			}
		}catch (Exception  e) {
			System.out.println(e);
			FailureText = "Registration Failed due to duplicate email id";
			session.setAttribute("FailureText", FailureText);

			request.getRequestDispatcher("RegisterUser.jsp").forward(request, response);
			/*session.setAttribute("FailureText", "Registration Failed due to duplicate email id");
			request.getRequestDispatcher("ErrorPage.jsp").forward(request, response);*/
		}



	}
}


