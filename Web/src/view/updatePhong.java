package view;

import java.io.IOException;
import java.util.ArrayList;
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
					 request.setAttribute("disabled", "disabled");
			            RequestDispatcher dispatcher = request.getRequestDispatcher("/dsKhachHang.jsp");
		                dispatcher.forward(request, response); 
				}
			}
		}else if(action.equals("editDV")) {
			String maphong =request.getParameter("madv");	
			for(DichVu p:new dsDichVu().list) {		
				if(maphong.equals(p.getMaDV())) {	
					new dsNhanVien().list.remove(p);
					 request.setAttribute("dsDichVu", new dsDichVu().list);
					 List<NhanVien> list_=new ArrayList<>();
					 NhanVien nv = new NhanVien();
					 nv.setMaNV(p.getMaNV());
					 nv.setHoTenNV(p.getTenNV());
					 list_.add(nv);
					 list_.addAll(new dsNhanVien().list);
					
					 request.setAttribute("dsNhanVien", list_ );
					 request.setAttribute("dv", p);
					 request.setAttribute("ma", p.getMaNV()+" - "+p.getTenNV());
					 request.setAttribute("name", "Sửa");
					
			            RequestDispatcher dispatcher = request.getRequestDispatcher("/dsDichVu.jsp");
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
