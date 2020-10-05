package Codecademy;

/*
 This project calculates the best transit option in NYC, according to days, trips and disabilities (if exist).
 Creator: Ben Arviv
 Codecademy projects
*/
public class TransitCalculator{

    int amountOfDays;
    int amountOfRides;
    String[] options = {"Pay-per-ride", "7-day Unlimited", "30-day Unlimited"};
    double[] fares = {2.75, 33.00, 127.00};

    public TransitCalculator(int days, int rides, boolean reducedFare){
        amountOfDays = days;
        amountOfRides = rides;
        if (reducedFare){
            fares[0] = 1.35; fares[1] = 16.50; fares[2] = 63.50;
        }
    }

    public double unlimited7Price(){ //This method calculates the price using the 7-day Unlimited option.
        int ticketsToBuy;
        double finalPrice;
        if (amountOfDays % 7 == 0) {
            ticketsToBuy = amountOfDays / 7;
        }
        else{
            ticketsToBuy = (amountOfDays / 7) + 1;
        }
        finalPrice = fares[1] * ticketsToBuy / amountOfRides;
        return finalPrice;
    }

    public double unlimited30Price(){//This method calculates the price using the 30-day Unlimited option.
        int ticketsToBuy;
        double finalPrice;
        if (amountOfDays % 30 == 0) {
            ticketsToBuy = amountOfDays / 30;
        }
        else{
            ticketsToBuy = (amountOfDays / 30) + 1;
        }
        finalPrice = fares[2] * ticketsToBuy / amountOfRides;
        return finalPrice;
    }

//This method create and returns an array of all the prices using different transit options.
    public double[] getRidePrices(TransitCalculator trip){
        double[] prices = new double[3];
        prices[0] = amountOfRides * fares[0];
        prices[1] = trip.unlimited7Price();
        prices[2] = trip.unlimited30Price();
        return prices;
    }

    public String getBestFare(double[] prices){//This method returns the cheapest option of the three.
        double fare = prices[0];
        int index = 0;
        for (int i = 0; i < 3; i++) {
            if (fare > prices[i]){
                fare = prices[i];
                index = i;
            }
        }
        String bestFare = "You should get the " + options[index] + " option at $" + prices[index] + " per ride.";
        return bestFare;
    }

    public static void main(String[] args) {
        TransitCalculator trip = new TransitCalculator(5, 12, true);
        double[] price = trip.getRidePrices(trip);
        System.out.println(trip.getBestFare(price));
    }
}
