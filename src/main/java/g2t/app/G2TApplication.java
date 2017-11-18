package g2t.app;

import g2t.app.services.DataLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.annotation.PostConstruct;


@SpringBootApplication
public class G2TApplication {

	private static final Logger logger = LoggerFactory.getLogger(G2TApplication.class);
	private DataLoader dataLoader;

	@Autowired
	public G2TApplication(DataLoader dataLoader) {
		this.dataLoader = dataLoader;
	}

	public static void main(String[] args) {
		SpringApplication.run(G2TApplication.class, args);
	}

	void load() {
		dataLoader.dataLoad();
	}
}
