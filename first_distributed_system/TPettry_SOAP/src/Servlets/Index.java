package Servlets;

import response.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: tpettry
 * Date: 7/31/13
 * Time: 5:53 PM
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(name = "index", urlPatterns = "/restaurants")
public class Index extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            File xml = File.createTempFile("xml", ".xml");//new File("C:\\Users\\tpettry\\Documents\\Java3\\Pettry_Travis_CSC380\\first_distributed_system\\TPettry_SOAP\\reasources\\getAllRestruantsResponse.xml");

            FileWriter fw = new FileWriter(xml);


            BufferedReader reader = request.getReader();

            int t = reader.read();
            String data = "";
            while(t != -1){
                data += (char)t;
                t = reader.read();
            }
            System.out.println(data + " data");
//            System.out.println(reader.read());
            fw.write(data+"\n");
            fw.flush();
            JAXBContext jc = JAXBContext.newInstance("jaxb.restaurant");
            Unmarshaller un = jc.createUnmarshaller();

            jaxb.restaurant.Envelope en = (jaxb.restaurant.Envelope) un.unmarshal(xml);//equest.getInputStream());

            String result = "";

            if(en.getBody().getGetAllResturants() instanceof jaxb.restaurant.GetAllResturants){
                result = getAllResturantData();
                response.getWriter().write(result);
                response.getWriter().flush();
            }


        }
        catch(Exception e){e.printStackTrace();}
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private String getAllResturantData(){
        String data = "";
        try{
            File f = new File(this.getClass().getClassLoader().getResource("getAllRestruantsResponse.xml").toURI());

            Scanner scan = new Scanner(f);

            while(scan.hasNextLine()){
                data += scan.nextLine();
            }

        }
        catch(Exception e){e.printStackTrace();}

        return data;
    }
}