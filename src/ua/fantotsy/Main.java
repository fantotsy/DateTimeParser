package ua.fantotsy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        List<String> dateTimes = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Home\\Desktop\\Example.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                dateTimes.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Calendar> convertedDateTimes = new ArrayList<Calendar>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy_HH:mm:ss", Locale.ENGLISH);
        String dateTimeWithoutMillis;
        for (String dateTime : dateTimes) {
            Calendar calendarDateTime = Calendar.getInstance();
            dateTimeWithoutMillis = dateTime.split(",")[0];
            try {
                calendarDateTime.setTime(dateFormat.parse(dateTimeWithoutMillis));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            convertedDateTimes.add(calendarDateTime);
        }
        dateTimes.clear();

        for(Calendar dateTime : convertedDateTimes) {
            System.out.println(dateTime.getTime());
        }
    }
}
