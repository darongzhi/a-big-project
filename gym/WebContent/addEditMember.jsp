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
	              <div class="panel-heading">${heading }</div>
	              
	               <div class="panel-body">
	                  <form class="form-horizontal" role="form" action="${action }" method="post">
	                        <c:if test="${member.id != null}">
	                            <input type="hidden" name="id" value="${member.id }" />
	                        </c:if>
							<div class="form-group">
								<label for="firstname" class="col-sm-1 control-label">姓名</label>
								<div class="col-sm-4"><input type="text" class="form-control"  placeholder="请输入姓名" required="required" name="name" value="${member.name }"/></div>
							</div>
							<div class="form-group">
							    <label for="firstname" class="col-sm-1 control-label">性别</label>
							    <div class="col-sm-4" align="left">
									<label class="radio-inline">
								        <input type="radio" name="sex"  value="0" checked> 男
								    </label>
								    <label class="radio-inline">
								        <input type="radio" name="sex"   value="1"> 女
								    </label>
							    </div>
							</div>
							<div class="form-group">
								<label for="firstname" class="col-sm-1 control-label">年龄</label>
								<div class="col-sm-4"><input type="text" class="form-control"  placeholder="请输入年龄" required="required" name="age" value="${member.age }"/></div>
							</div>
							
							<div class="form-group">
								<label for="firstname" class="col-sm-1 control-label">电话</label>
								<div class="col-sm-4"><input type="text" class="form-control"  placeholder="请输入电话" required="required" name="phone" value="${member.phone }"/></div>
							</div>
							
							<div class="form-group">
								<label for="firstname" class="col-sm-1 control-label">邮箱</label>
								<div class="col-sm-4"><input type="text" class="form-control"  placeholder="请输入邮箱" required="required" name="email" value="${member.email }"/></div>
							</div>
							
							<div class="form-group">
								<label for="firstname" class="col-sm-1 control-label">地址</label>
								<div class="col-sm-4"><input type="text" class="form-control"  placeholder="请输入地址" required="required" name="address" value="${member.address }"/></div>
							</div>
							
							<div class="form-group">
								<label for="firstname" class="col-sm-1 control-label" >注册日期</label>
								<div class="col-sm-4"><input type="date" class="form-control" required="required" name="starts" value="${member.starts }"/></div>
							</div>
							
							<div class="form-group">
								<div class="col-sm-offset-1 col-sm-6">
								    <button type="submit" class="btn btn-default">${btname }</button>
								</div>
							</div>
						</form>
	               </div>
               </div>
             </div>
</div>

<%@include file="footer.jsp" %>
</body>
</html>