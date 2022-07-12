package br.com.dojo.testesunitarios.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class CreditCardModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cardId;
    private String cardNumber;
    private String cardName;
    private String cardDateExp;
    private String cardDateCreate;
    private String cardNumberSecurity;
    private String clientId;
    private String balanceAvailable;
    private String balanceInUse;
    private String totalLimit;

    public CreditCardModel() {
        /**
         *
         */
    }

    public CreditCardModel(String cardNumber, String cardName, String cardDateExp, String cardDateCreate, String cardNumberSecurity, String clientId, String balanceAvailable, String balanceInUse, String totalLimit) {
        this.cardNumber = cardNumber;
        this.cardName = cardName;
        this.cardDateExp = cardDateExp;
        this.cardDateCreate = cardDateCreate;
        this.cardNumberSecurity = cardNumberSecurity;
        this.clientId = clientId;
        this.balanceAvailable = balanceAvailable;
        this.balanceInUse = balanceInUse;
        this.totalLimit = totalLimit;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardDateExp() {
        return cardDateExp;
    }

    public void setCardDateExp(String cardDateExp) {
        this.cardDateExp = cardDateExp;
    }

    public String getCardDateCreate() {
        return cardDateCreate;
    }

    public void setCardDateCreate(String cardDateCreate) {
        this.cardDateCreate = cardDateCreate;
    }

    public String getCardNumberSecurity() {
        return cardNumberSecurity;
    }

    public void setCardNumberSecurity(String cardNumberSecurity) {
        this.cardNumberSecurity = cardNumberSecurity;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getBalanceAvailable() {
        return balanceAvailable;
    }

    public void setBalanceAvailable(String balanceAvailable) {
        this.balanceAvailable = balanceAvailable;
    }

    public String getBalanceInUse() {
        return balanceInUse;
    }

    public void setBalanceInUse(String balanceInUse) {
        this.balanceInUse = balanceInUse;
    }

    public String getTotalLimit() {
        return totalLimit;
    }

    public void setTotalLimit(String totalLimit) {
        this.totalLimit = totalLimit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreditCardModel that = (CreditCardModel) o;
        return Objects.equals(cardNumber, that.cardNumber) && Objects.equals(cardName, that.cardName) && Objects.equals(cardDateExp, that.cardDateExp) && Objects.equals(cardDateCreate, that.cardDateCreate) && Objects.equals(cardNumberSecurity, that.cardNumberSecurity) && Objects.equals(clientId, that.clientId) && Objects.equals(balanceAvailable, that.balanceAvailable) && Objects.equals(balanceInUse, that.balanceInUse) && Objects.equals(totalLimit, that.totalLimit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardNumber, cardName, cardDateExp, cardDateCreate, cardNumberSecurity, clientId, balanceAvailable, balanceInUse, totalLimit);
    }

    @Override
    public String toString() {
        return "CreditCardModel{" +
                "cardId=" + cardId +
                ", cardNumber='" + cardNumber + '\'' +
                ", cardName='" + cardName + '\'' +
                ", cardDateExp='" + cardDateExp + '\'' +
                ", cardDateCreate='" + cardDateCreate + '\'' +
                ", cardNumberSecurity='" + cardNumberSecurity + '\'' +
                ", clientId='" + clientId + '\'' +
                ", balanceAvailable='" + balanceAvailable + '\'' +
                ", balanceInUse='" + balanceInUse + '\'' +
                ", totalLimit='" + totalLimit + '\'' +
                '}';
    }
}
