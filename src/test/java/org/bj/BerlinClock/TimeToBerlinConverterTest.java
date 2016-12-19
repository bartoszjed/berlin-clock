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
    public void convert_0_00h()throws Exception {
        converter = new TimeToBerlinConverter(0,0,0);
        String[] result = {"0000", "0000", "00000000000", "0000", "0"};
        assertThat(converter.convert(), is(result));
    }


    @Test
    public void convert_10h00m()throws Exception {
        converter = new TimeToBerlinConverter(10,0,0);
        String[] result = {"1100", "0000", "00000000000", "0000", "0"};
        assertThat(converter.convert(), is(result));
    }

    @Test
    public void convert_20h00m()throws Exception {
        converter = new TimeToBerlinConverter(20,0,0);
        String[] result = {"1111", "0000", "00000000000", "0000", "0"};
        assertThat(converter.convert(), is(result));
    }

    @Test
    public void convert_23h_15m()throws Exception {
        converter = new TimeToBerlinConverter(23,15,0);
        String[] result = {"1111", "1110", "11100000000", "0000", "0"};
        assertThat(converter.convert(), is(result));
    }

    @Test
    public void convert_12h_08m()throws Exception {
        converter = new TimeToBerlinConverter(12,8,0);
        String[] result = {"1100", "1100", "10000000000", "1110", "0"};
        assertThat(converter.convert(), is(result));
    }
}