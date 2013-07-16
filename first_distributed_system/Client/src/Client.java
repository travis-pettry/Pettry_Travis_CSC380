import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import sun.misc.Regexp;


public class Client{

	static final String HOST = "localhost";
	static final int PORT = 8181;
	
	private InputStream in;
	private OutputStream out;
	
	private BufferedReader reader;
	private OutputStreamWriter writer;
	
	private Socket socket;
	
	private Scanner scan;
	
	private String[] methods;
	private boolean hasClass = false;
	
	public Client() throws UnknownHostException, IOException {
		socket = new Socket(HOST, PORT);
		
		in = socket.getInputStream();
		out = socket.getOutputStream();
		
		reader = new BufferedReader(new InputStreamReader(in));
		writer = new OutputStreamWriter(out);
		
		scan = new Scanner(System.in);
		
		askForClass();
	}
	
	private void askForClass(){
		
		try {
			writer.write("-1,\n");
			writer.flush();
			String mes = reader.readLine();
			String[] m = mes.split(";");
			
			System.out.println("Pick a class");
			printStuff(m);
			scan = new Scanner(System.in);
			int temp = scan.nextInt();
			
			writer.write("-2," + temp + "\n");
			writer.flush();
			String t = reader.readLine();
			//System.out.println(t);
			
		} catch (IOException e) {e.printStackTrace();}
		fillMethods();
		
	}
	
	private void fillMethods(){
		
		try {
			writer.write("0,\n");
			writer.flush();
			String mes = reader.readLine();
			System.out.println(mes + "messsss");
			methods = mes.split(";");
		} catch (IOException e) {e.printStackTrace();}
		operate();
	}
	
	private void printStuff(String[] data){
		for(int i = 0; i < data.length; i++){
			System.out.println(i+1 + ") " + data[i]);
		}
		System.out.println((data.length + 1) + ") Quit");
	}
	
	public void operate(){
		int option;
		String result;
		
		printMenu();
		scan = new Scanner(System.in);
		option = scan.nextInt();
		
		String args = "";
		hasClass = true;
		while(option != methods.length + 1){		
			if(!hasClass){
				args = "0," + option + "\n";
				hasClass = true;
			}
			else{
				args = option +"," + getArgs(option) + "\n";	
			}
			
			try {
				System.out.println(" args: " + args );
				writer.write(args);
				writer.flush();
				result = reader.readLine();
				System.out.println("The result is " + result);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			printMenu();
			scan = new Scanner(System.in);
			option = scan.nextInt();			
		}
	}
	
	private void printMenu(){
		System.out.println("Please enter a number");
		for(int i = 0; i < methods.length; i++){
			System.out.println(i+1 + ") " + methods[i]);
		}
		System.out.println((methods.length + 1) + ") Quit");
	}
	
	private String getArgs(int option){
		
		String method = methods[option - 1];
		String arg = "";
		
		Pattern regex = Pattern.compile("\\(([\\w,\\[\\]]+)\\)");
		
		Matcher match = regex.matcher(method);
		
		while(match.find()){
			for(int i = 0; i < match.groupCount(); i++){
				arg = match.group(i);
			}
		}
		arg = arg.substring(1, arg.length() - 1);
		
		String result = "";
		
		if(arg.contains("[")){
			result = getArrayArgs(arg.substring(0,arg.length() - 2));
		}
		else{
			String[] args = arg.split(",");			
			result = obtainArgs(args);		
		}
		return result;
	}

	public static void main(String[] args) throws UnknownHostException, IOException {
		new Client();
	}
	
	private String getArrayArgs(String type){
		
		String input = "";
		String result = "";
		
		while(!input.toLowerCase().equals("no")){
			result += switchedInput(type);
			System.out.println("Do you have more input? (yes or no)");
			scan = new Scanner(System.in);
			input = scan.nextLine();
		}
		
		return result;
	}
	
	private String switchedInput(String data){
		String result = "";
		
		switch(data){
		
			case "int":
				result += "I" + getInt() + ",";
				break;
				
			case "String":
				result += "S" + getString() + ",";
				break;
				
			case "double":
				result += "D" + getDouble() + ",";
				break;
				
			case "char":
				result += "C" + getChar() + ",";
				break;
				
			case "float":
				result += "F" + getFloat() + ",";
				break;
				
			case "long":
				result += "L" + getLong() + ",";
				break;
				
			case "boolean":
				result += "B" + getBoolean() + ",";
				break;				
	}
		
		return result;
	}
	
	private String obtainArgs(String[] args){
		String result = "";
		
		for(String d : args){
			result += switchedInput(d);
		}				
		return result;
	}
	
	private int getInt(){
		int result = 0;
		
		while(true){
			try{
				System.out.println("please enter an int.");
				scan = new Scanner(System.in);
				result = scan.nextInt();
				break;
			}
			catch(Exception e){
				System.out.println("That was incorrect!");
			}
		}
		return result;
	}
	
	private double getDouble(){
		double result = 0;
		
		while(true){
			try{
				System.out.println("please enter an double.");
				scan = new Scanner(System.in);
				result = scan.nextDouble();
				break;
			}
			catch(Exception e){
				System.out.println("That was incorrect!");
			}
		}
		return result;
	}
	
	private float getFloat(){
		float result = 0;
		
		while(true){
			try{
				System.out.println("please enter a double.");
				scan = new Scanner(System.in);
				result = scan.nextFloat();
				break;
			}
			catch(Exception e){
				System.out.println("That was incorrect!");
			}
		}
		return result;
	}
	
	private boolean getBoolean(){
		boolean result = false;
		
		while(true){
			try{
				System.out.println("please enter a boolean.");
				scan = new Scanner(System.in);
				result = scan.nextBoolean();
				break;
			}
			catch(Exception e){
				System.out.println("That was incorrect!");
			}
		}
		return result;
	}
	
	private char getChar(){
		int result = 'c';
		
		while(true){
			try{
				System.out.println("please enter a char.");
				scan = new Scanner(System.in);
				result = scan.nextLine().toCharArray()[0];
				break;
			}
			catch(Exception e){
				System.out.println("That was incorrect!");
			}
		}
		return (char) result;
	}
	
	private long getLong(){
		long result = 0;
		
		while(true){
			try{
				System.out.println("please enter a long.");
				scan = new Scanner(System.in);
				result = scan.nextLong();
				break;
			}
			catch(Exception e){
				System.out.println("That was incorrect!");
			}
		}
		return result;		
	}
	
	private String getString(){
		String result = "";
		
		while(true){
			try{
				System.out.println("please enter a string.");
				scan = new Scanner(System.in);
				result = scan.nextLine();
				break;
			}
			catch(Exception e){
				System.out.println("That was incorrect!");
			}
		}
		return result;
	}

}