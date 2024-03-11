package org.example.Models;
// Bill.java
public class Bill {
    private int billId;
    private String itemName;
    private double amount;

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    // Constructors, getters, and setters

    @Override
    public String toString() {
        return "Bill{" +
                "billId=" + billId +
                ", itemName='" + itemName + '\'' +
                ", amount=" + amount +
                '}';
    }
}
