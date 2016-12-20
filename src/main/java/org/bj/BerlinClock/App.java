package org.bj.BerlinClock;

/**
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String[] colourPattern = {"R","R","Y","R","Y","Y"}; //5h, 1h, 5min, 15min, 1min, sec

        TimeToBerlinConverter berlinConverter = new TimeToBerlinConverter(14,33,46);
        String[] berlinColouredString = berlinConverter.applyColours(berlinConverter.convertTime(), colourPattern) ;
        ClockRenderer berliner = new ClockRenderer(berlinColouredString);

    }
}
