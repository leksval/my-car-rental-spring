package pl.blenart.carrental.rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository {
    Object save(Reservation r);
}
