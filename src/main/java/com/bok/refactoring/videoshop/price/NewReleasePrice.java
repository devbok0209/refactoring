package com.bok.refactoring.videoshop.price;

import com.bok.refactoring.videoshop.Movie;

public class NewReleasePrice extends Price{
    @Override
    int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    @Override
    public double getCharge(int daysRented) {
        return daysRented * 3;
    }
}
