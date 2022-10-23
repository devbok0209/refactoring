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
            Rental each = (Rental) rentals.nextElement();

            // 포인트 (frequent renter points) 추가
            frequentRenterPoints ++;

            // 최신 (new release)를 이틀 이상 대여하는 겨우 추가 포인트 제공
            if((each.getMovie().getPriceCode()) == Movie.NEW_RELEASE
                && each.getDaysRented() > 1 ) {
                frequentRenterPoints ++;
            }

            // 이 대여에 대한 요금 계산 결과 표시
            result += "\t" + each.getMovie().getTitle() + "\t"
                    + each.getCharge() + "\n";
            totalAmount += each.getCharge();
        }

        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints + "frequent renter points";
            
        return result;
    }

}
