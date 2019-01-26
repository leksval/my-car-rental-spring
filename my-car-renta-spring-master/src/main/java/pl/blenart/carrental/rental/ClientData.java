package pl.blenart.carrental.rental;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientData {
    String email;
    String firstName;
    String lastName;
}
