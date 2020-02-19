package subtitle.translator;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class RestServiceApplication implements CommandLineRunner {

    private static final Logger logger = LogManager.getLogger(RestServiceApplication.class);

    @Autowired
    private Environment env;

    @Override
    public void run(String[] args) throws Exception {
        logger.info("{}", env.getProperty("GOOGLE_APPLICATION_CREDENTIALS"));
    }
    public static void main(String[] args) {
        SpringApplication.run(RestServiceApplication.class, args);
    }

}
