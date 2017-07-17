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

@WebServlet("/TimKiem")
public class TimKiem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TimKiem() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String key = request.getParameter("search");
		
		ArrayList<Room> roomList = JSONConnector.getInstance().getRoomList();
		ArrayList<Room> result = new ArrayList<Room>();
		
		for (Room item : roomList) {
			if (String.valueOf(item.getId()).contains(key)
					|| String.valueOf(item.getCost()).contains(key)
					|| item.getDescription().contains(key)) {
				result.add(item);
			}
		}
		
		if (result.isEmpty()) {
			request.setAttribute("noti", "Không có kết quả phù hợp");
		}
		
		request.setAttribute("keySearch", "Hiển thị kết quả cho từ khóa:" + key);
		request.setAttribute("roomList", result);
		
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/ketQuaTimKiem.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}