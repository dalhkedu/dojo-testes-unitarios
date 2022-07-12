package br.com.dojo.testesunitarios.parameters;

import javax.validation.constraints.NotBlank;
import java.util.Objects;

public class SolicitationCreditCardParameter {

    public SolicitationCreditCardParameter() {
        /**
         *
         */
    }

    public SolicitationCreditCardParameter(String firstName, String lastName, String birthDate, String documentNumber, String cardType, String cardFlag) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.documentNumber = documentNumber;
        this.cardType = cardType;
        this.cardFlag = cardFlag;
    }

    public SolicitationCreditCardParameter(String firstName, String middleName, String lastName, String birthDate, String documentNumber, String cardType, String cardFlag) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.documentNumber = documentNumber;
        this.cardType = cardType;
        this.cardFlag = cardFlag;
    }

    @NotBlank
    private String firstName;

    private String middleName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String birthDate;

    @NotBlank
    private String documentNumber;

    @NotBlank
    private String cardType;

    @NotBlank
    private String cardFlag;

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public String getCardType() {
        return cardType;
    }

    public String getCardFlag() {
        return cardFlag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SolicitationCreditCardParameter that = (SolicitationCreditCardParameter) o;
        return Objects.equals(firstName, that.firstName) && Objects.equals(middleName, that.middleName) && Objects.equals(lastName, that.lastName) && Objects.equals(birthDate, that.birthDate) && Objects.equals(documentNumber, that.documentNumber) && Objects.equals(cardType, that.cardType) && Objects.equals(cardFlag, that.cardFlag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, middleName, lastName, birthDate, documentNumber, cardType, cardFlag);
    }

    @Override
    public String toString() {
        return "SolicitationCreditCardParameter{" +
                "firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", documentNumber='" + documentNumber + '\'' +
                ", cardType='" + cardType + '\'' +
                ", cardFlag='" + cardFlag + '\'' +
                '}';
    }
}
