package subtitle.translator.GCP_basic_translator;

import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.sax.BodyContentHandler;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;

public class TikaParser {

    public void test() {
        try {
            AutoDetectParser parser = new AutoDetectParser();
            BodyContentHandler handler = new BodyContentHandler();
            Metadata metadata = new Metadata();
            InputStream inputStream = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\week1_1.vtt");
            parser.parse(inputStream, handler, metadata);

            String test = handler.toString();
            BufferedWriter writer = new BufferedWriter(new FileWriter("week1_1_test.txt", true));
            writer.append('\n');
            writer.append(test);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
