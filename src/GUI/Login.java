package GUI;

import BLL.AccountsBUS;

import javax.swing.*;
import java.awt.*;

public class Login extends JDialog {
    public Login() {
        // phan title
        JLabel lTitle = new JLabel();
        lTitle.setText("Dang nhap vao he thong quan ly sinh vien!!");
        lTitle.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        lTitle.setForeground(Color.blue);
        lTitle.setHorizontalTextPosition(JLabel.CENTER);
        lTitle.setVerticalTextPosition(JLabel.CENTER);

        JPanel pTitle = new JPanel();
        pTitle.setBounds(0, 0, 600, 100);
        pTitle.add(lTitle);

        // phan username
        JLabel lUsername = new JLabel();
        lUsername.setText("Tai khoan");
        lUsername.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        lUsername.setBounds(30, 100, 100, 60);
        JTextField fUsername = new JTextField();
        fUsername.setBounds(180, 100, 290, 40);

        // phan password
        JLabel lPassword = new JLabel();
        lPassword.setText("Mat khau");
        lPassword.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        lPassword.setBounds(30, 170, 100, 60);
        JPasswordField fPassword = new JPasswordField();
        fPassword.setBounds(180, 170, 290, 40);

        JButton bLogin = new JButton();
        bLogin.setBounds(260, 300, 140, 40);
        bLogin.setForeground(Color.white);
        bLogin.setBackground(new Color(36, 47, 155));
        bLogin.setText("Dang nhap");
        bLogin.setFocusable(false);
        bLogin.addActionListener(e -> {
            if (fUsername.getText().equals("") || fPassword.getPassword().length == 0) {
                JOptionPane.showMessageDialog(null, "Tai khoan hoac mat khau trong");
            }
            else {
                String username = fUsername.getText();
                String password = String.valueOf(fPassword.getPassword());
                boolean checkLogin = new AccountsBUS(username, password).checkLogin();
                if (checkLogin) {
                    JOptionPane.showMessageDialog(null, "Dang nhap thanh cong");
                    this.dispose();
                    new MainPage();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Sai tai khoan hoac mat khau");
                }
            }
        });

        JButton bSignup = new JButton();
        bSignup.setBounds(405, 300, 90, 40);
        bSignup.setForeground(new Color(242, 76, 76));
        bSignup.setText("Dang ky");
        bSignup.setFocusable(false);
        bSignup.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Dang ky thanh cong");
        });

        //title
        this.add(pTitle);
        //username
        this.add(lPassword);
        this.add(fPassword);
        //password
        this.add(lUsername);
        this.add(fUsername);
        //button
        this.add(bLogin);
        this.add(bSignup);

        this.setLayout(null);
        this.setTitle("Quan ly sinh vien");
        this.setSize(600, 400);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
