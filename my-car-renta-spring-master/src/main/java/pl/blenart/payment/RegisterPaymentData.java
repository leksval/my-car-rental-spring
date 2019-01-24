package pl.blenart.payment;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class RegisterPaymentData extends VerifyPaymentData{



//    String orderID;
//    String Amount;
//    String currency;

    String sessionId;
    Integer amount;
    String email;
    String urlReturn;
    String description;
    String statusUrl;

    String currency;
    String country;
    String apiVersion;
}



