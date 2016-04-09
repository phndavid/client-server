package view;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class View extends JFrame {

	private JPanel contentPane;
	private JButton btnAgregarColor; 
	private JButton btnBuscarColor; 
	/**
	 * Create the frame.
	 */
	public View(){
		setTitle("AppColores");
		setBounds(100, 100, 408, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u00BFQu\u00E9 desea hacer?");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		
		btnAgregarColor = new JButton("Agregar Color");
		btnAgregarColor.setBackground(Color.BLUE);
		
		btnBuscarColor = new JButton("Consultar colores");
		btnBuscarColor.setBackground(Color.ORANGE);
		

		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\user\\Dropbox\\Universidad\\Programacion en Red\\ColoresCliente\\img\\colores-de-la-pintura-icono-4549-128.png"));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
							.addGap(33)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnBuscarColor, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnAgregarColor, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)))
						.addComponent(lblNewLabel))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(29)
					.addComponent(lblNewLabel)
					.addGap(50)
					.addComponent(btnAgregarColor)
					.addPreferredGap(ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
					.addGap(26)
					.addComponent(btnBuscarColor)
					.addGap(309))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(77)
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(301, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	public JButton getBtnAgregarColor(){
		return btnAgregarColor;
	}
	public JButton getBtnBuscarColor(){
		return btnBuscarColor;
	}
}
