package VideoRental;

import junit.framework.TestCase;
import org.junit.Test;

public class CustomerTest extends TestCase {

    @Test
    public void test() {
        Customer customer = new Customer("Bob");
        customer.addRental(new Rental(new Movie("Jaws", Movie.REGULAR), 2));
        customer.addRental(new Rental(new Movie("Golden Eye", Movie.REGULAR), 3));
        customer.addRental(new Rental(new Movie("Short New", Movie.NEW_RELEASE), 1));
        customer.addRental(new Rental(new Movie("Long New", Movie.NEW_RELEASE), 2));
        customer.addRental(new Rental(new Movie("Bambi", Movie.CHILDRENS), 3));
        customer.addRental(new Rental(new Movie("Toy Story", Movie.CHILDRENS), 4));

        String expected = "" +
                "Rental Record for Bob\n" +
                "\tJaws\t2.0\n" +
                "\tGolden Eye\t3.5\n" +
                "\tShort New\t3.0\n" +
                "\tLong New\t6.0\n" +
                "\tBambi\t1.5\n" +
                "\tToy Story\t3.0\n" +
                "Amount owed is 19.0\n" +
                "You earned 7 frequent renter points";

        assertEquals(expected, customer.statement());
    }

    @Test
    public void returnNewCustomer() {
        Customer customer = new Customer("NAME_NOT_IMPORTANT");
        assertNotNull(customer);
    }

    @Test
    public void statementForNoRental() {
        // arrange
        Customer customer = new Customer("NAME_NOT_IMPORTANT");

        // act
        String statement = customer.statement();

        // assert
        assertEquals(statement, "Rental Record for NAME_NOT_IMPORTANT\n"
                + "Amount owed is 0.0\n"
                + "You earned 0 frequent renter points");
    }

    @Test
    public void statementForRegularMovieRentalForLessThan3Days() {
        // arrange
        Customer customer = new Customer("NAME_NOT_IMPORTANT");
        Movie movie = new Movie("TITLE_NOT_IMPORTANT", Movie.REGULAR);
        int daysRented = 2;
        Rental rental = new Rental(movie, daysRented);
        customer.addRental(rental);

        // act
        String statement = customer.statement();

        // assert
        assertEquals(statement, "Rental Record for NAME_NOT_IMPORTANT\n"
                + "\tTITLE_NOT_IMPORTANT\t2.0\n"
                + "Amount owed is 2.0\n"
                + "You earned 1 frequent renter points");
    }

    @Test
    public void statementForNewReleaseMovie() {
        // arrange
        Customer customer = new Customer("NAME_NOT_IMPORTANT");
        Movie movie = new Movie("TITLE_NOT_IMPORTANT", Movie.NEW_RELEASE);
        int daysRented = 1;
        Rental rental = new Rental(movie, daysRented);
        customer.addRental(rental);

        // act
        String statement = customer.statement();

        // assert
        assertEquals(statement, "Rental Record for NAME_NOT_IMPORTANT\n"
                + "\tTITLE_NOT_IMPORTANT\t3.0\n"
                + "Amount owed is 3.0\n"
                + "You earned 1 frequent renter points");
    }

    @Test
    public void statementForChildrensMovieRentalMoreThan3Days() {
        // arrange
        Customer customer = new Customer("NAME_NOT_IMPORTANT");
        Movie movie = new Movie("TITLE_NOT_IMPORTANT", Movie.CHILDRENS);
        int daysRented = 4;
        Rental rental = new Rental(movie, daysRented);
        customer.addRental(rental);

        // act
        String statement = customer.statement();

        // assert
        assertEquals(statement, "Rental Record for NAME_NOT_IMPORTANT\n"
                + "\tTITLE_NOT_IMPORTANT\t3.0\n"
                + "Amount owed is 3.0\n"
                + "You earned 1 frequent renter points");
    }

    @Test
    public void statementForChildrensMovieRentalMoreThan4Days() {
        // arrange
        Customer customer = new Customer("NAME_NOT_IMPORTANT");
        Movie movie = new Movie("TITLE_NOT_IMPORTANT", Movie.CHILDRENS);
        int daysRented = 3;
        Rental rental = new Rental(movie, daysRented);
        customer.addRental(rental);

        // act
        String statement = customer.statement();

        // assert
        assertEquals(statement, "Rental Record for NAME_NOT_IMPORTANT\n"
                + "\tTITLE_NOT_IMPORTANT\t1.5\n"
                + "Amount owed is 1.5\n"
                + "You earned 1 frequent renter points");
    }

    @Test
    public void statementForNewReleaseMovieRentalMoreThan1Day() {
        // arrange
        Customer customer = new Customer("NAME_NOT_IMPORTANT");
        Movie movie = new Movie("TITLE_NOT_IMPORTANT", Movie.NEW_RELEASE);
        int daysRented = 2;
        Rental rental = new Rental(movie, daysRented);
        customer.addRental(rental);

        // act
        String statement = customer.statement();

        // assert
        assertEquals(statement, "Rental Record for NAME_NOT_IMPORTANT\n"
                + "\tTITLE_NOT_IMPORTANT\t6.0\n"
                + "Amount owed is 6.0\n"
                + "You earned 2 frequent renter points");
    }

    @Test
    public void statementForFewMovieRental() {
        // arrange
        Customer customer = new Customer("NAME_NOT_IMPORTANT");
        Movie regularMovie = new Movie("TITLE_NOT_IMPORTANT", Movie.REGULAR);
        Movie newReleaseMovie = new Movie("TITLE_NOT_IMPORTANT", Movie.NEW_RELEASE);
        Movie childrensMovie = new Movie("TITLE_NOT_IMPORTANT", Movie.CHILDRENS);
        customer.addRental(new Rental(regularMovie, 1));
        customer.addRental(new Rental(newReleaseMovie, 4));
        customer.addRental(new Rental(childrensMovie, 4));

        // act
        String statement = customer.statement();

        // assert
        assertEquals(statement, "Rental Record for NAME_NOT_IMPORTANT\n"
                + "\tTITLE_NOT_IMPORTANT\t2.0\n"
                + "\tTITLE_NOT_IMPORTANT\t12.0\n"
                + "\tTITLE_NOT_IMPORTANT\t3.0\n"
                + "Amount owed is 17.0\n"
                + "You earned 4 frequent renter points");
    }

}