package web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

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
		String kaiinnNostr = request.getParameter("kaiinnNo");

		PreparedStatement stmt = null;
		ResultSet rset = null;

		try {
			//接続文字列の構築
			/* ユーザ名 */
			String user = "root";
			/* パスワード */
			String pass = "root";

			/* サーバ名 */
			String servername = "localhost:3306";
			/* DB名 */
			String dbname = "new_schema";

			// ドライバーのロード
			Class.forName("com.mysql.jdbc.Driver");

			//接続の実行とコネクションオブジェクトの取得
			Connection c = DriverManager.getConnection(
					"jdbc:mysql://"
							+ servername
							+ "/"
							+ dbname,
					user,
					pass);

			/* Statementの作成 */
			stmt = c.prepareStatement(
					"select "
							+ "   kaiinNo"
							+ "  ,name"
							+ "  ,registDate"
							+ " from "
							+ "   kaiinn "
							+ "where "
							+ "  kaiinNo =? ");

			stmt.setInt(1, Integer.parseInt(kaiinnNostr));

			/* ｓｑｌ実行 */
			rset = stmt.executeQuery();

			String kaiinnName = null;
			LocalDate registDate = null;

			/* 取得したデータを表示します。 */
			while (rset.next()) {
				kaiinnName = rset.getString(2);
				registDate = rset.getDate(3).toLocalDate();
			}

			request.setAttribute("kaiinnNo", kaiinnNostr);
			request.setAttribute("kaiinnName", kaiinnName);
			request.setAttribute("registDate", registDate.toString());

			RequestDispatcher disp = request.getRequestDispatcher("/serch.jsp");
			disp.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			throw new ServletException(e);
		}
	}

}
