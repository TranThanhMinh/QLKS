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

    <title>Danh sách Nhân Viên</title>
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
			                 <i class="fa fa-user" aria-hidden="true"></i> Nhân viên
			                  </a>
			                </li>
			
			                <li >
			                  <a href="dsPhong"><i class="fa fa-home" aria-hidden="true"></i> Phòng </a>
			                </li>
			               
			
			
			                <li>
			                   <a href="dsKhachHang"><i class="fa fa-user-plus" aria-hidden="true"></i> Khách hàng </a>
			                </li>  
			             
			
			
			                <li>
			                  <a href="dsDichVu"><i class="fa fa-id-card" aria-hidden="true"></i> Dịch vụ </a>
			                </li>
			                
			                 <li>
			                  <a href="#"><i class="fa fa-money" aria-hidden="true"></i></i> Hóa đơn </a>
			                </li>
			                
			                 <li>
			                  <a href="dsThuePhong"><i class="fa fa-bed" aria-hidden="true"></i> Thuê phòng </a>
			                </li>
			                 <li  data-toggle="collapse" data-target="#products" class="collapsed active">
			                  <a href="#"><i class="fa fa-pie-chart" aria-hidden="true"></i> Báo cáo<span class="arrow"></span></a>
			                </li>
			                	<ul class="sub-menu collapse" id="products">
				                    <li><a href="#">Dịch vụ</a></li>
				                    <li><a href="#">Thuê phòng</a></li>
				                  			                    
				                </ul>
				                
			                  <li>
			                  <a href="login.jsp"><i class="fa fa-sign-out" aria-hidden="true"></i> Đăng xuất</a>			       
			                </li>
			                     
			               
			            </ul>
			     </div>
			</div>
    </div>
    <div class="col-sm-10">
     <div>
     <h4>Danh sách Nhân viên</h4></div>
   
     <div id="sizetext" class="myform">
	      <form action="insertNV" method="post" id="save">   
	      <div class="row" >
			  <div class="col-sm-3 col-xs-12">
			  <div class="form-group">
			   <label>Mã nhân viên:</label>
			     <input type ="text"  class="form-control" name="manv" value='${nv.getMaNV()}' ></input>
			  </div>
			   <div class="form-group">
				   <label>Họ và tên nhân viên:</label>
				  	<input type ="text"   class="form-control" name="tennv" value='${nv.getHoTenNV()}'></input>
				</div>
				 <div class="form-group">
				   <label>Ngày sinh:</label>
				   <input type ="text"  class="form-control" name="ns" value='${nv.getNgaySinh()}'></input>
		      	</div>
		      
				 
			  </div>
			  <div class="col-sm-3 col-xs-12">
			  	<div class="form-group">
				   <label>Giới tính:</label>
				    	<input type ="text"  class="form-control"  name="gt" value='${nv.getGioiTinh()}'></input>
		      	</div>
			   <div class="form-group">
			   <label>Số chứng minh thư:</label>
				<input type ="number"  class="form-control"  name="scmt" value='${nv.getSoCMT()}'></input>
		       </div>
		       <div class="form-group">
				   <label>Địa chỉ:</label>
				    <input type ="text"  class="form-control" name="dc" value='${nv.getDiaChi()}'></input>
	      		</div>
	      		 
			 
			  </div>
			  <div class="col-sm-3 col-xs-12">
			  <div class="form-group">
				   <label>Số điện thoại:</label>
				     <input type ="text"  class="form-control" name="sdt" value='${nv.getSoDT()}'></input>
	      		</div>
	      		<div class="form-group">
				   <label>Chức vụ:</label>
				     <input type ="text"  class="form-control" name="cv" value='${nv.getChucVu()}'></input>
	      		</div>
	      		
	  			
			  </div>
			   
			</div>	  
			<div>  <input id="click"  type ="submit"   value='${name}'></input></div>
		 
	        
	           
	      </form>    
      </div>
      <div></br>
       <input class="form-control" id="myInput" type="text" placeholder="Tìm theo mã, tên nhân viên....">
   		 <br>
		    <table class="table table-bordered" >
		       <tr>
		          <th>Mã nhân viên</th>
		          <th>Tên nhân viên</th>
		          <th>Ngày sinh</th>		       
		          <th>Số CMT</th>		        
		          <th>Số DT</th>
		     	  <th>Chức vụ</th>
		          <th>Sửa</th>
		          <th>Xóa</th>
		       </tr>
		       <c:forEach items="${dsNhanVien}" var="p" >
		        <tbody id="myTable">
		          <tr>
		             <td>${p.getMaNV()}</td>
		             <td>${p.getHoTenNV()}</td>
		             <td>${p.getNgaySinh()}</td>
		             <td>${p.getSoCMT()}</td>
		             <td>${p.getSoDT()}</td>
		             <td>${p.getChucVu()}</td>
		             <td>
		                <a class="fa fa-edit" href="updatePhong?action=editNV&manv=${p.getMaNV()}"></a>
		             </td>
		             <td>
		                <a class="fa fa-remove" href="Delete?action=editNV&manv=${p.getMaNV()}" "></a>
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
             manv: "required",
             tennv: "required",
             ns:"required",
             scmt:"required",
             dc:"required",
             cv:"required"
         },
         messages: {
        	 
        	 manv: "Vui lòng nhập mã nhân viên",
        	 tennv: " Vui lòng nhập họ tên nhân viên",
             ns:  " Vui lòng nhập ngày sinh",
             scmt:  " Vui lòng nhập số chứng minh thư",
             dc:  " Vui lòng nhập địa chỉ",
             cv:  " Vui lòng nhập chức vụ"
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