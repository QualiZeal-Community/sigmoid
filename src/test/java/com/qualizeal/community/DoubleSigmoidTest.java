package com.qualizeal.community;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.fail;

public class DoubleSigmoidTest {

    private List<Double> seriesA;
    private List<Double> seriesB;
    private List<Double> seriesC;

    @Before
    public void setUp() {
        seriesA = new ArrayList<>();
        seriesB = new ArrayList<>();
        seriesC = new ArrayList<>();
        seriesA.add(1.0);
        seriesA.add(1.0);
        seriesB.add(1.0);
        seriesB.add(1.0);
        seriesC.add(1.0);
    }

    @Test
    public void testGetInstance() {
        assertThat(DoubleSigmoid.getInstance()).isNotNull();
    }

    @Test
    public void testSumOfSeries() {
        assertThat(DoubleSigmoid.getInstance().sumOfSeries(seriesA)).isEqualTo(2.0);
    }

    @Test
    public void testSumOfSquaresOfSeries() {
        assertThat(DoubleSigmoid.getInstance().sumOfSquaresOfSeries(seriesA)).isEqualTo(2.0);
    }

    @Test
    public void testSumOfProductOfSeries() {
        assertThat(DoubleSigmoid.getInstance().sumOfProductsOfSeries(seriesA, seriesB)).isEqualTo(2.0);
    }

    @Test
    public void testSumOfProductOfSeriesMismatchSize() {
        try {
            DoubleSigmoid.getInstance().sumOfProductsOfSeries(seriesA, seriesC);
            fail("Did not throw exception");
        } catch (Exception e) {

        }
    }
}

