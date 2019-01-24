package pl.blenart.carrental.rentalapp.carcatalog;

import lombok.*;
import javax.persistence.*;

@Getter
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public
class Car {
    @Id
    String id;
    @Column
    String name;
    @Column
    String model;
    String segment;
    Integer capacity;
    Integer manufactureYear;
    Integer price;
    String urlPath;
    String gearboxType;
}