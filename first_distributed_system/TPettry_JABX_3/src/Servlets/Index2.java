package Servlets;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

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
		try{
			BufferedReader reader = request.getReader();
			System.out.println("Im here");
			
			String r = reader.readLine();
			System.out.println(r);
			
			File xml = File.createTempFile("xml", ".xml");
			FileWriter fr = new FileWriter(xml);
			fr.write(r);
			fr.flush();
			
			JAXBContext jc = JAXBContext.newInstance("Servlets");
			Unmarshaller unmarsh = jc.createUnmarshaller();
			Resturants re = (Resturants) unmarsh.unmarshal(xml);
			
			
			response.getWriter().write("Thank you for your order! You ordered " + re.getResturant().get(0).getMenu().getMenuItem().get(0).getName() + " From: " + re.getResturant().get(0).getName());
			response.getWriter().flush();
		}
		catch(Exception e){e.printStackTrace();}
	}

}
