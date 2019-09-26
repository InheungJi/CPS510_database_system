import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class QueryTables {

    private JFrame queryTablesFrame;
    private DatabaseConnection databaseConnection = new DatabaseConnection();

    private static List<String> queryNames = new ArrayList<>();
    private static List<String> queryCommands = new ArrayList<>();

    public static void queryTableRunnable() {
        EventQueue.invokeLater(() -> {
            try {
                QueryTables queryTablesWindow = new QueryTables();
                queryTablesWindow.queryTablesFrame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public QueryTables() {
        if (databaseConnection.createConnection()) {
            createQueryTablesWindow();
        }
    }

    private void createQueryTablesWindow() {
        queryTablesFrame = new JFrame();
        queryTablesFrame.setTitle("Query Tables");
        queryTablesFrame.setBounds(100, 100, 480, 550);
        queryTablesFrame.getContentPane().setLayout(null);
        queryTablesFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel carRentalSystemQueryLabel = new JLabel("Common Queries");
        carRentalSystemQueryLabel.setFont(new Font("Garamond", Font.BOLD, 24));
        carRentalSystemQueryLabel.setBounds(10, 0, 300, 50);
        queryTablesFrame.getContentPane().add(carRentalSystemQueryLabel);

        queryNames.add("1. List of Cars With More Than 7 Seats");
        queryNames.add("2. List of Promotions That Are Less Than Or Equal To 70");
        queryNames.add("3. List of Locations With LocationNumber Over 5000");
        queryNames.add("4. List of Promotions That Are Percentages");
        queryNames.add("5. List of Promotions That Are Amounts");
        queryNames.add("6. List of Cars Whose Mileage Is Over 10000");
        queryNames.add("7. List of Members From Toronto");
        queryNames.add("8. List of Cars That Are Honda Or Toyota");

        queryCommands.add("SELECT DISTINCT cm.ModelName, cm.Manufacturer, cm.ModelYear, cm.NumberOfSeats FROM CAR c, CAR_MODEL cm WHERE cm.NumberOfSeats >= 7 and c.ModelNumber = cm.ModelNumber");
        queryCommands.add("SELECT * FROM PROMOTION_AMOUNT WHERE Amount <= 70");
        queryCommands.add("SELECT DISTINCT LocationName, l.LocationNumber, PhoneNumber FROM LOCATION l, HAS h WHERE l.LocationNumber = h.LocationNumber AND h.LocationNumber >= 5000");
        queryCommands.add("SELECT DISTINCT PROMOTION.PromotionName, PROMOTION.PromotionCode, PROMOTION_PERCENTAGE.Percentage FROM PROMOTION_PERCENTAGE, PROMOTION WHERE PROMOTION.PromotionCode = PROMOTION_PERCENTAGE.PromotionCode");
        queryCommands.add("SELECT DISTINCT PROMOTION.PromotionName, PROMOTION.PromotionCode, PROMOTION_AMOUNT.Amount FROM PROMOTION_AMOUNT, PROMOTION WHERE PROMOTION.PromotionCode = PROMOTION_AMOUNT.PromotionCode");
        queryCommands.add("SELECT * FROM CAR WHERE Mileage >= 100000");
        queryCommands.add("SELECT DISTINCT cu.FirstName, cu.LastName, cu.EmailAddress, cu.PhoneNumber FROM MEMBER m, CUSTOMER cu WHERE City = 'Toronto' AND m.LicenseNumber = cu.LicenseNumber");
        queryCommands.add("SELECT DISTINCT cm.ModelName, cm.Manufacturer, cm.ModelYear FROM CAR c, CAR_MODEL cm WHERE cm.Manufacturer = 'Toyota' OR cm.Manufacturer = 'Honda' AND c.ModelNumber = cm.ModelNumber");

        JButton queryOneButton = new JButton(queryNames.get(0));
        queryOneButton.setFont(new Font("Garamond", Font.BOLD, 14));
        queryOneButton.setBounds(30, 60, 400, 30);
        queryTablesFrame.getContentPane().add(queryOneButton);

        JButton queryTwoButton = new JButton(queryNames.get(1));
        queryTwoButton.setFont(new Font("Garamond", Font.BOLD, 14));
        queryTwoButton.setBounds(30, 100, 400, 30);
        queryTablesFrame.getContentPane().add(queryTwoButton);

        JButton queryThreeButton = new JButton(queryNames.get(2));
        queryThreeButton.setFont(new Font("Garamond", Font.BOLD, 14));
        queryThreeButton.setBounds(30, 140, 400, 30);
        queryTablesFrame.getContentPane().add(queryThreeButton);

        JButton queryFourButton = new JButton(queryNames.get(3));
        queryFourButton.setFont(new Font("Garamond", Font.BOLD, 14));
        queryFourButton.setBounds(30, 180, 400, 30);
        queryTablesFrame.getContentPane().add(queryFourButton);

        JButton queryFiveButton = new JButton(queryNames.get(4));
        queryFiveButton.setFont(new Font("Garamond", Font.BOLD, 14));
        queryFiveButton.setBounds(30, 220, 400, 30);
        queryTablesFrame.getContentPane().add(queryFiveButton);

        JButton querySixButton = new JButton(queryNames.get(5));
        querySixButton.setFont(new Font("Garamond", Font.BOLD, 14));
        querySixButton.setBounds(30, 260, 400, 30);
        queryTablesFrame.getContentPane().add(querySixButton);

        JButton querySevenButton = new JButton(queryNames.get(6));
        querySevenButton.setFont(new Font("Garamond", Font.BOLD, 14));
        querySevenButton.setBounds(30, 300, 400, 30);
        queryTablesFrame.getContentPane().add(querySevenButton);

        JButton queryEightButton = new JButton(queryNames.get(7));
        queryEightButton.setFont(new Font("Garamond", Font.BOLD, 14));
        queryEightButton.setBounds(30, 340, 400, 30);
        queryTablesFrame.getContentPane().add(queryEightButton);

        Menu.executeButtonActionEvent(queryOneButton, databaseConnection, queryCommands.get(0));
        Menu.executeButtonActionEvent(queryTwoButton, databaseConnection, queryCommands.get(1));
        Menu.executeButtonActionEvent(queryThreeButton, databaseConnection, queryCommands.get(2));
        Menu.executeButtonActionEvent(queryFourButton, databaseConnection, queryCommands.get(3));
        Menu.executeButtonActionEvent(queryFiveButton, databaseConnection, queryCommands.get(4));
        Menu.executeButtonActionEvent(querySixButton, databaseConnection, queryCommands.get(5));
        Menu.executeButtonActionEvent(querySevenButton, databaseConnection, queryCommands.get(6));
        Menu.executeButtonActionEvent(queryEightButton, databaseConnection, queryCommands.get(7));

        JButton customQueryButton = new JButton("Custom Query");
        customQueryButton.setFont(new Font("Garamond", Font.BOLD, 12));
        customQueryButton.setBounds(30, 380, 120, 30);
        queryTablesFrame.getContentPane().add(customQueryButton);

        JTextField customQueryTextField = new JTextField();
        customQueryTextField.setBounds(160, 380, 260, 100);
        customQueryTextField.setColumns(1000);
        queryTablesFrame.getContentPane().add(customQueryTextField);

        customQueryButton.addActionListener(actionEvent -> {
            String customQuery = customQueryTextField.getText();
            Menu.executeButtonActionEvent(customQueryButton, databaseConnection, customQuery);
        });

        JButton backButton = new JButton("←");
        backButton.setFont(new Font("Garamond", Font.BOLD, 12));
        backButton.setBounds(400, 15, 50, 20);
        queryTablesFrame.getContentPane().add(backButton);

        backButton.addActionListener(actionEvent -> {
            Menu menu = new Menu();
            menu.menuRunnable();
            queryTablesFrame.dispose();
        });
    }
}
