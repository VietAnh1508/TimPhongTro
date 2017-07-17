<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Danh sách phòng trọ</title>
</head>
<body>
	<jsp:include page="_header.jsp"></jsp:include>
	<jsp:include page="_menu.jsp"></jsp:include>

	<h3>Danh sách phòng trọ</h3>

	<p>${ error }</p>

	<table border="1" cellpadding="5" cellspacing="1">
		<tr>
			<th>Mã số</th>
			<th>Giá thuê</th>
			<th>Mô tả</th>
		</tr>
		<c:forEach items="${ roomList }" var="room">
			<c:if test="${ room.isCheck() == true }">
				<tr>
					<td>${ room.id }</td>
					<td>${ room.cost }</td>
					<td>${ room.description }</td>
				</tr>
			</c:if>
		</c:forEach>
	</table>

	<script type="text/javascript">
		function getKey() {
			var key = document.getElementById("keyMap").value;
			return key;
		}
	</script>
</body>
</html>