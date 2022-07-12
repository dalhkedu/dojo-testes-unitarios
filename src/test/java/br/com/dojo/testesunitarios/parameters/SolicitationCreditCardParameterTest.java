package br.com.dojo.testesunitarios.parameters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
public class SolicitationCreditCardParameterTest {

    private static Validator validator;

    @BeforeEach
    public void setUp() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @Test
    @DisplayName("Criando objeto sem valor do construtor esperando erro de valor obrigatório")
    public void SolicitationCreditCardParameterTest1ErrorNull() {
        // Cenario
        var parameter = new SolicitationCreditCardParameter();

        //Ação
        Set<ConstraintViolation<SolicitationCreditCardParameter>> violations = validator.validate(parameter);

        //Verificacao
        assertThat(violations.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("Criando objeto com valores do construtor vazio")
    public void SolicitationCreditCardParameterTest1ErrorBlank() {
        // Cenario
        var parameter = new SolicitationCreditCardParameter("","","","","","","");

        //Ação
        Set<ConstraintViolation<SolicitationCreditCardParameter>> violations = validator.validate(parameter);

        //Verificacao
        assertThat(violations.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("Criando objeto com valores do construtor normal")
    public void SolicitationCreditCardParameterTest() {
        // Cenario
        var parameter = new SolicitationCreditCardParameter(
                "Primeiro",
                "Ultimo",
                "13-02-1988",
                "123654",
                "gold",
                "master"
        );

        //Ação
        Set<ConstraintViolation<SolicitationCreditCardParameter>> violations = validator.validate(parameter);

        //Verificacao
        assertThat(violations.size()).isEqualTo(0);
    }

}
