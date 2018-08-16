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
@WebServlet("/insertNV")
public class insertNV extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertNV() {
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
		String manv = request.getParameter("manv");
		String tennv = request.getParameter("tennv");
		String ns = request.getParameter("ns");
		String gt = request.getParameter("gt");
		String scmt = request.getParameter("scmt");
		String dc = request.getParameter("dc");
		String sdt = request.getParameter("sdt");
		String cv = request.getParameter("cv");
	
	     System.out.println(tennv);
		try {
			 Statement statement = new Connect().getConnect().createStatement();
	         String queryString = "select * from NHANVIEN where MaNV= '"+manv+"'";	     
	         ResultSet rs = statement.executeQuery(queryString);		    		      
	            if(rs.next()) {           	           
	       		 String update = "update NHANVIEN set HoTenNV= ?, NgaySinh= ?, GioiTinh= ?, SoCMT= ?, DiaChi=  ?,SoDT= ?, ChucVu= ?  where MaNV= ?";
	       	        PreparedStatement ps;
	       			try {
	       				ps = new Connect().getConnect().prepareStatement(update);
	       				   ps.setString(1,tennv);	 
	       				   ps.setString(2,ns);	    
	       				   ps.setString(3,gt);	   
	       				  ps.setString(4,scmt);	  
	       				  ps.setString(5,dc);	  
	       				  ps.setString(6,sdt);	  
	       				  ps.setString(7,cv);	  
	       				  ps.setString(8,manv);	  
	       			        ps.executeUpdate();
	       			            			      	       		       
	       			} catch (SQLException e) {
	       				// TODO Auto-generated catch block
	       				e.printStackTrace();
	       			}
	       			 response.sendRedirect("dsNhanVien");	
	                // Forward sang /WEB-INF/views/productListView.jsp	                  
	            }	else {
	            	try {
	        			//Statement statement = new Connect().getConnect().createStatement();
//	        			String query="insert into Phong values('"+maphong+"',N'"+loaiphong+"','"+giaphong+"')";
//	        			 statement.executeQuery(query);	
	        			 String insert = "INSERT INTO NHANVIEN (MaNV, HoTenNV, NgaySinh,GioiTinh,SoCMT,DiaChi,SoDT,ChucVu) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	        		        PreparedStatement ps = new Connect().getConnect().prepareStatement(insert);
	        		        ps.setString(1,manv);	
	        		        ps.setString(2,tennv);	 
		       				ps.setString(3,ns);	    
		       				ps.setString(4,gt);	   
		       				ps.setString(5,scmt);	  
		       				ps.setString(6,dc);	  
		       				ps.setString(7,sdt);	  
		       				ps.setString(8,cv);	  
		       				  	     
	        		        ps.executeUpdate();
	        		        ps.close();
	        		        new Connect().getConnect().commit();	
	        		        String message = "hello";
	        		        request.setAttribute("message", message);
	        		        RequestDispatcher dispatcher = request.getRequestDispatcher("dsNhanVien");
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
