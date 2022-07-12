package br.com.dojo.testesunitarios.controllers;

import br.com.dojo.testesunitarios.models.CreditCardModel;
import br.com.dojo.testesunitarios.parameters.UseCreditCardParameter;
import br.com.dojo.testesunitarios.responses.BalanceResponse;
import br.com.dojo.testesunitarios.services.interfaces.IUseCreditCardService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = CreditCardUse.class)
@AutoConfigureMockMvc
public class CreditCardUseTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private IUseCreditCardService iUseCreditCardService;

    @Test
    @DisplayName("Usar credito do cartao de credito")
    public void useCreditCardTest() throws Exception {

        //Cenario
        var parameter = new UseCreditCardParameter("2563.63");
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

        //Ação
        given(this.iUseCreditCardService.getCreditCardById(anyInt())).willReturn(model);
        given(this.iUseCreditCardService.updateBalanceCard(any(), any())).willReturn(model);
        given(this.iUseCreditCardService.save(any())).willReturn(model);

        var json = new ObjectMapper().writeValueAsString(parameter);

        var request = MockMvcRequestBuilders
                .put("/use/1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(json);

        //Validação
        this.mvc.perform(request)
                .andExpect(status().isNoContent());
    }

    @Test
    @DisplayName("Consultar o saldo do cartao de credito")
    public void balanceCreditCardTest() throws Exception {

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

        var response = new BalanceResponse(
                "1234.4321.5678.8765",
                "3069.52",
                "221.32",
                "3290.84"
        );

        //Ação
        given(this.iUseCreditCardService.getCreditCardById(any())).willReturn(model);

        var request = MockMvcRequestBuilders
                .get("/use/11")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        //Validação
        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("balance_available").value(response.getBalanceAvailable()));
    }

}
