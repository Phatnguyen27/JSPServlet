<%@page import="model.bean.Phongban"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/templates/admin/inc/header.jsp" %>
<%@ include file="/templates/admin/inc/leftbar.jsp" %>
<div id="page-wrapper">
	<div id="page-inner">
        <div class="row">
            <div class="col-md-12">
                <h2>Sửa phòng ban</h2>
            </div>
        </div>
        <!-- /. ROW  -->
        <hr>
        <div class="row">
            <div class="col-md-12">
                <!-- Form Elements -->
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="row">
                        <%
                        	if(request.getAttribute("phongban") != null){
                            	Phongban objP = (Phongban)request.getAttribute("phongban");
                        %> 
                            <div class="col-md-6">
                                 <form action="<%=request.getContextPath() %>/admin/phongban/edit?id=<%=objP.getId()  %>" role="form" method="POST">
                                   
                                    <div class="form-group">
                                        <label>Name</label>
                                        <input value="<%=objP.getName() %>" type="text" name="name" class="form-control">
                                    </div>

                                    <hr style="margin-top:30px;">
                                    <input type="submit" name="edit" class="btn btn-success btn-md" value="Save">
									<%} %>
                                </form>

                          </div>

                        </div>
                    </div>
                </div>
                <!-- End Form Elements -->
            </div>
        </div>
        <!-- /. ROW  -->
    </div>
    </div>
<%@ include file="/templates/admin/inc/footer.jsp" %>


