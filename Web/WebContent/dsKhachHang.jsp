<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
 <head>
 <link rel="stylesheet" type="text/css" href="css/menu.css">
 <link rel="stylesheet" type="text/css" href="css/text.css">
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.1/jquery.validate.min.js"></script>

    <title>Danh sách khách hàng</title>
    <style> 
</style>
 </head>
 <body>
 
 
    <div class="row">
    <div class="col-sm-2 bac">
			    <div class="nav-side-menu">
			    <div class="brand">Quản lý khách sạn</div>
			    <i class="fa fa-bars fa-2x toggle-btn" data-toggle="collapse" data-target="#menu-content"></i>
			  
			        <div class="menu-list">
			  
			            <ul id="menu-content" class="menu-content collapse out">
			                <li>
			                  <a href="dsNhanVien">
			                  <i class="fa fa-dashboard fa-lg"></i> Nhân viên
			                  </a>
			                </li>
			
			                <li >
			                  <a href="dsPhong"><i class="fa fa-gift fa-lg"></i> Phòng </a>
			                </li>
			               
			
			
			                <li>
			                  <a href="dsKhachHang"><i class="fa fa-globe fa-lg"></i> Khách hàng </a>
			                </li>  
			             
			
			
			                <li>
			                  <a href="dsDichVu"><i class="fa fa-car fa-lg"></i> Dịch vụ </a>
			                </li>
			                
			                 <li>
			                  <a href="#"><i class="fa fa-car fa-lg"></i> Hóa đơn </a>
			                </li>
			                
			                 <li>
			                  <a href="#"><i class="fa fa-car fa-lg"></i> Thuê phòng </a>
			                </li>
			                  <li>
			                  <a href="login.jsp"><i class="fa fa-car fa-lg"></i> Đăng xuất </a>
			                </li>
			               
			            </ul>
			     </div>
			</div>
    </div>
    <div class="col-sm-10">
     <div>
     <h4>Danh sách khách hàng</h4></div>
   
     <div id="sizetext" class="myform">
	      <form action="insertKH" method="post" id="save">   
	      <div class="row" >
			  <div class="col-sm-3 col-xs-12">
			  <div class="form-group">
			   <label>Mã khách hàng:</label>
			     <input type ="text" name="makh" value='${nv.getMaNV()}'  ></input>
			  </div>
			   <div class="form-group">
				   <label>Họ và tên khách hàng:</label>
				  	<input type ="text"  name="tenkh" value='${nv.getHoTenNV()}'></input>
				</div>
				
		      
				 
			  </div>
			  <div class="col-sm-3 col-xs-12">
			   <div class="form-group">
				   <label>Ngày sinh:</label>
				   <input type ="text"  name="ns" value='${nv.getNgaySinh()}'></input>
		      	</div>
			  	<div class="form-group">
				   <label>Giới tính:</label>
				    	<input type ="text"   name="gt" value='${nv.getGioiTinh()}'></input>
		      	</div>
			  
	      		 
			 
			  </div>
			  <div class="col-sm-3 col-xs-12">
			   <div class="form-group">
			   	<label>Số chứng minh thư:</label>
					<input type ="number"  name="scmt" value='${nv.getSoCMT()}'></input>
		       </div>
				  <div class="form-group">
				  	 <label>Số điện thoại:</label>
				     <input type ="text"  name="sdt" value='${nv.getSoDT()}'></input>
	      		</div>
		
			  </div>
			   
			</div>	  
			<div>  <input id="click"  type ="submit"   value='${name}'></input></div>     
	      </form>    
      </div>
      <div></br>
       <input class="form-control" id="myInput" type="text" placeholder="Tìm theo mã, tên khách hàng....">
   		 <br>
		    <table class="table table-bordered" >
		       <tr>
		          <th>Mã nhân viên</th>
		          <th>Tên nhân viên</th>
		          <th>Ngày sinh</th>		       
		          <th>Số CMT</th>		        
		          <th>Số DT</th>		     	
		          <th>Sửa</th>
		          <th>Xóa</th>
		       </tr>
		       <c:forEach items="${dsKhachHang}" var="p" >
		        <tbody id="myTable">
		          <tr>
		             <td>${p.getMaNV()}</td>
		             <td>${p.getHoTenNV()}</td>
		             <td>${p.getNgaySinh()}</td>
		             <td>${p.getSoCMT()}</td>
		             <td>${p.getSoDT()}</td>
		             
		             <td>
		                <a class="fa fa-edit" href="updatePhong?action=editKH&makh=${p.getMaNV()}"></a>
		             </td>
		             <td>
		                <a class="fa fa-remove" href="Delete?action=editKH&makh=${p.getMaNV()}" "></a>
		             </td>
		          </tr>
		          </tbody>
		       </c:forEach>
		    </table>
    </div>
 
    </div>
    </div>
    
    
  

 <script>
 $(document).ready(function() {
	 
     //Khi bàn phím được nhấn và thả ra thì sẽ chạy phương thức này
     $("#save").validate({
         rules: {
             makh: "required",
             tenkh: "required",
             ns:"required",
             scmt:"required"
         },
         messages: {
        	 
        	 makh: "Vui lòng nhập mã nhân viên",
        	 tenkh: " Vui lòng nhập tên nhân viên",
             ns:  " Vui lòng nhập ngày sinh",
             scmt:  " Vui lòng nhập số CMT"
            
         }
     });
 });
 function DoSubmit(){
	  document.myform.myinput.value = 'Sửa';
	  document.getElementById("them").submit();
	}
 
$(document).ready(function(){
  $("#myInput").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#myTable tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });
});
</script>
 </body>
</html>