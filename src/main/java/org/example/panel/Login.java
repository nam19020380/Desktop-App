package org.example.panel;

import org.example.HomePage.HPage;
import org.example.httpClient.HttpClient;
import org.example.payload.ForgetPasswordRequest;
import org.example.payload.LoginRequest;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Login extends JFrame{
    private String token;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton đăngNhậpButton;
    private JCheckBox ghiNhớĐăngNhậpCheckBox;
    private JButton signUpButton;
    private JButton quênMậtKhẩuButton;
    private JPanel loginPanel;

    public Login(){
        HttpClient httpClient = new HttpClient();
        setContentPane(loginPanel);
        setSize(300,300);
        setVisible(true);
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Signup signup = new Signup();
            }
        });
        đăngNhậpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginRequest loginRequest = new LoginRequest();
                loginRequest.setEmail(textField1.getText());
                loginRequest.setPassword(new String(passwordField1.getPassword()));
                token = httpClient.login("http://localhost:8080/api/v1/auth/login", loginRequest);
                token = token.replace("\"","");
                if(token == null){
                    JOptionPane.showMessageDialog(null,"Sai tên đăng nhập hoặc mật khẩu");
                } else{
                    System.out.println("Dang nhap thanh cong");
                    new HPage(textField1.getText());
                }

            }
        });
        quênMậtKhẩuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = textField1.getText();
                if (textField1 == null){
                    JOptionPane.showMessageDialog(null,"Điền vào email và thử lại");
                } else {
                    ForgetPasswordRequest forgetPasswordRequest = new ForgetPasswordRequest();
                    forgetPasswordRequest.setEmail(email);
                    httpClient.forgetPassword("http://localhost:8080/api/v1/auth/forgetP", forgetPasswordRequest);
                    JOptionPane.showMessageDialog(null,"Vào mail tạo tài khoản lấy mật khẩu mới và thử lại");
                }
            }
        });
    }
}
