package controller;


import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import view.View;
import model.Servidor;


public class ServerController {
	
	private static Server server; 
	private static Servidor model; 
	private static View view; 

	public ServerController(){
		model = new Servidor(); 
		server = new Server(this);
	}
	public static void main(String[] args){
		view = new View(); 
		view.setVisible(true); 
		new ServerController();
		windowListener();
		iniciarAtencionDelServidor();
	}
	public static void windowListener() { 
		view.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {	
				System.exit(0);
			}
		});
	}
	public static void iniciarAtencionDelServidor(){
		if(server != null){
			try{
				server.iniciarAtencionDelServidor();;
			}catch(Exception excep){
				JOptionPane.showMessageDialog(null,
						"Se ha interrumpido la atencion del servidor.\n\nPosible Causa:\n"
								+ excep.getMessage());
			}
		}
	}
	public void almacenarColorEnXml(String user, String r, String g, String b) { 
		try{
			SAXBuilder saxBuilder = new SAXBuilder(); 
			File file =new File("./xml/prueba.xml");
			Document document = saxBuilder.build(file);
			Element rootNode = document.getRootElement(); 
			List<Element> mensajeriaList = rootNode.getChildren("usuario");
			int size = mensajeriaList.size();
			Element theElement = null; 
			int index = 0;
			for(int i=0; i<size;i++) { 
				Element element = mensajeriaList.get(i); 
				String theName = element.getChildText("nombre");
				if(user.equalsIgnoreCase(theName)) { 
					index = i; 
					theElement = element; 
				}
			}
			theElement.addContent(new Element("color").setText(r + "," + g + "," + b));
			mensajeriaList.remove(index);
			mensajeriaList.add(index,theElement);
			
			XMLOutputter xmlOutputter = new XMLOutputter(); 
			xmlOutputter.setFormat(Format.getPrettyFormat());
			xmlOutputter.output(document,new FileWriter("./xml/prueba.xml"));
		}catch(JDOMException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(IOException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	public ArrayList<String> leerArchivoXML(String name) { 
		ArrayList<String> theColours = new ArrayList<String>();
		try{
			SAXBuilder saxBuilder = new SAXBuilder(); 
			File file =new File("./xml/prueba.xml");
			Document document = saxBuilder.build(file);
			Element rootNode = document.getRootElement(); 
			List<Element> mensajeriaList = rootNode.getChildren("usuario");
			int size = mensajeriaList.size();
			Element theElement = null;
			boolean loEncontro=false; 
			for(int i=0; i<size;i++) { 
				Element element = mensajeriaList.get(i); 
				String theName = element.getChildText("nombre");
				if(name.equalsIgnoreCase(theName)) { 
					theElement = element; 
					loEncontro=true; 
				}
			}
			if(loEncontro) { 
				List<Element> colors = theElement.getChildren("color");
				int colorsSize = colors.size();
				for (int j = 0; j < colorsSize; j++){
					Element theElement2 = colors.get(j); 
					String theColor = theElement2.getValue();
					theColours.add(theColor);
				}				
			}else { 
				Element newUser = new Element("usuario");
				newUser.addContent(new Element("nombre").setText(name));
				mensajeriaList.add(newUser);
				XMLOutputter xmlOutputter = new XMLOutputter(); 
				xmlOutputter.setFormat(Format.getPrettyFormat());
				xmlOutputter.output(document,new FileWriter("./xml/prueba.xml"));
			}
		}catch(JDOMException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(IOException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return theColours; 
	}
	public Server getServer(){
		return server;
	}
	public Servidor getModel(){
		return model;
	}
	public View getView(){
		return view;
	}
}
