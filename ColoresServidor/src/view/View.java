package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class View extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel; 
	private JLabel label;

	
	/**
	 * Create the frame.
	 */
	public View(){
		
	
		setBounds(100, 100, 254, 143);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		lblNewLabel = new JLabel("Cantidad de clientes conectados:");
		
		label = new JLabel("0");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(37, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(32))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							.addGap(96))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(18)
					.addComponent(label)
					.addContainerGap(37, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
	}


	public JLabel getLblNewLabel()
	{
		return lblNewLabel;
	}


	public void setLblNewLabel(JLabel lblNewLabel)
	{
		this.lblNewLabel = lblNewLabel;
	}


	public JLabel getLabel()
	{
		return label;
	}


	public void setLabel(JLabel label)
	{
		this.label = label;
	}
}
