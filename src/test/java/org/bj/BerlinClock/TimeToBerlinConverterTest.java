package org.bj.BerlinClock;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Bartosz Jedrzejczak on 19/12/2016.
 */
public class TimeToBerlinConverterTest {

    TimeToBerlinConverter converter;

    @Test
    public void convert_0h()throws Exception {
        converter = new TimeToBerlinConverter(0,0,0);
        String[] result = {"0000", "0000", "00000000000", "0000"};
        assertThat(converter.convert(), is(result));
    }


    @Test
    public void convert_10h()throws Exception {
        converter = new TimeToBerlinConverter(0,0,0);
        String[] result = {"1100", "0000", "00000000000", "0000"};
        assertThat(converter.convert(), is(result));
    }

    @Test
    public void convert_20h()throws Exception {
        converter = new TimeToBerlinConverter(0,0,0);
        String[] result = {"1100", "0000", "00000000000", "0000"};
        assertThat(converter.convert(), is(result));
    }
}