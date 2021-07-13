import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.Arrays;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
//import java.util.Iterator;
//import java.util.List;

public class OsobeProgram {
/*primer za navedeni stariji nacin
    public static class MojaFunkcija implements Function<String>{
        public Osoba apply(String string){
            return new Osoba(String);
        }
    }*/

    /*
    Function<String, Osoba> f = string -> {return  new Osoba(string); };
    * */

    private static final LocalDate GRANICA = LocalDate.of(1970, 1, 1);

    public static void main(String[] args) {
        //MojaFunkcija f = new MojaFunkcija();
        String[] nizStringova = Osobe.random(500);//generise 500 nasumicnih osoba
        Arrays.stream(nizStringova)//tok stringovapomocu statickom metoda klase arrays
                .map(Osoba::new)//prebacujemo stringove sa podacima o osobama u instance klase osoba, za to imamo :map
                .filter(o -> o.getPlata() < 50000)//izdvojimo osobe cija je plata manja do 50k
                .filter(o -> o.getDatumRodjenja().compareTo(GRANICA)<0)
                .sorted(Comparator.comparing(Osoba::getPlata))
                .limit(5)
                .flatMap(o -> o.getDeca().stream())
                .distinct()//za distinct ne mora da bude sortiran tok podataka
                .forEach(System.out::println);
        //.forEach(x -> System.out.println(x))


        ;

//.map prima funkciju, taklasa string,extenduje R, tip rezultat, jednu vrstu re zu drugu
//Function<?, ?> f = null;//opsti oblik
        //stari nacin bi bio da uzmemo i napravimo novu klasu koja implementira odg fnukciju,
        //u toj klasi napraivmo metod apply koji se primenjuje na fun sta vec treba
        //i vraca odg vrednost, implementiramo taj metod i tjt


//parametri od metoda su funkcionalni interfejsi
/*
//		Osobe.stream(500)
        String[] nizStringova = Osobe.random(500);//generise 500 nasumicnih osoba


//pretvara stringove sa podacia u objekte
		Osoba[] nizOsoba = new Osoba[nizStringova.length];
		for (int i = 0; i < nizStringova.length; i++) {
			nizOsoba[i] = new Osoba(nizStringova[i]);
		}

		//izdvaja samo one koje imaju manju od prosecne
		List<Osoba> ispodProseka = new ArrayList<>();
		for (Osoba osoba : nizOsoba) {
			if (osoba.getPlata() < 50_000) {
				ispodProseka.add(osoba);
			}
		}

		List<Osoba> pre1970 = new ArrayList<>();
		for (Osoba osoba : ispodProseka) {
			if (osoba.getDatumRodjenja().compareTo(GRANICA) < 0) {
				pre1970.add(osoba);
			}
		}
        Collections.sort(pre1970, (x,y) -> x.getPlata() - y.getPlata());

		List<Osoba> najsiromasniji = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			najsiromasniji.add(pre1970.get(i));
		}

		List<String> imena = new ArrayList<>();
		for (Osoba osoba : najsiromasniji) {
			for (String ime : osoba.getDeca()) {
				imena.add(ime);
			}
		}


		Collections.sort(imena);
//brisemo dupla imena iz liste
//ovde se podrazumeva da je polazni string / tok sortiran
		String proslo = null;
		Iterator<String> iterator = imena.iterator();
		while (iterator.hasNext()) {
			String ime = iterator.next();
			if (ime.equals(proslo)) {
				iterator.remove();
			} else {
				proslo = ime;
			}
		}


		for (String ime : imena) {
			System.out.println(ime);
		}
*/
    }
}
