import java.io.IOException;


public class Start {
	
	Server server;

	public Start() throws IOException {
		server = new Server(8181);
	}

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		new Start();
	}

}
