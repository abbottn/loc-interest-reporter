package org.launchcode.locinterestreporter.controllers;

import org.launchcode.locinterestreporter.models.Transaction;
import org.launchcode.locinterestreporter.models.TransactionData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Created by Nick Abbott on 12/12/2017.
 */
@Controller
@RequestMapping(value="transaction")
public class TransactionController {

    // Request path: /transaction
    @RequestMapping(value="")
    public String index(Model model) {
        return "transaction/index";
    }

    @RequestMapping(value = "terms", method = RequestMethod.GET)
    public String proesssTermsForm(Model model) {
        // return "printDay" + printDay + "\n" + "dayType" + dayType + "\n" + "interestRate" + interestRate;
        model.addAttribute("title", "Initial Account Setup Data");

        return "transaction/terms";
    }

    @RequestMapping(value = "terms", method = RequestMethod.POST)
    public String proesssTermsForm(@RequestParam String printDay,
                                   @RequestParam String dayBasis,
                                   @RequestParam String interestRate) {
        // return "printDay" + printDay + "\n" + "dayType" + dayType + "\n" + "interestRate" + interestRate;
        return "transaction/statement";  // go to a URL return add
    }

    @RequestMapping(value = "statement", method = RequestMethod.POST)
    public String processStatementForm(Model model,
                                       @RequestParam String interestRate,
                                       @RequestParam String dayBasis,
                                       @RequestParam String printDay) {
        // return "printDay" + printDay + "\n" + "dayType" + dayType + "\n" + "interestRate" + interestRate;
        model.addAttribute("title","Statement");
        model.addAttribute("printDay", printDay);
        model.addAttribute("dayBasis", dayBasis);
        model.addAttribute("interestRate", interestRate);
        return "transaction/statement";  // go to a URL return add
    }

    @RequestMapping(value = "initial-transaction", method = RequestMethod.POST)
    public String displayaddTransactionForm(Model model
                                            // @RequestParam String interestRate,
                                            // @RequestParam String dayBasis,
                                            // @RequestParam String printDay) {
                                                                            ) {
        model.addAttribute("transactions", TransactionData.getAll());
        model.addAttribute("title", "Initial Statement Transaction");
        // model.addAttribute("printDay", printDay);
        // model.addAttribute("dayBasis", dayBasis);
        // model.addAttribute("interestRate", interestRate);


        return "transaction/add";
    }

    @RequestMapping(value = "additional-transaction", method = RequestMethod.POST)
    public String processaddTransactionForm(Model model,
                                            @RequestParam String interestRate,
                                            @RequestParam String newDate,
                                            @RequestParam String transaction,
                                            @RequestParam String newAmount) {
        // return "printDay" + printDay + "\n" + "dayType" + dayType + "\n" + "interestRate" + interestRate;
        // TODO convert newDate to LocalDate
        // TODO create newTransaction using newDate
        // TODO move call to now() to calculation portion

        // TODO check if checkbox checked
        if (transaction == "checked") {
            int i = 1;
        }

        model.addAttribute("title", "Additional Statement Transaction");
        model.addAttribute("interestRate", interestRate);

        LocalDate transDate = LocalDate.now();
        double transAmount = Double.parseDouble(newAmount);
        Transaction newTransaction = new Transaction(transDate, transAmount);
        TransactionData.add(newTransaction);
        return "transaction/add";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveTransactionForm(Model model) {
        model.addAttribute("transaction", TransactionData.getAll());
        return "transaction/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String proesssRemoveTransactionForm(@RequestParam int[] transactionIds) {
        // return "printDay" + printDay + "\n" + "dayType" + dayType + "\n" + "interestRate" + interestRate;

        for (int transactionId : transactionIds) {
            TransactionData.remove(transactionId);
        }

        return "redirect:";
    }
}
