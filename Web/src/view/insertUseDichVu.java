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
@WebServlet("/insertUseDichVu")
public class insertUseDichVu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertUseDichVu() {
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
		String madv = request.getParameter("madv");
		String makh = request.getParameter("makh");

		String soluong = request.getParameter("soluong");
		String[] dv = madv.replaceAll(" ","").split("-");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		String day= sdf.format(new Date());
	   
		try {
			 Statement statement = new Connect().getConnect().createStatement();
	         String queryString = "select * from USE_DICHVU where MaDV= '"+dv+"' and MaKH ='"+makh+"'";	     
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
	        			 String insert = "INSERT INTO USE_DICHVU (MaKH, MaDV, SoLuong,NgayGio) VALUES (?, ?, ?,?)";
	        		        PreparedStatement ps = new Connect().getConnect().prepareStatement(insert);
	        		        ps.setString(1,makh);	
	        		        ps.setString(2,dv[0]);	 
		       				ps.setString(3,soluong);	    
		       				ps.setString(4,day);	       				        		  	     
	        		        ps.executeUpdate();
	        		        ps.close();
	        		        new Connect().getConnect().commit();	
	        		        RequestDispatcher dispatcher = request.getRequestDispatcher("dsUseDichVu");
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
