package view;

import java.io.IOException;
import java.sql.ResultSet;
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
 * Servlet implementation class dsPhong
 */
@WebServlet("/dsKhachHang")
public class dsKhachHang extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static List<NhanVien> list;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dsKhachHang() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
		try {
			 Statement statement = new Connect().getConnect().createStatement();
	         String queryString = "select * from KHACHHANG";
	         list= new ArrayList<>();
	         ResultSet rs = statement.executeQuery(queryString);		    		      
	            while(rs.next()) {           
	            	NhanVien p = new NhanVien();
	            	p.setMaNV(rs.getString(1));
	            	p.setHoTenNV(rs.getString(2));
	            	p.setNgaySinh(rs.getString(3));	     
	            	p.setGioiTinh(rs.getString(4));	
	            	p.setSoCMT(rs.getString(5));		            
	            	p.setSoDT(rs.getString(6));		            
	            	
	            	list.add(p);
	                // Forward sang /WEB-INF/views/productListView.jsp	                  
	            }		            
	            request.setAttribute("dsKhachHang", list);
	            request.setAttribute("name", "Thêm");
	            request.setAttribute("disabled", "true");
	            RequestDispatcher dispatcher = request.getRequestDispatcher("/dsKhachHang.jsp");
                dispatcher.forward(request, response);   
	            
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
