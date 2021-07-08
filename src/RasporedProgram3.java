

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class RasporedProgram3 {

    public static void main(String[] args) throws IOException {
        String text = readFile();
        Raspored raspored = RasporedProgram2.readRaspored(text);
        List<Cas> casovi = raspored.getList();//izvucemo list casova
        stampajUtorak(casovi);
    }
    //samo raspored za utorak
    public static void stampajUtorak(List<Cas> casovi) {
        for (Cas cas : casovi) {
            if(cas.getDan() == Dan.UTORAK) {
                System.out.println(cas);
            }
        }
    }

    public static String readFile() throws IOException {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(
                RasporedProgram1.class.getResourceAsStream("raspored.ics")))) {
            StringBuilder text = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                text.append(line);
                text.append('\n');
            }
            return text.toString();
        }
    }
}
