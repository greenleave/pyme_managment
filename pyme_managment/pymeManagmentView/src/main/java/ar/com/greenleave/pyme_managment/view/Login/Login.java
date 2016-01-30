package ar.com.greenleave.pyme_managment.view.login;

import javax.swing.JFrame;

public class Login {

	private JFrame frame;
	private static Login instance;



	/**
	 * Create the application.
	 */
	private Login() {
		initialize();
	}
	
	public static Login getInstance(){
		if(Login.instance==null){
			instance= new Login();
		}else{
			instance.limpiarCampos();
		}
		instance.frame.setVisible(true);
		return instance;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	private void limpiarCampos(){
		
	}

}
