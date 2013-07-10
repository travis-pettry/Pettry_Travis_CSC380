import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;


public class ClientThread extends Thread{
	
	private Socket socket;
	private InputStream in;
	private OutputStream out;
	
	private BufferedReader reader;
	private OutputStreamWriter writer;
	
	private MathLogic logic;

	public ClientThread(Socket socket, MathLogic logic) {
		this.socket = socket;
		this.logic = logic;
		
		try{
			in = this.socket.getInputStream();
			out = this.socket.getOutputStream();		
			
			reader = new BufferedReader(new InputStreamReader(in));
			writer = new OutputStreamWriter(out);
		}
		catch(Exception e){e.printStackTrace();}	
		
		this.start();
	}
	
	public void run(){
		int result;
		while(true){
			try{
				String read = reader.readLine();
				String[] info = read.split(",");
				result = handleInfo(info);
				
				writer.write(result);
				writer.flush();
			
			}
			catch(Exception e){break;}
		}
	}
	
	private int handleInfo(String[] info){
		int type = Integer.parseInt(info[0]);
		int num1 = Integer.parseInt(info[1]);
		int num2 = Integer.parseInt(info[2]);
		
		int result;
		
		if(type == 1){
			result = logic.add(num1, num2);
		}
		else{
			result = logic.subtract(num1, num2);
		}
		
		return result;
	}

}
