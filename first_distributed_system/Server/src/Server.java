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
	
	public Server(int port) throws IOException {
		this.port = port;
		clients = new ArrayList<ClientThread>();
		
		ss = new ServerSocket(port);
		
		logic = new MathLogic();
		
		listen();
	}
	
	private void listen() throws IOException{
		while(true){
			Socket clientSocket = ss.accept();
			ClientThread ct = new ClientThread(clientSocket, logic);
			clients.add(ct);
		}
	}

}
