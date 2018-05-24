package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WCDBServlet
 */
@WebServlet("/WCDBServlet")
public class WCDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public WCDBServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("kaiinnNo", Integer.toString(1));
		request.setAttribute("kaiinnName", "中村");
		request.setAttribute("registDate", "2018/05/24");

		RequestDispatcher disp = request.getRequestDispatcher("/serch.jsp");
		disp.forward(request, response);
	}

}
