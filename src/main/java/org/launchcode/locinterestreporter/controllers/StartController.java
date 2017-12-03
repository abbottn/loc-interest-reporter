package org.launchcode.locinterestreporter.controllers;

import org.launchcode.locinterestreporter.models.FederalHolidays;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.Calendar;
import static java.util.Calendar.*;

import java.util.GregorianCalendar;

import static org.launchcode.locinterestreporter.models.FederalHolidays.dateOf;


/**
 * Created by Nick Abbott on 9/19/2017.
 */
@Controller
@RequestMapping("interest")
public class StartController {

    @RequestMapping(value = "")
    public String index(Model model) {

        //LocalDate requestDate = LocalDate.now();

        //int requestDay = requestDate.getDayOfMonth();
        //int requestMonth = requestDate.getMonthValue();

        // Calendar today = new GregorianCalendar();
        Calendar today = Calendar.getInstance();


        int year = today.get(Calendar.YEAR);
        int month = today.get(Calendar.MONTH);
        int day = today.get(Calendar.DAY_OF_MONTH);

        String requestDate = Integer.toString(month) + " " +
                        Integer.toString(day) + " " +
                         Integer.toString(year);


        model.addAttribute("title", "Interest Reporter");
        model.addAttribute("requestDate", requestDate);
        return "interest/index";
    }

    @RequestMapping(value = "terms", method = RequestMethod.GET)
    public String displayInputForm(Model model) {
        model.addAttribute("title", "Account Terms");
        return "interest/terms";
    }

//    @RequestMapping(value = "terms", method = RequestMethod.POST)
//    public String processTermsForm(@RequestParam String printDate, @RequestParam String basedOn) {
//        // get current date
//        Calendar today = Calendar.getInstance();
//
//
//        // get bill print date
//        Calendar billDate = Calendar.getInstance();
//
//        // get holiday(s) for current month
//        String holiday = "";
//
//        switch (MONTH) {
//            case  2:
//                holiday = "WASHINGTONS_BIRTHDAY";
//            case  5:
//                holiday = "MEMORIAL_DAY";
//            case  7:
//                holiday = "INDEPENDENCE_DAY";
//            case  9:
//                holiday = "LABOR_DAY";
//
//        }
//        dateOf(FederalHolidays.Observance.Calendar.billDate.MONTH, 2017);
//
//
//        int printDay = Integer.parseInt(printDate);
//
//        int dayCount = 1;
//
//        while (dayCount < printDay) {
//            billDate.set(DAY_OF_MONTH, dayCount);
//            // check for weekend
//            if (billDate.get(DAY_OF_WEEK) == SATURDAY || billDate.get(DAY_OF_WEEK) == SUNDAY) {
//                break;
//            }
//
//            // check for holiday
//            if () {
//                break;
//            }
//
//            dayCount++;
//
//
//        }
//
//
//        // check current date before/after bill print date
//        if(today.before(billDate)) {
//
//            // check bill print date based on business or calendar day
//            if (basedOn.equals("business")) {
//                // get dates of holidays for the month
//                // set up loop to get statement date
//            }
//        }
//
//
//
//
//        return "redirect:";
//
//    }


}
