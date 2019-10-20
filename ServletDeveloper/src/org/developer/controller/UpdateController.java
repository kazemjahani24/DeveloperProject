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

public class UpdateController extends HttpServlet{

	private static final long serialVersionUID = 938200474606565611L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.valueOf(request.getParameter("id"));
		System.out.println("id: "+id);
		
		Developer developer = DeveloperRepository.findById(id);

		String dobString = "";
		
		if(developer!=null) {
			
			Date dob = developer.getDob();
			if(dob!=null) {
				DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
				dobString = formatter.format(dob);
				System.out.println(dobString);
			}
			
		}
		
		request.setAttribute("developer", developer);
		request.setAttribute("dobString", dobString);
		RequestDispatcher dispatcher  = request.getRequestDispatcher("/update.jsp");
		dispatcher.forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.valueOf(request.getParameter("id"));
		String name = request.getParameter("name");
		String position = request.getParameter("position");
		String task = request.getParameter("task");
		String dobString = request.getParameter("dob");
		String fatherName = request.getParameter("fatherName");
		String email = request.getParameter("email");
		
		DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		
		Developer developer = DeveloperRepository.findById(id);
		
		 try {
		     Date dob = formatter.parse(dobString);
		     System.out.println(dob);
		     System.out.println(formatter.format(dob));
		     developer.setDob(dob);
	     } 
		 catch (ParseException e) {
			 e.printStackTrace();
	     }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		 developer.setName(name);
		 developer.setPosition(position);
		 developer.setTask(task);
		 developer.setFatherName(fatherName);
		 developer.setEmail(email);
		 DeveloperRepository.update(developer);
		 
		 RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");
		 dispatcher.forward(request, response);
	}
	
}
