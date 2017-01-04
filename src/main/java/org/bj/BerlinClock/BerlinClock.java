package org.bj.BerlinClock;

import java.time.LocalTime;

/**
 * Created by Bartosz Jedrzejczak on 04/01/2017.
 */
public class BerlinClock {

    private UserInterface ui;
    private final String[] colourPattern = {"R","R","Y","R","Y","Y"}; //5h, 1h, 5min, 15min, 1min, sec

    BerlinClock(){
        ui = new UserInterface();
    }

    void runClock() {

        LocalTime timeEntered = getUserInput();

        TimeToBerlinConverter berlinConverter = new TimeToBerlinConverter(timeEntered);
        String[] berlinColouredString = berlinConverter.applyColours(berlinConverter.convertTime(), colourPattern);
        new ClockRenderer(ui, berlinColouredString);
    }

    private LocalTime getUserInput() {
        LocalTime result = LocalTime.now();
        Boolean success;
        String aLine;
        do {
            success = true;
            ui.printLine("Please specify time in format HH24:MI:SS e.g. 13:51:33, or hit ENTER for current time.");
            aLine = ui.readLine();

            if(aLine.isEmpty()){
                return result;
            }

            try {
                result = LocalTime.parse(aLine);
            }
            catch (Exception e){
                success = false;
                ui.printLine("Wrong time entered, please try once more.");
                ui.printLine();
            }
        }
        while(!success);

        return result;
    }
}
