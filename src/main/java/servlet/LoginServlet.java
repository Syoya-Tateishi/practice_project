package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.UserDAO;
import model.entity.UserBean;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		UserDAO userdao = new UserDAO();
		/*
		 *sessionに"userId"を設定
		 */
		String userId = request.getParameter("userId");
		session.setAttribute("userId", userId);
		session.setAttribute("password", request.getParameter("pass"));
		try {
			//UserBean型のuserbeanにDAOで受け取ったデータを渡す
			UserBean userbean = userdao.getUserId(userId);
			String password = userbean.getPassword();
			
			//入力したPASSWORDがあっているか判定
			if(request.getParameter("pass").equals(password)) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("menu.jsp");
				dispatcher.forward(request, response);
			}else {
				String message = "Invalid user ID or password";
				request.setAttribute("message", message);
				RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
				dispatcher.forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
