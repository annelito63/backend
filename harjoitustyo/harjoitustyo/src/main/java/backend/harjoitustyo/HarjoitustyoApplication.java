package backend.harjoitustyo;

/* import org.springframework.boot.CommandLineRunner; */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/* import org.springframework.context.annotation.Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import backend.harjoitustyo.model.AppUser;
import backend.harjoitustyo.model.AppUserRepository;
import backend.harjoitustyo.model.Havainto;
import backend.harjoitustyo.model.HavaintoRepositorio;
import backend.harjoitustyo.model.Retki;
import backend.harjoitustyo.model.RetkiRepositorio; */

@SpringBootApplication
public class HarjoitustyoApplication {

/* 	private static final Logger log = LoggerFactory.getLogger(HarjoitustyoApplication.class);

	@Bean
	public CommandLineRunner retkiRunner(RetkiRepositorio retkiRepositorio, HavaintoRepositorio havaintoRepositorio,
			 AppUserRepository urepository ) {
		return (args) -> {
			log.info("tallenna retket:");

			Retki retki1 = new Retki("Hanhiretki", "13.03.2026", "Kaunista");
			Retki retki2 = new Retki("Kahlaajaretki", "05.02.2025", "");

			retkiRepositorio.save(retki1);
			retkiRepositorio.save(retki2);

			havaintoRepositorio.save(new Havainto("Kanadanhandi", "Viikki", retki1));
			havaintoRepositorio.save(new Havainto("Tundrahanhi", "Viikki", retki1));
			havaintoRepositorio.save(new Havainto("Tylli", "Viikki", retki2));
			havaintoRepositorio.save(new Havainto("Punajalkaviklo", "Viikki", retki2));

			log.info("hae kaikki retket");
			for (Retki retki : retkiRepositorio.findAll()) {
				log.info(retki.toString());
			}

			AppUser user1 = new AppUser("user", "$2a$10$pK4LUhr0vF2DRBnhhOz5T.b8NfGCz7dNXEM2OGGNKty.LgbyARoSe", "USER");
			AppUser user2 = new AppUser("admin", "$2a$10$xRCtQvySKG8qgr5za9fqL.KA6S7a6.WslR.vfsfs.OQtC21G6VSFa", "ADMIN");
			urepository.save(user1);
			urepository.save(user2); 
		};
	}
 */
	public static void main(String[] args) {
		SpringApplication.run(HarjoitustyoApplication.class, args);
	}

}
