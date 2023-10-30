package com.kh.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.dao.MemberDAO;


@WebServlet("/emailCheck")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String email = request.getParameter("email");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter resp = response.getWriter();
		MemberDAO dao = new MemberDAO();
		
		try {
			boolean result = dao.isEmailExist(email);
			if(result) {
				resp.println("이미 사용중인 email 입니다.");
			}else {
				resp.println("사용 가능한 email 입니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.println("조회하는 도중 오류가 발생했습니다");			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}