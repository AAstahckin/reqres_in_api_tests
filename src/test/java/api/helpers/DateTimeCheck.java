package api.helpers;

import org.junit.jupiter.api.Assertions;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static api.constans.TimeFormatConstants.DD_MM_YYYY_HH_MM;

public class DateTimeCheck {

    public static void differenceTime(String checkedDate, String comparedDate, String dateFormat) {
        System.out.println(checkedDate + " " + comparedDate);
        SimpleDateFormat format = new SimpleDateFormat(dateFormat);
        try {

            Date d1 = format.parse(checkedDate);
            Date d2 = format.parse(comparedDate);
            long diff = Math.abs(d1.getTime() - d2.getTime());
            long diffMinutes = TimeUnit.MINUTES.convert(diff, TimeUnit.MILLISECONDS);
            System.out.println(diffMinutes);
            boolean temp;
            if (diffMinutes >= 0 && diffMinutes <= 1) {
                temp = true;
            } else
                temp = false;
            Assertions.assertTrue(temp, "Error differenceTime: checkedDate " + checkedDate + " != " + comparedDate);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void timeDifferenceCreateForServ(String dateCreate, int serverDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR_OF_DAY, serverDate);
        String dateLocal = new SimpleDateFormat(DD_MM_YYYY_HH_MM.getTimeFormat()).format(calendar.getTime());
        differenceTime(dateCreate, dateLocal, DD_MM_YYYY_HH_MM.getTimeFormat());
    }

}
