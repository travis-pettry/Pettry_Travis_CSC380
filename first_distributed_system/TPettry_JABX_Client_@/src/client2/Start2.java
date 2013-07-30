package client2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class Start2 {

	Scanner scan;
	OutputStream out;
	InputStream in;
	
	BufferedReader read;
	OutputStreamWriter write;
	
	Socket socket;
	
	public Start2() {
		try {
//			scan = new Scanner(System.in);
//			socket = new Socket("localhost", 8080);
//			in = socket.getInputStream();
//			out = socket.getOutputStream();
//			
//			read = new BufferedReader(new InputStreamReader(in));
//			write = new OutputStreamWriter(out);
			
//			write.write("GET http://localhost:8080/TPettry_JABX_3/ HTTP/1.1\n\n");
//			write.flush();
//			String temp = "";
//			
//			while(true){
//				int f = read.read();
//				if(f != -1){
//					temp += (char) f;
//				}
//				else{
//					break;
//				}
//				
//			}
//			String[] res = temp.split("\n");
//			String result = res[res.length-1] +"\n";
			File xml = new File("NewFile.xml");//File.createTempFile("xml", ".xml");
			
//			FileReader fr = new FileReader(xml);
			//	        FileWriter fw = new FileWriter(xml);
//	        fw.write(result);
//	        fw.flush();
			
			JAXBContext jc = JAXBContext.newInstance(Resturants.class);
	        Unmarshaller unmarshaller = jc.createUnmarshaller();	        
	        Resturants tests = (Resturants) unmarshaller.unmarshal(xml);

	        System.out.println("");
		} 
		catch (Exception e) {e.printStackTrace();}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args){
		new Start2();
	}

}
