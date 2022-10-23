package com.bok.refactoring.videoshop;

import lombok.Getter;
import lombok.Setter;

import java.util.Enumeration;
import java.util.Vector;

@Getter
@Setter
public class Customer {
    private String name;
    private Vector rentals = new Vector();

    public void addRental(Rental rental) {
        rentals.addElement(rental);
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration rentals = this.rentals.elements();
        String result = "Rental Record for " + this.name + "\n";

        while (rentals.hasMoreElements()) {
            double thisAmount = 0;
            Rental each = (Rental) rentals.nextElement();

            // 각 영화에 대한 요금 결정
            thisAmount = amountFor(each);

            // 포인트 (frequent renter points) 추가
            frequentRenterPoints ++;

            // 최신 (new release)를 이틀 이상 대여하는 겨우 추가 포인트 제공
            if((each.getMovie().getPriceCode()) == Movie.NEW_RELEASE
                && each.getDaysRented() > 1 ) {
                frequentRenterPoints ++;
            }

            // 이 대여에 대한 요금 계산 결과 표시
            result += "\t" + each.getMovie().getTitle() + "\t"
                    + thisAmount + "\n";
            totalAmount += thisAmount;
        }

        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints + "frequent renter points";
            
        return result;
    }

    private double amountFor(Rental each) {
        int thisAmount = 0;

        switch (each.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                thisAmount += 2;
                if (each.getDaysRented() >  2) {
                    thisAmount += (each.getDaysRented() - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                thisAmount += each.getDaysRented() * 3;
                break;
            case Movie.CHILDREN:
                thisAmount += 1.5;
                if (each.getDaysRented() > 3) {
                    thisAmount += (each.getDaysRented() - 3) * 1.5;
                }
                break;
         }
        return thisAmount;
    }
}
