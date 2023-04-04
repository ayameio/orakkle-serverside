package dev.ayameio.orakkle.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
//	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String... args) {
		SpringApplication.run(Application.class, args);
	}
/*
	@Bean
	public CommandLineRunner run(SignalRepository repository) {
		return (args) -> {

			// Cleanup
			repository.deleteAll();

			repository.save(new Signal("EUR/USD","1200","2313","123123",false,false));
			repository.save(new Signal("GBP/USD","1200","2313","123123",false,false));
			repository.save(new Signal("AUD/USD","1200","2313","123123",false,true));
			repository.save(new Signal("EUR/JPY","1200","2313","123123",false,true));
			repository.save(new Signal("EUR/GBP","1200","2313","123123",false,true));

			log.info("Signals found with findAll():");
			log.info("-------------------------------");
			for (Signal signal : repository.findAll()) {
				log.info(signal.toString());
			}
			log.info("");

			Optional<Signal> signal = repository.findById(3L);
			log.info("Signal found with findById(3L):");
			log.info("--------------------------------");
			log.info(Optional.ofNullable(signal).toString());
			log.info("");


			log.info("Signal found with findByAsset('EUR/USD'):");
			log.info("--------------------------------------------");
			repository.findByAsset("EUR/USD").forEach(item -> {
				log.info(item.toString());
			});

			log.info("");

			log.info("Successful signals found with findByWasSuccess(true):");
			log.info("--------------------------------------------");
			repository.findByWasSuccessful(true).forEach(item -> {
				log.info(item.toString());
			});

			log.info("");

			log.info("Unsuccessful signals found with findByWasSuccess(false):");
			log.info("--------------------------------------------");
			repository.findByWasSuccessful(false).forEach(item -> {
				log.info(item.toString());
			});

			log.info("");

			log.info("Open signals found with findByClosed(false):");
			log.info("--------------------------------------------");
			repository.findByClosed(false).forEach(item -> {
				log.info(item.toString());
			});

			log.info("");

			log.info("Sending a test signal with save(new Signal()):");
			log.info("--------------------------------------------");
			repository.save(
					new Signal("TEST ASSET", "123", "123", "123", true, false)
			);

			log.info("");

			log.info("Closed signals found with findByClosed(true):");
			log.info("--------------------------------------------");
			repository.findByClosed(true).forEach(item -> {
				log.info(item.toString());
			});
		};
	}
*/
}
