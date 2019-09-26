import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Menu {

    private JFrame mainMenuFrame;
    DatabaseConnection databaseConnection = new DatabaseConnection();

    public static void main(String[] args) {
        menuRunnable();
    }

    public static void menuRunnable() {
        EventQueue.invokeLater(() -> {
            try {
                Menu menuWindow = new Menu();
                menuWindow.mainMenuFrame.setVisible(true);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Menu() {
        if (databaseConnection.createConnection()) {
            createMainMenuWindow();
        }
    }

    private void createMainMenuWindow() {
        mainMenuFrame = new JFrame();
        mainMenuFrame.setTitle("Car Rental System");
        mainMenuFrame.setBounds(100, 100, 480, 300);
        mainMenuFrame.getContentPane().setLayout(null);
        mainMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel carRentalSystemLabel = new JLabel("Car Rental System");
        carRentalSystemLabel.setFont(new Font("Garamond", Font.BOLD, 24));
        carRentalSystemLabel.setBounds(10, 0, 300, 50);
        mainMenuFrame.getContentPane().add(carRentalSystemLabel);

        JButton dropTablesButton = new JButton("Drop Tables");
        dropTablesButton.setForeground(new Color(139, 0, 0));
        dropTablesButton.setFont(new Font("Garamond", Font.BOLD, 16));
        dropTablesButton.setBounds(10, 60, 140, 24);
        mainMenuFrame.getContentPane().add(dropTablesButton);

        JButton createTablesButton = new JButton("Create Tables");
        createTablesButton.setForeground(new Color(0, 128, 0));
        createTablesButton.setFont(new Font("Garamond", Font.BOLD, 16));
        createTablesButton.setBounds(160, 60, 140, 24);
        mainMenuFrame.getContentPane().add(createTablesButton);

        JButton populateTablesButton = new JButton("Insert Data");
        populateTablesButton.setForeground(new Color(0, 191, 255));
        populateTablesButton.setFont(new Font("Garamond", Font.BOLD, 16));
        populateTablesButton.setBounds(310, 60, 140, 24);
        mainMenuFrame.getContentPane().add(populateTablesButton);

        DropTables.executeDropQueries(mainMenuFrame, databaseConnection, dropTablesButton);
        CreateTables.executeCreateQueries(mainMenuFrame, databaseConnection, createTablesButton);
        PopulateTables.executePopulateDataQueries(mainMenuFrame, databaseConnection, populateTablesButton);

        JButton viewTablesButton = new JButton("View");
        viewTablesButton.setForeground(new Color(0, 0, 0));
        viewTablesButton.setFont(new Font("Garamond", Font.BOLD, 18));
        viewTablesButton.setBounds(10, 100, 140, 140);
        mainMenuFrame.getContentPane().add(viewTablesButton);

        JButton queryTablesButton = new JButton("Query");
        queryTablesButton.setForeground(new Color(0, 0, 0));
        queryTablesButton.setFont(new Font("Garamond", Font.BOLD, 18));
        queryTablesButton.setBounds(160, 100, 140, 140);
        mainMenuFrame.getContentPane().add(queryTablesButton);

        JButton updateTablesButton = new JButton("Edit");
        updateTablesButton.setForeground(new Color(0, 0, 0));
        updateTablesButton.setFont(new Font("Garamond", Font.BOLD, 18));
        updateTablesButton.setBounds(310, 100, 140, 140);
        mainMenuFrame.getContentPane().add(updateTablesButton);

        viewTablesButton.addActionListener(actionEvent -> {
            ViewTables viewTable = new ViewTables();
            viewTable.viewTableRunnable();
            mainMenuFrame.setVisible(false);
        });

        queryTablesButton.addActionListener(actionEvent -> {
            QueryTables queryTable = new QueryTables();
            queryTable.queryTableRunnable();
            mainMenuFrame.setVisible(false);
        });

        updateTablesButton.addActionListener(actionEvent -> {
            UpdateTables updateTable = new UpdateTables();
            updateTable.updateTablesRunnable();
            mainMenuFrame.setVisible(false);
        });

        JButton backButton = new JButton("←");
        backButton.setFont(new Font("Garamond", Font.BOLD, 14));
        backButton.setBounds(400, 15, 50, 20);
        mainMenuFrame.getContentPane().add(backButton);

        backButton.addActionListener(actionEvent -> {
            Login login = new Login();
            login.loginRunnable();
            mainMenuFrame.dispose();
        });
    }

    public static void executeButtonActionEvent(JButton tableButton, DatabaseConnection databaseConnection, String query) {
        tableButton.addActionListener(actionEvent -> {
            try {
                ResultSet queryResult = databaseConnection.executeQuery(query);
                JTable queryResultTable = new JTable(buildTableModel(queryResult));
                JOptionPane.showMessageDialog(null, new JScrollPane(queryResultTable));
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    public static DefaultTableModel buildTableModel(ResultSet queryResult) throws SQLException {

        ResultSetMetaData queryMetaData = queryResult.getMetaData();
        int columnCount = queryMetaData.getColumnCount();
        Vector<String> columnNames = new Vector<>();
        Vector<Vector<Object>> queryDataVector = new Vector<>();

        for (int columnNumber = 1; columnNumber <= columnCount; columnNumber++) {
            columnNames.add(queryMetaData.getColumnName(columnNumber));
        }

        while (queryResult.next()) {
            Vector<Object> tempDataVector = new Vector<>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                tempDataVector.add(queryResult.getObject(columnIndex));
            }
            queryDataVector.add(tempDataVector);
        }
        return new DefaultTableModel(queryDataVector, columnNames);
    }
}