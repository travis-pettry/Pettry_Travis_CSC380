import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class Server {

	ServerSocket ss;
	int port;
	List<ClientThread> clients;
	MathLogic logic;
	
	public Server(int port) {
		try{
			this.port = port;
			clients = new ArrayList<ClientThread>();
			
			ss = new ServerSocket(port);
			
			logic = new MathLogic();
			
			listen();
			}
		catch(Exception e){e.printStackTrace();}
	}
	
	private void listen() throws IOException{
		while(true){
			Socket clientSocket = ss.accept();
			System.out.println("A new client has connected");
			ClientThread ct = new ClientThread(clientSocket, logic);
			clients.add(ct);
		}
	}

}
