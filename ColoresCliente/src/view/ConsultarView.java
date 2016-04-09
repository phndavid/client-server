package view;



import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import javax.swing.JLabel;

import java.awt.Dimension;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;


public class ConsultarView extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 307669761956169950L;
	private JScrollPane colorsJSP;
	private JPanel panel;
	private JButton btnMenu;
	
	public ConsultarView() {
		getContentPane().setBackground(new Color(255, 255, 255));
		setTitle("Colors");
		setSize(400, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblColors = new JLabel("Colors");
		lblColors.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblColors.setBounds(155, 11, 73, 25);
		getContentPane().add(lblColors);
		
		btnMenu = new JButton("Menu");
		btnMenu.setBackground(new Color(192, 192, 192));
		btnMenu.setBounds(10, 11, 89, 23);
		getContentPane().add(btnMenu);
		panel = new JPanel();
		panel.setLayout(new GridLayout(10,1));
		int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
	    int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER; 
	    colorsJSP =new JScrollPane(panel,v,h);
	    colorsJSP.setBounds(20, 45, 343, 105);	    
	    getContentPane().add(colorsJSP);
		center();
	}
	private void center()
	{
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int xEsquina = (screen.width - getWidth()) / 2;
		int yEsquina = (screen.height - getHeight()) / 2;
		setLocation(xEsquina, yEsquina);
	}
	public JButton getBtnMenu(){
		return btnMenu;
	}
	public JPanel getPanel(){
		return panel;
	}
}
