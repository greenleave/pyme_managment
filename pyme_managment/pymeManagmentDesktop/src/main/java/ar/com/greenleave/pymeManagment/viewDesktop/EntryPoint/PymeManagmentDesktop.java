package ar.com.greenleave.pymeManagment.viewDesktop.EntryPoint;

import java.awt.EventQueue;

import javax.swing.JFrame;

import ar.com.greenleave.pymeManagment.viewDesktop.widgets.login.LoginPanel;
import java.awt.GridBagLayout;

public class PymeManagmentDesktop {

	private JFrame frame;
	private LoginPanel loginPanel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PymeManagmentDesktop window = new PymeManagmentDesktop();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PymeManagmentDesktop() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 586, 353);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		//Login Panel;
		this.loginPanel= new LoginPanel();
		GridBagLayout gridBagLayout = (GridBagLayout) loginPanel.getLayout();
		gridBagLayout.columnWidths = new int[]{13, 13, 13, 106, 126, 128, 13, 13, 13};
		gridBagLayout.columnWeights = new double[]{126.0, 126.0, 126.0, 212.0, 252.0, 256.0, 126.0, 126.0, 126.0};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 1.0};
		gridBagLayout.rowHeights = new int[]{1, 1, 1, 1, 1, 1, 3, 1};
		loginPanel.setBounds(0, 0, 586, 348);
		this.loginPanel.setVisible(true);
		this.frame.getContentPane().add(this.loginPanel);
		
	}

}
