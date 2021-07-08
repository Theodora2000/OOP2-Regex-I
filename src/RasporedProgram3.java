

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
        stampajDan(casovi, cas -> true, (cas1, cas2) -> cas1.getPredmet().compareTo(cas2.getPredmet()));

    }
/*
    public static final class KomparatorPoPredmetu implements Comparator<Cas>{
        public int compare(Cas cas1, Cas cas2){
            return cas1.getPredmet().compareTo(cas2.getPredmet());
        }
    }*/
    //ne moramo navoditi tacan tip interfejsa jer ga java sama prepozna iz konteksta
    //lambda izrazi nemaju imena nego ->
    //ako imamo samo jednu naredbu ili izraz ne moramo viticaste i return
    //ne moramo tipove parametara, java ih prepozna iz konteksta
//odredjuje da li dati cas zadovoljava kriterijum ili ne
public interface Kriterijum{
    public boolean zadovoljava(Cas cas);
}





    public static void stampajDan(List<Cas> casovi, Kriterijum kriterijum, Comparator<Cas> redosled) {
        List<Cas> pom = new ArrayList<>(casovi);
        Collections.sort(pom, redosled);
        for (Cas cas : casovi) {
            if(kriterijum.zadovoljava(cas)) {
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
