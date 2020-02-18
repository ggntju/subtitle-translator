package GCP_Translation;

import com.google.cloud.translate.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Translator {
    private String translatedText;
    private static final Logger logger = LoggerFactory.getLogger(Translator.class);
    public Translator() {

    }
    public String getTranslatedText() {
        return translatedText;
    }
    public String translate(String text2Translate) {
        try {
            Translate translate = TranslateOptions.getDefaultInstance().getService();
            Translation translation = translate.translate(text2Translate,
                    Translate.TranslateOption.sourceLanguage("en"),
                    Translate.TranslateOption.targetLanguage("zh"),
                    Translate.TranslateOption.model("nmt"));
            this.translatedText = translation.getTranslatedText();
        } catch (NullPointerException e) {
            logger.error(e.toString());
        }
        return translatedText;
    }
}
