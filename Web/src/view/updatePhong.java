package view;

import java.io.IOException;
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
 * Servlet implementation class updatePhong
 */
@WebServlet("/updatePhong")
public class updatePhong extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatePhong() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action =request.getParameter("action");		
		if(action.equals("edit")) {
			String maphong =request.getParameter("maphong");	
			for(Phong p:new dsPhong().list) {		
				if(maphong.equals(p.getMaPhong())) {
					System.out.println(maphong);
					 request.setAttribute("dsPhong", new dsPhong().list);
					 request.setAttribute("phong", p);
					 request.setAttribute("name", "Sửa");
					 request.setAttribute("maphong",p.getMaPhong());
			            RequestDispatcher dispatcher = request.getRequestDispatcher("/dsPhong.jsp");
		                dispatcher.forward(request, response); 
				}
			}
		}else if(action.equals("editNV")) {
			String maphong =request.getParameter("manv");	
			for(NhanVien p:new dsNhanVien().list) {		
				if(maphong.equals(p.getMaNV())) {					
					 request.setAttribute("dsNhanVien", new dsNhanVien().list);
					 request.setAttribute("nv", p);
					 request.setAttribute("manv", p.getMaNV());
					 request.setAttribute("name", "Sửa");
			            RequestDispatcher dispatcher = request.getRequestDispatcher("/dsNhanVien.jsp");
		                dispatcher.forward(request, response); 
				}
			}
		}
		else if(action.equals("editKH")) {
			String maphong =request.getParameter("makh");	
			for(NhanVien p:new dsKhachHang().list) {		
				if(maphong.equals(p.getMaNV())) {					
					 request.setAttribute("dsKhachHang", new dsKhachHang().list);
					 request.setAttribute("nv", p);
					 request.setAttribute("name", "Sửa");
					 request.setAttribute("mak",p.getMaNV());
					 request.setAttribute("disabled", "disabled");
			            RequestDispatcher dispatcher = request.getRequestDispatcher("/dsKhachHang.jsp");
		                dispatcher.forward(request, response); 
				}
			}
		}else if(action.equals("editDV")) {
			String maphong =request.getParameter("madv");	
			for(DichVu p:new dsDichVu().list) {		
				if(maphong.equals(p.getMaDV())) {				
					 request.setAttribute("dsDichVu", new dsDichVu().list);
					 List<NhanVien> list_=new ArrayList<>();
					 NhanVien nv = new NhanVien();
					 nv.setMaNV(p.getMaNV());
					 nv.setHoTenNV(p.getTenNV());
					 list_.add(nv);
					 list_.addAll(new dsNhanVien().list);
					
					 request.setAttribute("dsNhanVien", list_ );
					 request.setAttribute("dv", p);
					 request.setAttribute("madv", p.getMaDV());
					 request.setAttribute("ma", p.getMaNV()+" - "+p.getTenNV());
					 request.setAttribute("name", "Sửa");
					
			            RequestDispatcher dispatcher = request.getRequestDispatcher("/dsDichVu.jsp");
		                dispatcher.forward(request, response); 
				}
			}
		}
		else if(action.equals("editTP")) {
			String den=null,di=null;
			String maphong =request.getParameter("matp");	
			for(ThuePhong p:new dsThuePhong().list) {		
				if(maphong.equals(p.getMaTP())) {				
					 request.setAttribute("dsThuePhong", new dsThuePhong().list);
					 den = p.getNgayDen();
		            	di = p.getNgayDi();
					 List<NhanVien> list_=new ArrayList<>();
					 NhanVien nv = new NhanVien();
					 nv.setMaNV(p.getMaKH());
					 nv.setHoTenNV(p.getTenKH());
					 list_.add(nv);
					 list_.addAll(new dsKhachHang().list);
					 
					 List<Phong> listP=new ArrayList<>();
					 Phong ph=new Phong();
					 ph.setMaPhong(p.getMaPhong());
					 ph.setLoaiPhong(p.getLoaiPhong());
					 listP.add(ph);
					 listP.addAll(new dsPhong().list);
					 
					 request.setAttribute("dsKhachHang", list_ );					
					 request.setAttribute("dsPhong", listP );
					 request.setAttribute("tp", p);
					 request.setAttribute("date", new Date());
					   request.setAttribute("den", den);
			            request.setAttribute("di", di);
			            request.setAttribute("matp", p.getMaTP());
					 request.setAttribute("kh", p.getMaKH()+" - "+p.getTenKH());
					 request.setAttribute("ph", p.getMaPhong()+" - "+p.getLoaiPhong());
					 request.setAttribute("name", "Sửa");
					
			            RequestDispatcher dispatcher = request.getRequestDispatcher("/dsThuePhong.jsp");
		                dispatcher.forward(request, response); 
				}
			}
		}
		else if(action.equals("editHD")) {
			
			String ma;
			String maphong =request.getParameter("mahd");	
			for(HoaDon p:new dsHoaDon().list) {		
				if(maphong.equals(p.getMaHD())) {	
					ma = p.getMaHD();
					 request.setAttribute("dsHoaDon", new dsHoaDon().list);			
					 List<NhanVien> listNV=new ArrayList<>();
					 NhanVien nv = new NhanVien();
					 nv.setMaNV(p.getMaNV());
					 nv.setHoTenNV(p.getHoTenNV());
					 listNV.add(nv);
					 listNV.addAll(new dsNhanVien().list);
					 
					 List<NhanVien> listKH=new ArrayList<>();
					 NhanVien kh = new NhanVien();
					 kh.setMaNV(p.getMaKH());
					 kh.setHoTenNV(p.getTenKH());
					 listKH.add(kh);
					 listKH.addAll(new dsKhachHang().list);
					 
					 request.setAttribute("dsKhachHang", listKH );					
					 request.setAttribute("dsNhanVien", listNV );
					 request.setAttribute("ma", ma);
				
					 request.setAttribute("tenkh", p.getMaKH()+" - "+p.getTenKH());
					 request.setAttribute("tennv", p.getMaNV()+" - "+p.getHoTenNV());
					
					 request.setAttribute("name", "Sửa");
					
			            RequestDispatcher dispatcher = request.getRequestDispatcher("/dsHoaDon.jsp");
		                dispatcher.forward(request, response); 
				}
			}
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
