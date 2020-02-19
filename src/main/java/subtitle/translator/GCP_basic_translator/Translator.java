package subtitle.translator.GCP_basic_translator;

import com.google.cloud.translate.v3.LocationName;
import com.google.cloud.translate.v3.TranslateTextRequest;
import com.google.cloud.translate.v3.TranslateTextResponse;
import com.google.cloud.translate.v3.Translation;
import com.google.cloud.translate.v3.TranslationServiceClient;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.io.IOException;
import java.util.LinkedList;

public class Translator {
    private String projectID;
    private String targetLanguage;
    private static final Logger logger = LogManager.getLogger(Translator.class);
    public Translator(String projectID, String targetLanguage) {
        this.projectID = projectID;
        this.targetLanguage = targetLanguage;
    }
    public String translate(String text2Translate) {
        LinkedList<String> results = new LinkedList<>();
        try {
            TranslationServiceClient client = TranslationServiceClient.create();
            LocationName location = LocationName.of(projectID, "global");
            TranslateTextRequest request = TranslateTextRequest.newBuilder()
                    .setParent(location.toString())
                    .setMimeType("text/plain")
                    .setTargetLanguageCode(targetLanguage)
                    .addContents(text2Translate)
                    .build();
            TranslateTextResponse response = client.translateText(request);
            for (Translation translation: response.getTranslationsList()) {
                results.add(translation.getTranslatedText());
            }
        } catch (NullPointerException e) {
            logger.error(e.toString());
        } catch (IOException e) {
            logger.error(e.toString());
        }
        return results.size() == 1 ? results.get(0) : "More than one translation in collection";
    }
}
