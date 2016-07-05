package ar.com.greenleave.pyme_managment.pymeManagmentDesktop.viewDesktop.ui.controller;

import javax.swing.JOptionPane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.greenleave.pyme_managment.pymeManagmentDesktop.viewDesktop.DTO.UserDTO;
import ar.com.greenleave.pyme_managment.pymeManagmentDesktop.viewDesktop.services.JsonService;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

@Service
public class LoginController extends BasicScreenController
{
	@Autowired(required=true)
    protected JsonService jsonService;
	
	private static final Logger log = LoggerFactory.getLogger(LoginController.class);
    
	@FXML 
    private TextField txtUserName;
    @FXML 
    private PasswordField pwdLoginPass;
    @FXML 
    private Label messageLabel;
    @FXML
    private Hyperlink hlkMensegeNewUser;
    
    
    public void login() {
        String userName = txtUserName.getText();
        String password = pwdLoginPass.getText();
        UserDTO usuarioALoguearse= new UserDTO();
        usuarioALoguearse.setUserName(userName);
        usuarioALoguearse.setPassword(password);
        String json = jsonService.toJson(usuarioALoguearse);
        log.error(json);
    }
    
    
    
    public void createNewUser(){
    	JOptionPane.showInputDialog(this, "Sarasa");
    }

	@Override
	public void inicializarce(String json) {
		/**
		 * No se inicializa el login
		 */
		this.setTitulo("Login Pyme Managment");
	}

}
