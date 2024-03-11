    package org.example.Models;
    import java.sql.*;
    import java.util.ArrayList;
    import java.util.List;

    public class Operations {
        private static final String JDBC_URL = "jdbc:sqlite:billdata.db";

        public List<Bill> getAllBills() {
            List<Bill> bills = new ArrayList<>();
            try (Connection connection = DriverManager.getConnection(JDBC_URL);
                 Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery("SELECT * FROM bills")) {

                while (resultSet.next()) {
                    Bill bill = new Bill();
                    bill.setBillId(resultSet.getInt("billId"));
                    bill.setItemName(resultSet.getString("itemName"));
                    bill.setAmount(resultSet.getDouble("amount"));
                    bills.add(bill);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return bills;
        }

        public void addBill(Bill bill) {
            try (Connection connection = DriverManager.getConnection(JDBC_URL);
                 PreparedStatement preparedStatement = connection.prepareStatement(
                         "INSERT INTO bills (itemName, amount) VALUES (?, ?)")) {

                preparedStatement.setString(1, bill.getItemName());
                preparedStatement.setDouble(2, bill.getAmount());
                preparedStatement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void updateBill(Bill bill) {
            try (Connection connection = DriverManager.getConnection(JDBC_URL);
                 PreparedStatement preparedStatement = connection.prepareStatement(
                         "UPDATE bills SET itemName=?, amount=? WHERE billId=?")) {

                preparedStatement.setString(1, bill.getItemName());
                preparedStatement.setDouble(2, bill.getAmount());
                preparedStatement.setInt(3, bill.getBillId());
                preparedStatement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void deleteBill(int billId) {
            try (Connection connection = DriverManager.getConnection(JDBC_URL);
                 PreparedStatement preparedStatement = connection.prepareStatement(
                         "DELETE FROM bills WHERE billId=?")) {

                preparedStatement.setInt(1, billId);
                preparedStatement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
