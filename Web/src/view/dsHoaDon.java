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
 * Servlet implementation class dsHoaDon
 */
@WebServlet("/dsHoaDon")
public class dsHoaDon extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static List<HoaDon> list;
	private String mahd="";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dsHoaDon() {
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
	         String queryString = "select * from KHACHHANG kh left join HOADON hd on kh.MaKH = hd.MaKH inner join THUEPHONG tp on kh.MaKH = tp.MaKH where hd.MaKH is  null";
	         new dsKhachHang().list= new ArrayList<>();
	         ResultSet rs = statement.executeQuery(queryString);
	         NhanVien nv=  new NhanVien();
	        		 nv.setMaNV("0");
	        		 nv.setHoTenNV("Chọn khách hàng");
	     	new dsKhachHang().list.add(nv);
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
	         
			} catch (Exception ex) {
	            ex.printStackTrace();
	        }
		try {
			 Statement statement = new Connect().getConnect().createStatement();
	         String queryString = "select hd.*,kh.TenKH,nv.HoTenNV from HOADON hd inner join KHACHHANG kh on hd.MaKH = kh.MaKH inner join NHANVIEN nv on hd.MaNV = nv.MaNV";
	         list= new ArrayList<>();
	         ResultSet rs = statement.executeQuery(queryString);
	        
	            while(rs.next()) { 
	            	HoaDon p = new HoaDon();
	            	p.setMaHD(rs.getString(1));
	            	p.setMaKH(rs.getString(2));
	            	p.setNgayLapHD(rs.getString(3));
	            	p.setMaNV(rs.getString(4));
	            	p.setTenKH(rs.getString(5));
	            	p.setHoTenNV(rs.getString(6));
	            	mahd = rs.getString(1);
	            
	            	list.add(p);
	                // Forward sang /WEB-INF/views/productListView.jsp	                  
	            	
	         }
	            if(mahd.equals("")){
	        	 mahd ="HD-0";
	         }
	            String[] hd =mahd.split("-");	       
	            request.setAttribute("dsHoaDon", list);
	            request.setAttribute("dsNhanVien", new dsNhanVien().list);
	            request.setAttribute("dsKhachHang", new dsKhachHang().list);
	            request.setAttribute("name", "Thêm");
	            request.setAttribute("ma", hd[0]+"-"+(Integer.parseInt(hd[1])+1));
	            RequestDispatcher dispatcher = request.getRequestDispatcher("/dsHoaDon.jsp");
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
