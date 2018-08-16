package view;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class deletePhong
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		String action = request.getParameter("action");
		//xoa phong
		if(action.equals("editP")) {
		String maphong = request.getParameter("maphong");
		 String delete = "delete from PHONG where MaPhong= ?";
	        PreparedStatement ps;
			try {
				ps = new Connect().getConnect().prepareStatement(delete);
				   ps.setString(1,maphong);	    	     
			        ps.executeUpdate();
			        ps.close();
			        new Connect().getConnect().commit();
			        System.out.println("Storing Student Object is Done!");
			       
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 response.sendRedirect("dsPhong");	
		}else if(action.equals("editNV")) {
			String maphong = request.getParameter("manv");
			 String delete = "delete from NHANVIEN where MaNV= ?";
		        PreparedStatement ps;
				try {
					ps = new Connect().getConnect().prepareStatement(delete);
					   ps.setString(1,maphong);	    	     
				        ps.executeUpdate();
				        ps.close();
				        new Connect().getConnect().commit();
				       
				       
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 response.sendRedirect("dsNhanVien");	
		}else if(action.equals("editKH")) {
			String makh = request.getParameter("makh");
			 String delete = "delete from KHACHHANG where MaKH= ?";
		        PreparedStatement ps;
				try {
					ps = new Connect().getConnect().prepareStatement(delete);
					   ps.setString(1,makh);	    	     
				        ps.executeUpdate();
				        ps.close();
				        new Connect().getConnect().commit();
				       
				       
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 response.sendRedirect("dsKhachHang");	
		}else if(action.equals("editDV")) {
			String makh = request.getParameter("madv");
			 String delete = "delete from DICHVU where MaDV= ?";
		        PreparedStatement ps;
				try {
					ps = new Connect().getConnect().prepareStatement(delete);
					   ps.setString(1,makh);	    	     
				        ps.executeUpdate();
				        ps.close();
				        new Connect().getConnect().commit();
				       
				       
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 response.sendRedirect("dsDichVu");	
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
