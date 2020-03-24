package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stockMarketLogger.History;

/**
 * Servlet implementation class history
 */
@WebServlet("/history")
public class history extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public history() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost( request, response );
//		System.out.println( "running" );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String url = "/history.jsp";
		ResultSet resultSet = selectAllFromDB();
		// custom class transforms resultSet into a Set - lines of records
		History h = new History( resultSet );

		request.setAttribute("allStocks", h.getRows() );
		getServletContext()
		.getRequestDispatcher( url )
		.forward(request, response);
	}
	
	// query into DB
	protected ResultSet selectAllFromDB() {
		Connection con;
		ResultSet res = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection( 
					constants.Database.DATABASE_URL,
					constants.Database.DATABASE_USER,
					constants.Database.DATABASE_PASSWORD );
					
			Statement s = con.createStatement();
			String query = "SELECT *" + 
							"FROM stockhistory";
			
			res = s.executeQuery( query );
		} catch ( ClassNotFoundException e ) {
			e.printStackTrace();
		} catch ( SQLException e ) {
			e.printStackTrace();
		}
		return res;
	}	
}
