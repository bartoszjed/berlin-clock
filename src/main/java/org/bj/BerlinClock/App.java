package org.bj.BerlinClock;

import java.io.Console;

/**
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        String[] berlinerTime = new TimeToBerlinConverter(14,33,46).convert();
        ClockRenderer berliner = new ClockRenderer(berlinerTime);

    }
}
