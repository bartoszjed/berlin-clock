package org.bj.BerlinClock;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Bartosz Jedrzejczak on 19/12/2016.
 */
public class TimeToBerlinConverterTest {

    private TimeToBerlinConverter converter;



    @Test
    public void convert_00h00h00s()throws Exception {
        converter = new TimeToBerlinConverter(0,0,0);
        String[] expectedTime = {"0000", "0000", "00000000000", "0000", "1"};
        assertThat(converter.convertTime(), is(expectedTime));
    }

    @Test
    public void convert_10h00m00s()throws Exception {
        converter = new TimeToBerlinConverter(10,0,0);
        String[] expectedTime = {"1100", "0000", "00000000000", "0000", "1"};
        assertThat(converter.convertTime(), is(expectedTime));
    }

    @Test
    public void convert_20h00m00s()throws Exception {
        converter = new TimeToBerlinConverter(20,0,0);
        String[] expectedTime = {"1111", "0000", "00000000000", "0000", "1"};
        assertThat(converter.convertTime(), is(expectedTime));
    }

    @Test
    public void convert_23h_15m00s()throws Exception {
        converter = new TimeToBerlinConverter(23,15,0);
        String[] expectedTime = {"1111", "1110", "11100000000", "0000", "1"};
        assertThat(converter.convertTime(), is(expectedTime));
    }

    @Test
    public void convert_12h_08m00s()throws Exception {
        converter = new TimeToBerlinConverter(12,8,0);
        String[] expectedTime = {"1100", "1100", "10000000000", "1110", "1"};
        assertThat(converter.convertTime(), is(expectedTime));
    }

    @Test
    public void convert_16h_56m_32s()throws Exception {
        converter = new TimeToBerlinConverter(16,56,32);
        String[] expectedTime = {"1110", "1000", "11111111111", "1000", "1"};
        assertThat(converter.convertTime(), is(expectedTime));
    }

    @Test
    public void convert_17h_31m_01s()throws Exception {
        converter = new TimeToBerlinConverter(17,31,1);
        String[] expectedTime = {"1110", "1100", "11111100000", "1000", "0"};
        assertThat(converter.convertTime(), is(expectedTime));
    }

    @Test
    public void verify_colourPattern_RRYRYY()throws Exception {
        converter = new TimeToBerlinConverter(17,31,1);
        //String[] expectedTime = {"1110", "1100", "11111100000", "1000", "0"};
        String[] resultTime = converter.convertTime();
        String[] colourPattern = {"R","R","Y","R","Y","Y"}; //5h, 1h, 5min, 15min, sec
        String[] expectedResult = {"RRR0", "RR00", "YYRYYR00000", "Y000", "0"};
        assertThat(converter.applyColours(resultTime, colourPattern), is(expectedResult));
    }

    @Test
    public void verify_colourPattern_BBGBGG()throws Exception {
        converter = new TimeToBerlinConverter(17,31,2);
        //String[] expectedTime = {"1110", "1100", "11111100000", "1000", "0"};
        String[] resultTime = converter.convertTime();
        String[] colourPattern = {"B","B","G","B","G","R"}; //5h, 1h, 5min, 15min, sec
        String[] expectedResult = {"BBB0", "BB00", "GGBGGB00000", "G000", "R"};
        assertThat(converter.applyColours(resultTime, colourPattern), is(expectedResult));
    }
}