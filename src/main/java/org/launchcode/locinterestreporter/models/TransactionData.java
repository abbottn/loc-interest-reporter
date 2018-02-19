package org.launchcode.locinterestreporter.models;

import java.util.ArrayList;

/**
 * Created by Nick Abbott on 12/26/2017.
 */
public class TransactionData {

    static ArrayList<Transaction> transactions = new ArrayList<>();

    // getAll
    public static ArrayList<Transaction> getAll() {
        return transactions;
    }

    // add
    public static void add(Transaction newTransaction)
    {
        transactions.add(newTransaction);
    }
    // remove
    public static void remove(int id) {
        Transaction transactionToRemove = getById(id);
        transactions.remove(transactionToRemove);
    }

    //getById
    public static Transaction getById(int id) {
        Transaction theTransaction = null;

        for (Transaction candidateTransaction : transactions) {
            if (candidateTransaction.getTransactionId() == id) {
                theTransaction = candidateTransaction;
            }
        }

        return theTransaction;
    }

}
