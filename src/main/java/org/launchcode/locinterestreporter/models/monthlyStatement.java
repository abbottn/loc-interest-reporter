package org.launchcode.locinterestreporter.models;

import java.time.LocalDate;

/**
 * Created by Nick Abbott on 12/21/2017.
 */
public class monthlyStatement {
    LocalDate startDate;
    LocalDate pymtDate;
    double prevBalance;
    double newBalance;
    double minPayment;

    public monthlyStatement(LocalDate startDate, LocalDate pymtDate,
                            double prevBalance, double newBalance, double minPayment) {
        this.startDate = startDate;
        this.pymtDate = pymtDate;
        this.prevBalance = prevBalance;
        this.newBalance = newBalance;
        this.minPayment = minPayment;


    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getPymtDate() {
        return pymtDate;
    }

    public double getPrevBalance() {
        return prevBalance;
    }

    public double getNewBalance() {
        return newBalance;
    }

    public double getMinPayment() {
        return minPayment;
    }
}
