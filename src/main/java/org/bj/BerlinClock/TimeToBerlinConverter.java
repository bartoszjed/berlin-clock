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

    String[] convertTime() {
        String[] result = {"0000", "0000", "00000000000", "0000", "0"};
        int hours = timeToConvert.getHour();
        int minutes = timeToConvert.getMinute();
        int seconds = timeToConvert.getSecond();

        result[0] = paddedString(numberDivider(timeToConvert.getHour(), 5) ,"0", 4);
        result[1] = paddedString(numberDivider(timeToConvert.getHour()%5,1),"0", 4);
        result[2] = paddedString(numberDivider(timeToConvert.getMinute(), 5),"0", 11);
        result[3] = paddedString(numberDivider(timeToConvert.getMinute()%5, 1),"0", 4);
        result[4] = ( (timeToConvert.getSecond() )%2==0?"1":"0");

        return result;
    }


    String[] applyColours(String[] berlinTime, String[] colourPattern) {

        // String[] colourPattern = {"R","R","Y","R","Y","Y"}; //5h, 1h, 5min, 15min, 1min, sec

        String[] result = berlinTime;
        // row 1: 5h
        result[0] = berlinTime[0].replace("1",colourPattern[0]);

        // row 2: 1h
        result[1] = berlinTime[1].replace("1",colourPattern[1]);

        // row 3: 5 mins / 15 mins
        //currentVal = (i%3==0?currentVal.replace("1","R"):currentVal.replace("1",colour));
        result[2] = berlinTime[2].replace("1",colourPattern[2]);

        // row 4: 1 min
        result[3] = berlinTime[3].replace("1",colourPattern[3]);

        // row 0: 1 sec
        result[4] = berlinTime[4].replace("1",colourPattern[5]);


        return result;
    }
}
