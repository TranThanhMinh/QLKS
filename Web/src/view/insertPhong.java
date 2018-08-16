package view;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class insertPhong
 */
@WebServlet("/insertPhong")
public class insertPhong extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertPhong() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		String maphong = request.getParameter("maphong");
		String loaiphong = request.getParameter("loaiphong");
		String giaphong = request.getParameter("giaphong");
		
		
		try {
			 Statement statement = new Connect().getConnect().createStatement();
	         String queryString = "select * from PHONG where MaPhong= '"+maphong+"'";	     
	         ResultSet rs = statement.executeQuery(queryString);		    		      
	            if(rs.next()) {           	           
	       		 String update = "Update PHONG set LoaiPhong= ?,GiaPhong= ?  where MaPhong= ?";
	       	        PreparedStatement ps;
	       			try {
	       				ps = new Connect().getConnect().prepareStatement(update);
	       				   ps.setString(1,loaiphong);	 
	       				   ps.setString(2,giaphong);	    
	       				   ps.setString(3,maphong);	    
	       			        ps.executeUpdate();
	       			            			      	       		       
	       			} catch (SQLException e) {
	       				// TODO Auto-generated catch block
	       				e.printStackTrace();
	       			}
	       			 response.sendRedirect("dsPhong");	
	                // Forward sang /WEB-INF/views/productListView.jsp	                  
	            }	else {
	            	try {
	        			//Statement statement = new Connect().getConnect().createStatement();
//	        			String query="insert into Phong values('"+maphong+"',N'"+loaiphong+"','"+giaphong+"')";
//	        			 statement.executeQuery(query);	
	        			 String insert = "INSERT INTO PHONG (MaPhong, LoaiPhong, GiaPhong) VALUES (?, ?, ?)";
	        		        PreparedStatement ps = new Connect().getConnect().prepareStatement(insert);
	        		        ps.setString(1,maphong);
	        		        ps.setString(2, loaiphong);
	        		        ps.setString(3, giaphong);		     
	        		        ps.executeUpdate();
	        		        ps.close();
	        		        new Connect().getConnect().commit();	
	        		        String message = "hello";
	        		        request.setAttribute("message", message);
	        		        RequestDispatcher dispatcher = request.getRequestDispatcher("dsPhong");
	                        dispatcher.forward(request, response);  
	        					
	        		} catch (SQLException e) {
	        			// TODO Auto-generated catch block
	        			e.printStackTrace();
	        		}
	            }
	         
	            
			} catch (Exception ex) {
	            ex.printStackTrace();
	        }
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
