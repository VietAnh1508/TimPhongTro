<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Đăng nhập hệ thống</title>
</head>
<body>
	<jsp:include page="_header.jsp"></jsp:include>
	<jsp:include page="_menu.jsp"></jsp:include>
	
	<h3>Đăng nhập</h3>
	
	<p style="color: red;">${ error }</p>
	<p>${ noti }</p>
	
	<form method="POST" action="ThucHienDangNhap">
		<table border="0">
			<tr>
				<td>Tên đăng nhập</td>
				<td><input type="text" name="username" value="${ user.username }" />
				</td>
			</tr>
			<tr>
				<td>Mật khẩu</td>
				<td><input type="password" name="password" value="${ user.password }" />
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="Đăng nhập" />
					<a href="${ pageContext.request.contextPath }/">Hủy</a>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>