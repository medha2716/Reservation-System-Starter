package flight.reservation.payment;

import java.util.Date;

public class CreditCardStrategy implements PaymentStrategy {
    private CreditCard creditCard;

    public CreditCardStrategy(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public CreditCardStrategy(String number, Date expirationDate, String cvv) {
        this.creditCard = new CreditCard(number, expirationDate, cvv);
    }

    @Override
    public boolean pay(double amount) throws IllegalStateException {
        if (isValid()) {
            System.out.println("Paying " + amount + " using Credit Card.");
            double remainingAmount = creditCard.getAmount() - amount;
            if (remainingAmount < 0) {
                System.out.printf("Card limit reached - Balance: %f%n", remainingAmount);
                throw new IllegalStateException("Card limit reached");
            }
            creditCard.setAmount(remainingAmount);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isValid() {
        return creditCard != null && creditCard.isValid();
    }
}