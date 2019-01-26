package pl.blenart.carrental.rental;

public interface PaymentGateway {
    public Payment registerPayment(String reservationId, ClientData clientData, double offerValue);
}
