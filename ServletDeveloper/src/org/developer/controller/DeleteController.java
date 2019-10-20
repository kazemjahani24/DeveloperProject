package org.developer.controller;

import java.io.IOException;
import java.net.URL;
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

public class DeleteController extends HttpServlet{

	private static final long serialVersionUID = 938200474606565611L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.valueOf(request.getParameter("id"));
		System.out.println("id: "+id);
		
		DeveloperRepository.delete(id);			//deleting data using id

		URL url = new URL(request.getRequestURL().toString());
		String scheme = url.getProtocol();
		String host  = url.getHost();
		String contextPath = request.getContextPath();
		
		int portNumber = request.getServerPort();
		
		String redirectUrl = scheme +"://"+host+":"+portNumber+contextPath+"/find";
		
		System.out.println("redirectUrl: "+redirectUrl);
		
		response.sendRedirect(redirectUrl); 		//redirecting to find all url
		
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
