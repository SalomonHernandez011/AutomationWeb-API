package constants;

import lombok.AllArgsConstructor;
import lombok.Getter;
@AllArgsConstructor
public enum CreditCardVariations {
    VALID_CREDIT_CARD("4242424242424242"),
    DECLINES_CREDIT_CARD("4000000000000002"),
    NOFUNDS_CREDIT_CARD("4000000000009995"),
    EXPIRED_CREDIT_CARD("4000000000000069"),
    INCORRECT_CVC("4000000000000127"),
    PROCESS_ERROR_CC("4000000000000119");
    @Getter
    private final String CreditCard;
}
