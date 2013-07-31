package Client;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: tpettry
 * Date: 7/29/13
 * Time: 10:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class Start {

    private List<Resturant> rest;
    private Resturant chosenRest;

    OutputStream out;
    InputStream in;

    BufferedReader read;
    OutputStreamWriter write;

    private Socket socket;

    public Start(){

        rest = new ArrayList<Resturant>();

        try{
            //File xml = new File("C:\\Users\\tpettry\\Documents\\Java3\\Pettry_Travis_CSC380\\first_distributed_system\\TPettry_JABX_Client\\src\\Client\\resturants.xml");

            socket = new Socket("localhost", 8080);
			in = socket.getInputStream();
			out = socket.getOutputStream();

			read = new BufferedReader(new InputStreamReader(in));
			write = new OutputStreamWriter(out);

			write.write("GET http://localhost:8080/TPettry_JABX_3/ HTTP/1.1\n\n");
			write.flush();
			String temp = "";

			while(true){
				int f = read.read();
				if(f != -1){
					temp += (char) f;
				}
				else{
					break;
				}

			}
			String[] res = temp.split("\n");
			String result = res[res.length-1] +"\n";
            System.out.println(result);
            File xml = File.createTempFile("xml", ".xml");

			FileReader fr = new FileReader(xml);
            FileWriter fw = new FileWriter(xml);
	        fw.write(result);
	        fw.flush();





            JAXBContext jc = JAXBContext.newInstance("Client");
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            Resturants tests = (Resturants) unmarshaller.unmarshal(xml);

            for(Resturant d : tests.getResturant()){
                rest.add(d);
            }

            System.out.println("Which resturant would you like to dine from?");
            for(int i = 0; i < rest.size(); i++){
                System.out.println(i + ") " + rest.get(i).getName());
            }
            Scanner scan = new Scanner(System.in);
            int input = scan.nextInt();
            chosenRest = rest.get(input);

            Menu menu = chosenRest.getMenu();

            for(int i = 0; i < menu.getMenuItem().size(); i++){
                System.out.println(i + ") " + menu.getMenuItem().get(i).getName() + " " + menu.getMenuItem().get(i).getDescription() + " " + menu.getMenuItem().get(i).getPrice());
            }

            input = scan.nextInt();

            MenuItem mi = menu.getMenuItem().get(input);
            System.out.println(mi.getName());
//
//            socket = new Socket("localhost", 8080);
//            in = socket.getInputStream();
//            out = socket.getOutputStream();
//
//            write = new OutputStreamWriter(out);
//            write.write("POST http://localhost:8080/TPettry_JABX_3/ HTTP/1.1\nhello world\n\n");
//            write.flush();

            //System.out.println("Start sending " + action + " request");
            URL url = new URL( "http://localhost:8080/TPettry_JABX_3/" );
            HttpURLConnection rc = (HttpURLConnection)url.openConnection();
            //System.out.println("Connection opened " + rc );
            rc.setRequestMethod("POST");
            rc.setDoOutput( true );
            rc.setDoInput( true );
            rc.setRequestProperty( "Content-Type", "text/xml; charset=utf-8" );
            String reqStr = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><resturants><resturant name=\""+ chosenRest.getName() +"\"><menu><menuItem name=\""+ mi.getName() +"\" price=\""+ mi.getPrice() +"\" description=\""+ mi.getDescription() + "\" /></menu></resturant></resturants>";  // the entire payload in a single String
            int len = reqStr.length();
            rc.setRequestProperty( "Content-Length", Integer.toString( len ) );
            rc.connect();
            OutputStreamWriter out = new OutputStreamWriter( rc.getOutputStream() );
            out.write( reqStr, 0, len );
            out.flush();
            System.out.println("Request sent, reading response ");
            InputStreamReader read = new InputStreamReader( rc.getInputStream() );
            StringBuilder sb = new StringBuilder();
            int ch = read.read();
            System.out.println(ch);
            while( ch != -1 ){
                sb.append((char)ch);
                ch = read.read();
            }
          //  response = sb.toString(); // entire response ends up in String
            read.close();
            rc.disconnect();
            System.out.println(sb.toString());
//
//            read = new BufferedReader(new InputStreamReader(in));
//            System.out.println(read.readLine());

        }
        catch(Exception e){e.printStackTrace();}
    }

    public static void main(String[] args) {
        new Start();
    }

}
