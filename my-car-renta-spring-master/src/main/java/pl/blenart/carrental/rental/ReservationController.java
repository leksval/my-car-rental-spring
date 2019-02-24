/*package pl.blenart.carrental.rental;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
class ReservationController {
    @Autowired
    ReservationRepository reservationRepository;

    //list
    @GetMapping("/reservstions")
    List<Reservation> list() {
        return reservationRepository.findAll();
    }

    @PostMapping("/reservations")
    void create(@RequestBody ReservationRequest reservationRequest) {
        reservationRepository.save(reservationRequest);
    }

    @GetMapping("/reservations/{id}")
    Reservation details(@PathVariable String id) {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("no such reservation"));
    }

    @DeleteMapping("/reservations/{id}")
    void delete(@PathVariable String id) {
        reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("no such reservation"));

        reservationRepository.deleteById(id);
    }

    @PutMapping("/reservations/{id}")
    void update(@PathVariable String id, @RequestBody Reservation reservation) {
        Reservation loaded = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("no such reservation"));

        loaded.setCapacity(car.getCapacity());
        loaded.setModel(car.getModel());
        loaded.setManufactureYear(car.getManufactureYear());
        loaded.setSegment(car.getSegment());
        loaded.setName(car.getName());
        loaded.setPrice(car.getPrice());
        loaded.setUrlPath(car.getUrlPath());
        loaded.setGearboxType(car.getGearboxType());

        reservationRepository.save(loaded);
    }
}

*/