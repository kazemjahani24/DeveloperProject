package org.developer.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.developer.model.Developer;
import org.developer.repository.DeveloperRepository;

public class CreateController extends HttpServlet {
   

	private static final long serialVersionUID = -5685290100446284658L;


	public CreateController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("CreateController doget ---------------------------");
		RequestDispatcher dispatcher  = request.getRequestDispatcher("/add-developer.jsp");
		dispatcher.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");
		String position = request.getParameter("position");
		String task = request.getParameter("task");
		String dobString = request.getParameter("dob");
		String fatherName = request.getParameter("fatherName");
		String email = request.getParameter("email");
		
		DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		
		Developer dev = new Developer();
		
		 try {
		     Date dob = formatter.parse(dobString);
		     System.out.println(dob);
		     System.out.println(formatter.format(dob));
		     dev.setDob(dob);
	     } 
		 catch (ParseException e) {
			 e.printStackTrace();
	     }
		 
		dev.setName(name);
		dev.setPosition(position);
		dev.setTask(task);
		dev.setFatherName(fatherName);
		dev.setEmail(email);
		
		dev = DeveloperRepository.addDeveloper(dev);
		
		RequestDispatcher dispatcher = null;
	
		if(dev!=null) {
			dispatcher = request.getRequestDispatcher("success.jsp");
		}
		else {
			dispatcher = request.getRequestDispatcher("error.jsp");
		}
		dispatcher.forward(request, response);
	}

}
