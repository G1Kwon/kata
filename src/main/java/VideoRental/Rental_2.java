package VideoRental;

/**
 * The rental class represents a customer renting a movie.
 */
public class Rental_2 {

    private Movie_1 _movie;
    private int _daysRented;

    public Rental_2(Movie_1 movie, int daysRented) {
        _movie = movie;
        _daysRented = daysRented;
    }

    public int getDaysRented() {
        return _daysRented;
    }

    public Movie_1 getMovie() {
        return _movie;
    }

    public double getCharge() {
        return _movie.getCharge(_daysRented);
    }

    public int getPoint() {
        return getMovie().getPoint(_daysRented);
    }
}