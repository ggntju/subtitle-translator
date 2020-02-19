package subtitle.translator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class RestServiceApplication implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(RestServiceApplication.class);

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
