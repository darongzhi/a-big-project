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
	                  
	                        <c:if test="${coach.id != null}">
	                            <input type="hidden" name="id" value="${coach.id }" />
	                        </c:if> 	                        
	                        
							<div class="form-group">
								<label for="firstname" class="col-sm-1 control-label">姓名</label>
								<div class="col-sm-4"><input type="text" class="form-control"  placeholder="请输入姓名" required="required" name="name" value="${coach.name }"></div>
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
								<div class="col-sm-4"><input type="text" class="form-control"  placeholder="请输入年龄" required="required" name="age" value="${coach.age }"/></div>
							</div>
							
							<div class="form-group">
								<label for="firstname" class="col-sm-1 control-label">电话</label>
								<div class="col-sm-4"><input type="text" class="form-control"  placeholder="请输入电话" required="required" name="phone" value="${coach.phone }"/></div>
							</div>
							
							<div class="form-group">
								<label for="firstname" class="col-sm-1 control-label">教授课程</label>
								<div class="col-sm-4"><input type="text" class="form-control"  placeholder="请输入教授课程"  required="required" name="teach" value="${coach.teach }"/></div>
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