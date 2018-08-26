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

    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/css/bootstrap-datepicker.min.css" rel="stylesheet"/>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <title>Danh sách Phòng</title>
    <style> 
</style>
 </head>
 <body>
<div class="container-full">
   
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
			                  <a href="dsHoaDon"><i class="fa fa-money" aria-hidden="true"></i></i> Hóa đơn </a>
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
     <h4>Danh sách thuê phòng</h4></div>    
     <div id="sizetext" >
      <form action="insertHD" method="post" id="save">    
      <div class="row">
	       <div class="col-sm-3 col-xs-12">
			      	 <div class="form-group">
			      	<label>Mã hóa đơn:</label>
			      	<input type ="text"  class="form-control" disabled="disabled" value='${ma}' ></input>
			      	</div>
			      		<div>
			      		<input type ="hidden" id="mahd"  name="mahd" value='${ma}'></input>
			      	</div>
			      	
		      </div>
		       <div class="col-sm-3 col-xs-12">
			      	
			      	<div class="form-group">
			      	<label>Khách hàng:</label>			      	
			        <select id="selectKH" class="selectpicker col form-control" onchange="changeFuncKH();">
			          <c:forEach items="${dsKhachHang}" var="p" >
						  <option name='${p.getMaNV()}' >${p.getMaNV()} - ${p.getHoTenNV()}</option>
					 </c:forEach>
					</select>
			      	</div>
			      	<div>
			      		<input type ="hidden" id="kh"  name="tenkh" value='${tenkh}'></input>
			      	</div>
			      	
			</div>
		      <div class="col-sm-3 col-xs-12">
			      	 
			      	<div class="form-group">
				      	<label>Nhân viên:</label>			      	
				        <select id=selectNV class="selectpicker col form-control" onchange="changeFuncNV();">
				          <c:forEach items="${dsNhanVien}" var="p" >
							  <option name='${p.getMaNV()}' >${p.getMaNV()} - ${p.getHoTenNV()}</option>
						 </c:forEach>
						</select>
			      	</div>
			      	<div>
			      		<input type ="hidden" id="nv"  name="tennv" value='${tennv}'></input>
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
		          <th>Mã hóa đơn</th>		     
		          <th>Tên khách hàng</th>
		          <th>Ngày lập hóa đơn</th>
		           <th>Nhân viên</th>
		          <th>Chi tiết</th>
		          <th>Sửa</th>
		          <th>Xóa</th>
		       </tr>
		       <c:forEach items="${dsHoaDon}" var="p" >
		        <tbody id="myTable">
		          <tr>
		             <td >${p.getMaHD()}</td>
		             <td >${p.getMaKH()} - ${p.getTenKH()}</td>		       
		             <td >${p.getNgayLapHD()}</td>
		           <td >${p.getMaNV()} - ${ p.getHoTenNV()}</td>
		            <td>		           
		                <a href="updatePhong?matp=${p.getMaHD()}"> Xem</a>
		             </td>
		             <td>
		            
		                <a class="fa fa-edit" href="updatePhong?action=editHD&mahd=${p.getMaHD()}"></a>
		             </td>
		             <td>
		                <a class="fa fa-remove" href="Delete?action=editHD&mahd=${p.getMaHD()}"></a>
		             </td>
		          </tr>
		          </tbody>
		       </c:forEach>
		    </table>
    </div>
 
    </div>
    </div>
    
    </div>
  
<script type="text/javascript">
	   function changeFuncNV() {
	    var selectBox = document.getElementById("selectNV");
	    var selectedValue = selectBox.options[selectBox.selectedIndex].value;
	    document.getElementById("nv").value=selectedValue;
	   }
	   function changeFuncKH() {
		    var selectBox = document.getElementById("selectKH");
		    var selectedValue = selectBox.options[selectBox.selectedIndex].value;
		    document.getElementById("kh").value=selectedValue;
		   }
 </script>

 <script>

 $(document).ready(function() {
	 
     //Khi bàn phím được nhấn và thả ra thì sẽ chạy phương thức này
     $("#save").validate({
         rules: {           
        	 tennv: "required",
        	 tenkh:"required"
         },
         messages: {
        
        	 tennv: " Vui lòng nhập loại phòng",
        	 tenkh:  " Vui lòng nhập giá phòng"
             
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

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/js/bootstrap-datepicker.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script type="text/javascript">
  	
    $('#datepickerden').datepicker();
    $('#datepickerdi').datepicker();
</script>
 </body>
</html>