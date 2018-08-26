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
@WebServlet("/dsPhong")
public class dsPhong extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static List<Phong> list;
	private String ma="";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dsPhong() {
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
	         String queryString = "select * from PHONG";
	         list= new ArrayList<>();
	         ResultSet rs = statement.executeQuery(queryString);		    		      
	            while(rs.next()) {           
	      	               Phong p = new Phong();
	            	p.setMaPhong(rs.getString(1));
	            	p.setLoaiPhong(rs.getString(2));
	            	p.setGiaPhong(rs.getString(3));
	            	ma=rs.getString(1);
	            	list.add(p);
	                // Forward sang /WEB-INF/views/productListView.jsp	                  
	            }	
	            if(ma.equals("")) {
	            	ma="PH0";
	            }
	          
	            String[] maphong = ma.split("PH");
	            request.setAttribute("dsPhong", list);
	            request.setAttribute("name", "Thêm");
	            request.setAttribute("maphong","PH"+(Integer.parseInt(maphong[1])+1));
	            RequestDispatcher dispatcher = request.getRequestDispatcher("/dsPhong.jsp");
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
