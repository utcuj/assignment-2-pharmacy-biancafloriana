package view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class LoginView {

    private JFrame jframe;
    private JPanel jpanel;
    private JButton loginButton;
    private JLabel usernameLabel, passwordL;
    private JTextField usernameTF;
    private JPasswordField passwordTF;

    public LoginView() {
        this.jframe = new JFrame();
        this.jpanel = new JPanel();
        this.loginButton = new JButton("Log in");
        this.usernameLabel = new JLabel("Username:");
        this.passwordL = new JLabel("Password");
        this.usernameTF = new JTextField(10);
        this.passwordTF = new JPasswordField(10);

        init();
    }

    private void init() {

        jframe.setContentPane(jpanel);
        jpanel.add(usernameLabel);
        jpanel.add(usernameTF);
        jpanel.add(passwordL);
        jpanel.add(passwordTF);
        jpanel.add(loginButton);
        jframe.setLocation(600, 200);
        jframe.setSize(800, 600);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setVisible(true);

    }

    public void addListener(ActionListener listener) {
        loginButton.addActionListener(listener);
    }

    public String[] getInfo() {

        return new String[]{usernameTF.getText(), passwordTF.getText()};
    }

    public void dispose() {
        jframe.dispose();
    }
}

