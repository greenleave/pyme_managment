package ar.com.greenleave.pyme_managment.main;

import java.awt.EventQueue;

import ar.com.greenleave.pyme_managment.view.Login.Login;

public class Main {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login.getInstance();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
