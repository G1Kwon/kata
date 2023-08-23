package VideoRental;

import java.util.ArrayList;
import java.util.List;

public class Customer_2 {
    private String _name;
    private List<Rental_2> _rentals = new ArrayList<Rental_2>();

    public Customer_2(String name) {
        _name = name;
    }

    public void addRental(Rental_2 arg) {
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
        result += "You earned " + String.valueOf(getFrequentRenterPoints()) + " frequent renter points";

        return result;
    }

    private int getFrequentRenterPoints() {
        int result = 0;
        for (Rental_2 aRental : _rentals) {
            result += aRental.getPoint();
        }
        return result;
    }

    private String getMidLines() {
        String result = "";
        for (Rental_2 aRental : _rentals) {
            result += "\t" + aRental.getMovie().getTitle() + "\t" + String.valueOf(aRental.getCharge()) + "\n";
        }
        return result;
    }

    private double getTotalAmount() {
        double totalAmount = 0;
        for (Rental_2 aRental : _rentals) {
            totalAmount += aRental.getCharge();
        }
        return totalAmount;
    }

}