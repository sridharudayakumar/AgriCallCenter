package com.callcenter.controller.former;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.callcenter.dao.FormerDao;

import com.callcenter.dto.Former;



/**
 * Servlet implementation class UpdateFormer
 */
@WebServlet("/UpdateFormer")
public class UpdateFormer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateFormer() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Former former = new Former();
		int formerId = Integer.parseInt(request.getParameter("id"));

		try {
			former = FormerDao.findOne(formerId);
			request.setAttribute("former", former);
			request.setAttribute("id", formerId);

			request.getRequestDispatcher("UpdateFormer.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (NullPointerException e) {
			response.sendRedirect("login.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Former former = new Former();

		former.setFormerName(request.getParameter("formerName"));
		former.setPhoneNo(Long.parseLong(request.getParameter("phoneNo")));
		former.setAddress(request.getParameter("address"));
		former.setQuery(request.getParameter("query"));
		former.setStatus(request.getParameter("status"));
		System.out.println(request.getParameter("formerId"));

		int id = Integer.parseInt(request.getParameter("formerId"));

		try {
			int result = FormerDao.updateFormer(former, id);

			if (result > 0) {
				HttpSession session = request.getSession();
				String SuccessText = "Record Updated";
				session.setAttribute("SuccessText", SuccessText);
				request.getRequestDispatcher("ShowFormers").forward(request, response);

			} else {
				request.getRequestDispatcher("UpdateFormer.jsp").forward(request, response);
			}

		} catch (

				SQLException e)

		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


