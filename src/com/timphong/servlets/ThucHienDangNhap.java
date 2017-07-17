package com.timphong.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.timphong.connector.JSONConnector;
import com.timphong.models.Account;

@WebServlet("/ThucHienDangNhap")
public class ThucHienDangNhap extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ThucHienDangNhap() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String error = null;
		
		if (JSONConnector.getInstance().checkLogin(new Account(username, password))) {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
		} else {
			error = "Tên đăng nhập hoặc mật khẩu không đúng!";
		}
		
		if (error == null) {
			request.setAttribute("noti", "Đăng nhập thành công");
		} else {
			request.setAttribute("error", error);
		}
			
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp");
		dispatcher.forward(request, response);
	}

}