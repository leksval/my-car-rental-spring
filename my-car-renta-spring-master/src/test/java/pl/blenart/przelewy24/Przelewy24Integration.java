package pl.blenart.przelewy24;

import org.junit.Test;
import pl.blenart.przelewy24.Model.ApiResponse;
import pl.blenart.przelewy24.Model.RegisterPaymentData;
import pl.blenart.support.http.NativeHttpClient;

public class Przelewy24Integration {

    @Test
    public void registerTransaction() {
        Przelewy24Api api = new Przelewy24Api(Przelewy24Properties.ofEnvironment(), new NativeHttpClient());

        ApiResponse r = api.registerPayment(new RegisterPaymentData(
                "exampleSessionIdsadasdsa",
                1000,
                "blenart@uek.krakow.pl",
                "http://blen.pl",
                "some description",
                "http://blen.pl/payment/verify"));

        String token = r.getValue("token");
        System.out.println(
                String.format("continue transaction here: https://sandbox.przelewy24.pl/trnRequest/%s", token));
    }
}
