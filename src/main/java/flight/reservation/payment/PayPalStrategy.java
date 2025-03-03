package flight.reservation.payment;

public class PayPalStrategy implements PaymentStrategy {
    private String email;
    private String password;

    public PayPalStrategy(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public boolean pay(double amount) throws IllegalStateException {
        if (isValid()) {
            System.out.println("Paying " + amount + " using PayPal.");
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isValid() {
        return email != null && password != null &&
               email.equals(Paypal.DATA_BASE.get(password));
    }
}
