package org.developer.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.developer.model.Developer;
import org.developer.repository.DeveloperRepository;

public class FindController extends HttpServlet {
       
	private static final long serialVersionUID = 4193197244667767735L;

	public FindController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Developer> developerList = DeveloperRepository.findAll();
		
		request.setAttribute("developerList", developerList);		//sending value from servlet to jsp(in setAttribute, first one is the key and second one is value)
		
		RequestDispatcher dispatcher  = request.getRequestDispatcher("/developer-list.jsp");
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
