package com.callcenter.controller.agri;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.callcenter.dao.InformationDao;

import com.callcenter.dto.Information;

/**
 * Servlet implementation class AddInformation
 */
@WebServlet("/AddInformation")
public class AddInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddInformation() {
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
		request.getRequestDispatcher("AddInformation.jsp").forward(request, response);
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
		Information information = new Information();
			information.setCategory(request.getParameter("category"));
			information.setTitle(request.getParameter("title"));
			
			information.setDescription(request.getParameter("description"));
			


			int result = InformationDao.insertInformation(information);
			System.out.println(result);
			if (result > 0) {

				 SuccessText = "Information Added";
				session.setAttribute("SuccessText", SuccessText);

				request.getRequestDispatcher("AddInformation.jsp").forward(request, response);

			} else {


				FailureText = "Failed to Insert";
				session.setAttribute("FailureText", FailureText);

				request.getRequestDispatcher("AddInformation.jsp").forward(request, response);
				
			}
		}catch (Exception  e) {
			System.out.println(e);
			FailureText = "Failed to Insert";
			session.setAttribute("FailureText", FailureText);

			request.getRequestDispatcher("AddInformation.jsp").forward(request, response);
		
		}



	}

}
