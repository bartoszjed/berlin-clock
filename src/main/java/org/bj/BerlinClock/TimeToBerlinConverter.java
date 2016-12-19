package org.bj.BerlinClock;

import java.time.LocalTime;

/**
 * Created by Bartosz Jedrzejczak on 16/12/2016.
 */
public class TimeToBerlinConverter {

    private LocalTime timeToConvert;

    TimeToBerlinConverter(){
        timeToConvert = LocalTime.now();
    }

    TimeToBerlinConverter(int hours, int mins, int secs){
        timeToConvert = LocalTime.of(hours, mins, secs);
    }

    private String numberDivider(int numberIn, int divisor){
        String result = "";
        int numberOfDivisors = numberIn/divisor;
        for(int i=0; i<numberOfDivisors; i++){
            result = result.concat("1");
        }
        return result;
    }

    private String paddedString(String strIn, String padChar, int expectedSize){
        String result = strIn;
        for(int i=0; i<expectedSize-strIn.length(); i++){
            result = result.concat(padChar);
        }

       return result;
    }

    String[] convert() {
        //localTime = LocalTime.of(22, 33); //10:33 PM
        //localTime = LocalTime.ofSecondOfDay(4503); // The 4,503 second in a day (1:15:30 AM)
        String[] result = {"0000", "0000", "00000000000", "0000", "0"};
        int hours = timeToConvert.getHour();
        int minutes = timeToConvert.getMinute();
        int seconds = timeToConvert.getSecond();

        result[0] = paddedString(numberDivider(timeToConvert.getHour(), 5) ,"0", 4);
        result[1] = paddedString(numberDivider(timeToConvert.getHour()%5,1),"0", 4);
        result[2] = paddedString(numberDivider(timeToConvert.getMinute(), 5),"0", 11);
        result[3] = paddedString(numberDivider(timeToConvert.getMinute()%5, 1),"0", 4);
        result[4] = ( (timeToConvert.getSecond())%2==0?"1":"0");


        return result;
    }


}
