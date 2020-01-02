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
                <h2>Result</h2>
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
                                </div>
                                <div class="col-sm-6" style="text-align: right;">
                                    <form method="post" action="">
                                        <input type="submit" name="" value="Tìm kiếm" class="btn btn-warning btn-sm" style="float:right" />
                                        <input type="search" name="search" class="form-control input-sm" placeholder="Search ..." style="float:right; width: 300px;" />
                                        <div style="clear:both"></div>
                                    </form><br />
                                </div>
                                <div class="col-sm-6" style="text-align: right;"></div>
                            </div>
                            <%
								if(request.getParameter("msg")!=null){
									int msg = Integer.parseInt(request.getParameter("msg"));
									switch(msg){
									case 2: out.print("No result!!"); break;
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
  									if(request.getAttribute("listSearch") != null){
  									int index = 0;
  									 ArrayList<Phongban> listP = (ArrayList<Phongban>)request.getAttribute("listSearch");
  										if(listP.size() > 0){
  										for(Phongban objP:listP){
   								%>
                                    <tr>
                                        <%-- <td><%=++index %></td> --%>
                                        <td class="center"><%=objP.getId() %></td>
                                        <td class="center"><%=objP.getName() %></td>
                                        <td class="center">
                                            <a href="<%=request.getContextPath()%>/admin/nhanvien/edit?id=<%=objP.getId() %>" title="Edit" class="btn btn-primary"><i class="fa fa-edit "></i> Edit</a>
                                            <a href="<%=request.getContextPath()%>/admin/nhanvien/del?id=<%=objP.getId() %>" title="Delete" class="btn btn-danger"><i class="fa fa-trash"></i> Delete</a>
                                        </td>
                                    </tr>
									<%}}} %>
                                </tbody>
                            </table>
                            <div class="row">
                                <div class="col-sm-6">
                                    <div class="dataTables_info" id="dataTables-example_info" style="margin-top:27px">Show search result</div>
                                </div>
                                <!-- <div class="col-sm-6" style="text-align: right;">
                                    <div class="dataTables_paginate paging_simple_numbers" id="dataTables-example_paginate">
                                        <ul class="pagination">
                                            <li class="paginate_button previous" aria-controls="dataTables-example" tabindex="0" id="dataTables-example_previous"><a href="#">Prev Page</a></li>
                                            <li class="paginate_button active" aria-controls="dataTables-example" tabindex="0"><a href="">1</a></li>
											<li class="paginate_button" aria-controls="dataTables-example" tabindex="0"><a href="">2</a></li>
                                            <li class="paginate_button next" aria-controls="dataTables-example" tabindex="0" id="dataTables-example_next"><a href="#">Next Page</a></li>
                                        </ul>
                                    </div>
                                </div> -->
                            </div>
                    	</div>
                    </div>
                </div>
                <!--End Advanced Tables -->
            </div>
        </div>
    </div>
</div>
<script>
    document.getElementById("phongban").classList.add('active-menu');
</script>
<!-- /. PAGE INNER  -->
<%@ include file="/templates/admin/inc/footer.jsp" %>