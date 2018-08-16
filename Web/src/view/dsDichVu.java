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
@WebServlet("/dsDichVu")
public class dsDichVu extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static List<DichVu> list;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dsDichVu() {
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
	         String queryString = "select * from NHANVIEN";
	         new dsNhanVien().list= new ArrayList<>();
	         ResultSet rs = statement.executeQuery(queryString);
	         NhanVien nv=  new NhanVien();
	        		 nv.setMaNV("0");
	        		 nv.setHoTenNV("Chọn nhân viên");
	     	new dsNhanVien().list.add(nv);
	            while(rs.next()) {           
	            	NhanVien p = new NhanVien();
	            	p.setMaNV(rs.getString(1));
	            	p.setHoTenNV(rs.getString(2));
	            	p.setNgaySinh(rs.getString(3));	     
	            	p.setGioiTinh(rs.getString(4));	
	            	p.setSoCMT(rs.getString(5));	
	            	p.setDiaChi(rs.getString(6));	
	            	p.setSoDT(rs.getString(7));	
	            	p.setChucVu(rs.getString(8));	
	            	System.out.println(rs.getString(4));
	            	new dsNhanVien().list.add(p);
	                // Forward sang /WEB-INF/views/productListView.jsp	                  
	            }		            	          
	         
			} catch (Exception ex) {
	            ex.printStackTrace();
	        }
		try {
			 Statement statement = new Connect().getConnect().createStatement();
	         String queryString = "select a.*,b.HoTenNV from DICHVU a inner join NHANVIEN b on a.MaNV = b.MaNV";
	         list= new ArrayList<>();
	         ResultSet rs = statement.executeQuery(queryString);		    		      
	            while(rs.next()) { 
	            	DichVu p = new DichVu();
	            	p.setMaDV(rs.getString(1));
	            	p.setTenDV(rs.getString(2));
	            	p.setGiaDV(rs.getString(3));
	            	p.setMaNV(rs.getString(4));
	            	p.setDVT(rs.getString(5));
	            	p.setTenNV(rs.getString(6));
	            
	            	list.add(p);
	                // Forward sang /WEB-INF/views/productListView.jsp	                  
	            }		            
	            request.setAttribute("dsDichVu", list);
	            request.setAttribute("dsNhanVien", new dsNhanVien().list);
	            request.setAttribute("name", "Thêm");
	            RequestDispatcher dispatcher = request.getRequestDispatcher("/dsDichVu.jsp");
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
