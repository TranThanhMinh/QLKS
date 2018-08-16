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
@WebServlet("/insertKH")
public class insertKH extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertKH() {
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
		String makh = request.getParameter("makh");
		String tenkh = request.getParameter("tenkh");
		String ns = request.getParameter("ns");
		String gt = request.getParameter("gt");
		String scmt = request.getParameter("scmt");
		String sdt = request.getParameter("sdt");

		try {
			 Statement statement = new Connect().getConnect().createStatement();
	         String queryString = "select * from KHACHHANG where MaKH= '"+makh+"'";	     
	         ResultSet rs = statement.executeQuery(queryString);		    		      
	            if(rs.next()) {           	           
	       		 String update = "update KHACHHANG set TenKH= ?, NgaySinh= ?, GioiTinh= ?, SoCMT= ?,SoDT= ? where MaKH= ?";
	       	        PreparedStatement ps;
	       			try {
	       				ps = new Connect().getConnect().prepareStatement(update);
	       				   ps.setString(1,tenkh);	 
	       				   ps.setString(2,ns);	    
	       				   ps.setString(3,gt);	   
	       				  ps.setString(4,scmt);	  	  
	       				  ps.setString(5,sdt);	  	 
	       				  ps.setString(6,makh);	  
	       			        ps.executeUpdate();
	       			            			      	       		       
	       			} catch (SQLException e) {
	       				// TODO Auto-generated catch block
	       				e.printStackTrace();
	       			}
	       			 response.sendRedirect("dsKhachHang");	
	                // Forward sang /WEB-INF/views/productListView.jsp	                  
	            }	else {
	            	try {
	        			//Statement statement = new Connect().getConnect().createStatement();
//	        			String query="insert into Phong values('"+maphong+"',N'"+loaiphong+"','"+giaphong+"')";
//	        			 statement.executeQuery(query);	
	        			 String insert = "INSERT INTO KHACHHANG (MaKH, TenKH, NgaySinh,GioiTinh,SoCMT,SoDT) VALUES (?, ?, ?, ?, ?, ?)";
	        		        PreparedStatement ps = new Connect().getConnect().prepareStatement(insert);
	        		        ps.setString(1,makh);	
	        		        ps.setString(2,tenkh);	 
		       				ps.setString(3,ns);	    
		       				ps.setString(4,gt);	   
		       				ps.setString(5,scmt);	  
		       				ps.setString(6,sdt);		       				  	     
	        		        ps.executeUpdate();
	        		        ps.close();
	        		        new Connect().getConnect().commit();	
	        		        RequestDispatcher dispatcher = request.getRequestDispatcher("dsKhachHang");
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
