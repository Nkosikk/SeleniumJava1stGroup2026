package Utlilties;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {

    public static void Props(String[] args) throws IOException {
        FileReader fr = new FileReader("/Users/refilwemakume/Documents/Assessment/SeleniumAssessment/SeleniumAssessmentProject/src/test/resources/configfiles/config.properties");
        Properties p = new Properties();
        p.load(fr);
        System.out.println(p.getProperty("browser"));
        System.out.println(p.getProperty("testurl"));
    }
}

