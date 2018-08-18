package view;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
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
 * Servlet implementation class dsThuePhong
 */
@WebServlet("/dsThuePhong")
public class dsThuePhong extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static List<ThuePhong> list;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dsThuePhong() {
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
			    String queryString = "select k.* from KHACHHANG K left join THUEPHONG T on K.MaKH = T.MaKH where T.MaKH is null";
			    new dsKhachHang().list= new ArrayList<>();
			    NhanVien nv = new NhanVien();
            	nv.setMaNV("0");
            	nv.setHoTenNV("Chọn khách hàng");
            	 new dsKhachHang().list.add(nv);
		         ResultSet rs = statement.executeQuery(queryString);		    		      
		            while(rs.next()) {           
		            	NhanVien p = new NhanVien();
		            	p.setMaNV(rs.getString(1));
		            	p.setHoTenNV(rs.getString(2));
		            	p.setNgaySinh(rs.getString(3));	     
		            	p.setGioiTinh(rs.getString(4));	
		            	p.setSoCMT(rs.getString(5));		            
		            	p.setSoDT(rs.getString(6));		            
		            	
		            	new dsKhachHang().list.add(p);
		                // Forward sang /WEB-INF/views/productListView.jsp	                  
		            }	
	            String queryString1 = "select P.*from PHONG P left join THUEPHONG T on P.MaPhong = T.MaPhong where T.MaPhong is null";
		         new dsPhong().list= new ArrayList<>();
		         Phong ph=  new Phong();
        		 ph.setMaPhong("0");
        		 ph.setLoaiPhong("Chọn phòng");
        		 new dsPhong().list.add(ph);
		         ResultSet rs1 = statement.executeQuery(queryString1);		    		      
		            while(rs1.next()) {           
		      	         Phong p = new Phong();
		            	p.setMaPhong(rs1.getString(1));
		            	p.setLoaiPhong(rs1.getString(2));
		            	p.setGiaPhong(rs1.getString(3));		           
		            	 new dsPhong().list.add(p);
		                // Forward sang /WEB-INF/views/productListView.jsp	                  
		            }	
	         
			} catch (Exception ex) {
	            ex.printStackTrace();
	        }
		
		try {
			 Statement statement = new Connect().getConnect().createStatement();
	         String queryString = "select a.*, c.TenKH,c.SoCMT,b.LoaiPhong from THUEPHONG a inner join PHONG b  on a.MaPhong = b.MaPhong " + 
	         		"inner join KHACHHANG c   on a.MaKH = c.MaKH";
	         list= new ArrayList<>();
	        ResultSet rs = statement.executeQuery(queryString);		       
     		DateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
     		DateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
     		Date date = null;
	            while(rs.next()) { 
	            	ThuePhong p = new ThuePhong();
	            	p.setMaTP(rs.getString(1));
	            	p.setMaKH(rs.getString(2));
	            	p.setMaPhong(rs.getString(3));	            
	            	date =sdf1.parse(rs.getString(4));
	            	String den = sdf2.format(date);
	            	date =sdf1.parse(rs.getString(5));
	            	String di = sdf2.format(date);	
	            	p.setNgayDen(den);
	            	p.setNgayDi(di);
	            	p.setTenKH(rs.getString(6));
	            	p.setSoCMT(rs.getString(7));
	            	p.setLoaiPhong(rs.getString(8));
	            	
	            	list.add(p);
	                // Forward sang /WEB-INF/views/productListView.jsp	                  
	            }		            
	            request.setAttribute("dsThuePhong", list);
	            request.setAttribute("dsKhachHang", new dsKhachHang().list);
	            request.setAttribute("dsPhong", new dsPhong().list);
	            request.setAttribute("name", "Thêm");
	            RequestDispatcher dispatcher = request.getRequestDispatcher("/dsThuePhong.jsp");
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
