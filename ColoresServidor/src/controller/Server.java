package controller;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;




public class Server {
	
	public static final int PORT = 6500;
	
	private Socket socket;
	private ServerSocket serverSocket;
	private ServerController controller; 

	public Server(ServerController controller ){
		// TODO Auto-generated constructor stub
		try{
			this.controller = controller;
			serverSocket = new ServerSocket(PORT);
		}catch(IOException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void iniciarAtencionDelServidor() throws Exception { 
		int cantidadClientes = 0; 
		while(true){
			socket = serverSocket.accept();
			cantidadClientes++; 
			new ConectionThread(socket, controller).start();
			controller.getModel().setCantidadClientes(cantidadClientes);
			controller.getView().getLabel().setText(cantidadClientes + "");
		}
	}

}
