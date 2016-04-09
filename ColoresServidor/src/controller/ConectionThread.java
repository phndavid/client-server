package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ConectionThread extends Thread  {

	public final static String ALMACENAR = "ALMACENAR";
	public final static String PEDIR_COLORES = "PEDIR";
	public final static String NUEVO = "NUEVO";
	public final static String EXISTENTE = "EXISTENTE";
	
	@SuppressWarnings("unused")
	private Socket socket; 
	private BufferedReader reader; 
	private PrintWriter writter; 
	private ServerController server; 
	
	public ConectionThread(Socket socket, ServerController serverController){
		// TODO Auto-generated constructor stub
		this.server = serverController; 
		this.socket = socket; 
		try{
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writter = new PrintWriter(socket.getOutputStream(), true);
		}catch(IOException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void run() { 
		try{
			String nombre = reader.readLine(); 
			while(true) { 
				String peticion = reader.readLine();
				if(peticion.equals(PEDIR_COLORES)) { 
					ArrayList<String> colours = server.leerArchivoXML(nombre);
					int size = colours.size(); 
					if(size ==0) {
						writter.println(NUEVO);
					}else { 
						writter.println(EXISTENTE);
						writter.println(colours.size());
						for(int i=0; i<colours.size();i++) { 
							String theColor = colours.get(i);
							writter.println(theColor);
						}											
					}
				}
				if(peticion.equals(ALMACENAR)) { 
					String r = reader.readLine(); 
					String g = reader.readLine(); 
					String b = reader.readLine(); 
					server.almacenarColorEnXml(nombre, r, g, b);
				}
			}
		}catch(NumberFormatException ex) { 
			ex.printStackTrace();
		}catch(Exception e){
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Se ha desconectado un cliente","Mensaje",JOptionPane.INFORMATION_MESSAGE);
			server.getModel().setCantidadClientes(server.getModel().getCantidadClientes()-1);
			server.getView().getLabel().setText(server.getModel().getCantidadClientes() +"");
		}
	}

}
