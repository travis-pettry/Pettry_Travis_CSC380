package Servlets;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Index2
 */
@WebServlet("/")
public class Index2 extends HttpServlet {
private static final long serialVersionUID = 1L;
	
       
    
    public Index2() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.addHeader("contextType", "text/xml");
		System.out.println("sup????????????");
		File file;
		try {
			file = new File(this.getClass().getClassLoader().getResource("Resturant.xml").toURI());
			response.setContentLength((int) file.length());
			
			Scanner scan = new Scanner(file);
			
			String result = "";
			
			while(scan.hasNextLine()){
				result += scan.nextLine();				
			}
			
			response.getWriter().write(result);
			response.getWriter().flush();
		} 
		catch (Exception e) {e.printStackTrace();}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("im here");
		InputStream in = request.getInputStream();
		BufferedReader d = request.getReader();
		
		int c = d.read();
		
		while(c != -1){
			System.out.print(c);
			c = d.read();
		}
		
		
	}

}
