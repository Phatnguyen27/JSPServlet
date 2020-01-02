<%@page import="model.bean.Phongban"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/admin/inc/header.jsp" %>
<%@ include file="/templates/admin/inc/leftbar.jsp" %>
<div class="main-content">
	<div class="section__content section__content--p10">
	    <div class="container-fluid">
	        <div class="row">
	            <div class="col-md-12">
	                <h2><%=DefineUtil.Phongban %></h2>
	            </div>
	        </div>
	        <!-- /. ROW  -->
	        <hr />
	        <div class="row">
	            <div class="col-md-12">
	                <!-- Advanced Tables -->
	                <div class="panel panel-default">
	                    <div class="panel-body">
	                            <div class="row">
	                            	<div class="col-sm-6">
	                                    <a href="<%=request.getContextPath() %>/admin/phongban/add" class="btn btn-success btn-md">Add</a>
	                                </div>
	                                <div class="col-sm-6" style="text-align: right;">
	                                    <form method="post" action="<%=request.getContextPath() %>/admin/phongban/index">
	                                        <input type="submit" name="" value="Tìm kiếm" class="btn btn-warning btn-sm" style="float:right" />
	                                        <input type="search" name ="search" class="form-control input-sm" placeholder="Search ..." style="float:right; width: 300px;" />
	                                        <div style="clear:both"></div>
	                                    </form><br />
	                                </div>
	                                <div class="col-sm-6" style="text-align: right;">
	                                   
	                                </div>
	                            </div>
								<%
									if(request.getParameter("msg")!=null){
										int msg = Integer.parseInt(request.getParameter("msg"));
										switch(msg){
										case 0: out.print("ERROR"); break;
										case 1: out.print("Add Success!!"); break;
										case 2: out.print("Edit Success!!"); break;
										case 3: out.print("Delete Success!!"); break;
										}
									}
								%>
	                            <table class="table table-striped table-bordered table-hover" id="dataTables-example">
	                                <thead>
	                                    <tr>
	                                        <th>ID</th>
	                                        <th>Name</th>
	                                        <th width="200px">Function</th>
	                                    </tr>
	                                </thead>
	                                <tbody>
	                                <%
	  									if(request.getAttribute("phongban") != null){
	  									int index = 0;
	  									 ArrayList<Phongban> listPhong = (ArrayList<Phongban>)request.getAttribute("phongban");
	  										if(listPhong.size() > 0){
	  										for(Phongban objP : listPhong){
	   								%>
	                                    <tr>
	                                        <td><%=objP.getId() %></td>
	                                        <td class="center"><%=objP.getName() %></td>
	                                        <td class="center">
	                                            <a href="<%=request.getContextPath() %>/admin/phongban/edit?id=<%=objP.getId() %>" title="" class="btn btn-primary"><i class="fa fa-edit "></i> Edit</a>
	                                            <a href="<%=request.getContextPath() %>/admin/phongban/del?id=<%=objP.getId() %>" onclick="return confirm('Delete this?')" title="" class="btn btn-danger"><i class="fa fa-trash"></i> Delete</a>
	                                        </td>
	                                    </tr>
										<%}}} %>
	                                </tbody>
	                            </table>
	                           <%
	                            	int numberOfPages =(Integer)(request.getAttribute("numberOfPages"));
	                           		int currentPages =(Integer)(request.getAttribute("currentPage"));
	
	                            %>
	                            <div class="row">
	                                <div class="col-sm-6">
	                                    <div class="dataTables_info" id="dataTables-example_info" style="margin-top:27px">Page <%=currentPages %> / <%=numberOfPages %></div>
	                                </div>
	                                <div class="col-sm-6" style="text-align: right;">
	                                    <div class="dataTables_paginate paging_simple_numbers" id="dataTables-example_paginate">
	                                        <ul class="pagination">
	                                            <li class="paginate_button next" aria-controls="dataTables-example" tabindex="0" id="dataTables-example_previous"><a href="<%=request.getContextPath()%>/admin/phongban/index?page=<%=currentPages-1%>">Prev page</a></li>
	                                           
	                                           	   <%
	                                           String active ="";
	                                           for(int i = 1; i <= numberOfPages ; i++){
	                                        	   if(currentPages == i)
	                                           			active = "active";
	                                        	   else active = "";
	                                           %>
	                                            <li class="paginate_button <%=active %>" aria-controls="dataTables-example" tabindex="0"><a href="<%=request.getContextPath()%>/admin/phongban/index?page=<%=i%>"><%=i %></a></li>
												 <%} %>
	                                            <li class="paginate_button next" aria-controls="dataTables-example" tabindex="0" id="dataTables-example_next"><a href="<%=request.getContextPath()%>/admin/phongban/index?page=<%=currentPages+1%>">Next page</a></li>
	                                        </ul>
	                                    </div>
	                                </div>
	                            </div>
	                        </div>
	                </div>
	                <!--End Advanced Tables -->
	            </div>
	    	</div>
        </div>
    </div>
</div>
<script>
    document.getElementById("phongban").classList.add('active-menu');
</script>
<!-- /. PAGE INNER  -->
<%@ include file="/templates/admin/inc/footer.jsp" %>