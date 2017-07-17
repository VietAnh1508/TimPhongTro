<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Thêm phòng</title>
</head>
<body>
	<jsp:include page="_header.jsp"></jsp:include>
	<jsp:include page="_menu.jsp"></jsp:include>

	<h3>Đăng ký phòng cho thuê</h3>
	
	<p style="color: red;">${ error }</p>
	<p>${ noti }</p>
	
	<form action="ThucHienThem" method="get">
		<table>
			<tr>
				<td>Mã phòng</td>
				<td><input type="text" name="id" value="${ room.id }" /></td>
			</tr>
			<tr>
				<td>Giá thuê</td>
				<td><input type="text" name="cost" value="${ room.cost }" /></td>
			</tr>
			<tr>
				<td>Mô tả</td>
				<td><input type="text" name="description" value="${ room.description }" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="Thêm" />
					<a href="DanhSachPhong">Hủy</a>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>