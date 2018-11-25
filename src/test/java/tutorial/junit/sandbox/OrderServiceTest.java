package tutorial.junit.sandbox;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {
    @Test
    void doPaymentNotExceed15Seconds() {
        OrderService orderService = new OrderService();
        assertTimeout(ofSeconds(15), orderService::doPayment);
    }

    @Test
    @Disabled("Just to show how timeout fails")
    void doPaymentExceed5Seconds() {
        OrderService orderService = new OrderService();
        assertTimeout(ofSeconds(5), orderService::doPayment, "The doPayment method take more than 5 seconds");
    }

    @Test
    @Disabled("Just to show how timeout fails")
    public void printShippingLabelExceeded15SecondsWithPreemptiveTermination() {
        OrderService orderService = new OrderService();
        assertTimeoutPreemptively(ofSeconds(3), orderService::doPayment, () -> "The printShippingLabel method took more than 15 seconds and was aborted.");
    }

    @Test
    void exception() {
        assertThrows(RuntimeException.class, () -> new OrderService().withdraw(200));
    }
}