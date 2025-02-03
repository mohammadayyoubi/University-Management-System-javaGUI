package university.management.system;

import java.awt.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame {

    JLabel Lwelcome = new JLabel("   Welcome to USAL UMS   ");
    JLabel Lusername = new JLabel("Username");
    JLabel Lpass = new JLabel("Password");
    JTextField Tusername = new JTextField();
    JPasswordField Tpass = new JPasswordField();
    JButton Blogin = new JButton("Login");

    public Login() {
        String userFilePath = "username.txt";
        String username = "";

        try ( BufferedReader reader = new BufferedReader(new FileReader(userFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                username += line;
            }
        } catch (IOException e) {
            System.out.println("Error : " + e.getMessage());
        }
        Tusername.setText(username);
        setLayout(new BorderLayout());
        setTitle("Login to System Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel contentPane = new JPanel(new BorderLayout(10, 10));
        contentPane.setBorder(new EmptyBorder(15, 15, 15, 15));
        contentPane.setBackground(Color.white);

        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        headerPanel.setBackground(new Color(58, 135, 173));
        headerPanel.setBorder(new EmptyBorder(10, 0, 10, 0));
        Lwelcome.setFont(new Font("Arial", Font.BOLD, 20));
        Lwelcome.setForeground(Color.white);
        headerPanel.add(Lwelcome);
        contentPane.add(headerPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new GridLayout(2, 2, 5, 10));
        centerPanel.setBackground(Color.white);
        centerPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        Lusername.setFont(new Font("Arial", Font.PLAIN, 14));
        Lpass.setFont(new Font("Arial", Font.PLAIN, 14));
        centerPanel.add(Lusername);
        centerPanel.add(Tusername);
        centerPanel.add(Lpass);
        centerPanel.add(Tpass);
        contentPane.add(centerPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        buttonPanel.setBackground(Color.white);
        Blogin.setBackground(new Color(58, 135, 173));
        Blogin.setForeground(Color.white);
        Blogin.setFont(new Font("Arial", Font.BOLD, 14));
        buttonPanel.add(Blogin);
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        add(contentPane);
        pack();
        setLocationRelativeTo(null);
    }
}
