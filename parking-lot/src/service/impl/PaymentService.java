package service.impl;

import enums.PaymentMode;
import service.interfaces.IPaymentService;

public class PaymentService implements IPaymentService {

    private static final PaymentService paymentService = new PaymentService();

    public static PaymentService getInstance() {
        return paymentService;
    }

    public void makePayment(final PaymentMode paymentMode, final int amount) {
        if (paymentMode.equals(PaymentMode.CASH)) {
            System.out.println("Amount: " + amount + " paid by cash");
        } else if (paymentMode.equals(PaymentMode.CARD)) {
            System.out.println("Amount: " + amount + " paid by card");
        }
    }

}
