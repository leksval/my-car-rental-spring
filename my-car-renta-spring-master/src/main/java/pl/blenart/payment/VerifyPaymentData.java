package pl.blenart.payment;


import lombok.*;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class VerifyPaymentData {
    String sessionId;
    String orderId;
    Integer amount;
    String currency;
}
