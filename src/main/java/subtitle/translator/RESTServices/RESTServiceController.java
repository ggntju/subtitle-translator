package subtitle.translator.RESTServices;

import java.util.concurrent.atomic.AtomicLong;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import subtitle.translator.GCP_basic_translator.Translator;

@RestController
public class RESTServiceController {
    private static final Logger logger = LoggerFactory.getLogger(RESTServiceController.class);
    private final AtomicLong counter = new AtomicLong(0);
    private Translator translator = new Translator("translation-basic-266904", "zh");
    @GetMapping("/basic-translator")
    public String basicTranslate(@RequestParam(value = "content", defaultValue = "") String content) {
        counter.getAndIncrement();
        logger.info("Run " + counter.get() + " times");
        return translator.translate(content);
    }
}





