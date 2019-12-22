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
	              <div class="panel-heading">教练基本信息</div>
	              
	               <div class="panel-body">
	                  <table class="table table-bordered">
						<caption>教练基本信息</caption>
						<thead>
							<tr>
								<th>教练id</th>
								<th>姓名</th>
								<th>性别</th>
								<th>年龄</th>
								<th>电话</th>
								<th>教授课程</th>
								<th>编辑</th>
								<th>删除</th>
							</tr>
						</thead>
						<tbody>
						    <c:forEach items="${coachList}" var="coach">
								<tr>
									<td>${coach.id }</td>
									<td>${coach.name }</td>
									<td>${coach.sex==0 ? "男":"女" }</td>
									<td>${coach.age }</td>
									<td>${coach.phone }</td>
									<td>${coach.teach }</td>
									<td><a href="Coach?action=addedit&type=edit&id=${coach.id }">编辑</a></td>
									<td><a href="Coach?action=delete&id=${coach.id }">删除</a></td>
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