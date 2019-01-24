package pl.blenart.payment;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
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
