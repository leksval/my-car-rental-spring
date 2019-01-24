package pl.blenart.przelewy24;

import org.junit.Test;
import pl.blenart.przelewy24.Model.ApiResponse;
//import pl.blenart.przelewy24.Model.RegisterPaymentData;
import pl.blenart.support.http.NativeHttpClient;

import pl.blenart.payment.*;


public class Przelewy24Integration {

    @Test
    public void registerTransaction() {
        Przelewy24Api api = new Przelewy24Api(Przelewy24Properties.ofEnvironment(), new NativeHttpClient());

        ApiResponse r = api.registerPayment(new RegisterPaymentData(
                "exampleSessionId",
                1000,
                "blenart@uek.krakow.pl",
                "http://blenart.pl",
                "some description",
                "http://blenart.pl/payment/verify",
                "PLN",
                "PL",
                "1.0"));

        String token = r.getValue("token");
        System.out.println(
                String.format("continue transaction here: https://sandbox.przelewy24.pl/trnRequest/%s", token));
    }
}
