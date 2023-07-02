package api.utils;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.Assertions;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static api.constans.TimeFormatConstants.DD_MM_YYYY_HH_MM;

public class DateTimeCheck {

    public static void differenceTime(String checkedDate, String comparedDate, String dateFormat) {
        SimpleDateFormat format = new SimpleDateFormat(dateFormat);
        try {

            Date d1 = format.parse(checkedDate);
            Date d2 = format.parse(comparedDate);
            long diff = Math.abs(d1.getTime() - d2.getTime());
            long diffMinutes = TimeUnit.MINUTES.convert(diff, TimeUnit.MILLISECONDS);
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

    public static void timeDifferenceCreateForServ(String dateCreate) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR_OF_DAY, -3);
        String dateLocal = new SimpleDateFormat(DD_MM_YYYY_HH_MM.getValue()).format(calendar.getTime());
        Allure.step("Проверка разница во времени: " + dateCreate+ " : " + dateLocal);
        differenceTime(dateCreate, dateLocal, DD_MM_YYYY_HH_MM.getValue());
    }

}
