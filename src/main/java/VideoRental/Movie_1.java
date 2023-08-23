package VideoRental;

interface Policy {
    public double getCharge(int dayRented);
}
class Regular implements Policy {
    @Override
    public double getCharge(int dayRented) {
        double result = 2.0;
        if (dayRented > 2)
            result += (dayRented - 2) * 1.5;
        return result;
    }
}
class NewRelease implements Policy {
    @Override
    public double getCharge(int dayRented) {
        return dayRented * 3;
    }
}
class Children implements Policy {
    @Override
    public double getCharge(int dayRented) {
        double result = 1.5;
        if (dayRented> 3)
            result += (dayRented - 3) * 1.5;
        return result;
    }
}

public class Movie_1 {

    public static final int CHILDRENS = 2;
    public static final int NEW_RELEASE = 1;
    public static final int REGULAR = 0;

    private String _title;
    private int _priceCode;

    public Movie_1(String title, int priceCode) {
        _title = title;
        _priceCode = priceCode;
    }

    public int getPriceCode() {
        return _priceCode;
    }

    public void setPriceCode(int arg) {
        _priceCode = arg;
    }
    public String getTitle() {
        return _title;
    }

    public int getPoint(int dayRented) {
        int result = 0 ;
        // add frequent renter points
        result++;
        // add bonus for a two day new release rental
        if ((getPriceCode() == Movie.NEW_RELEASE) && dayRented > 1)
            result++;
        return result;
    }

    public double getCharge(int daysRented) {
        Policy t = createPolicy();
        return t.getCharge(daysRented);
    }

    private Policy createPolicy() {
        Policy t = null;
        switch (getPriceCode()) {
            case Movie.REGULAR:
                t = new Regular();
                break;
            case Movie.NEW_RELEASE:
                t = new NewRelease();
                break;
            case Movie.CHILDRENS:
                t = new Children();
                break;
            default:
                t = new Regular();
                break;
        }
        return t;
    }
}