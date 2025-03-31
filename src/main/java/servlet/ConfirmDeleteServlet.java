package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.CustomerDAO;

/**
 * Servlet implementation class ConfirmDeleteServlet
 */
@WebServlet("/customer-delete")
public class ConfirmDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");
		String password = (String) session.getAttribute("password");
		
//		if(userId == "null" || password == null) {
//			String message = "セッション切れ";
//			request.setAttribute("message", message);
//			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
//			dispatcher.forward(request, response);
//		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("confirmDelete.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");
		String password = (String) session.getAttribute("password");
		
//		if(userId == "null" || password == null) {
//			String message = "セッション切れ";
//			request.setAttribute("message", message);
//			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
//			dispatcher.forward(request, response);
//		}
		
		CustomerDAO customerdao = new CustomerDAO();
		
		try {
			customerdao.deleteCustomer(request.getParameter("customerId"));
			String operation = "削除";
			session.setAttribute("operation", operation);
			RequestDispatcher dispatcher = request.getRequestDispatcher("completed.jsp");
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			String message = "Error deleting customer";
			session.setAttribute("message", message);
			RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);
		}
	}

}
