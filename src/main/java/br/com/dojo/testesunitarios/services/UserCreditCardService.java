package br.com.dojo.testesunitarios.services;

import br.com.dojo.testesunitarios.models.CreditCardModel;
import br.com.dojo.testesunitarios.repositories.ICreditCardRepository;
import br.com.dojo.testesunitarios.services.interfaces.IUseCreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserCreditCardService implements IUseCreditCardService {

    @Autowired
    private ICreditCardRepository repository;

    @Override
    public CreditCardModel getCreditCardById(Integer cardId) {
        var card = repository.findById(cardId);
        if (card.isPresent())
            return card.get();
        else
            throw new RuntimeException("Cartão nao encontrado");
    }

    @Override
    public void verifyBalance(String value, String balanceAvailable) {
        var inUseNow = new BigDecimal(value);
        var available = new BigDecimal(balanceAvailable);
        if (inUseNow.compareTo(available) == -1) {
            throw new RuntimeException("Não possui limite disponivel");
        }
    }

    @Override
    public CreditCardModel updateBalanceCard(CreditCardModel model, String value) {
        var inUse = new BigDecimal(model.getBalanceInUse());
        var inUseNow = new BigDecimal(value);
        var balanceAvailable = new BigDecimal(model.getBalanceAvailable());
        model.setBalanceInUse(inUse.add(inUseNow).toString());
        model.setBalanceAvailable(balanceAvailable.subtract(inUseNow).toString());
        return model;
    }

    @Override
    public CreditCardModel save(CreditCardModel model) {
        return repository.saveAndFlush(model);
    }
}
