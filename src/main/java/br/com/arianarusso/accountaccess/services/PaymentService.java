package br.com.arianarusso.accountaccess.services;

import br.com.arianarusso.accountaccess.dtos.PaymentData;
import br.com.arianarusso.accountaccess.entities.Account;

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
