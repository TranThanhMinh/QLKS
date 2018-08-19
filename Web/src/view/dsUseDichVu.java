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
@WebServlet("/dsUseDichVu")
public class dsUseDichVu extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String tenkh,makh;
	public static List<UseDichVu> list;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dsUseDichVu() {
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
	         String queryString = "select * from DICHVU";
	         new dsDichVu().list= new ArrayList<>();
	         DichVu dv = new DichVu();
	         dv.setMaDV("0");
	         dv.setTenDV("Chọn dịch vụ");
	         new dsDichVu().list.add(dv);
	         ResultSet rs = statement.executeQuery(queryString);		    		      
	            while(rs.next()) { 
	            	DichVu p = new DichVu();
	            	p.setMaDV(rs.getString(1));
	            	p.setTenDV(rs.getString(2));
	            	p.setGiaDV(rs.getString(3));
	            	            
	            	 new dsDichVu().list.add(p);
	                // Forward sang /WEB-INF/views/productListView.jsp	                  
	            }		            
	          
	           
	            
			} catch (Exception ex) {
	            ex.printStackTrace();
	        }
		try {
			String makh = request.getParameter("makh");
			tenkh = request.getParameter("tenkh");
			 Statement statement = new Connect().getConnect().createStatement();
	         String queryString = "select u.*,k.TenKH,d.TenDV,d.GiaDV from USE_DICHVU u inner join KHACHHANG k on u.MaKH = k.MaKH " + 
	         		"inner join DICHVU d on u.MaDV = d.MaDV where u.MaKH='"+makh+"'";
	         list= new ArrayList<>();
	         ResultSet rs = statement.executeQuery(queryString);
	         int money =0;
	            while(rs.next()) {           
	            	UseDichVu p = new UseDichVu();
	            	p.setMaKH(rs.getString(1));
	            	p.setMaDV(rs.getString(2));
	            	p.setSoLuong(rs.getInt(3));	   
	            	p.setNgayGio(rs.getString(4));	   
	            	p.setTenKH(rs.getString(5));	
	            	p.setTenDV(rs.getString(6));	
	            	p.setGiaDV(rs.getInt(7));	
	            	money = rs.getInt(3)* rs.getInt(7) + money;
	            	list.add(p);
	                // Forward sang /WEB-INF/views/productListView.jsp	                  
	            }		            
	            request.setAttribute("dsUseDichVu", list);
	            request.setAttribute("name", "Thêm");
	            request.setAttribute("tenkh", tenkh);
	            request.setAttribute("makh", makh);
	            request.setAttribute("money", money);
	            request.setAttribute("dsDichVu", new dsDichVu().list);
	            RequestDispatcher dispatcher = request.getRequestDispatcher("/dsUseDichVu.jsp");
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
