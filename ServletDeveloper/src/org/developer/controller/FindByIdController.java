package org.developer.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.developer.model.Developer;
import org.developer.repository.DeveloperRepository;

public class FindByIdController extends HttpServlet {

	private static final long serialVersionUID = 6329756506045033617L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.valueOf(request.getParameter("id"));
		
		System.out.println("id: "+id);
		
		Developer developer = DeveloperRepository.findById(id);
		
		request.setAttribute("developer", developer);		
		
		RequestDispatcher dispatcher  = request.getRequestDispatcher("/details.jsp");
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
