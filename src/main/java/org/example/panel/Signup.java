package org.example.panel;

import org.example.entity.User;
import org.example.httpClient.HttpClient;
import org.example.payload.LoginRequest;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signup extends JFrame{
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JButton xácNhậnButton;
    private JPanel signupPanel;
    private JButton quayLạiButton;

    public Signup() {
        HttpClient httpClient = new HttpClient();
        setContentPane(signupPanel);
        setSize(300,300);
        setVisible(true);
        quayLạiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Login login = new Login();
            }
        });
        xácNhậnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer status;
                String password = new String(passwordField1.getPassword());
                String confirmPassword = new String(passwordField2.getPassword());
                LoginRequest loginRequest = new LoginRequest();
                loginRequest.setEmail(textField1.getText());
                loginRequest.setPassword(password);
                if(!password.equals(confirmPassword)){
                    JOptionPane.showMessageDialog(null,"Mật khẩu và mật khẩu xác nhận không trùng nhau");
                } else {
                    status = httpClient.signup("http://localhost:8080/api/v1/auth/signup", loginRequest);
                    if(status == 201){
                        JOptionPane.showMessageDialog(null,"Đăng ký thành công");
                        setVisible(false);
                        Login login = new Login();
                    } else {
                        JOptionPane.showMessageDialog(null,"Tên đăng nhập trùng lặp, vui lòng tạo lại!");
                    }
                }
            }
        });
    }
}
