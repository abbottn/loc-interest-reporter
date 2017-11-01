package org.launchcode.locinterestreporter.models;

import java.util.Calendar;
import static java.util.Calendar.*;

/**
 * Created by Nick Abbott on 9/3/2017.
 */

/**
 * For a holiday that falls on Saturday, the Federal holiday will be observed the previous Friday. If it
 * falls on Sunday, it will be observed the following Monday.
 */

public class FederalHolidays {

    /**
     * The list of Federal Observances, as per section 6103(a) of title 5 of the United States Code.
     *
     * see http://www.law.cornell.edu/uscode/text5/6103
     */

    public enum Observance {

        /**
         *  January 1st.
         */
        NEW_YEARS_DAY(JANUARY, 1),
        /**
         *  Third Monday in January.
         */
        BIRTHDAY_OF_MARTIN_LUTHER_KING_JR(JANUARY, MONDAY, 3),
        /**
         *  Third Monday in February.
         */
        WASHINGTONS_BIRTHDAY(FEBRUARY, MONDAY, 3),
        /**
         *  Last Monday in May.
         */
        MEMORIAL_DAY(MAY, MONDAY, -1),
        /**
         *  July 4th.
         */
        INDEPENDANCE_DAY(JULY, 4),
        /**
         *  First Monday in September.
         */
        LABOR_DAY(SEPTEMBER, MONDAY, 1),
        /**
         *  Second Monday in October.
         */
        COLUMBUS_DAY(OCTOBER, MONDAY, 2),
        /**
         *  November 11th.
         */
        VETERANS_DAY(NOVEMBER, 11),
        /**
         *  Fourth Thursday in November.
         */
        THANKDGIVING_DAY(NOVEMBER, THURSDAY, 4),
        /**
         *  December 25th.
         */
        CHRISTMAS_DAY(DECEMBER, 25);

        private final int month;
        private final int dayOfMonth;
        private final int dayOfWeek;
        private final int weekOfMonth;
        private static final int NA = 0;

        private Observance(int month, int dayOfMonth) {
            this.month = month;
            this.dayOfMonth = dayOfMonth;
            this.dayOfWeek = NA;
            this.weekOfMonth = NA;
        }

        private Observance(int month, int dayOfWeek, int weekOfMonth) {

            this.month = month;
            this.dayOfMonth = NA;
            this.dayOfWeek = dayOfWeek;
            this.weekOfMonth = weekOfMonth;
        }

        /**
         * Returns true if this observance is a fixed date, e.g. December 25th or January 1st.
         * Non-fixed dates are those that are on a particular day of week and week of the month,
         * e.g. 3rd Thursday in November.
         */

        boolean isFixedDate() {
            return dayOfMonth != NA;
        }

    }

}
