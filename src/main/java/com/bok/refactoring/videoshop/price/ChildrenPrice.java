package com.bok.refactoring.videoshop.price;

import com.bok.refactoring.videoshop.Movie;

public class ChildrenPrice extends Price {
    @Override
    int getPriceCode() {
        return Movie.CHILDREN;
    }
}
