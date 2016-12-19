package org.bj.BerlinClock;

import java.time.LocalTime;

/**
 * Created by Bartosz Jedrzejczak on 16/12/2016.
 */
public class TimeToBerlinConverter {

    LocalTime timeToConvert;

    TimeToBerlinConverter(){
        timeToConvert = LocalTime.now();
    }

    TimeToBerlinConverter(int hours, int mins, int secs){
        timeToConvert = LocalTime.of(hours, mins, secs);
    }

    String[] convert() {
        //localTime = LocalTime.of(22, 33); //10:33 PM
        //localTime = LocalTime.ofSecondOfDay(4503); // The 4,503 second in a day (1:15:30 AM)
        String[] result = {"0000", "0000", "00000000000", "0000"};
        int hours = timeToConvert.getHour();
        int minutes = timeToConvert.getMinute();
        int seconds = timeToConvert.getSecond();

        //result[1] = "10000";


        return result;
    }


}
