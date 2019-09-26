import javax.swing.*;

public class DropTables {

    public static void executeDropQueries(JFrame mainMenuFrame, DatabaseConnection databaseConnection, JButton dropTablesButton) {
        dropTablesButton.addActionListener(actionEvent -> {

            databaseConnection.executeQuery("DROP TABLE RESERVATION cascade constraints purge");
            databaseConnection.executeQuery("DROP TABLE LOCATION cascade constraints purge");
            databaseConnection.executeQuery("DROP TABLE CAR cascade constraints purge");
            databaseConnection.executeQuery("DROP TABLE CAR_MODEL cascade constraints purge");
            databaseConnection.executeQuery("DROP TABLE CAR_TYPE cascade constraints purge");
            databaseConnection.executeQuery("DROP TABLE CUSTOMER cascade constraints purge");
            databaseConnection.executeQuery("DROP TABLE MEMBER cascade constraints purge");
            databaseConnection.executeQuery("DROP TABLE BILLING cascade constraints purge");
            databaseConnection.executeQuery("DROP TABLE PROTECTIONS_COVERAGES cascade constraints purge");
            databaseConnection.executeQuery("DROP TABLE ACCESSORIES_SERVICES cascade constraints purge");
            databaseConnection.executeQuery("DROP TABLE PROMOTION cascade constraints purge");
            databaseConnection.executeQuery("DROP TABLE PROMOTION_PERCENTAGE cascade constraints purge");
            databaseConnection.executeQuery("DROP TABLE PROMOTION_AMOUNT cascade constraints purge");
            databaseConnection.executeQuery("DROP TABLE MAKES cascade constraints purge");
            databaseConnection.executeQuery("DROP TABLE CHOSEN cascade constraints purge");
            databaseConnection.executeQuery("DROP TABLE HAS cascade constraints purge");
            databaseConnection.executeQuery("DROP TABLE CONTAINS cascade constraints purge");
            databaseConnection.executeQuery("DROP TABLE BELONGS cascade constraints purge");
            databaseConnection.executeQuery("DROP TABLE INCLUDES cascade constraints purge");
            databaseConnection.executeQuery("DROP TABLE CREATES cascade constraints purge");
            databaseConnection.executeQuery("commit");

            JOptionPane.showMessageDialog(mainMenuFrame, "All Tables Dropped");
        });
    }
}
