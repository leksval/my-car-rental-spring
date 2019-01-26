package pl.blenart.carrental.rental;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
class Reservation {
    String id;
    String carId;
    int days;
    double price;
    Payment payment;
}
