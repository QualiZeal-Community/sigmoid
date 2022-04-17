package com.qualizeal.community;

import java.util.List;

public interface Sigmoid<T, U> {
    T sumOfSeries(List<U> values);
    T sumOfSquaresOfSeries(List<U> values);
    T sumOfProductsOfSeries(List<U>... lists);
}
