package br.com.dojo.testesunitarios.controllers;

import br.com.dojo.testesunitarios.models.CreditCardModel;
import br.com.dojo.testesunitarios.parameters.UseCreditCardParameter;
import br.com.dojo.testesunitarios.responses.BalanceResponse;
import br.com.dojo.testesunitarios.services.interfaces.IUseCreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/use")
public class CreditCardUse {

    @Autowired
    private IUseCreditCardService iService;

    @PutMapping(value = "/{cardId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void useCreditCard(@PathVariable(value = "cardId") Integer cardId,
                              @RequestBody UseCreditCardParameter parameter) {

        var card = iService.getCreditCardById(cardId);
        iService.verifyBalance(parameter.getValue(), card.getBalanceAvailable());
        var model = iService.updateBalanceCard(card, parameter.getValue());
        iService.save(model);

    }

    @GetMapping(value = "/{cardId}")
    @ResponseStatus(HttpStatus.OK)
    public BalanceResponse balanceCreditCard(@PathVariable(value = "cardId") Integer cardId) {
        var model = iService.getCreditCardById(cardId);
        return new BalanceResponse(
                model.getCardNumber(),
                model.getBalanceAvailable(),
                model.getBalanceInUse(),
                model.getTotalLimit()
        );
    }
}
