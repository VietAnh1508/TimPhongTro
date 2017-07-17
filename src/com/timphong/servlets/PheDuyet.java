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

@WebServlet("/PheDuyet")
public class PheDuyet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PheDuyet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Room> roomList = JSONConnector.getInstance().getRoomList();
		
		request.setAttribute("roomList", roomList);
		
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/pheDuyet.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}