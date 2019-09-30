package learning.java;

import java.util.ArrayList;

public class Customer {

    private String name;
    private ArrayList<Double> transactions;
    private double balance;

    private Customer(String name, double initialTransaction) {
        setName(name);
        this.transactions = new ArrayList<>();
        this.transactions.add(Math.max(initialTransaction, 0));
        this.balance = this.transactions.get(0);
    }

    static Customer createCustomer(String name, double initialTransaction) {
        return new Customer(name, initialTransaction);
    }

    boolean addTransaction(double amount) {
        if (amount < 0) {
            if (this.balance + amount < 0) {
                return false;
            }
        }
        this.transactions.add(amount);
        this.balance += amount;
        return true;
    }

    String getName() {
        return this.name;
    }

    void setName(String name) {
        this.name = name.toLowerCase();
    }

    double[] getTransactions() {
        double[] transactions = new double[this.transactions.size()];
        for (int i = 0; i < transactions.length; i++) {
            transactions[i] = this.transactions.get(i);
        }
        return transactions;
    }

    double getBalance() {
        return this.balance;
    }
}
