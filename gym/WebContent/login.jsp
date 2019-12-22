<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/login.css" />
<title>用户登录-健身房管理系统</title>
</head>
<body>

<div id="header">
	<div class="header_title">
		<span class="title_con">健身房管理系统</span>
	</div>
</div>

<div id="content">
    <form action="Login" method="post">
	<center>
		<div class="con">
		<div class="con_title">
			<span class="con_title_sp">健身房管理系统</span>
		</div>
		<div class="con_panel">
			<div class="con_input">
				<span>用户名：</span><input type="text" placeholder="用户名" name="username"/>
			</div>
			<div class="con_input">
				<span>密&nbsp;&nbsp;&nbsp;&nbsp;码：</span><input type="password" placeholder="密码" name="password"/>
			</div>
			 <div class="well well-sm" style="text-align:center;">
                
                <input type="radio" name="role" value="0" checked/> 管理员
               
            </div>
			<input type="submit" value="登    录" class="submit-btn"/>
		</div>
	</div>
	</center>
	</form>
</div>

<div id="footer">
	<center>
		健身房管理系统
	</center>
</div>

</body>
</html>