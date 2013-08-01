package Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: tpettry
 * Date: 7/31/13
 * Time: 10:45 PM
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(name = "TakeOrder", urlPatterns = "/takeOrder/")
public class TakeOrder extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            JAXBContext jc = JAXBContext.newInstance("response");
            Unmarshaller un = jc.createUnmarshaller();
            response.Envelope en = (response.Envelope) un.unmarshal(request.getInputStream());

            response.getWriter().write("Thanks for your order! You ardered " + en.getBody().getResturantResponse().getResturants().getResturant().get(0).getMenu().getMenuItem().get(0).getName() + " From " + en.getBody().getResturantResponse().getResturants().getResturant().get(0).getName());
            response.getWriter().flush();
        }
        catch(Exception e){e.printStackTrace();}
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
