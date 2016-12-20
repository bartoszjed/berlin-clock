package org.bj.BerlinClock;

/**
 * Created by Bartosz Jedrzejczak on 16/12/2016.
 */

class ClockRenderer{

    //Console console = new Console();
    private static String NEW_LINE = System.getProperty("line.separator");
    private static String TOP_LEFT_CORNER = "\u2554";
    private static String TOP_RIGHT_CORNER = "\u2557";
    private static String BOTTOM_LEFT_CORNER = "\u255A";
    private static String BOTTOM_RIGHT_CRNER = "\u255D";
    private static String HORIZONTAL_BORDER = "\u2550";
    private static String VERTICAL_BORDER = "\u2551";


    ClockRenderer (String[] berlinerTime){

        System.out.println(buttonLine(berlinerTime[0], "R"));
        System.out.println(buttonLine(berlinerTime[1], "R"));
        System.out.println(buttonLine(berlinerTime[2], "Y"));
        System.out.println(buttonLine(berlinerTime[3], "R"));

    }

    private String buttonLine(String values, String colour){
        int buttonCount = values.length();
        Boolean big = (buttonCount==4?true:false);
        String val = values.replace("0", "O");

        String result = "";
        for(int i=0; i< buttonCount;i++){
            result += TOP_LEFT_CORNER + HORIZONTAL_BORDER + (big?HORIZONTAL_BORDER + HORIZONTAL_BORDER :"") + TOP_RIGHT_CORNER;
        }
        result += NEW_LINE;


        for(int i=0; i< buttonCount;i++){
            String currentVal = val.substring(i,i+1);
            currentVal = (i%3==0?currentVal.replace("1","R"):currentVal.replace("1",colour));

            result += VERTICAL_BORDER + (big?" ":"") + currentVal + (big?" ":"") + VERTICAL_BORDER;;
        }
        result += NEW_LINE;


        for(int i=0; i< buttonCount;i++){
            result += BOTTOM_LEFT_CORNER + HORIZONTAL_BORDER + (big?HORIZONTAL_BORDER + HORIZONTAL_BORDER :"") + BOTTOM_RIGHT_CRNER;
        }
        result += NEW_LINE;

        return result;
    }

}
