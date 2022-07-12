package br.com.dojo.testesunitarios.services;

import br.com.dojo.testesunitarios.models.CreditCardModel;
import br.com.dojo.testesunitarios.repositories.ICreditCardRepository;
import br.com.dojo.testesunitarios.services.interfaces.ISolicitationCreditCardService;
import br.com.dojo.testesunitarios.utils.DataUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class SolicitationCreditCardService implements ISolicitationCreditCardService {

    public SolicitationCreditCardService(ICreditCardRepository repository) {
        this.repository = repository;
    }

    @Autowired
    private ICreditCardRepository repository;

    @Override
    public void legalAge(String birthDate) {
        var date = DataUtils.convertStringToDate(birthDate);
        var now = LocalDate.now();
        if (now.getYear() - date.getYear() < 18) {
            throw new RuntimeException("Cliente ainda não pode possui cartão de credito");
        }
    }

    @Override
    public String getClientId(String documentNumber) {
        if (documentNumber != null && !documentNumber.isEmpty()) {
            return "cb3243cd-6069-49b7-aa10-862cb04449b3";
        } else {
            throw new RuntimeException("Documento invalido");
        }
    }

    @Override
    public boolean getCardAvailable(String cardType, String cardFlag) {
        return true;
    }

    @Override
    public CreditCardModel createCard(String fullName, String clientId) {
        return new CreditCardModel(
                "1234.4321.5647.9999",
                fullName,
                LocalDate.now().plusYears(8).toString(),
                LocalDate.now().toString(),
                "111",
                clientId,
                new BigDecimal("3012.23").toString(),
                BigDecimal.ZERO.toString(),
                new BigDecimal("3012.23").toString()
        );
    }

    @Override
    public CreditCardModel save(CreditCardModel model) {
        return repository.saveAndFlush(model);
    }
}
