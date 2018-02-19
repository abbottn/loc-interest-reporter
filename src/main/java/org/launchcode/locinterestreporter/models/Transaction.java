package org.launchcode.locinterestreporter.models;

import java.time.LocalDate;

/**
 * Created by Nick Abbott on 12/21/2017.
 */
public class Transaction {
    private LocalDate transactionDate;
    private double balance;
    private int transactionId;
    private static int nextId = 1;


    public Transaction(LocalDate transactionDate, double balance) {
        this();
        this.transactionDate = transactionDate;
        this.balance = balance;
    }

    public Transaction() {
        transactionId = nextId;
        nextId++;

    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public double getBalance() {
        return balance;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

}
