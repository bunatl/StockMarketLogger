package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stockMarketLogger.Stock;

/**
 * Servlet implementation class index
 */
@WebServlet("/index")
public class index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public index() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost( request, response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);

		String url = "/index.jsp";
		Stock apple = new Stock("AAPL");
		updateDB( apple );
		request.setAttribute("stock", apple);
		getServletContext()
		.getRequestDispatcher( url )
		.forward(request, response);
	}
	
	protected void updateDB( Stock x ) {
		Connection con;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection( 
					constants.Database.DATABASE_URL,
					constants.Database.DATABASE_USER,
					constants.Database.DATABASE_PASSWORD );
					
			Statement s = con.createStatement();
			String query = "INSERT INTO stockHistory" + 
			"( id, name, price, priceTime  )" + 
			"VALUE ( NULL, '" + x.getStockName() + "', '" + x.getStockPrice() + "', now())";
			
			s.executeUpdate( query );
		} catch ( ClassNotFoundException e ) {
			e.printStackTrace();
		} catch ( SQLException e ) {
			e.printStackTrace();
		}
	}
}
