package com.callcenter.controller.agri;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.callcenter.dao.InformationDao;
import com.callcenter.dto.Information;



/**
 * Servlet implementation class UpdateInformation
 */
@WebServlet("/UpdateInformation")
public class UpdateInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateInformation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Information information = new Information();
		int infoId = Integer.parseInt(request.getParameter("id"));

		try {
			information = InformationDao.findOne(infoId);
			request.setAttribute("information", information);
			request.setAttribute("id", infoId);

			request.getRequestDispatcher("UpdateInformation.jsp").forward(request, response);
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
		Information information = new Information();

		information.setCategory(request.getParameter("category"));
		information.setTitle(request.getParameter("title"));
		
		information.setDescription(request.getParameter("description"));
		System.out.println(request.getParameter("infoId"));

		int id = Integer.parseInt(request.getParameter("infoId"));

		try {
			int result = InformationDao.updateInformation(information, id);

			if (result > 0) {
				HttpSession session = request.getSession();
				String SuccessText = "Record Updated";
				session.setAttribute("SuccessText", SuccessText);
				request.getRequestDispatcher("ShowInformations").forward(request, response);

			} else {
				request.getRequestDispatcher("UpdateInformation.jsp").forward(request, response);
			}

		} catch (

				SQLException e)

		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
