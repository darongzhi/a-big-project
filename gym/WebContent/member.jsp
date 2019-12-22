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
	              <div class="panel-heading">会员基本信息</div>
	              
	               <div class="panel-body">
	                  <table class="table table-bordered">
						<caption>会员基本信息</caption>
						<thead>
							<tr>
								<th>会员id</th>
								<th>姓名</th>
								<th>性别</th>
								<th>年龄</th>
								<th>电话</th>
								<th>邮箱</th>
								<th>地址</th>
								<th>注册时间</th>
								<th>编辑</th>
								<th>删除</th>
							</tr>
						</thead>
						<tbody>
						    <c:forEach items="${memberList}" var="member">
								<tr>
									<td>${member.id }</td>
									<td>${member.name }</td>
									<td>${member.sex==0 ? "男":"女" }</td>
									<td>${member.age }</td>
									<td>${member.phone }</td>
									<td>${member.email }</td>
									<td>${member.address }</td>
									<td>${member.starts }</td>
									<td><a href="Member?action=addedit&type=edit&id=${member.id }">编辑</a></td>	
									<td><a href="Member?action=delete&id=${member.id }">删除</a></td>
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