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
	                        <c:if test="${equipment.id != null}">
	                           <input type="hidden" name="id" value="${equipment.id }" /> 
	                        </c:if>
							<div class="form-group">
								<label for="firstname" class="col-sm-1 control-label">器材名称</label>
								<div class="col-sm-4"><input type="text" class="form-control"  placeholder="请输入器材名称" required="required" name="name" value="${equipment.name }"></div>
							</div>
							
							<div class="form-group">
								<label for="firstname" class="col-sm-1 control-label">器材状态</label>
								<div class="col-sm-4"><input type="text" class="form-control"  placeholder="请输入器材状态" required="required" name="states" value="${equipment.states }"/></div>
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