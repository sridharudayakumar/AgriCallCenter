package com.callcenter.controller.former;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.callcenter.dao.FormerDao;

import com.callcenter.dto.Former;


/**
 * Servlet implementation class AddFormer
 */
@WebServlet("/AddFormer")
public class AddFormer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFormer() {
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
		request.getRequestDispatcher("RegisterFormer.jsp").forward(request, response);
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
			Former former = new Former();

			former.setFormerName(request.getParameter("formerName"));
			former.setPhoneNo(Long.parseLong(request.getParameter("phoneNo")));
			former.setAddress(request.getParameter("address"));
			former.setQuery(request.getParameter("query"));
			former.setStatus(request.getParameter("status"));


			int result = FormerDao.insertFormer(former);
			System.out.println(result);
			if (result > 0) {

				 SuccessText = "Former Detail Registered";
				session.setAttribute("SuccessText", SuccessText);

				request.getRequestDispatcher("RegisterFormer.jsp").forward(request, response);

			} else {


				FailureText = "Registration Failed ";
				session.setAttribute("FailureText", FailureText);

				request.getRequestDispatcher("RegisterFormer.jsp").forward(request, response);
				//request.getRequestDispatcher("Registerformer.jsp").forward(request, response);
			}
		}catch (Exception  e) {
			System.out.println(e);
			FailureText = "Registration Failed";
			session.setAttribute("FailureText", FailureText);

			request.getRequestDispatcher("RegisterFormer.jsp").forward(request, response);
			/*session.setAttribute("FailureText", "Registration Failed due to duplicate email id");
			request.getRequestDispatcher("ErrorPage.jsp").forward(request, response);*/
		}




	}

}
