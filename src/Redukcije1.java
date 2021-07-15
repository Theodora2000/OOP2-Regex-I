import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Redukcije1 {

    public static void main(String[] args) {

//        // Prosta suma prvih 10 pozitivnih brojeva
//        System.out.println("S1:");
//        int s1 = IntStream.range(1, 11)//tok koji sadrzi prvh 10 br i sumirati ih
//                .sum();//terminalna op
//        System.out.println(s1);

//        // Suma kvadrata
//        System.out.println();
//        System.out.println("S2:");
//        int s2 = IntStream.range(1, 11)
//                .map(x -> x * x)//pomocu map mozemo da mapiramo istu vrstu obj na istu vrstu obj
//                .sum();
//        System.out.println(s2);

//        // Ispis svih prostih brojeva
//        System.out.println();
//        System.out.println("Prosti brojevi:");
//        IntStream.range(2, 21)
//                .filter(x -> IntStream.range(2, x).noneMatch(y -> x % y == 0))
//                //.noneMatch(y -> x % y == 0) ako to bude uvek false, mi to x ppusitmo da se ispise, da prodje dalje kroz tok podataka
//                .forEach(System.out::println);

//        // Suma pomocu .reduce() umesto .sum()
//        System.out.println();
//        System.out.println("S3:");
//        int s3 = IntStream.range(1, 11)
//                .reduce(0, (x, y) -> x + y);
//        //.reducie je opsta redukcija
//        //redukcija, ako imamo br od 1-10, ocemo to da rekdukujemo na edan objekat
//        //na kraju redukcije ne ostane nista u toku podataka, van toka podataka ce biti neko x koje smo mi reduovali
//        System.out.println(s3);
//
//        // Racunanje sume na isti nacina samo sa porukama koje ilustruju redosled poziva operacije
//        System.out.println();
//        System.out.println("S4:");
//        int s4 = IntStream.range(1, 11)//serijski tok podataka
//                .reduce(0, (x, y) -> { int r = x + y; System.out.printf("%d + %d = %d%n", x, y, r); return r; });
//        System.out.println(s4);
//
        // Skupljanje elemenata u listu
        // OVAKO NE TREBA RADITI posto moze dovesti do problema i netacnih rezultata
        //ovo je samo ilustracija
//        System.out.println();
//        System.out.println("L1:");
//        List<Integer> l1 = new ArrayList<>();//ova lista nije predvidjena da u nju moze vise niti paralelno izvrsavanje da ubacuje stvari, pogube se elementi
//        IntStream.range(1, 21).parallel()
//                //paralel podeli tok na delove pa svkai posebno redukuje
//                //u svim podtokovnia je nula poscetni element, ovo se odnosi na prethodni primer
//                .forEach(x -> l1.add(x));
//        System.out.println(l1);
//
//        // Pravilan nacin skupljanja elemenata u listu pomocu redukcije
//        // U ovom slucaju koristimo .collect() koji radi promenljivu (mutable) redukciju
//        // Koristi se jednom napravljena lista i u nju se dodaju elementi
//        System.out.println();
//        System.out.println("L2:");
//        List<Integer> l2 = IntStream.range(1, 21).parallel()
//                .collect(ArrayList::new,//u svakom koraku menja ovaj objekat
//                        (l, x) -> l.add(x),//izvrsava se za svaki element, da se svaki ubaci
//                        (la, lb) -> la.addAll(lb));//da se na kraju se svedu svi na jedan konacan rezultujuci element
//        System.out.println(l2);
//        //paralel
//        //1 2 3 4 5 | 6 7 8 9 ....
//        //[]
//        //[]
//        //itoovremeno se izvrsava za prvi u drugi podtok


        // [2] [3] [4] [5] |  [7] [8] [9]
        //[] + [1]
        //[] + [6]
//
//        // Prikaz skupljanja elemenata u listu pomocu .reduce() koji radi nepromenljivu redukciju
//        // Ovo je neefikasnije resenje jer u svakom koraku pravi nove liste posto ne smemo da menjamo postojece
//        System.out.println();
//        System.out.println("L3:");
//        List<Integer> l3 = IntStream.range(1, 21).parallel()
//                //maoToObj, svaki elemnt je smestio u zadebnu listu
//                .mapToObj(x -> {//svaki put pravimo novi rezultat
//                    List<Integer> l = new ArrayList<>();//nova lista
//                    l.add(x);
//                    return l;
//                })
//                //operacija koponovanja, imamo dva medjurezultat i ukomponujemo  ga u zajednicki medjurezultat
//                .reduce(new ArrayList<>(), (la, lb) -> {//prazna list nam je inicijalni obj
//                    List<Integer> l = new ArrayList<>();//svaki put se proizvede novi objekat, koji ce biti novi rezultat, a originalini objekti ostaju neizmenjeni
//                    l.addAll(la);
//                    l.addAll(lb);
//                    return l;
//                });
//        System.out.println(l3);
//
//        // Neefikasan nacin za brojanje posebno parnih i posebno neparnih brojeva
//        // Prolazimo dva puta kroz tok
//        long par = IntStream.of(1, 2, -3, 5, 7, 3, 8, -5, -2, 10, 11)
//                .peek(System.out::println)
//                .filter(x -> x % 2 == 0)
//                .count();
//        long nepar = IntStream.of(1, 2, -3, 5, 7, 3, 8, -5, -2, 10, 11)
//                .peek(System.out::println)
//                .filter(x -> x % 2 != 0)
//                .count();
//        System.out.println("Parnih: " + par);
//        System.out.println("Neparnih: " + nepar);
//
        //sluzi kao nosilac info u tim medjurezultatima
        //prati i parne i neparne
        class ParNepar {
            public long par;
            public long nepar;
        }

        //ParNepr je neki medjurezultat
        // Efikasniji nacin posto samo jednom prolazimo kroz tok
        ParNepar pn = IntStream.of(1, 2, -3, 5, 7, 3, 8, -5, -2, 10, 11)
                .peek(System.out::println)
                .collect(ParNepar::new,//napravimo neki treci objekat
                        (pn1, x) -> {//kako da ukomponujemo jeden element iz toka u taj novi
                            if (x % 2 == 0) {
                                pn1.par++;
                            } else {
                                pn1.nepar++;
                            }
                        },
                        (pn1, pn2) -> {//kako da ser ukomponuju dva ta necega u to trece
                            pn1.par += pn2.par;
                            pn1.nepar += pn2.nepar;
                        });
        System.out.println("Parnih: " + pn.par);
        System.out.println("Neparnih: " + pn.nepar);

        // Za domaci zadatak pronaci i minimalni i maksimalni element pomocu
        // .collect samo jednim prolaskom kroz tok

    }
}
