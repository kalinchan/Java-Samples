package payarasql;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


@WebServlet("/PayaraSQL")
public class PayaraSQL extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Resource(name = "jdbc/postgresql")
	DataSource dataSource;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try(Connection connection = dataSource.getConnection()) {
	        DatabaseMetaData databaseMetaData = connection.getMetaData();
	        PrintWriter writer = resp.getWriter();
	        writer.append("DB info: ")
	              .append(databaseMetaData.getDatabaseProductName())
	              .append("\nCatalog name: ")
	              .append(connection.getCatalog());
	        try(ResultSet tables = databaseMetaData.getTables(connection.getCatalog(), null, null, new String[] { "TABLE" })) {
	            while(tables.next()) {
	                writer.append("\n" + tables.getString("TABLE_NAME"));
	            }
	        }
	    } catch(SQLException ex) {
	        resp.getWriter().append("Error " + ex.getMessage());
	        getServletContext().log("Error connecting to DB", ex);
	    }
	}
}
