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
@WebServlet("/insertThuePhong")
public class insertThuePhong extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertThuePhong() {
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
		String matp = request.getParameter("matp");
		String maphong = request.getParameter("maphong");
		String makh = request.getParameter("makh");
		String ngayden = request.getParameter("ngayden");
		String ngaydi = request.getParameter("ngaydi");
		String[] phong = maphong.replaceAll(" ","").split("-");
		String[] kh = makh.replaceAll(" ","").split("-");
		System.out.println(phong[0]+"-"+kh[0]);
	   
		try {
			 Statement statement = new Connect().getConnect().createStatement();
	         String queryString = "select * from THUEPHONG where MaTP= '"+matp+"'";	     
	         ResultSet rs = statement.executeQuery(queryString);		    		      
	            if(rs.next()) {           	           
//	       		 String update = "update DICHVU set TenDV= ?, GiaDV= ?, MaNV= ?, DVT= ?  where MaDV= ?";
//	       	        PreparedStatement ps;
//	       			try {
//	       				ps = new Connect().getConnect().prepareStatement(update);
//	       				ps.setString(1,tendv);	
//	     		        ps.setString(2,giadv);	 
//	       				ps.setString(3,manv[0]);	    
//	       				ps.setString(4,dvt);	   
//	       				ps.setString(5,madv);	  	  
//	       			    ps.executeUpdate();
//	       			            			      	       		       
//	       			} catch (SQLException e) {
//	       				// TODO Auto-generated catch block
//	       				e.printStackTrace();
//	       			}
//	       			 response.sendRedirect("dsDichVu");	
	                // Forward sang /WEB-INF/views/productListView.jsp	                  
	            }	else {
	            	try {
	            			
	        			 String insert = "INSERT INTO THUEPHONG (MaTP, MaKH,MaPhong,NgayDen,NgayDi) VALUES (?, ?, ?, ?, ?)";
	        		        PreparedStatement ps = new Connect().getConnect().prepareStatement(insert);
	        		        ps.setString(1,matp);	
	        		        ps.setString(2,kh[0]);	 
		       				ps.setString(3,phong[0]);	    
		       				ps.setString(4,ngayden);	   
		       				ps.setString(5,ngaydi);	  		       				  
      			  	     
	        		        ps.executeUpdate();
	        		        ps.close();
	        		        new Connect().getConnect().commit();	
	        		        RequestDispatcher dispatcher = request.getRequestDispatcher("dsThuePhong");
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
