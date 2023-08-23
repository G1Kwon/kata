package VideoRental;

import java.util.ArrayList;
import java.util.List;

public class Customer_1 {
    private String _name;
    private List<Rental_1> _rentals = new ArrayList<Rental_1>();

    public Customer_1(String name) {
        _name = name;
    }

    public void addRental(Rental_1 arg) {
        _rentals.add(arg);
    }

    public String getName() {
        return _name;
    }

    public String statement() {
        String result = "";
        // add head lines
        result += "Rental Record for " + getName() + "\n";

        // add mid lines
        result += getMidLines();

        // add footer lines
        result += "Amount owed is " + String.valueOf(getTotalAmount()) + "\n";
        result += "You earned " + String.valueOf(getPoint()) + " frequent renter points";

        return result;
    }

    private int getPoint() {
        int result = 0;
        for (Rental_1 aRental : _rentals) {
            result += getPoint(aRental);
        }
        return result;
    }

    private static int getPoint(Rental_1 aRental) {
        int result = 0 ;
        // add frequent renter points
        result++;
        // add bonus for a two day new release rental
        if ((aRental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && aRental.getDaysRented() > 1)
            result++;
        return result;
    }

    private String getMidLines() {
        String result = "";
        for (Rental_1 aRental : _rentals) {
            result += "\t" + aRental.getMovie().getTitle() + "\t" + String.valueOf(aRental.getCharge()) + "\n";
        }
        return result;
    }

    private double getTotalAmount() {
        double totalAmount = 0;
        for (Rental_1 aRental : _rentals) {
            totalAmount += aRental.getCharge();
        }
        return totalAmount;
    }

}