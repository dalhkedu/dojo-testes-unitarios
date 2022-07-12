package br.com.dojo.testesunitarios.controllers;

import br.com.dojo.testesunitarios.parameters.SolicitationCreditCardParameter;
import br.com.dojo.testesunitarios.services.interfaces.ISolicitationCreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/solicitation")
public class CreditCardSolicitation {

    @Autowired
    private ISolicitationCreditCardService iService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createCreditCard(@Valid @RequestBody SolicitationCreditCardParameter parameter) {

        this.iService.legalAge(parameter.getBirthDate());
        this.iService.getCardAvailable(parameter.getCardType(), parameter.getCardFlag());
        var clientId = this.iService.getClientId(parameter.getDocumentNumber());
        var model = this.iService.createCard(parameter.getFirstName()
                .concat(parameter.getMiddleName())
                .concat(parameter.getLastName()), clientId);
        this.iService.save(model);

    }
}
