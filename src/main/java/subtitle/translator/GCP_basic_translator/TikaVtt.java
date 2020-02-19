package subtitle.translator.GCP_basic_translator;

import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class TikaVtt {

    public static void main(String... args) throws IOException {

        String fname = System.getProperty("user.dir") + "\\src\\main\\resources\\week1_1.vtt";
        String vttString = "WEBVTT\n\n00:01.000 --> 00:04.000\nNever drink liquid nitrogen.\n\n00:05.000 --> 00:09.000\n- It will perforate your stomach.\n- You could die.";

        System.out.println(vttString + "\n");
        Tika tika = new Tika();
        File file = new File(fname);
        // if file has .vtt it will work. but this is not always the case
        String s = tika.detect(file);
        System.out.println("Tika detect from file: " + s);
        Metadata metadata = new Metadata();
        FileInputStream in = new FileInputStream(file);
        try {
            String res = tika.parseToString(in, metadata);
            System.out.println(res);
        } catch(TikaException e) {
            e.printStackTrace();
        }
    }
}