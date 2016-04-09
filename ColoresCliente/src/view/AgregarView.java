package view;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class AgregarView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnProbar;
	private JButton btnEnviar; 
	/**
	 * Create the frame.
	 */
	public AgregarView(){
		setBounds(100, 100, 256, 349);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblAgregarColor = new JLabel("AGREGAR COLOR");
		lblAgregarColor.setForeground(Color.ORANGE);
		lblAgregarColor.setFont(new Font("Tahoma", Font.ITALIC, 16));
		
		JLabel lblR = new JLabel("R:");
		lblR.setForeground(Color.RED);
		lblR.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblG = new JLabel("G:");
		lblG.setForeground(Color.GREEN);
		lblG.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblB = new JLabel("B:");
		lblB.setForeground(Color.BLUE);
		lblB.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		textField = new JTextField();
		textField.setForeground(Color.WHITE);
		textField.setBackground(Color.RED);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setForeground(Color.WHITE);
		textField_1.setBackground(Color.GREEN);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setForeground(Color.WHITE);
		textField_2.setBackground(Color.BLUE);
		textField_2.setColumns(10);
		
		btnProbar = new JButton("Probar");
		
		btnEnviar = new JButton("Enviar");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(50)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblB)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblG)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblR)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblAgregarColor, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGap(35)
							.addComponent(btnEnviar)
							.addPreferredGap(ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
							.addComponent(btnProbar)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(35)
					.addComponent(lblAgregarColor)
					.addGap(41)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblR)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblG)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblB)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnProbar)
						.addComponent(btnEnviar))
					.addGap(20))
		);
		contentPane.setLayout(gl_contentPane);
	}

	public JTextField getTextField(){
		return textField;
	}
	public JTextField getTextField_1(){
		return textField_1;
	}
	public JTextField getTextField_2(){
		return textField_2;
	}
	public JButton getBtnProbar(){
		return btnProbar;
	}

	public JButton getBtnEnviar(){
		return btnEnviar;
	}
}
