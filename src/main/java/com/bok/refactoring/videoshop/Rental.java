package com.bok.refactoring.videoshop;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Rental {
    private Movie movie;
    private int daysRented;
}
