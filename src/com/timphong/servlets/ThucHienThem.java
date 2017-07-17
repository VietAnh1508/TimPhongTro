package com.timphong.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.timphong.connector.JSONConnector;
import com.timphong.models.Room;

@WebServlet("/ThucHienThem")
public class ThucHienThem extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ThucHienThem() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Room> roomList = JSONConnector.getInstance().getRoomList();
		String error = null;
		
		int id = Integer.valueOf(request.getParameter("id"));
		long cost = Long.valueOf(request.getParameter("cost"));
		String description = request.getParameter("description");
		
		Room newRoom = new Room(id, cost, description, false);
		
		for (Room item : roomList) {
			if (item.getId() == id) {
				error = "Mã phòng này đã tồn tại";
				break;
			}
		}
		
		if (error == null) {
			roomList.add(newRoom);
			JSONConnector.getInstance().writeToJSONFile(roomList);
			request.setAttribute("noti", "Thêm thành công, bài đăng của bạn đang chờ được phê duyệt");
		} else {
			request.setAttribute("error", error);
			request.setAttribute("room", newRoom);
		}
		
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/themPhong.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}