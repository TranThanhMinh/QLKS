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
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.1/jquery.validate.min.js"></script>

    <title>Danh sách Phòng</title>
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
			                  <a href="#"><i class="fa fa-car fa-lg"></i> Dịch vụ </a>
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
     <h4>Danh sách dịch vụ</h4></div>    
     <div id="sizetext" >
      <form action="insertDichVu" method="post" id="save">    
      <div class="row">
	      
		      <div class="col-sm-3 col-xs-12">
			      	 <div class="form-group">
			      	<label>Mã dịch vụ:</label>
			      	<input type ="text" name="madv" value='${dv.getMaDV()}' ></input>
			      	</div>
			      		<div class="form-group">
			      	<label>Tên dịch vụ:</label>
			      	<input type ="text" name="tendv" value='${dv.getTenDV()}'></input>
			      	</div>
		      </div>
	    
	      
	      	<div class="col-sm-3 col-xs-12">
			      	
			      	<div class="form-group">
			      	<label>Giá dịch vụ:</label>
			      	<input type ="text" name="giadv" value='${dv.getGiaDV()}'></input>
			      	</div>
			      		<div class="form-group">
			      	<label>Đơn vị tính:</label>
			      	<input type ="text" name="dvt" value='${dv.getDVT()}'></input>
			      	</div>
		      </div>
	 
		   <div class="col-sm-3 col-xs-12">
			      	
			      	<div class="form-group">
			      	<label>Nhân viên:</label>			      	
			        <select id="selectBox" class="selectpicker col" value='${dv.getDVT()}' onchange="changeFunc();">
			          <c:forEach items="${dsNhanVien}" var="p" >
						  <option name='${p.getMaNV()}' >${p.getMaNV()} - ${p.getHoTenNV()}</option>
					 </c:forEach>
					</select>
			      	</div>
			      	<div>
			      		<input type ="hidden" id="nv" name="tennv" value='${ma}'></input>
			      	</div>
		 </div>
		
      </div>
       

       <input id="click"  type ="submit"   value='${name}'></input>
      </form>    
      </div>
      <div></br>
     
      
       <input class="form-control" id="myInput" type="text" placeholder="Tìm theo mã, loại, giá phòng....">
   		 <br>
		    <table id="table" class="table table-bordered" >
		       <tr>		      
		          <th>Mã dịch vụ</th>
		          <th>Tên dịch vụ</th>
		          <th>Giá dịch vụ</th>
		          <th>Nhân viên</th>
		           <th>đơn vị tính</th>
		          <th>Sửa</th>
		          <th>Xóa</th>
		       </tr>
		       <c:forEach items="${dsDichVu}" var="p" >
		        <tbody id="myTable">
		          <tr>
		             <td >${p.getMaDV()}</td>
		             <td >${p.getTenDV()}</td>
		             <td >${p.getGiaDV()}</td>
		             <td >${p.getTenNV()}</td>
		             <td >${p.getDVT()}</td>
		             <td>
		            
		                <a class="fa fa-edit" href="updatePhong?action=editDV&madv=${p.getMaDV()}"></a>
		             </td>
		             <td>
		                <a class="fa fa-remove" href="Delete?action=editDV&madv=${p.getMaDV()}"></a>
		             </td>
		          </tr>
		          </tbody>
		       </c:forEach>
		    </table>
    </div>
 
    </div>
    </div>
    
    
  
<script type="text/javascript">
	   function changeFunc() {
	    var selectBox = document.getElementById("selectBox");
	    var selectedValue = selectBox.options[selectBox.selectedIndex].value;
	    document.getElementById("nv").value=selectedValue;
	   }

 </script>

 <script>

 $(document).ready(function() {
	 
     //Khi bàn phím được nhấn và thả ra thì sẽ chạy phương thức này
     $("#save").validate({
         rules: {
             maphong: "required",
             loaiphong: "required",
             giaphong:"required",
         },
         messages: {
        	 maphong: "Vui lòng nhập mã phòng",
        	 loaiphong: " Vui lòng nhập loại phòng",
             giaphong:  " Vui lòng nhập giá phòng",
             
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