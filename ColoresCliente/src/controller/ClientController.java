package controller;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import view.AgregarView;
import view.ConsultarView;
import view.View;
import model.Color;
import model.User;

public class ClientController {
	
	public final static int PORT = 6500; 
	public final static String ALMACENAR = "ALMACENAR";
	public final static String PEDIR_COLORES = "PEDIR";
	public final static String NUEVO = "NUEVO";
	public final static String EXISTENTE = "EXISTENTE";

	private static User user; 
	private static View view;
	private static AgregarView agregarView; 
	private static ConsultarView consultarView; 
	private static Socket socket; 
	private static BufferedReader reader; 
	private static PrintWriter writter; 
	
	
	public ClientController(){
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args){
		// TODO Auto-generated method stub
		comunicacionServidor();
		String nombre = JOptionPane.showInputDialog("Bienvenido a AppColores. Por favor, ingrese su nombre:"); 
		if(nombre == null) { 
			System.exit(0);
		}
		writter.println(nombre);
		user = new User(nombre); 
		registrarColores();
		view = new View(); 
		agregarView = new AgregarView(); 
		consultarView = new ConsultarView();
		view.setVisible(true); 
		windowsListeners();
		btnsListeners();
	
		
	}
	public static void btnsListeners() { 
		btnAgregarColorListener();
		btnConsultarColoresListener(); 
		btnProbarListener();
		btnEnviarListener();
		btnMenuListener();
	}
	public static void windowsListeners() { 
		windowListener(); 
		windowListener2();
		windowListener3();
	}
	public static void registrarColores() { 
		writter.println(PEDIR_COLORES);
		try{
			String respuesta = reader.readLine(); 
			if(respuesta.equals(NUEVO)) { 
				JOptionPane.showMessageDialog(null,"Usuario nuevo, por avor ingrese sus colores favorito", "Mensaje",JOptionPane.INFORMATION_MESSAGE);
			}
			if(respuesta.equals(EXISTENTE)) { 
				int size = Integer.parseInt(reader.readLine());
				for (int i = 0; i < size; i++){
					String color = reader.readLine(); 
					String [] arrayColor = color.split(",");
					int r = Integer.parseInt(arrayColor[0]);
					int g= Integer.parseInt(arrayColor[1]);
					int b = Integer.parseInt(arrayColor[2]);
					Color theColor = new Color(r, g, b);
					user.getColors().add(theColor);
				}				
			}
		}catch(NumberFormatException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(IOException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private static void comunicacionServidor() {
		try{
			socket = new Socket(InetAddress.getLocalHost(), PORT);
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writter = new PrintWriter(socket.getOutputStream(),true);
		}catch(Exception e){
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "No hay ningun servidor en linea","Mensaje",JOptionPane.INFORMATION_MESSAGE);
		}	
	}
	public static void windowListener() { 
		view.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {	
				System.exit(0);
			}
		});
	}
	public static void windowListener2() { 
		agregarView.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {	
				System.exit(0);
			}
		});
	}
	public static void windowListener3() { 
		consultarView.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {	
				System.exit(0);
			}
		});
	}
	//principal view
	public static void btnAgregarColorListener() { 
		view.getBtnAgregarColor().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				view.setVisible(false);
				agregarView.setVisible(true);
			}
		});
	}
	public static void btnConsultarColoresListener() { 
		view.getBtnBuscarColor().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				view.setVisible(false);
				ArrayList<Color> colors = user.getColors(); 
				for(int i =0; i<colors.size();i++) { 
					Color color = colors.get(i); 
					addBtnColor(color.getR(), color.getG(), color.getB());
				}
				consultarView.setVisible(true);
			}
		});
	}
	public static void addBtnColor(int r, int g, int b){
		JButton btn = new JButton();
		btn.setText(r+","+g+","+b);
		btn.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn.setBackground(new java.awt.Color(r, g, b));
		consultarView.getPanel().add(btn);
	}
	//agregar view 
	public static void btnProbarListener() { 
		agregarView.getBtnProbar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				// TODO Auto-generated method stub
				int r = Integer.parseInt(agregarView.getTextField().getText());
				int g = Integer.parseInt(agregarView.getTextField_1().getText());
				int b = Integer.parseInt(agregarView.getTextField_2().getText());
				java.awt.Color color = new java.awt.Color(r, g, b);
				agregarView.getBtnEnviar().setBackground(color);
				
			}
		});
	}
	public static void btnEnviarListener() { 
		agregarView.getBtnEnviar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				// TODO Auto-generated method stub
				int r = Integer.parseInt(agregarView.getTextField().getText());
				int g = Integer.parseInt(agregarView.getTextField_1().getText());
				int b = Integer.parseInt(agregarView.getTextField_2().getText());
				writter.println(ALMACENAR);
				writter.println(r+"");
				writter.println(g+"");
				writter.println(b+"");
				JOptionPane.showMessageDialog(null, "Color agregado correctamente","Mensaje",JOptionPane.INFORMATION_MESSAGE);
				agregarView.getTextField().setText("");
				agregarView.getTextField_1().setText("");
				agregarView.getTextField_2().setText(""); 	
				agregarView.setVisible(false);
				view.setVisible(true);
			}
		});
	}
	//consultar view 
	public static void btnMenuListener() { 
		consultarView.getBtnMenu().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				// TODO Auto-generated method stub
				consultarView.setVisible(false); 
				view.setVisible(true);
			}
		});
	}
}
