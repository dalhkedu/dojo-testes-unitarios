package br.com.dojo.testesunitarios.services.interfaces;

import br.com.dojo.testesunitarios.models.CreditCardModel;

public interface IUseCreditCardService {

    CreditCardModel getCreditCardById(Integer cardId);

    void verifyBalance(String value, String balanceAvailable);

    CreditCardModel updateBalanceCard(CreditCardModel model, String value);

    CreditCardModel save(CreditCardModel model);
}
