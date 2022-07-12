package br.com.dojo.testesunitarios.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class BalanceResponse {

    @JsonProperty(value = "card_number")
    private String cardNumber;

    @JsonProperty(value = "balance_available")
    private String balanceAvailable;
    private String balanceInUse;
    private String totalLimit;

    public BalanceResponse() {
        /**
         *
         */
    }

    public BalanceResponse(String cardNumber, String balanceAvailable, String balanceInUse, String totalLimit) {
        this.cardNumber = cardNumber;
        this.balanceAvailable = balanceAvailable;
        this.balanceInUse = balanceInUse;
        this.totalLimit = totalLimit;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
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
        BalanceResponse that = (BalanceResponse) o;
        return Objects.equals(cardNumber, that.cardNumber) && Objects.equals(balanceAvailable, that.balanceAvailable) && Objects.equals(balanceInUse, that.balanceInUse) && Objects.equals(totalLimit, that.totalLimit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardNumber, balanceAvailable, balanceInUse, totalLimit);
    }

    @Override
    public String toString() {
        return "BalanceResponse{" +
                "cardNumber='" + cardNumber + '\'' +
                ", balanceAvailable='" + balanceAvailable + '\'' +
                ", balanceInUse='" + balanceInUse + '\'' +
                ", totalLimit='" + totalLimit + '\'' +
                '}';
    }
}
