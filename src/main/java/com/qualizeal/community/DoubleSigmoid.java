package com.qualizeal.community;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class DoubleSigmoid implements Sigmoid<Double, Double> {

    private static DoubleSigmoid instance;

    private DoubleSigmoid() {
        // Prevent Instantiation
    }

    public static DoubleSigmoid getInstance() {
        if (Objects.isNull(instance)) {
            instance = new DoubleSigmoid();
        }
        return instance;
    }

    @Override
    public Double sumOfSeries(List<Double> series) {
        return series.stream().mapToDouble(Double::doubleValue).sum();
    }

    @Override
    public Double sumOfSquaresOfSeries(List<Double> series) {
        return series.stream().map(s -> s * s).mapToDouble(Double::doubleValue).sum();
    }

    @SafeVarargs
    @Override
    public final Double sumOfProductsOfSeries(List<Double>... listOfSeries) {
        if (!Arrays.stream(listOfSeries).allMatch(s -> s.size() == listOfSeries[0].size())) {
            throw new SeriesSizeMismatchException();
        }
        return IntStream.range(0, listOfSeries[0].size()).mapToDouble(i -> {
            double product = 1;
            for (List<Double> series : listOfSeries) {
                product *= series.get(i);
            }
            return product;
        }).sum();
    }
}
