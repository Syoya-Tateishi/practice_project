package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.AreaDAO;
import model.dao.CustomerDAO;
import model.entity.AreaBean;
import model.entity.CustomerBean;

/**
 * Servlet implementation class CustomerEditServlet
 */
@WebServlet("/editCustomer")
public class CustomerEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerEditServlet() {
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
		
		if(userId == "null" || password == null) {
			String message = "セッション切れ";
			request.setAttribute("message", message);
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
		
		CustomerDAO customerdao = new CustomerDAO();
		AreaDAO areadao = new AreaDAO();

		CustomerBean customer = new CustomerBean();
		List<AreaBean> areaList = new ArrayList<AreaBean>();

		try {
			customer = customerdao.getCustomer(Integer.parseInt(request.getParameter("customerId")));
			areaList = areadao.getAllArea();
			request.setAttribute("customer", customer);
			request.setAttribute("areaList", areaList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("customerEdit.jsp");
			dispatcher.forward(request, response);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
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
		
		if(userId == "null" || password == null) {
			String message = "セッション切れ";
			request.setAttribute("message", message);
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
		
		CustomerDAO customerdao = new CustomerDAO();

		CustomerBean customer = new CustomerBean();

		String message = "Error adding employee<br>未入力があります";

		if (request.getParameter("customerName") == null || request.getParameter("customerName").trim().isEmpty() ||
			request.getParameter("customerNameKana") == null || request.getParameter("customerNameKana").trim().isEmpty() ||
			request.getParameter("postalCode") == null || request.getParameter("postalCode").trim().isEmpty() ||
			request.getParameter("address") == null || request.getParameter("address").trim().isEmpty() ||
			request.getParameter("areaCode") == null || request.getParameter("areaCode").trim().isEmpty() ||
			request.getParameter("contactPersonName") == null || request.getParameter("contactPersonName").trim().isEmpty() ||
			request.getParameter("contactPersonNameKana") == null || request.getParameter("contactPersonNameKana").trim().isEmpty() ||
			request.getParameter("contactPersonTell") == null || request.getParameter("contactPersonTell").trim().isEmpty() ||
			request.getParameter("userId") == null || request.getParameter("userId").trim().isEmpty()) {
			request.setAttribute("message", message);
			RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);
		} else {
			try {
				customer.setCustomerName(request.getParameter("customerName"));
				customer.setCustomerNameKana(request.getParameter("customerNameKana"));
				customer.setPostalCode(request.getParameter("postalCode"));
				customer.setAddress(request.getParameter("address"));
				customer.setAreaCode(request.getParameter("areaCode"));
				customer.setContactPersonName(request.getParameter("contactPersonName"));
				customer.setContactPersonNameKana(request.getParameter("contactPersonNameKana"));
				customer.setContactPersonTell(request.getParameter("contactPersonTell"));
				customer.setUserId(request.getParameter("userId"));

				customerdao.updateCustomer(customer);
				
				String operation = "編集";
				session.setAttribute("operation", operation);
				RequestDispatcher dispatcher = request.getRequestDispatcher("completed.jsp");
				dispatcher.forward(request, response);

			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
