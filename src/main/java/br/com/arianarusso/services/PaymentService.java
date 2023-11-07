package br.com.arianarusso.services;

import br.com.arianarusso.dtos.PaymentData;
import br.com.arianarusso.entities.Account;

public class PaymentService {

    private PaymentGateway paymentGateway;

    public PaymentService(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public void payBill (Account payingAccount, PaymentData paymentData){
        paymentGateway.transferValue(
                payingAccount.getNumber(),
                paymentData.getReceivingAccount().getNumber(),
                paymentData.getValue());
    }
}
