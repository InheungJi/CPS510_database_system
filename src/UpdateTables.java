import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UpdateTables {

    private JFrame updateTableFrame;
    DatabaseConnection databaseConnection = new DatabaseConnection();

    public void updateTablesRunnable() {
        EventQueue.invokeLater(() -> {
            try {
                UpdateTables updateTableWindow = new UpdateTables();
                updateTableWindow.updateTableFrame.setVisible(true);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public UpdateTables() {
        if (databaseConnection.createConnection()) {
            createUpdateTablesWindow();
        }
    }

    private void createUpdateTablesWindow() {
        updateTableFrame = new JFrame();
        updateTableFrame.setBounds(100, 100, 480, 320);
        updateTableFrame.getContentPane().setLayout(null);
        updateTableFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel carRentalEditLabel = new JLabel("Edit Table");
        carRentalEditLabel.setFont(new Font("Garamond", Font.BOLD, 24));
        carRentalEditLabel.setBounds(10, 0, 300, 50);
        updateTableFrame.getContentPane().add(carRentalEditLabel);

        JButton updateButton = new JButton("Update");
        updateButton.setFont(new Font("Garamond", Font.BOLD, 16));
        updateButton.setBounds(20, 60, 100, 30);
        updateTableFrame.getContentPane().add(updateButton);

        JTextField updateTextField = new JTextField("UPDATE table-name");
        updateTextField.setBounds(140 , 60, 300, 20);
        updateTextField.setColumns(500);
        updateTableFrame.getContentPane().add(updateTextField);

        JTextField setTextField = new JTextField("SET column-name = value, column-name = value, ...");
        setTextField.setBounds(140 , 80, 300, 20);
        setTextField.setColumns(500);
        updateTableFrame.getContentPane().add(setTextField);

        JTextField whereTextField = new JTextField("WHERE condition");
        whereTextField.setBounds(140 , 100, 300, 20);
        whereTextField.setColumns(500);
        updateTableFrame.getContentPane().add(whereTextField);

        updateButton.addActionListener(actionEvent -> {
            String updateTextString = updateTextField.getText();
            String setTextString = setTextField.getText();
            String whereTextString = whereTextField.getText();

            String queryStatement = updateTextString + " " + setTextString + " " + whereTextString;
            databaseConnection.executeQuery(queryStatement);

            JOptionPane.showMessageDialog(updateTableFrame, "Updated!");
        });

        JButton insertButton = new JButton("Insert");
        insertButton.setFont(new Font("Garamond", Font.BOLD, 16));
        insertButton.setBounds(20, 140, 100, 30);
        updateTableFrame.getContentPane().add(insertButton);

        JTextField insertIntoTextField = new JTextField("INSERT INTO table-name");
        insertIntoTextField.setBounds(140 , 140, 300, 20);
        insertIntoTextField.setColumns(500);
        updateTableFrame.getContentPane().add(insertIntoTextField);

        JTextField insertAttributeNamesTextField = new JTextField("(column-names)");
        insertAttributeNamesTextField.setBounds(140 , 160, 300, 20);
        insertAttributeNamesTextField.setColumns(500);
        updateTableFrame.getContentPane().add(insertAttributeNamesTextField);

        JTextField insertValuesTextField = new JTextField("VALUES (values)");
        insertValuesTextField.setBounds(140 , 180, 300, 20);
        insertValuesTextField.setColumns(500);
        updateTableFrame.getContentPane().add(insertValuesTextField);

        insertButton.addActionListener(actionEvent -> {
            String insertIntoString = insertIntoTextField.getText();
            String insertAttributeNamesString = insertAttributeNamesTextField.getText();
            String insertValuesString = insertValuesTextField.getText();

            String queryStatement = insertIntoString + " " + insertAttributeNamesString + " " + insertValuesString;
            databaseConnection.executeQuery(queryStatement);

            JOptionPane.showMessageDialog(insertButton, "Inserted!");
        });

        JButton removeButton = new JButton("Remove");
        removeButton.setFont(new Font("Garamond", Font.BOLD, 16));
        removeButton.setBounds(20, 220, 100, 30);
        updateTableFrame.getContentPane().add(removeButton);

        JTextField deleteTableTextField = new JTextField("DELETE table-name");
        deleteTableTextField.setBounds(140, 220, 300, 20);
        deleteTableTextField.setColumns(500);
        updateTableFrame.getContentPane().add(deleteTableTextField);

        JTextField deleteConditionTextField = new JTextField("WHERE condition");
        deleteConditionTextField.setBounds(140, 240, 300, 20);
        deleteConditionTextField.setColumns(500);
        updateTableFrame.getContentPane().add(deleteConditionTextField);

        removeButton.addActionListener(actionEvent -> {
            String deleteTableString = deleteTableTextField.getText();
            String deleteConditionString = deleteConditionTextField.getText();

            String queryStatement = deleteTableString + " " + deleteConditionString;
            databaseConnection.executeQuery(queryStatement);

            JOptionPane.showMessageDialog(removeButton, "Removed!");
        });

        JButton backButton = new JButton("←");
        backButton.setFont(new Font("Garamond", Font.BOLD, 12));
        backButton.setBounds(400, 15, 50, 20);
        updateTableFrame.getContentPane().add(backButton);

        backButton.addActionListener(actionEvent -> {
            Menu menu = new Menu();
            menu.menuRunnable();
            updateTableFrame.dispose();
        });
    }
}
