package ar.com.greenleave.pymeManagment.viewDesktop.widgets.login;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class LoginPanel extends JPanel {
	
	private static final long serialVersionUID = 7186092706817466481L;
	private JTextField txtUsuario;
	private JPasswordField passwordLogin;

	public LoginPanel() {
		this.inicializate();
	}
	
	private void inicializate(){
		this.setBackground(new Color(202, 224, 192));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 106, 126, 128, 13, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblUser = new JLabel("Usuario:");
		lblUser.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblUser = new GridBagConstraints();
		gbc_lblUser.anchor = GridBagConstraints.WEST;
		gbc_lblUser.insets = new Insets(0, 0, 5, 5);
		gbc_lblUser.gridx = 3;
		gbc_lblUser.gridy = 2;
		add(lblUser, gbc_lblUser);
		
		txtUsuario = new JTextField();
		GridBagConstraints gbc_txtUsuario = new GridBagConstraints();
		gbc_txtUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_txtUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUsuario.gridx = 5;
		gbc_txtUsuario.gridy = 2;
		add(txtUsuario, gbc_txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.WEST;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 3;
		gbc_lblPassword.gridy = 4;
		add(lblPassword, gbc_lblPassword);
		
		passwordLogin = new JPasswordField();
		GridBagConstraints gbc_passwordLogin = new GridBagConstraints();
		gbc_passwordLogin.insets = new Insets(0, 0, 5, 5);
		gbc_passwordLogin.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordLogin.gridx = 5;
		gbc_passwordLogin.gridy = 4;
		add(passwordLogin, gbc_passwordLogin);
		
		JButton btnNewButton = new JButton("Login");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 4;
		gbc_btnNewButton.gridy = 7;
		add(btnNewButton, gbc_btnNewButton);
		this.setVisible(true);
	}

}
