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
        Enumeration rentals = this.rentals.elements();
        String result = "Rental Record for " + this.name + "\n";

        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();

            // 이 대여에 대한 요금 계산 결과 표시
            result += "\t" + each.getMovie().getTitle() + "\t"
                    + each.getCharge() + "\n";
        }

        result += "Amount owed is " + getTotalCharge() + "\n";
        result += "You earned " + getTotalFrequentRenterPoints() + "frequent renter points";
            
        return result;
    }

    public String htmlStatement() {
        Enumeration rentals = this.rentals.elements();
        String result = "<H1>Rental Record for <EM>" + this.name + "</EM><H1><P>\n";

        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();

            // 이 대여에 대한 요금 계산 결과 표시
            result += each.getMovie().getTitle() + ": "
                    + each.getCharge() + "<BR>\n";
        }

        result += "<P>Amount owed is <EM>" + getTotalCharge() + "</EM><P>\n";
        result += "You earned <EM>" + getTotalFrequentRenterPoints() + "</EM> frequent renter points<P>";

        return result;
    }

    private double getTotalCharge() {
        double result = 0;
        Enumeration rentals = this.rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getCharge();
        }
        return result;
    }

    private int getTotalFrequentRenterPoints() {
        int result = 0;
        Enumeration rentals = this.rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }

}
