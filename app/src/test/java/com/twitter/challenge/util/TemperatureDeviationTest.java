package com.twitter.challenge.util;

import org.assertj.core.api.Java6Assertions;
import org.assertj.core.data.Offset;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.assertj.core.api.Java6Assertions.within;


public class TemperatureDeviationTest {

    private List<Float> entryData;

    @Before
    public void setup(){
        entryData = new ArrayList<>();
        entryData.add(20f);
        entryData.add(50f);
        entryData.add(10f);
        entryData.add(45f);
        entryData.add(70f);
    }

    @Test
    public void test(){
        final Offset<Float> precision = within(0.01f);
        float standard = TemperatureDeviation.calculateStandardDeviation(entryData);
        System.out.println(standard);
        assertThat(standard).isEqualTo((float)24.08,precision);
    }
}