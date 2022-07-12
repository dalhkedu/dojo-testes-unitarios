package br.com.dojo.testesunitarios.services.interfaces;

import br.com.dojo.testesunitarios.models.CreditCardModel;

public interface ISolicitationCreditCardService {

    void legalAge(String birthDate);

    String getClientId(String documentNumber);

    boolean getCardAvailable(String cardType, String cardFlag);

    CreditCardModel createCard(String fullName, String clientId);

    CreditCardModel save(CreditCardModel model);
}
