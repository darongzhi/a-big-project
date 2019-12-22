<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<%@include file="head.jsp" %>
<body style="width: 100%; overflow: hidden;">

<%@include file="nav.jsp" %>

<div align="center" style="padding-top: 20px;" class="row">
                
           <%@include file="menu.jsp" %>
           
              <div class="col-md-10">
                <div class="panel panel-default ">
	              <div class="panel-heading">器材基本信息</div>
	              
	               <div class="panel-body">
	                  <table class="table table-bordered">
						<caption>器材基本信息</caption>
						<thead>
							<tr>
								<th>器材id</th>
								<th>器材名称</th>
								<th>状态</th>
								<th>编辑</th>
								<th>删除</th>
							</tr>
						</thead>
						<tbody>
						    <c:forEach items="${equipmentList}" var="equipment">
								<tr>
									<td>${equipment.id }</td>
									<td>${equipment.name }</td>
									<td>${equipment.states }</td>
									<td><a href="Equipment?action=addedit&type=edit&id=${equipment.id }">编辑</a></td>								
									<td><a href="Equipment?action=delete&id=${equipment.id }">删除</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
	               </div>
               </div>
             </div>
</div>

<%@include file="footer.jsp" %>
</body>
</html>