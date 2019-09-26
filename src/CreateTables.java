import javax.swing.*;

public class CreateTables {

    public static void executeCreateQueries (JFrame mainMenuFrame, DatabaseConnection databaseConnection, JButton createTablesButton) {
        createTablesButton.addActionListener(actionEvent -> {

            databaseConnection.executeQuery("CREATE TABLE RESERVATION ( ReservationID INTEGER PRIMARY KEY, RentalStatus VARCHAR2(3) CONSTRAINT reservation_check_out_in CHECK (RentalStatus IN ('OUT', 'IN')), PickupLocation VARCHAR2(18) NOT NULL, StartDate DATE NOT NULL, EndDate DATE NOT NULL, ReturnedDate DATE )");
            databaseConnection.executeQuery("CREATE TABLE LOCATION ( LocationNumber INTEGER PRIMARY KEY, LocationName VARCHAR2(18), PhoneNumber VARCHAR2(12), StreetAddress VARCHAR2(50) NOT NULL, City VARCHAR2(20) NOT NULL, Province VARCHAR2(2) DEFAULT 'ON', PostalCode VARCHAR2(7) NOT NULL, Country VARCHAR2(20) DEFAULT 'Canada' )");
            databaseConnection.executeQuery("CREATE TABLE CAR ( RegistrationNumber INTEGER PRIMARY KEY, CarAvailability VARCHAR2(3) CONSTRAINT car_check_out_in CHECK (CarAvailability IN ('OUT', 'IN')), Mileage INTEGER, RentalPrice INTEGER NOT NULL, LateFees INTEGER, ModelNumber INTEGER NOT NULL )");
            databaseConnection.executeQuery("CREATE TABLE CAR_MODEL ( ModelNumber INTEGER PRIMARY KEY, ModelName VARCHAR2(18), ModelYear INTEGER, Manufacturer VARCHAR2(18), NumberOfSeats INTEGER )");
            databaseConnection.executeQuery("CREATE TABLE CAR_TYPE ( CarTypeName VARCHAR2(18) PRIMARY KEY, RentalDeposit INTEGER )");
            databaseConnection.executeQuery("CREATE TABLE CUSTOMER ( LicenseNumber VARCHAR2(18) PRIMARY KEY, ExpiryDate DATE NOT NULL, DateOfBirth DATE NOT NULL, FirstName VARCHAR2(20) NOT NULL, MiddleName VARCHAR2(1), LastName VARCHAR2(30) NOT NULL, EmailAddress VARCHAR2(50), PhoneNumber VARCHAR2(12) NOT NULL, StreetAddress VARCHAR2(50) NOT NULL, Apartment VARCHAR2(5), City VARCHAR2(20) NOT NULL, Province VARCHAR2(2) DEFAULT 'ON', PostalCode VARCHAR2(7) NOT NULL, Country VARCHAR2(20) DEFAULT 'Canada' )");
            databaseConnection.executeQuery("CREATE TABLE MEMBER ( LicenseNumber VARCHAR2(18) REFERENCES CUSTOMER(LicenseNumber), MembershipID INTEGER )");
            databaseConnection.executeQuery("CREATE TABLE BILLING ( BillingID INTEGER PRIMARY KEY, BillingStatus VARCHAR2(4) CONSTRAINT billing_status_check_good_bad CHECK (BillingStatus IN ('GOOD', 'BAD')), BillingDate DATE NOT NULL, Tax INTEGER NOT NULL, CarRentalFees INTEGER NOT NULL, PCFees INTEGER, ASFees INTEGER, CarLateFees INTEGER, DiscountValue INTEGER )");
            databaseConnection.executeQuery("CREATE TABLE PROTECTIONS_COVERAGES ( PCCode INTEGER PRIMARY KEY, PCName VARCHAR2(30), PCPrice INTEGER )");
            databaseConnection.executeQuery("CREATE TABLE ACCESSORIES_SERVICES ( ASCode INTEGER PRIMARY KEY, ASName VARCHAR2(30), ASPrice INTEGER )");
            databaseConnection.executeQuery("CREATE TABLE PROMOTION ( PromotionCode INTEGER PRIMARY KEY, PromotionName VARCHAR2(30), ExpiryDate DATE, OneTimeUse VARCHAR2(3) CONSTRAINT one_time_use_check_yes_no CHECK (OneTimeUse IN ('YES', 'NO')), Source VARCHAR2(50) )");
            databaseConnection.executeQuery("CREATE TABLE PROMOTION_PERCENTAGE ( PromotionCode INTEGER REFERENCES PROMOTION(PromotionCode), Percentage INTEGER, PRIMARY KEY(PromotionCode) )");
            databaseConnection.executeQuery("CREATE TABLE PROMOTION_AMOUNT ( PromotionCode INTEGER REFERENCES PROMOTION(PromotionCode), Amount INTEGER, PRIMARY KEY(PromotionCode) )");
            databaseConnection.executeQuery("CREATE TABLE MAKES ( LicenseNumber VARCHAR2(18) REFERENCES CUSTOMER(LicenseNumber), ReservationID INTEGER REFERENCES RESERVATION(ReservationID), BookingDate DATE, PRIMARY KEY(LicenseNumber,ReservationID) )");
            databaseConnection.executeQuery("CREATE TABLE CHOSEN ( ReservationID INTEGER REFERENCES RESERVATION(ReservationID), RegistrationNumber INTEGER REFERENCES CAR(RegistrationNumber), PRIMARY KEY(ReservationID, RegistrationNumber) )");
            databaseConnection.executeQuery("CREATE TABLE HAS ( LocationNumber INTEGER REFERENCES LOCATION(LocationNumber), RegistrationNumber INTEGER REFERENCES CAR(RegistrationNumber), PRIMARY KEY(LocationNumber, RegistrationNumber) )");
            databaseConnection.executeQuery("CREATE TABLE CONTAINS ( RegistrationNumber INTEGER REFERENCES CAR(RegistrationNumber), ModelNumber INTEGER REFERENCES CAR_MODEL(ModelNumber), PRIMARY KEY(RegistrationNumber, ModelNumber) )");
            databaseConnection.executeQuery("CREATE TABLE BELONGS ( RegistrationNumber INTEGER REFERENCES CAR(RegistrationNumber), CarTypeName VARCHAR2(18) REFERENCES CAR_TYPE(CarTypeName), PRIMARY KEY(RegistrationNumber, CarTypeName) )");
            databaseConnection.executeQuery("CREATE TABLE INCLUDES ( ReservationID INTEGER REFERENCES RESERVATION(ReservationID), PCCode INTEGER REFERENCES PROTECTIONS_COVERAGES(PCCode), ASCode INTEGER REFERENCES ACCESSORIES_SERVICES(ASCode), PromotionCode INTEGER REFERENCES PROMOTION(PromotionCode), PRIMARY KEY(ReservationID, PCCode, ASCode, PromotionCode) )");
            databaseConnection.executeQuery("CREATE TABLE CREATES ( ReservationID INTEGER REFERENCES RESERVATION(ReservationID), BillingID INTEGER REFERENCES BILLING(BillingID), PRIMARY KEY(ReservationID, BillingID) )");

            JOptionPane.showMessageDialog(mainMenuFrame, "All Tables Created!");
        });
    }
}
