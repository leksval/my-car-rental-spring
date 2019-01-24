package pl.blenart.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


    @RestController
    public class PaymentController {
        @Autowired
        PaymentRepository paymentRepository;

        //list
        @GetMapping("/paymentss")
        List<Payment> list() {
            return paymentRepository.findAll();
        }

        @PostMapping("/paymentss")
        void create(@RequestBody Payment payment) {
            paymentRepository.save(payment);
        }

        @GetMapping("/payments/{id}")
        Payment details(@PathVariable String id) {
            return paymentRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("no such payment"));
        }

        @DeleteMapping("/payments/{id}")
        void delete(@PathVariable String id) {
            paymentRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("no such payment"));

            paymentRepository.deleteById(id);
        }

        @PutMapping("/payments/{id}")
        void update(@PathVariable String id, @RequestBody Payment car) {
            Payment loaded = paymentRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("no such payment"));

            loaded.setSessionId(car.getSessionId());
            loaded.setAmount(car.getAmount());
            loaded.setCurrency(car.getCurrency());
            loaded.setEmail(car.getEmail());
            loaded.setDescription(car.getDescription());
            loaded.setStatusUrl(car.getStatusUrl());
            loaded.setUrlReturn(car.getUrlReturn());
            loaded.setApiVersion(car.getApiVersion());
            loaded.setCountry(car.getCountry());

            paymentRepository.save(loaded);
        }
    }