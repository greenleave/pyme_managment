package ar.com.greenleave.pyme_managment.pymeManagmentDesktop.viewDesktop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import ar.com.greenleave.pyme_managment.pymeManagmentDesktop.viewDesktop.MainApp;
import ar.com.greenleave.pyme_managment.pymeManagmentDesktop.viewDesktop.DTO.UserDTO;
import ar.com.greenleave.pyme_managment.pymeManagmentDesktop.viewDesktop.services.JsonService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

@Service("loginController")
public class LoginController
{
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private JsonService jsonService;
    @FXML 
    private TextField txtUserName;
    @FXML 
    private PasswordField pwdLoginPass;
    @FXML 
    private Label messageLabel;

    public void login() {

        String userName = txtUserName.getText();
        String password = pwdLoginPass.getText();
        UserDTO usuarioALoguearse= new UserDTO();
        usuarioALoguearse.setUserName(userName);
        usuarioALoguearse.setPassword(password);
        String json = jsonService.toJson(usuarioALoguearse);
//        StringBuilder builder = new StringBuilder();
//
//        if (!StringUtils.isEmpty(firstName)) {
//            builder.append(firstName);
//        }
//
//        if (!StringUtils.isEmpty(lastName)) {
//            if (builder.length() > 0) {
//                builder.append(" ");
//            }
//            builder.append(lastName);
//        }
//
//        if (builder.length() > 0) {
//            String name = builder.toString();
//            log.debug("Saying hello to " + name);
//            messageLabel.setText("Hello " + name);
//        } else {
//            log.debug("Neither first name nor last name was set, saying hello to anonymous person");
//            messageLabel.setText("Hello mysterious person");
//        }
    }

}
