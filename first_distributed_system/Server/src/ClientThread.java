
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ClientThread extends Thread{
	
	private Socket socket;
	private InputStream in;
	private OutputStream out;
	
	private BufferedReader reader;
	private OutputStreamWriter writer;
	
	private MathLogic logic;
	private Class<? extends MathLogic> math;
	
	private Class<?> chosenClass;
	private List<Class<?>> classes;

	public ClientThread(Socket socket, MathLogic logic) {
		this.socket = socket;
		this.logic = logic;
		math = this.logic.getClass();
		
		try{
			in = this.socket.getInputStream();
			out = this.socket.getOutputStream();		
			
			reader = new BufferedReader(new InputStreamReader(in));
			writer = new OutputStreamWriter(out);
		}
		catch(Exception e){e.printStackTrace();}
		
		classes = new ArrayList<Class<?>>();
		
		Scanner scan;
		try {
			scan = new Scanner(new File(this.getClass().getClassLoader().getResource("classes.txt").toURI()));
			while(scan.hasNext()){
				try {
					String t = scan.nextLine();
					classes.add(Class.forName(t));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		this.start();
	}
	
	public void run(){
		String result;
		while(true){
			try{
				String read = reader.readLine();
				System.out.println("reding in data: " + read);
				String[] info = read.split(",");
				result = handleInfo(info);
				System.out.println(" hererereree " + result);
				writer.write(result);
				writer.flush();
			
			}
			catch(SocketException e1){System.out.println("The client left... :'(");break;}
			catch(Exception e){e.printStackTrace(); break;}
		}
	}
	
	private String handleInfo(String[] info){
		int type = Integer.parseInt(info[0]);
		
		List<Object> args = new ArrayList<Object>();
		
		for(int i = 1; i < info.length; i++){
			args.add(getObject(info[i]));
		}
		
		String result = "";
		
		if(type == 0){
			
			Method[] methods = chosenClass.getDeclaredMethods();
			List<String> methodNames = new ArrayList<String>();
			
			result = "";
			
			for(int i = 0; i < methods.length; i++){
				methodNames.add(methods[i].toString().replace("java.lang.String", "String").replace("java.lang.Object", "object").split("\\.")[1]);
				result += methods[i].toString().replace("java.lang.String", "String").replace("java.lang.Object", "object").split("\\.")[1] + ";";
			}
		}
		else if(type == -1){
			for(int i = 0;  i < classes.size(); i++){
				result += classes.get(i).toString() + ";";
			}
		}
		else if( type == -2){
			int classs = Integer.parseInt(info[1]) - 1;
			chosenClass = classes.get(classs);	
			try {
				result = ("you chose " + chosenClass.toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(type == -3){
			String obj = info[1].trim();
			
			try {
				Class c = Class.forName(obj);
				
				Constructor d = c.getConstructors()[0];
				
				String temp = "";
				
				Pattern regex = Pattern.compile("\\(([\\w,\\[\\]]+)\\)");
				
				Matcher match = regex.matcher(d.toString().replace("java.lang.String", "String").replace("java.lang.Object", "object"));
				
				while(match.find()){
					for(int i = 0; i < match.groupCount(); i++){
						temp = match.group(i);
					}
				}
				
				temp = temp.substring(1, temp.length() - 1);
				
				result = temp;
				
				
			} catch (ClassNotFoundException e) {e.printStackTrace();}
			
		}
		else{
			Method[] methods = chosenClass.getDeclaredMethods();
			Method method = methods[type - 1];
			
			
			try {
				
				Pattern regex = Pattern.compile("\\(([\\w,\\[\\]]+)\\)");
				
				Matcher match = regex.matcher(method.toString().replace("java.lang.String", "String").replace("java.lang.Object", "object").split("\\.")[1]);
				
				String arg2 = "";
				
				while(match.find()){
					for(int i = 0; i < match.groupCount(); i++){
						arg2 = match.group(i);
					}
				}
				
				String[] p = arg2.split(",");
				String obj = "";
				if(p.length == 1){
					obj = p[0].substring(1, p[0].length()-1);
				}
			
				if(!obj.equals("") && !obj.equals("int") && !obj.equals("int[]") && !obj.equals("String") && !obj.equals("String[]") && !obj.equals("boolean") && !obj.equals("booelan[]") && !obj.equals("float") && !obj.equals("float[]") && !obj.equals("char") && !obj.equals("char[]") && !obj.equals("long") && !obj.equals("long[]") ){
					Class c = Class.forName(obj.trim());
					
					Constructor con = c.getConstructors()[0];
					
					List<Object> pram = new ArrayList<Object>();
					
					for(int i = 1; i < info.length; i++){
						pram.add(getObject(info[i]));
					}
					
					Object o = con.newInstance(pram.toArray());
					
					Object res = method.invoke(chosenClass.newInstance(), o);
					
					System.out.println(res.toString());
					result = res.toString();
				}				
				else if(arg2.split(",").length > 1){
					System.out.println(method.toString() + " " + chosenClass.toString());
					for(Object d : args.toArray()){
						System.out.println(d instanceof Integer);
					}
					Object[] o = args.toArray();
					result = method.invoke(chosenClass.newInstance(), o) + "";					 
				}
				else{
					arg2 = arg2.substring(1, arg2.length()-3);
					Object[] t = args.toArray();
					switch(arg2.toLowerCase()){
						case "int":
							int[] temp = new int[t.length];
							
							for(int i = 0; i < t.length; i++){
								temp[i] = (int) t[i];
							}
							result = method.invoke(chosenClass.newInstance(), temp) + "";	
							break;
							
						case "double":
							double[] temp2 = new double[t.length];
							
							for(int i = 0; i < t.length; i++){
								temp2[i] = (double) t[i];
							}
							result = method.invoke(chosenClass.newInstance(), temp2) + "";	
							break;
							
						case "long":
							long[] temp3 = new long[t.length];
							
							for(int i = 0; i < t.length; i++){
								temp3[i] = (long) t[i];
							}
							result = method.invoke(chosenClass.newInstance(), temp3) + "";	
							break;
							
						case "float":
							float[] temp4 = new float[t.length];
							
							for(int i = 0; i < t.length; i++){
								temp4[i] = (float) t[i];
							}
							result = method.invoke(chosenClass.newInstance(), temp4) + "";	
							break;
							
						case "boolean":
							boolean[] temp5 = new boolean[t.length];
							
							for(int i = 0; i < t.length; i++){
								temp5[i] = (boolean) t[i];
							}
							result = method.invoke(chosenClass.newInstance(), temp5) + "";	
							break;
							
						case "string":
							String[] temp6 = new String[t.length];
							
							for(int i = 0; i < t.length; i++){
								temp6[i] = (String) t[i];
							}
							result = method.invoke(chosenClass.newInstance(), (Object[]) temp6) + "";	
							break;
							
						case "char":
							char[] temp7 = new char[t.length];
							
							for(int i = 0; i < t.length; i++){
								temp7[i] = (char) t[i];
							}
							result = method.invoke(chosenClass.newInstance(), temp7) + "";	
							break;
					}
				}
				
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("The result is: " + result);
		return (result + "\n");
	}
	
	private Object getObject(String data){
		
		String type = data.substring(0,1);
		Object result = new Object();
		
		switch(type){
			case "I":
				result = Integer.parseInt(data.substring(1, data.length()));
				break;
				
			case "S":
				result = data.substring(1, data.length());
				break;
				
			case "D":
				result = Double.parseDouble(data.substring(1, data.length()));
				break;
				
			case "C":
				result = data.substring(1, data.length()).toCharArray()[0];
				break;
				
			case "F":
				result = Float.parseFloat(data.substring(1, data.length()));
				break;
				
			case "L":
				result = Long.parseLong(data.substring(1, data.length()));
				break;
				
			case "B":
				result = Boolean.parseBoolean(data.substring(1, data.length()));
				break;
		}
		
		return result;
	}

}
