package bankProject.validation;

import java.time.LocalDate;

/**
 * A valid day format should be the following:
 *      - MM.YYYY or MM/YYYY (ex. 01.2023 or 01/2023).
 */

public class CreditCardDateValidation {
    private String date;
    private int month;
    private int year;

    public boolean isDateValid(String date) {
        this.date = date;
        return isDateExpired();
    }

    private boolean isDateExpired() {
        if (splitDayMonthYear()) {
            LocalDate currentTime = LocalDate.now();
            int localMonth = currentTime.getMonthValue();
            int localYear = currentTime.getYear();
            if (!((month <= 12) && (month >= 1))) { // the month can be only from 1 to 12
                return false;
            }
            if (this.year > localYear) {
                return true;
            } else if ((this.year == localYear) && (this.month >= localMonth)) {
                return true;
            }
        }
        return false;
    }

    private boolean splitDayMonthYear() {
        if (date.matches("[0-1]+[0-9]+[./]+2+0+[2-9]+[0-9]")) {
            String[] splitDate = date.split("[./]");
            if (splitDate.length != 2) {
                return false;
            }
            if (splitDate[1].charAt(0) == '0') {          //MONTH
                month = (splitDate[1].charAt(1) - 48);
            } else {
                month = Integer.parseInt(splitDate[0]);
            }
            year = Integer.parseInt(splitDate[1]);        //YEAR
            return true;
        }
        return false;
    }
}
