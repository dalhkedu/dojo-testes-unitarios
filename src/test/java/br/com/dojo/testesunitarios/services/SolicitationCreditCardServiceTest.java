package br.com.dojo.testesunitarios.services;

import br.com.dojo.testesunitarios.models.CreditCardModel;
import br.com.dojo.testesunitarios.repositories.ICreditCardRepository;
import br.com.dojo.testesunitarios.services.interfaces.ISolicitationCreditCardService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class SolicitationCreditCardServiceTest {

    private ISolicitationCreditCardService service;

    @MockBean
    private ICreditCardRepository repository;

    @BeforeEach
    private void setUp() {
        this.service = new SolicitationCreditCardService(repository);
    }

    @Test
    @DisplayName("Validar de cliente solicitante e maior de 18 anos de idade e retornar erro caso seja menor")
    public void legalAgeError() {
        var birthDate = LocalDate.now().minusYears(16).toString();
        var message = "Cliente ainda não pode possui cartão de credito";

        var exception = assertThrows(RuntimeException.class, () -> this.service.legalAge(birthDate));

        //validacao
        assertTrue(exception.getMessage().equals(message));
    }

    @Test
    @DisplayName("Testar busca de id do cliente com numero do documento")
    public void getClientId() {
        //Cenario
        var document = "1234565";

        // Acao
        var response = this.service.getClientId(document);

        //Validacao
        assertEquals(response, "cb3243cd-6069-49b7-aa10-862cb04449b3");
    }

    @Test
    @DisplayName("Testar busca de id do cliente com numero do documento dado vazio")
    public void getClientIdError() {
        //Cenario
        var document = "";
        var message = "Documento invalido";

        //Ação
        var exception = assertThrows(RuntimeException.class, () -> this.service.getClientId(document));

        //validacao
        assertTrue(exception.getMessage().equals(message));
    }

    @Test
    @DisplayName("Verificar se cartao solicitado esta disponivel para aprovacao")
    public void getCardAvailable() {
        var cardType = "gold";
        var cardFlag = "visa";

        var response = this.service.getCardAvailable(cardType, cardFlag);

        assertTrue(response);
    }

    @Test
    @DisplayName("Criar cartao novo para cliente")
    public void createCard() {
        var fullName = "Nome Completo Cliente";
        var clientId = "cb3243cd-6069-49b7-aa10-862cb04449b3";

        var response = this.service.createCard(fullName, clientId);

        assertEquals(response.getClientId(), clientId);
        assertEquals(response.getCardDateCreate(), LocalDate.now().toString());
        assertEquals(response.getCardDateExp(), LocalDate.now().plusYears(8).toString());
    }

    @Test
    @DisplayName("Erro ao Criar cartao novo para cliente")
    public void createCardError() {
        var clientId = "cb3243cd-6069-49b7-aa10-862cb04449b3";

        var exception = assertThrows(
                RuntimeException.class, () ->
                        this.service.createCard(null, clientId));

        String expectedMessage = "Nome ou id nulo ou vazio";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @DisplayName("Salvar cartao criado na base de dados para cliente")
    public void save() {
        var card = new CreditCardModel(
                "1234.4321.5647.9999",
                "fullName",
                LocalDate.now().plusYears(8).toString(),
                LocalDate.now().toString(),
                "111",
                "clientId",
                new BigDecimal("3012.23").toString(),
                BigDecimal.ZERO.toString(),
                new BigDecimal("3012.23").toString()
        );

        when(this.repository.saveAndFlush(any())).thenReturn(card);

        var response = this.service.save(card);

        assertEquals(response.getCardNumber(), card.getCardNumber());
    }
}
