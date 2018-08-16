package view;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
 public static Connection conn ;
    String sqlInstanceName = "SQLEXPRESS";
    String database = "HOS_HNI";
    String userName = "sa";
    String password = "123456a@"; /**
     * @see HttpServlet#HttpServlet()
     */    
    public login() {
        super();
        conn = new Connect().getConnect();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		// TODO Auto-generated method stub
				String taikhoan = request.getParameter("Taikhoan");
				String matkhau = request.getParameter("Matkhau");
				//response.sendRedirect("Hello.jsp");
				  System.out.println(taikhoan +" "+matkhau);
		
				try {
				 Statement statement = conn.createStatement();
		         String queryString = "select * from USER_ where taikhoan='"+taikhoan+"' and matkhau='"+matkhau+"'";
		      
		         ResultSet rs = statement.executeQuery(queryString);		    		      
		            if(rs.next()) {           
		                response.sendRedirect("dsPhong");          
		            }
		            else {
		            	 response.sendRedirect("login.jsp");  
		            }	
		            
		            
				} catch (Exception ex) {
		            ex.printStackTrace();
		        }
				
		

	}



}
