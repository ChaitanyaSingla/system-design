package service.interfaces;

import enums.PaymentMode;

public interface IPaymentService {

    void makePayment(final PaymentMode paymentMode, final int amount);

}
