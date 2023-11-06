package br.com.arianarusso.services;

import java.math.BigDecimal;

public interface PaymentGateway {
    void transferValue (int sender, int receiver, BigDecimal value);
}
