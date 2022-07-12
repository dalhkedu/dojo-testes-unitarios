package br.com.dojo.testesunitarios.repositories;

import br.com.dojo.testesunitarios.models.CreditCardModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ICreditCardRepository extends JpaRepository<CreditCardModel, Integer> {

    List<CreditCardModel> findAllByClientId(String clientId);

    Optional<CreditCardModel> findByClientIdAndCardNumber(String clientId, String cardNumber);

}
