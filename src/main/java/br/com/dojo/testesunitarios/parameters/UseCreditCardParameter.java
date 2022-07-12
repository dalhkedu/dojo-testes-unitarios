package br.com.dojo.testesunitarios.parameters;

import javax.validation.constraints.NotBlank;
import java.util.Objects;

public class UseCreditCardParameter {

    public UseCreditCardParameter() {
        /**
         *
         */
    }

    public UseCreditCardParameter(String value) {
        this.value = value;
    }

    @NotBlank
    private String value;

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UseCreditCardParameter that = (UseCreditCardParameter) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "UseCreditCardParameter{" +
                "value='" + value + '\'' +
                '}';
    }
}
