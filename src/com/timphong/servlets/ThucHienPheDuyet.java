package com.timphong.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.timphong.connector.JSONConnector;

@WebServlet("/ThucHienPheDuyet")
public class ThucHienPheDuyet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ThucHienPheDuyet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.valueOf(request.getParameter("id"));
		JSONConnector.getInstance().checkRoom(id);
		
		request.setAttribute("roomList", JSONConnector.getInstance().getRoomList());
		
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/pheDuyet.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}