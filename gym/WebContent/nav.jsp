<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<nav class="navbar navbar-default navbar-static-top" role="navigation">
	<div class="container-fluid"> 
    <div class="navbar-header">
        <a class="navbar-brand" href="#">健身房信息系统</a>
    </div>
    <div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="#">用户:${sessionScope.username}</a></li>
            
            <li><a href="exit.jsp">退出登录</a></li>
        </ul>
    </div>
	</div>
</nav>