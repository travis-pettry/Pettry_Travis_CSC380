import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class Client{

	static final String HOST = "localhost";
	static final int PORT = 8080;
	
	private InputStream in;
	private OutputStream out;
	
	private BufferedReader reader;
	private OutputStreamWriter writer;
	
	private Socket socket;
	
	private Scanner scan;
	
	public Client() throws UnknownHostException, IOException {
		socket = new Socket(HOST, PORT);
		
		in = socket.getInputStream();
		out = socket.getOutputStream();
		
		reader = new BufferedReader(new InputStreamReader(in));
		writer = new OutputStreamWriter(out);
		
		scan = new Scanner(System.in);
		
		operate();
	}
	
	public void operate(){
		int option, num1, num2, result;
		
		printMenu();
		option = scan.nextInt();
		
		while(option != 3){
			printMenu2(1);
			num1 = scan.nextInt();
			printMenu2(2);
			num2 = scan.nextInt();
			
			try {
				writer.write(option + "," + num1 + "," + num2 + "\n");
				result = reader.read();
				System.out.println("The result is " + result);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	private void printMenu(){
		System.out.println("Please enter a number");
		System.out.println("1) Add");
		System.out.println("2) Subtract");
		System.out.println("3) Quit");
	}
	
	private void printMenu2(int num){
		String val = (num == 1)? "first" : "second";
		System.out.println("What is the " + val + " number");
	}

	public static void main(String[] args) throws UnknownHostException, IOException {
		new Client();
	}

}