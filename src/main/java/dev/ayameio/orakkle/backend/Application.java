package dev.ayameio.orakkle.backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
	private static final Logger log = LoggerFactory.getLogger(Application.class);
	public static void main(String... args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner demo(SignalRepository repository) {
		return (args) -> {

			repository.save(new Signal(1L,100L,"EUR/USD","1200","2313","123123",false,true));
			repository.save(new Signal(2L,101L,"GBP/USD","1200","2313","123123",false,true));
			repository.save(new Signal(3L,102L,"AUD/USD","1200","2313","123123",false,true));
			repository.save(new Signal(4L,103L,"EUR/JPY","1200","2313","123123",false,true));
			repository.save(new Signal(5L,104L,"EUR/GBP","1200","2313","123123",false,true));

			log.info("Signals found with findAll():");
			log.info("-------------------------------");
			for (Signal signal : repository.findAll()) {
				log.info(signal.toString());
			}
			log.info("");

			Signal signal = repository.findById(3L);
			log.info("Signal found with findById(3L):");
			log.info("--------------------------------");
			log.info(signal.toString());
			log.info("");


			log.info("Signal found with findByAsset('EUR/USD'):");
			log.info("--------------------------------------------");
			repository.findByAsset("EUR/USD").forEach(item -> {
				log.info(item.toString());
			});

			log.info("");
		};
	}
}
