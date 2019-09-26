import javax.swing.*;

public class PopulateTables {

    public static void executePopulateDataQueries(JFrame mainMenuFrame, DatabaseConnection databaseConnection, JButton populateTablesButton) {
        populateTablesButton.addActionListener(actionEvent -> {

            databaseConnection.executeQuery("INSERT INTO CUSTOMER (LicenseNumber, ExpiryDate, DateOfBirth, FirstName, LastName, EmailAddress, PhoneNumber, StreetAddress, City, PostalCode) VALUES ('D3101-69581-63862', '2020/07/22', '1974/12/04', 'Paul', 'Arroyo', 'PaulDArroyo@dayrep.com', '604-431-6663', '1037 Adelaide St', 'Toronto', 'M5H 1P6')");
            databaseConnection.executeQuery("INSERT INTO CUSTOMER (LicenseNumber, ExpiryDate, DateOfBirth, FirstName, LastName, EmailAddress, PhoneNumber, StreetAddress, City, PostalCode) VALUES ('D2345-34567-45678', '2022/09/12', '1993/01/10', 'Javid', 'Decster', 'javidD@gmail.com', '647-222-2222', '100 Church St', 'Toronto', 'M2M 3B2')");
            databaseConnection.executeQuery("INSERT INTO CUSTOMER (LicenseNumber, ExpiryDate, DateOfBirth, FirstName, LastName, EmailAddress, PhoneNumber, StreetAddress, City, PostalCode) VALUES ('D4020-88182-19796', '2021/03/28', '1966/03/15', 'Katherine', 'Sisson', 'KatherineDSisson@armyspy.com', '519-570-6264', '4332 Water Street', 'Kitchener','N2H 5A5')");
            databaseConnection.executeQuery("INSERT INTO CUSTOMER (LicenseNumber, ExpiryDate, DateOfBirth, FirstName, LastName, EmailAddress, PhoneNumber, StreetAddress, City, PostalCode) VALUES ('D1416-89395-92248', '2024/07/20', '1992/11/10', 'Casey', 'Trejo', 'CaseyRTrejo@jourrapide.com', '519-473-1266', '3469 Hyde Park Road', 'London', 'N6H 3S2')");
            databaseConnection.executeQuery("INSERT INTO CUSTOMER (LicenseNumber, ExpiryDate, DateOfBirth, FirstName, LastName, EmailAddress, PhoneNumber, StreetAddress, City, PostalCode) VALUES ('D6960-19171-26137', '2024/11/21', '1995/12/08', 'Josephine', 'Mast', 'JosephineNMast@teleworm.us', '519-293-2149', '2991 Baker Street', 'London', 'N0N 0N0')");
            databaseConnection.executeQuery("INSERT INTO CUSTOMER (LicenseNumber, ExpiryDate, DateOfBirth, FirstName, LastName, EmailAddress, PhoneNumber, StreetAddress, City, PostalCode) VALUES ('D4348-32119-11009', '2024/05/27', '1990/08/03', 'William', 'Walter', 'WilliamDWalter@teleworm.us', '905-621-4183', '3830 Toy Avenue', 'Ajax', 'L1S 6L6')");
            databaseConnection.executeQuery("INSERT INTO CUSTOMER (LicenseNumber, ExpiryDate, DateOfBirth, FirstName, LastName, EmailAddress, PhoneNumber, StreetAddress, City, PostalCode) VALUES ('D9133-32635-40061', '2022/09/02', '1976/02/26', 'Tina', 'Baily', 'TinaABaily@teleworm.us', '905-391-1159', '2605 Toy Avenue', 'Kitchener', 'L1W 3N9')");
            databaseConnection.executeQuery("INSERT INTO CUSTOMER (LicenseNumber, ExpiryDate, DateOfBirth, FirstName, LastName, EmailAddress, PhoneNumber, StreetAddress, City, PostalCode) VALUES ('D1601-90328-66848', '2024/09/12', '1994/10/30', 'Mattie', 'Warnock', 'MattieRWarnock@teleworm.us', '647-223-0149', '4093 Islington Ave', 'Toronto', 'M8V 3B6')");

            databaseConnection.executeQuery("INSERT INTO MEMBER (LicenseNumber, MembershipID) VALUES ('D1601-90328-66848', 1001)");
            databaseConnection.executeQuery("INSERT INTO MEMBER (LicenseNumber, MembershipID) VALUES ('D4348-32119-11009', 1002)");
            databaseConnection.executeQuery("INSERT INTO MEMBER (LicenseNumber, MembershipID) VALUES ('D9133-32635-40061', 1003)");
            databaseConnection.executeQuery("INSERT INTO MEMBER (LicenseNumber, MembershipID) VALUES ('D4020-88182-19796', 1004)");
            databaseConnection.executeQuery("INSERT INTO MEMBER (LicenseNumber, MembershipID) VALUES ('D3101-69581-63862', 1005)");

            databaseConnection.executeQuery("INSERT INTO CAR (RegistrationNumber, CarAvailability, Mileage, RentalPrice, LateFees, ModelNumber) VALUES (716830987, 'IN', 148299, 120, 20, 18187118415)");
            databaseConnection.executeQuery("INSERT INTO CAR (RegistrationNumber, CarAvailability, Mileage, RentalPrice, LateFees, ModelNumber) VALUES (416341540, 'IN', 98213, 120, 20, 53517077183)");
            databaseConnection.executeQuery("INSERT INTO CAR (RegistrationNumber, CarAvailability, Mileage, RentalPrice, LateFees, ModelNumber) VALUES (448632952, 'IN', 119096, 120, 20, 14685153720)");
            databaseConnection.executeQuery("INSERT INTO CAR (RegistrationNumber, CarAvailability, Mileage, RentalPrice, LateFees, ModelNumber) VALUES (830323748, 'IN', 44556, 80, 20, 14040211286)");
            databaseConnection.executeQuery("INSERT INTO CAR (RegistrationNumber, CarAvailability, Mileage, RentalPrice, LateFees, ModelNumber) VALUES (624749069, 'IN', 54522, 80, 20, 23552234653)");
            databaseConnection.executeQuery("INSERT INTO CAR (RegistrationNumber, CarAvailability, Mileage, RentalPrice, LateFees, ModelNumber) VALUES (232940401, 'IN', 74632, 100, 20, 46568522408)");
            databaseConnection.executeQuery("INSERT INTO CAR (RegistrationNumber, CarAvailability, Mileage, RentalPrice, LateFees, ModelNumber) VALUES (407177022, 'IN', 67354, 100, 20, 14332249770)");
            databaseConnection.executeQuery("INSERT INTO CAR (RegistrationNumber, CarAvailability, Mileage, RentalPrice, LateFees, ModelNumber) VALUES (956503875, 'IN', 132452, 60, 10, 82381133464)");
            databaseConnection.executeQuery("INSERT INTO CAR (RegistrationNumber, CarAvailability, Mileage, RentalPrice, LateFees, ModelNumber) VALUES (259930739, 'IN', 23456, 100, 20, 17210491613)");
            databaseConnection.executeQuery("INSERT INTO CAR (RegistrationNumber, CarAvailability, Mileage, RentalPrice, LateFees, ModelNumber) VALUES (257923645, 'IN', 98765, 100, 20, 12760346714)");

            databaseConnection.executeQuery("INSERT INTO CAR_MODEL (ModelNumber, ModelName, ModelYear, Manufacturer, NumberOfSeats) VALUES (18187118415, 'Ford Explorer', 2017, 'Ford', 7)");
            databaseConnection.executeQuery("INSERT INTO CAR_MODEL (ModelNumber, ModelName, ModelYear, Manufacturer, NumberOfSeats) VALUES (53517077183, 'Ford F150', 2018, 'Ford', 5)");
            databaseConnection.executeQuery("INSERT INTO CAR_MODEL (ModelNumber, ModelName, ModelYear, Manufacturer, NumberOfSeats) VALUES (14685153720, 'Jeep Wrangler', 2016, 'Jeep', 4)");
            databaseConnection.executeQuery("INSERT INTO CAR_MODEL (ModelNumber, ModelName, ModelYear, Manufacturer, NumberOfSeats) VALUES (14040211286, 'Toyota Sienna', 2018, 'Toyota', 8)");
            databaseConnection.executeQuery("INSERT INTO CAR_MODEL (ModelNumber, ModelName, ModelYear, Manufacturer, NumberOfSeats) VALUES (23552234653, 'Honda Odyssey', 2018, 'Honda', 8)");
            databaseConnection.executeQuery("INSERT INTO CAR_MODEL (ModelNumber, ModelName, ModelYear, Manufacturer, NumberOfSeats) VALUES (46568522408, 'Honda Accord', 2018, 'Honda', 5)");
            databaseConnection.executeQuery("INSERT INTO CAR_MODEL (ModelNumber, ModelName, ModelYear, Manufacturer, NumberOfSeats) VALUES (14332249770, 'Toyota Camry', 2018, 'Toyota', 5)");
            databaseConnection.executeQuery("INSERT INTO CAR_MODEL (ModelNumber, ModelName, ModelYear, Manufacturer, NumberOfSeats) VALUES (82381133464, 'Honda Civic', 2017, 'Honda', 4)");
            databaseConnection.executeQuery("INSERT INTO CAR_MODEL (ModelNumber, ModelName, ModelYear, Manufacturer, NumberOfSeats) VALUES (17210491613, 'Lexus GS', 2018, 'Lexus', 5)");
            databaseConnection.executeQuery("INSERT INTO CAR_MODEL (ModelNumber, ModelName, ModelYear, Manufacturer, NumberOfSeats) VALUES (12760346714, 'Toyota Corolla', 2017, 'Toyota', 5)");

            databaseConnection.executeQuery("INSERT INTO CAR_TYPE (CarTypeName, RentalDeposit) VALUES ('Truck', 500)");
            databaseConnection.executeQuery("INSERT INTO CAR_TYPE (CarTypeName, RentalDeposit) VALUES ('Van', 400)");
            databaseConnection.executeQuery("INSERT INTO CAR_TYPE (CarTypeName, RentalDeposit) VALUES ('Sedan', 300)");

            databaseConnection.executeQuery("INSERT INTO LOCATION (LocationNumber, LocationName, PhoneNumber, StreetAddress, City, PostalCode) VALUES (5222, 'Billy Bishop', '416-777-1618', '161A Bay Street', 'Toronto', 'M5J 2S1')");
            databaseConnection.executeQuery("INSERT INTO LOCATION (LocationNumber, LocationName, PhoneNumber, StreetAddress, City, PostalCode) VALUES (2498, 'Hamilton', '905-525-1400', '237 Main Street East', 'Hamilton', 'L8N 1H4')");
            databaseConnection.executeQuery("INSERT INTO LOCATION (LocationNumber, LocationName, PhoneNumber, StreetAddress, City, PostalCode) VALUES (8331, 'Toronto Pearson', '905-676-1100', '5990 Airport Road', 'Toronto', 'L5P 1B2')");
            databaseConnection.executeQuery("INSERT INTO LOCATION (LocationNumber, LocationName, PhoneNumber, StreetAddress, City, PostalCode) VALUES (7670, 'London Airport', '519-451-8400', '1750 Crumlin Road', 'London', 'N5V 3B6')");

            databaseConnection.executeQuery("INSERT INTO RESERVATION (ReservationID, RentalStatus, PickupLocation, StartDate, EndDate, ReturnedDate) VALUES (1, 'IN', '8331', '2018/09/28', '2018/09/29', '2018/09/29')");
            databaseConnection.executeQuery("INSERT INTO RESERVATION (ReservationID, RentalStatus, PickupLocation, StartDate, EndDate, ReturnedDate) VALUES (2, 'IN', '8331', '2018/07/02', '2018/09/06', '2018/09/06')");
            databaseConnection.executeQuery("INSERT INTO RESERVATION (ReservationID, RentalStatus, PickupLocation, StartDate, EndDate) VALUES (3, 'OUT', '8331', '2018/10/01', '2018/10/10')");
            databaseConnection.executeQuery("INSERT INTO RESERVATION (ReservationID, RentalStatus, PickupLocation, StartDate, EndDate) VALUES (4, 'OUT', '5222', '2018/10/04', '2018/10/06')");
            databaseConnection.executeQuery("INSERT INTO RESERVATION (ReservationID, RentalStatus, PickupLocation, StartDate, EndDate, ReturnedDate) VALUES (5, 'IN', '5222', '2018/10/03', '2018/10/03', '2018/10/04')");

            databaseConnection.executeQuery("INSERT INTO PROTECTIONS_COVERAGES (PCCode, PCName, PCPrice) VALUES (101, 'Loss Damage Waiver', 40)");
            databaseConnection.executeQuery("INSERT INTO PROTECTIONS_COVERAGES (PCCode, PCName, PCPrice) VALUES (102, 'Personal Accident Insurance', 10)");
            databaseConnection.executeQuery("INSERT INTO PROTECTIONS_COVERAGES (PCCode, PCName, PCPrice) VALUES (103, 'Personal Effects Protection', 5)");

            databaseConnection.executeQuery("INSERT INTO ACCESSORIES_SERVICES (ASCode, ASName, ASPrice) VALUES (201, 'Additional Driver', 10)");
            databaseConnection.executeQuery("INSERT INTO ACCESSORIES_SERVICES (ASCode, ASName, ASPrice) VALUES (202, 'Travel Tab', 25)");
            databaseConnection.executeQuery("INSERT INTO ACCESSORIES_SERVICES (ASCode, ASName, ASPrice) VALUES (203, 'GPS', 10)");
            databaseConnection.executeQuery("INSERT INTO ACCESSORIES_SERVICES (ASCode, ASName, ASPrice) VALUES (204, 'Extended Roadside Assistance', 10)");
            databaseConnection.executeQuery("INSERT INTO ACCESSORIES_SERVICES (ASCode, ASName, ASPrice) VALUES (205, 'Child Safety Seat', 5)");

            databaseConnection.executeQuery("INSERT INTO PROMOTION (PromotionCode, PromotionName, OneTimeUse) VALUES (301, 'First Rental', 'YES')");
            databaseConnection.executeQuery("INSERT INTO PROMOTION (PromotionCode, PromotionName, OneTimeUse) VALUES (302, '10x Rental', 'NO')");
            databaseConnection.executeQuery("INSERT INTO PROMOTION (PromotionCode, PromotionName, ExpiryDate, OneTimeUse, Source) VALUES (649052, 'Christmas', '2018/12/31', 'YES', 'Online')");

            databaseConnection.executeQuery("INSERT INTO PROMOTION_PERCENTAGE (PromotionCode, Percentage) VALUES (649052, 10)");

            databaseConnection.executeQuery("INSERT INTO PROMOTION_AMOUNT (PromotionCode, Amount) VALUES (301, 100)");
            databaseConnection.executeQuery("INSERT INTO PROMOTION_AMOUNT (PromotionCode, Amount) VALUES (302, 50)");

            databaseConnection.executeQuery("INSERT INTO BILLING (BillingID, BillingStatus, BillingDate, Tax, CarRentalFees, PCFees, ASFees, DiscountValue) VALUES (1, 'GOOD', '2018/09/29', 13, 200, 80, 10, 100)");
            databaseConnection.executeQuery("INSERT INTO BILLING (BillingID, BillingStatus, BillingDate, Tax, CarRentalFees) VALUES (2, 'GOOD', '2018/09/06', 13, 3600)");
            databaseConnection.executeQuery("INSERT INTO BILLING (BillingID, BillingStatus, BillingDate, Tax, CarRentalFees, PCFees, ASFees, DiscountValue) VALUES (3, 'BAD', '2018/10/01', 13, 800, 400, 100, 10)");
            databaseConnection.executeQuery("INSERT INTO BILLING (BillingID, BillingStatus, BillingDate, Tax, CarRentalFees, PCFees, ASFees) VALUES (4, 'BAD', '2018/10/04', 13, 360, 30, 30)");
            databaseConnection.executeQuery("INSERT INTO BILLING (BillingID, BillingStatus, BillingDate, Tax, CarRentalFees, CarLateFees) VALUES (5, 'GOOD', '2018/10/04', 13, 240, 20)");

            databaseConnection.executeQuery("INSERT INTO MAKES (LicenseNumber, ReservationID, BookingDate) VALUES ('D3101-69581-63862', 1, '2018/09/27')");
            databaseConnection.executeQuery("INSERT INTO MAKES (LicenseNumber, ReservationID, BookingDate) VALUES ('D2345-34567-45678', 2, '2018/07/01')");
            databaseConnection.executeQuery("INSERT INTO MAKES (LicenseNumber, ReservationID, BookingDate) VALUES ('D4020-88182-19796', 3, '2018/09/28')");
            databaseConnection.executeQuery("INSERT INTO MAKES (LicenseNumber, ReservationID, BookingDate) VALUES ('D1416-89395-92248', 4, '2018/10/03')");
            databaseConnection.executeQuery("INSERT INTO MAKES (LicenseNumber, ReservationID, BookingDate) VALUES ('D6960-19171-26137', 5, '2018/10/02')");

            databaseConnection.executeQuery("INSERT INTO CHOSEN (ReservationID, RegistrationNumber) VALUES (1, 716830987)");
            databaseConnection.executeQuery("INSERT INTO CHOSEN (ReservationID, RegistrationNumber) VALUES (2, 956503875)");
            databaseConnection.executeQuery("INSERT INTO CHOSEN (ReservationID, RegistrationNumber) VALUES (3, 407177022)");
            databaseConnection.executeQuery("INSERT INTO CHOSEN (ReservationID, RegistrationNumber) VALUES (4, 232940401)");
            databaseConnection.executeQuery("INSERT INTO CHOSEN (ReservationID, RegistrationNumber) VALUES (5, 448632952)");

            databaseConnection.executeQuery("INSERT INTO HAS (LocationNumber, RegistrationNumber) VALUES (5222, 716830987)");
            databaseConnection.executeQuery("INSERT INTO HAS (LocationNumber, RegistrationNumber) VALUES (2498, 416341540)");
            databaseConnection.executeQuery("INSERT INTO HAS (LocationNumber, RegistrationNumber) VALUES (8331, 448632952)");
            databaseConnection.executeQuery("INSERT INTO HAS (LocationNumber, RegistrationNumber) VALUES (7670, 830323748)");
            databaseConnection.executeQuery("INSERT INTO HAS (LocationNumber, RegistrationNumber) VALUES (5222, 624749069)");
            databaseConnection.executeQuery("INSERT INTO HAS (LocationNumber, RegistrationNumber) VALUES (2498, 232940401)");
            databaseConnection.executeQuery("INSERT INTO HAS (LocationNumber, RegistrationNumber) VALUES (8331, 407177022)");
            databaseConnection.executeQuery("INSERT INTO HAS (LocationNumber, RegistrationNumber) VALUES (7670, 956503875)");
            databaseConnection.executeQuery("INSERT INTO HAS (LocationNumber, RegistrationNumber) VALUES (7670, 259930739)");
            databaseConnection.executeQuery("INSERT INTO HAS (LocationNumber, RegistrationNumber) VALUES (8331, 257923645)");

            databaseConnection.executeQuery("INSERT INTO INCLUDES (ReservationID, PCCode, ASCode, PromotionCode) VALUES (1, 101, 205, 301)");
            databaseConnection.executeQuery("INSERT INTO INCLUDES (ReservationID, PCCode, ASCode, PromotionCode) VALUES (2, 101, 201, 301)");
            databaseConnection.executeQuery("INSERT INTO INCLUDES (ReservationID, PCCode, ASCode, PromotionCode) VALUES (3, 101, 202, 649052)");
            databaseConnection.executeQuery("INSERT INTO INCLUDES (ReservationID, PCCode, ASCode, PromotionCode) VALUES (4, 102, 203, 649052)");
            databaseConnection.executeQuery("INSERT INTO INCLUDES (ReservationID, PCCode, ASCode, PromotionCode) VALUES (5, 103, 204, 301)");

            databaseConnection.executeQuery("INSERT INTO CREATES (ReservationID, BillingID) VALUES (1, 1)");
            databaseConnection.executeQuery("INSERT INTO CREATES (ReservationID, BillingID) VALUES (2, 2)");
            databaseConnection.executeQuery("INSERT INTO CREATES (ReservationID, BillingID) VALUES (3, 3)");
            databaseConnection.executeQuery("INSERT INTO CREATES (ReservationID, BillingID) VALUES (4, 4)");
            databaseConnection.executeQuery("INSERT INTO CREATES (ReservationID, BillingID) VALUES (5, 5)");

            JOptionPane.showMessageDialog(mainMenuFrame, "All Tables Populated!");
        });
    }
}
