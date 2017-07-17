<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div style="background: #E0E0E0; height: 55px; padding: 5px;">
	<div style="float: left">
		<h3>Tìm Phòng Trọ</h3>
	</div>

	<div style="float: right; padding: 10px; text-align: right;">
		<!-- User store in session with attribute: loginedUser -->
		Xin chào <b>${ username }</b> <br />
		<form action="TimKiem" method="get">
			<table>
				<tr>
					<td>Tìm kiếm <input name="search"> <input type="submit" value="Tìm" />
					</td>
				</tr>
			</table>
		</form>
	</div>
</div>