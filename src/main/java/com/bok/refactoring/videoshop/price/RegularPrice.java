package com.bok.refactoring.videoshop.price;

import com.bok.refactoring.videoshop.Movie;

public class RegularPrice extends Price {
    @Override
    int getPriceCode() {
        return Movie.REGULAR;
    }
}
