<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/admin/inc/header.jsp" %>
<%@ include file="/templates/admin/inc/leftbar.jsp" %>
<div class="main-content">
	<div class="section__content section__content--p10">
	    <div class="container-fluid">
	        <div class="row">
	            <div class="col-md-12">
	                <h2><%=DefineUtil.home %></h2>
	            </div>
	        </div>
        <!-- /. ROW  -->
	        <hr />
	        <div class="row">
	            <div class="col-md-4 col-sm-4 col-xs-4">
	                <div class="panel panel-back noti-box">
	                    <span class="icon-box bg-color-red set-icon">
	                    <i class="fa fa-user"></i>
	                </span>
	                    <div class="text-box">
	                        <p class="main-text"><a href="<%=request.getContextPath() %>/admin/nhanvien/index" title=""><%=DefineUtil.Nhanvien %></a></p>
	
	                    </div>
	                </div>
	            </div>
	            <div class="col-md-4 col-sm-4 col-xs-4">
	                <div class="panel panel-back noti-box">
	                    <span class="icon-box bg-color-green set-icon">
	                    <i class="fa fa-film"></i>
	                </span>
	                    <div class="text-box">
	                        <p class="main-text"><a href="<%=request.getContextPath() %>/admin/phongban/index" title=""><%=DefineUtil.Phongban %></a></p>
	
	                    </div>
	                </div>
	            </div>
	        </div>
		</div>
    </div>
</div>
<script>
    document.getElementById("index").classList.add('active-menu');
</script>
<!-- /. PAGE WRAPPER  -->
<%@ include file="/templates/admin/inc/footer.jsp" %>