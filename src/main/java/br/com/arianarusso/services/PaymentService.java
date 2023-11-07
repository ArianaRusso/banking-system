package br.com.arianarusso.services;

import br.com.arianarusso.PaymentData;
import br.com.arianarusso.entities.Account;
import br.com.arianarusso.exceptions.BusinessRuleException;

import java.math.BigDecimal;

public class PaymentService {

    private PaymentGateway paymentGateway;

    public PaymentService(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public void payBill (Account payingAccount, PaymentData paymentData){
        if (paymentData.getValue().compareTo(BigDecimal.ZERO) <= 0) {
            throw new BusinessRuleException("Value must be greater than zero");
        }

        if (payingAccount.getBalance().compareTo(paymentData.getValue()) < 0) {
            throw new BusinessRuleException("Insufficient funds");
        }

        paymentGateway.transferValue(
                payingAccount.getNumber(),
                paymentData.getReceivingAccount().getNumber(),
                paymentData.getValue());
    }
}
