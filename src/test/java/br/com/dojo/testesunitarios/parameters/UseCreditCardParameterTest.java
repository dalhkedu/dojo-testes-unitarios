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
public class UseCreditCardParameterTest {

    private static Validator validator;

    @BeforeEach
    public void setUp() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @Test
    @DisplayName("Criando objeto sem valor do construtor esperando erro de valor obrigatório")
    public void useCreditCardParameterTest1ErrorNull() {
        // Cenario
        var parameter = new UseCreditCardParameter();

        //Ação
        Set<ConstraintViolation<UseCreditCardParameter>> violations = validator.validate(parameter);

        //Verificacao
        assertThat(violations.size()).isEqualTo(1);
    }


    @Test
    @DisplayName("Criando objeto com valores do construtor vazio")
    public void useCreditCardParameter1ErrorBlank() {
        // Cenario
        var parameter = new UseCreditCardParameter("");

        //Ação
        Set<ConstraintViolation<UseCreditCardParameter>> violations = validator.validate(parameter);

        //Verificacao
        assertThat(violations.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("Criando objeto com valores do construtor")
    public void useCreditCardParameter() {
        // Cenario
        var parameter = new UseCreditCardParameter("1000");

        //Ação
        Set<ConstraintViolation<UseCreditCardParameter>> violations = validator.validate(parameter);

        //Verificacao
        assertThat(violations.size()).isEqualTo(0);
    }
}
