package org.bj.BerlinClock;

import java.io.Console;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 */
public class App {

    private static Console console;

    public static void main( String[] args ) {

        console = System.console();
        String[] colourPattern = {"R","R","Y","R","Y","Y"}; //5h, 1h, 5min, 15min, 1min, sec

        LocalTime timeEntered = getUserInput();

//        TimeToBerlinConverter berlinConverter = new TimeToBerlinConverter(14,33,46);
        TimeToBerlinConverter berlinConverter = new TimeToBerlinConverter(timeEntered);
        String[] berlinColouredString = berlinConverter.applyColours(berlinConverter.convertTime(), colourPattern);
        ClockRenderer berliner = new ClockRenderer(console, berlinColouredString);

    }

    private static LocalTime getUserInput() {
        LocalTime result = LocalTime.now();
        Boolean success;
        String aLine;
        do {
            success = true;
            console.writer().println ("Please specify time in format HH24:MI:SS e.g. 13:51:33, or hit ENTER for current time.");
            aLine = console.readLine();

            if(aLine.isEmpty()){
                return result;
            }

            try {
                result = LocalTime.parse(aLine);
            }
            catch (Exception e){
                success = false;
                console.writer().println("Wrong time entered, please try once more.");
                console.writer().println();
            }
        }
        while(!success);

        return result;
    }
}
