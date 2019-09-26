import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ViewTables {

    private JFrame viewTableFrame;
    DatabaseConnection databaseConnection = new DatabaseConnection();

    private static List<String> queryNames = new ArrayList<>();
    private static List<String> queryCommands = new ArrayList<>();

    public static void viewTableRunnable() {
        EventQueue.invokeLater(() -> {
            try {
                ViewTables viewTableWindow = new ViewTables();
                viewTableWindow.viewTableFrame.setVisible(true);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public ViewTables() {
        if (databaseConnection.createConnection())	 {
            createViewTableWindow();
        }
    }

    private void createViewTableWindow() {
        viewTableFrame = new JFrame();
        viewTableFrame.setTitle("View Tables");
        viewTableFrame.setBounds(100, 100, 360, 500);
        viewTableFrame.getContentPane().setLayout(null);
        viewTableFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel carRentalSystemTableLabel = new JLabel("Tables");
        carRentalSystemTableLabel.setFont(new Font("Garamond", Font.BOLD, 24));
        carRentalSystemTableLabel.setBounds(10, 0, 300, 50);
        viewTableFrame.getContentPane().add(carRentalSystemTableLabel);

        queryNames.add("Reservation");
        queryNames.add("Billing");
        queryNames.add("Location");
        queryNames.add("Car");
        queryNames.add("Car Model");
        queryNames.add("Car Type");
        queryNames.add("Protections & Coverages");
        queryNames.add("Accessories & Services");
        queryNames.add("Promotions");
        queryNames.add("Customer");

        queryCommands.add("SELECT * FROM RESERVATION");
        queryCommands.add("SELECT * FROM BILLING");
        queryCommands.add("SELECT * FROM LOCATION");
        queryCommands.add("SELECT * FROM CAR");
        queryCommands.add("SELECT * FROM CAR_MODEL");
        queryCommands.add("SELECT * FROM CAR_TYPE");
        queryCommands.add("SELECT * FROM PROTECTIONS_COVERAGES");
        queryCommands.add("SELECT * FROM ACCESSORIES_SERVICES");
        queryCommands.add("SELECT * FROM PROMOTION");
        queryCommands.add("SELECT * FROM CUSTOMER");

        JButton reservationTableButton = new JButton(queryNames.get(0));
        reservationTableButton.setFont(new Font("Garamond", Font.BOLD, 18));
        reservationTableButton.setBounds(50, 50, 240, 30);
        viewTableFrame.getContentPane().add(reservationTableButton);

        JButton billingTableButton = new JButton(queryNames.get(1));
        billingTableButton.setFont(new Font("Garamond", Font.BOLD, 18));
        billingTableButton.setBounds(50, 90, 240, 30);
        viewTableFrame.getContentPane().add(billingTableButton);

        JButton locationTableButton = new JButton(queryNames.get(2));
        locationTableButton.setFont(new Font("Garamond", Font.BOLD, 18));
        locationTableButton.setBounds(50, 170, 240, 30);
        viewTableFrame.getContentPane().add(locationTableButton);

        JButton carTableButton = new JButton(queryNames.get(3));
        carTableButton.setFont(new Font("Garamond", Font.BOLD, 18));
        carTableButton.setBounds(50, 130, 240, 30);
        viewTableFrame.getContentPane().add(carTableButton);

        JButton carModelTableButton = new JButton(queryNames.get(4));
        carModelTableButton.setFont(new Font("Garamond", Font.BOLD, 18));
        carModelTableButton.setBounds(50, 210, 240, 30);
        viewTableFrame.getContentPane().add(carModelTableButton);

        JButton carTypeTableButton = new JButton(queryNames.get(5));
        carTypeTableButton.setFont(new Font("Garamond", Font.BOLD, 18));
        carTypeTableButton.setBounds(50, 250, 240, 30);
        viewTableFrame.getContentPane().add(carTypeTableButton);

        JButton protectionsCoveragesTableButton = new JButton(queryNames.get(6));
        protectionsCoveragesTableButton.setFont(new Font("Garamond", Font.BOLD, 18));
        protectionsCoveragesTableButton.setBounds(50, 290, 240, 30);
        viewTableFrame.getContentPane().add(protectionsCoveragesTableButton);

        JButton accessoriesServicesTableButton = new JButton(queryNames.get(7));
        accessoriesServicesTableButton.setFont(new Font("Garamond", Font.BOLD, 18));
        accessoriesServicesTableButton.setBounds(50, 330, 240, 30);
        viewTableFrame.getContentPane().add(accessoriesServicesTableButton);

        JButton promotionsTableButton = new JButton(queryNames.get(8));
        promotionsTableButton.setFont(new Font("Garamond", Font.BOLD, 18));
        promotionsTableButton.setBounds(50, 370, 240, 30);
        viewTableFrame.getContentPane().add(promotionsTableButton);

        JButton customerTableButton = new JButton(queryNames.get(9));
        customerTableButton.setFont(new Font("Garamond", Font.BOLD, 18));
        customerTableButton.setBounds(50, 410, 240, 30);
        viewTableFrame.getContentPane().add(customerTableButton);

        Menu.executeButtonActionEvent(reservationTableButton, databaseConnection, queryCommands.get(0));
        Menu.executeButtonActionEvent(billingTableButton, databaseConnection, queryCommands.get(1));
        Menu.executeButtonActionEvent(locationTableButton, databaseConnection, queryCommands.get(2));
        Menu.executeButtonActionEvent(carTableButton, databaseConnection, queryCommands.get(3));
        Menu.executeButtonActionEvent(carModelTableButton, databaseConnection, queryCommands.get(4));
        Menu.executeButtonActionEvent(carTypeTableButton, databaseConnection, queryCommands.get(5));
        Menu.executeButtonActionEvent(protectionsCoveragesTableButton, databaseConnection, queryCommands.get(6));
        Menu.executeButtonActionEvent(accessoriesServicesTableButton, databaseConnection, queryCommands.get(7));
        Menu.executeButtonActionEvent(promotionsTableButton, databaseConnection, queryCommands.get(8));
        Menu.executeButtonActionEvent(customerTableButton, databaseConnection, queryCommands.get(9));

        JButton backButton = new JButton("←");
        backButton.setFont(new Font("Garamond", Font.BOLD, 14));
        backButton.setBounds(280, 15, 50, 20);
        viewTableFrame.getContentPane().add(backButton);

        backButton.addActionListener(actionEvent -> {
            Menu menu = new Menu();
            menu.menuRunnable();
            viewTableFrame.dispose();
        });
    }
}
