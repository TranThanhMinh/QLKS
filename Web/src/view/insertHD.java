package view;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
@WebServlet("/insertHD")
public class insertHD extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertHD() {
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
		String mahd = request.getParameter("mahd");
		String tennv = request.getParameter("tennv");
		String[] manv = tennv.replace(" ","").split("-");
		String tenkh = request.getParameter("tenkh");
		String[] makh = tenkh.replace(" ","").split("-");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(new Date());
	

		try {
			 Statement statement = new Connect().getConnect().createStatement();
	         String queryString = "select * from HOADON where MaHD= '"+mahd+"'";	     
	         ResultSet rs = statement.executeQuery(queryString);		    		      
	            if(rs.next()) {           	           
	       		 String update = "update HOADON set MaKH= ?, MaNV= ? where MaHD= ?";
	       	        PreparedStatement ps;
	       			try {
	       				ps = new Connect().getConnect().prepareStatement(update);	       
	       				ps.setString(1,makh[0]);	 	        
	       				ps.setString(2,manv[0]);  
	       				ps.setString(3,mahd);	
	       			        ps.executeUpdate();
	       			            			      	       		       
	       			} catch (SQLException e) {
	       				// TODO Auto-generated catch block
	       				e.printStackTrace();
	       			}
	       			 response.sendRedirect("dsHoaDon");	
	                // Forward sang /WEB-INF/views/productListView.jsp	                  
	            }	else {
	            	try {
	        			//Statement statement = new Connect().getConnect().createStatement();
//	        			String query="insert into Phong values('"+maphong+"',N'"+loaiphong+"','"+giaphong+"')";
//	        			 statement.executeQuery(query);	
	        			 String insert = "INSERT INTO HOADON (MaHD, MaKH, NgayLapHD,MaNV) VALUES (?, ?, ?, ?)";
	        		        PreparedStatement ps = new Connect().getConnect().prepareStatement(insert);
	        		        ps.setString(1,mahd);	
	        		        ps.setString(2,makh[0]);	 
		       				ps.setString(3,date);	    
		       				ps.setString(4,manv[0]);	 				  	     
	        		        ps.executeUpdate();
	        		        ps.close();
	        		        new Connect().getConnect().commit();	
	        		        RequestDispatcher dispatcher = request.getRequestDispatcher("dsHoaDon");
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
