package pl.blenart.carrental.rentalapp;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import pl.blenart.carrental.rentalapp.carcatalog.Car;
import pl.blenart.carrental.rentalapp.carcatalog.CarRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@SpringBootApplication
public class RentalApplication {

	@Autowired
	CarRepository repo;

	@Component
	private class DevFixtures implements CommandLineRunner{

		String pattern = "yyyy-mm-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		Date date;

		{
			try {
				date = simpleDateFormat.parse("2019-01-30");
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}


		@Override
		public void run(String... args) throws Exception {
			repo.save(Car.builder().id("1").name("Tesla")
					.model("S").segment("A").manufactureYear(2018).capacity(4)
					.price(299).urlPath("https://www.gocar.it/wp-content/uploads/2018/1/Model-S.jpeg").gearboxType("Auto").build());

			repo.save(Car.builder().id("2").name("Volkswagen")
					.model("Passat").segment("B").manufactureYear(2016).capacity(5)
					.price(100).urlPath("https://www.antwerpenautoworld.com/assets/stock/colormatched_01/white/640/cc_2018vwc040001_01_640/cc_2018vwc040001_01_640_i9i9.jpg").gearboxType("Manual").build());

			repo.save(Car.builder().id("3").name("Ford")
					.model("Fiesta").segment("B").manufactureYear(2015).capacity(5)
					.price(129).urlPath("https://www.ford.com/cmslibs/content/dam/vdm_ford/live/en_us/ford/nameplate/fiesta/2019/collections/adplanner/19_frd_fie_4dr_s_32.jpg/_jcr_content/renditions/cq5dam.web.1280.1280.jpeg").gearboxType("Auto").build());

			repo.save(Car.builder().id("4").name("Audi")
					.model("A4").segment("C").manufactureYear(2016).capacity(5)
					.price(159).urlPath("https://redwhiteballphilly.org/wp-content/uploads/2013/10/audi-a4-lls-raffle-2018.png").gearboxType("Manual").build());

			repo.save(Car.builder().id("5").name("Fiat")
					.model("Talento").segment("B").manufactureYear(2014).capacity(8)
					.price(175).urlPath("https://vantage-leasing.com/uploads/images/thumbnails/_1200x800_crop_center-center_82_line/FI005865_thumbs.jpg").gearboxType("Auto").build());



		}
	}
	public static void main(String[] args) {
		SpringApplication.run(RentalApplication.class, args);
	}
}