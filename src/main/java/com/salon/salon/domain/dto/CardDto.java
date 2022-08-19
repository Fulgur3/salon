package com.salon.salon.domain.dto;

import com.salon.salon.domain.models.Card;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardDto {
    private String cardNumber;
    private BigDecimal amount;


    public static CardDto convert(Card card){
        return new CardDto(card.getCardNumber(), card.getAmount());
    }
}
