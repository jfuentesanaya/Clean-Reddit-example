package jfuentesa.cleanarchitecture.utils;

import android.content.Context;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import jfuentesa.cleanarchitecture.R;

/**
 * Created by jfuentesa on 28/10/2016.
 */

public class DateParse {

    public static String createDate(Context context, long created){

        Date createdDate = new Date(created*1000L);
        createdDate.getTime();

        Calendar currentDate = Calendar.getInstance();
        currentDate.getTime();

        long millisecondsAgo = currentDate.getTime().getTime() - createdDate.getTime();

        long seconds = TimeUnit.MILLISECONDS.toSeconds(millisecondsAgo);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(millisecondsAgo);

        String time_to_return;

        //Hace X minuto/s
        if (minutes <= 60) {
            if (minutes < 1) {
                time_to_return = context.getString(R.string.seconds, (int)seconds);
            } else {
                time_to_return = context.getResources().getQuantityString(R.plurals.minutes, (int)minutes, (int)minutes);
            }
        } else {
            long hours = TimeUnit.MILLISECONDS.toHours(millisecondsAgo);

            //Hace X hora/s
            if (hours <= 24) {
                time_to_return = context.getResources().getQuantityString(R.plurals.hours, (int)hours, (int)hours);
            } else {
                long days = TimeUnit.MILLISECONDS.toDays(millisecondsAgo);
                time_to_return = context.getResources().getQuantityString(R.plurals.days, (int)days, (int)days);
            }
        }

        return time_to_return;
    }

}
