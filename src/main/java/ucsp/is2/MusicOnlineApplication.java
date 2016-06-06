package ucsp.is2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;

import ucsp.is2.model.Song;

@SpringBootApplication
@EnableAutoConfiguration
@EntityScan(basePackageClasses = Song.class)
public class MusicOnlineApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusicOnlineApplication.class, args);
	}
}
