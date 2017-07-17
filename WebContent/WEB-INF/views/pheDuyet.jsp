<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="_header.jsp"></jsp:include>
	<jsp:include page="_menu.jsp"></jsp:include>

	<h3>Phê duyệt</h3>
	
	<table border="1" cellpadding="5" cellspacing="1">
		<tr>
			<th>Mã số</th>
			<th>Giá thuê</th>
			<th>Mô tả</th>
			<th>Trạng thái</th>
			<th>Thao tác</th>
		</tr>
		<c:forEach items="${ roomList }" var="room">
			<tr>
				<td>${ room.id }</td>
				<td>${ room.cost }</td>
				<td>${ room.description }</td>
				<td>
					<c:choose>
						<c:when test="${ room.isCheck() == false }"> Chưa phê duyệt </c:when>
						<c:when test="${ room.isCheck() == true }"> Đã phê duyệt </c:when>
					</c:choose>
				</td>
				<td>
					<c:choose>
						<c:when test="${ room.isCheck() == false }">
							<a href="ThucHienPheDuyet?id=${ room.id }">Duyệt</a>
						</c:when>
						<c:when test="${ room.isCheck() == true }">
							<a href="xoa?id=${ room.id }">Xóa</a>
						</c:when>
					</c:choose>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>