<%@page import="util.DefineUtil"%>
<%@page import="model.bean.Nhanvien"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
    
		<aside class="menu-sidebar2">
            <div class="logo">
                <a href="#">
                </a>
            </div>
            <div class="menu-sidebar2__content js-scrollbar1">
                <div class="account2">
                    <div class="image img-cir img-100">
                        <img src="/THLTM_B3/templates/admin/assets/images/icon/cnttbk.png" alt="Image" />
                    </div>
                </div>
	            <nav class="navbar-sidebar2">
	                <ul class="list-unstyled navbar__list">
	                    <li>
	                        <a href="<%=request.getContextPath() %>/admin/index">
	                            <i class="fas fa-home"></i>Trang chủ</a>
	                    </li>
	                    <li>
                            <a href="<%=request.getContextPath() %>/admin/nhanvien/index">
                                <i class="fas fa-user"></i>Nhân viên</a>
                        </li>
                        <li>
                            <a href="<%=request.getContextPath() %>/admin/phongban/index">
                                <i class="fas fa-film"></i>Phòng ban</a>
                        </li>
	                </ul>
	            </nav>
	        </div>
        </aside>
        
		<div class="page-container2">
			<header class="header-desktop2">
                <div class="section__content section__content--p30">
                    <div class="container-fluid">
                        <div class="header-wrap2">
		                	<!-- <form class="form-header form-header2" action="" method="post">
		                        <input class="au-input au-input--w435" type="text" name="search" placeholder="Search ...">
		                        <button class="au-btn--submit" type="submit">
		                            <i class="zmdi zmdi-search"></i>
		                        </button>
		                    </form> -->
                        </div>
                    </div>
                </div>
            </header>
<!-- /. NAV SIDE  -->