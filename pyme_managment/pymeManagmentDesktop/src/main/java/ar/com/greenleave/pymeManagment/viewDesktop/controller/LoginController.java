package ar.com.greenleave.pymeManagment.viewDesktop.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("loginController")
public class LoginController
{
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    @FXML 
    private TextField txtUserName;
    @FXML 
    private PasswordField pwdLoginPass;
    @FXML 
    private Label messageLabel;

    public void login() {

        String firstName = txtUserName.getText();
        String lastName = pwdLoginPass.getText();

        StringBuilder builder = new StringBuilder();

        if (!StringUtils.isEmpty(firstName)) {
            builder.append(firstName);
        }

        if (!StringUtils.isEmpty(lastName)) {
            if (builder.length() > 0) {
                builder.append(" ");
            }
            builder.append(lastName);
        }

        if (builder.length() > 0) {
            String name = builder.toString();
            log.debug("Saying hello to " + name);
            messageLabel.setText("Hello " + name);
        } else {
            log.debug("Neither first name nor last name was set, saying hello to anonymous person");
            messageLabel.setText("Hello mysterious person");
        }
    }

}
