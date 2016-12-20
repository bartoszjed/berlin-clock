package org.bj.BerlinClock;

import java.util.Arrays;

/**
 * Created by Bartosz Jedrzejczak on 16/12/2016.
 */

class ClockRenderer{

    //Console console = new Console();
    private static String NEW_LINE = System.getProperty("line.separator");
    private static char TOP_LEFT_CORNER = '\u2554';
    private static char TOP_RIGHT_CORNER = '\u2557';
    private static char BOTTOM_LEFT_CORNER = '\u255A';
    private static char BOTTOM_RIGHT_CRNER = '\u255D';
    private static char HORIZONTAL_BORDER = '\u2550';
    private static char VERTICAL_BORDER = '\u2551';


    ClockRenderer (String[] berlinerTime){
        System.out.println(rowOfLights(berlinerTime[0]));
        System.out.println(rowOfLights(berlinerTime[1]));
        System.out.println(rowOfLights(berlinerTime[2]));
        System.out.println(rowOfLights(berlinerTime[3]));

    }

    private String rowOfLights(String values){
        int buttonCount = values.length();
        Boolean big = (buttonCount==4?true:false);

        String bigHorizontalBorder = stringFiller(6, HORIZONTAL_BORDER);
        String bigSpace = stringFiller(bigHorizontalBorder.length()/2, ' ');

        String result = (big?"":" ");;
        for(int i=0; i< buttonCount;i++){
            result += String.valueOf(TOP_LEFT_CORNER) + HORIZONTAL_BORDER + (big?bigHorizontalBorder :"") + TOP_RIGHT_CORNER;
        }
        result += NEW_LINE;

        result += (big?"":" ");
        for(int i=0; i< buttonCount;i++){
            String currentVal = values.substring(i,i+1);
            result += VERTICAL_BORDER + (big?bigSpace:"") + currentVal + (big?bigSpace:"") + VERTICAL_BORDER;;
        }
        result += NEW_LINE;

        result += (big?"":" ");
        for(int i=0; i< buttonCount;i++){
            result += String.valueOf(BOTTOM_LEFT_CORNER) + HORIZONTAL_BORDER + (big?bigHorizontalBorder:"") + BOTTOM_RIGHT_CRNER;
        }
        result += NEW_LINE;

        return result;
    }


    private String stringFiller(int size, char filler) {
        char[] chars = new char[size];
        Arrays.fill(chars, filler);
        return new String(chars);
    }

}
