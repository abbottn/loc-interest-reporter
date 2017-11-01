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
import java.util.GregorianCalendar;

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

        Calendar today = new GregorianCalendar();

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

    @RequestMapping(value = "terms", method = RequestMethod.POST)
    public String processTermsForm(@RequestParam String printDate) {
        FederalHolidays.Observance.NEW_YEARS_DAY;
        return "redirect:";

    }
}
