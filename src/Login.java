import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Login {

    private JFrame loginFrame;
    private JTextField usernameField;
    private JTextField passwordField;
    private JButton loginButton;
    private static Map<String, String> userCredentials;

    public static void main(String[] args) {
        loginRunnable();
    }

    public static void loginRunnable() {
        EventQueue.invokeLater(() -> {
            try {
                Login loginWindow = new Login();
                loginWindow.loginFrame.setVisible(true);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Login() {
        loginFrame = new JFrame();
        loginFrame.setTitle("Car Rental - Login");
        loginFrame.setBounds(100, 100, 420, 300);
        loginFrame.getContentPane().setLayout(null);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel carRentalLoginLabel = new JLabel("Login");
        carRentalLoginLabel.setFont(new Font("Garamond", Font.BOLD, 24));
        carRentalLoginLabel.setBounds(10, 0, 300, 50);
        loginFrame.getContentPane().add(carRentalLoginLabel);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Garamond", Font.PLAIN, 18));
        usernameLabel.setBounds(60, 80, 80, 20);
        loginFrame.getContentPane().add(usernameLabel);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Garamond", Font.PLAIN, 18));
        passwordLabel.setBounds(60, 120, 80, 20);
        loginFrame.getContentPane().add(passwordLabel);

        usernameField = new JTextField();
        usernameField.setBounds(150, 80, 180, 30);
        usernameField.setColumns(50);
        loginFrame.getContentPane().add(usernameField);

        passwordField = new JTextField();
        passwordField.setBounds(150, 120, 180, 30);
        passwordField.setColumns(50);
        loginFrame.getContentPane().add(passwordField);

        loginButton = new JButton("Submit");
        loginButton.setFont(new Font("Garamond", Font.BOLD, 18));
        loginButton.setBounds(180, 170, 100, 30);
        loginFrame.getContentPane().add(loginButton);

        userCredentials = new HashMap<>();

        loginButton.addActionListener(actionEvent -> { 
            String username = usernameField.getText();
            String password = passwordField.getText();
            if (userCredentials.containsKey(username)) {
                if (userCredentials.get(username).equals(password)) {
                    JOptionPane.showMessageDialog(loginFrame, "Success!");
                    Menu menu = new Menu();
                    menu.menuRunnable();
                    loginFrame.setVisible(false);
                }
                else {
                    JOptionPane.showMessageDialog(loginFrame, "Invalid Username or Password");
                }
            }
            else {
                userCredentials.put(username, password);
                JOptionPane.showMessageDialog(loginFrame, "Welcome New User!");
                Menu menu = new Menu();
                menu.menuRunnable();
                loginFrame.setVisible(false);
            }
        });
    }
}