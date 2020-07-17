package pokemonGame.Entity;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import pokemonGame.Enum.TimesOfDay;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Game {

    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public static DateTime getData(){
        DateTimeZone dateTimeZone = DateTimeZone.forID("Europe/Moscow");
        return DateTime.now(dateTimeZone);
    }

    public static LocalTime getTime(){
   return null;
     }

     public static TimesOfDay getTimesOfDay(){
            if (getData().getHourOfDay() >= 12 && getData().getHourOfDay() < 20)
            return TimesOfDay.DAY;
            else if(getData().getHourOfDay() >= 20 || getData().getHourOfDay() < 4 )
                 return TimesOfDay.NIGHT;
            else return TimesOfDay.MORNING;
     }
}
