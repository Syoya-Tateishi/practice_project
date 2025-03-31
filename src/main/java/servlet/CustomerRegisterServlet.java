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
 * Servlet implementation class CustomerRegisterServlet
 */
@WebServlet("/registerCustomer")
public class CustomerRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerRegisterServlet() {
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
		
		AreaDAO areadao = new AreaDAO();

		List<AreaBean> areaList = new ArrayList<AreaBean>();

		try {
			areaList = areadao.getAllArea();
			request.setAttribute("areaList", areaList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("customerRegister.jsp");
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
		
//		if(userId == "null" || password == null) {
//			String message = "セッション切れ";
//			request.setAttribute("message", message);
//			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
//			dispatcher.forward(request, response);
//		}

		CustomerDAO customerdao = new CustomerDAO();

		CustomerBean customer = new CustomerBean();

		String message = "Error adding employee<br>未入力があります";
		
		if (request.getParameter("customer_name") == null || request.getParameter("customerName").trim().isEmpty() ||
			request.getParameter("customer_name_kana") == null || request.getParameter("customerNameKana").trim().isEmpty() ||
			request.getParameter("postal_code") == null || request.getParameter("postalCode").trim().isEmpty() ||
			request.getParameter("address") == null || request.getParameter("address").trim().isEmpty() ||
			request.getParameter("area_name") == null || request.getParameter("areaCode").trim().isEmpty() ||
			request.getParameter("contact_person_name") == null || request.getParameter("contactPersonName").trim().isEmpty() ||
			request.getParameter("contact_person_name_kana") == null || request.getParameter("contactPersonNameKana").trim().isEmpty() ||
			request.getParameter("contact_person_tel") == null || request.getParameter("contactPersonTell").trim().isEmpty()) {
			request.setAttribute("message", message);
			RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);
		} else {
			try {
				customer.setCustomerName(request.getParameter("customer_name"));
				customer.setCustomerNameKana(request.getParameter("customer_name_kana"));
				customer.setPostalCode(request.getParameter("postal_code"));
				customer.setAddress(request.getParameter("address"));
				customer.setAreaCode(request.getParameter("area_name"));
				customer.setContactPersonName(request.getParameter("contact_person_name"));
				customer.setContactPersonNameKana(request.getParameter("contact_person_name_kana"));
				customer.setContactPersonTell(request.getParameter("contact_person_tel"));
				customer.setUserId(userId);

				customerdao.addCustomer(customer);
				
				String operation = "登録";
				session.setAttribute("operation", operation);
				RequestDispatcher dispatcher = request.getRequestDispatcher("completed.jsp");
				dispatcher.forward(request, response);

			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
