package tutorial.junit.sandbox;

public class OrderService {

    private static final int LIMIT = 100;

    public void doPayment() {
        try {
            Thread.sleep(8000);// 10 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void printShippingLabel() {
        try {
            Thread.sleep(20000);// 20 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void withdraw(int amount) {
        if (amount > LIMIT)
            throw new RuntimeException("Limit Exceeded. Max is " + LIMIT);

    }
}
