package org.bj.BerlinClock;

import java.io.Console;
import java.util.Arrays;

/**
 * Created by Bartosz Jedrzejczak on 16/12/2016.
 */

class ClockRenderer{

    private static String NEW_LINE = System.getProperty("line.separator");
    private static char TOP_LEFT_CORNER = '\u2554';
    private static char TOP_RIGHT_CORNER = '\u2557';
    private static char BOTTOM_LEFT_CORNER = '\u255A';
    private static char BOTTOM_RIGHT_CRNER = '\u255D';
    private static char HORIZONTAL_BORDER = '\u2550';
    private static char VERTICAL_BORDER = '\u2551';


    ClockRenderer (Console console, String[] berlinerTime){

        console.writer().println(circleLight(berlinerTime[4]));
        console.writer().println(rowOfLights(berlinerTime[0]));
        console.writer().println(rowOfLights(berlinerTime[1]));
        console.writer().println(rowOfLights(berlinerTime[2]));
        console.writer().println(rowOfLights(berlinerTime[3]));
    }

    private String rowOfLights(String values){
        int buttonCount = values.length();
        Boolean big = (buttonCount==4);

        String bigHorizontalBorder = stringFiller(6, HORIZONTAL_BORDER);
        String bigSpace = stringFiller(bigHorizontalBorder.length()/2, ' ');

        String result = (big?"":" ");
        for(int i=0; i< buttonCount;i++){
            result += String.valueOf(TOP_LEFT_CORNER) + HORIZONTAL_BORDER + (big?bigHorizontalBorder :"") + TOP_RIGHT_CORNER;
        }
        result += NEW_LINE;

        result += (big?"":" ");
        for(int i=0; i< buttonCount;i++){
            String currentVal = values.substring(i,i+1);
            result += VERTICAL_BORDER + (big?bigSpace:"") + currentVal + (big?bigSpace:"") + VERTICAL_BORDER;
        }
        result += NEW_LINE;

        result += (big?"":" ");
        for(int i=0; i< buttonCount;i++){
            result += String.valueOf(BOTTOM_LEFT_CORNER) + HORIZONTAL_BORDER + (big?bigHorizontalBorder:"") + BOTTOM_RIGHT_CRNER;
        }
        result += NEW_LINE;

        return result;
    }

    private String circleLight(String value){

        int halfSize = 18;
        String left1 = stringFiller(halfSize,"","*",' ');
        String left2 = stringFiller(halfSize,"","*  ",' ');
        String middle = stringFiller(halfSize,"","*    ",' ');

        String result = left1 + " " + stringReverse(left1) + NEW_LINE;
        result += left2 + " " +stringReverse(left2) + NEW_LINE;
        result += middle + value +stringReverse(middle) + NEW_LINE;
        result += left2 + " " +stringReverse(left2) + NEW_LINE;
        result += left1 + " " +stringReverse(left1) + NEW_LINE;

        return result;
    }

    private String stringFiller(int size, char filler) {
        return stringFiller(size,"","",filler);
    }

    private String stringFiller(int size, String startsWith, String endsWith, char filler) {
        char[] chars = new char[size-startsWith.length()-endsWith.length()];
        Arrays.fill(chars, filler);
        return startsWith.concat(new String(chars)).concat(endsWith);
    }

    private String stringReverse(String in){
        return (new StringBuilder()).append(in).reverse().toString();

    }

}
