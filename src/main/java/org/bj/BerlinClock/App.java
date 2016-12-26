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
        console.writer().println ("Please specify time in format HH24:MI:SS e.g. 13:51:33, or hit ENTER for current time.");

        LocalTime result = null;
        String aLine;
        //do {
            aLine = console.readLine();

            if(aLine.isEmpty()){
                return LocalTime.now();
            }

            try {
                result = LocalTime.parse(aLine);
            }
            catch (Exception e){
                console.writer().println("Wrong tie entered, please try once more, or hit Enter for current time.");
            }
//        }
        //while(result != null);

        return result;
    }
}
