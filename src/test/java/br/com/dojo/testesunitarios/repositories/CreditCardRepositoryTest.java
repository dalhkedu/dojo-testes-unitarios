package br.com.dojo.testesunitarios.repositories;

import br.com.dojo.testesunitarios.models.CreditCardModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CreditCardRepositoryTest {

    @Autowired
    private ICreditCardRepository repository;

    @Test
    @DisplayName("Testar busca de cartoes de credito de um unico cliente")
    public void findAllByClientId() {
        //Cenario
        var model = new CreditCardModel(
                "1234.4321.5678.8765",
                "Super Mario Bros",
                "04/30",
                "04/22",
                "999",
                "97321f9b-b662-41eb-9f09-76e5c677823b",
                "3069.52",
                "221.32",
                "3290.84"
        );

        var model2 = new CreditCardModel(
                "1234.4321.5678.8766",
                "Super Mario Bros",
                "04/30",
                "04/22",
                "999",
                "97321f9b-b662-41eb-9f09-76e5c677823b",
                "3069.52",
                "221.32",
                "3290.84"
        );

        var models = Arrays.asList(model, model2);

        // Ação
        this.repository.saveAll(models);
        var response = this.repository.findAllByClientId(model.getClientId());

        // Validacao
        assertNotNull(response);
        assertEquals(response.size(), models.size());
    }

    @Test
    @DisplayName("Testar busca de cartao de credito pela codigo cliente mais numero do cartao")
    public void findByClientIdAndCardNumber() {
        //Cenario
        var model = new CreditCardModel(
                "1234.4321.5678.8765",
                "Super Mario Bros",
                "04/30",
                "04/22",
                "999",
                "97321f9b-b662-41eb-9f09-76e5c677823b",
                "3069.52",
                "221.32",
                "3290.84"
        );

        var model2 = new CreditCardModel(
                "1234.4321.5678.8766",
                "Super Mario Bros",
                "04/30",
                "04/22",
                "999",
                "97321f9b-b662-41eb-9f09-76e5c677823b",
                "3069.52",
                "221.32",
                "3290.84"
        );

        var models = Arrays.asList(model, model2);

        // Ação
        this.repository.saveAll(models);
        var response = this.repository.findByClientIdAndCardNumber(
                model.getClientId(), model.getCardNumber());

        // Validacao
        assertNotNull(response);
        assertEquals(response.get().getCardNumber(), model.getCardNumber());
    }
}
