
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import java.util.stream.Stream.Builder;

public class Kreiranja {

    public static void main(String[] args) throws IOException {
//vise nacina za kreiranje toka podataka
		List<String> listaStringova = new ArrayList<>();//napravimo jednu listu
		listaStringova.add("A1");//ubacujemo elemente, stringve
		listaStringova.add("A2");
		listaStringova.add("B1");
		listaStringova.add("C1");
		listaStringova.add("C2");
		listaStringova.add("C3");

//		System.out.println();
//		System.out.println("Tok stringova iz kolekcije");
//		Stream<String> tokStringova = listaStringova.stream();//pomocu metoda stream() dobijamo tok one vrste koje je bila polazna kolekcija
//		tokStringova.forEach(System.out::println);//pomocu ovog sve stampamo

//		System.out.println("Moze samo jednom da se koristi");
//		//jednom koriscen tok podataka ne moze vise da se koristi
//		tokStringova.forEach(System.out::println);

//		System.out.println();
//		System.out.println("Redosled operacija");
//		listaStringova.stream()//objekat
//			.peek(s -> System.out.println("Peek: " + s))//ista kao foreach ali ne zatvara tok podataka
//                //peek nije terminalna operacija, pozivaju se samo kad se stigne do neke termiranlne operacije
////			.map(s->s.toLowerCase())
//                .forEach(s -> System.out.println("ForEach: " + s));
//            //kad smo pozvali forezh napravio se novi tok podataka
            //izvrsava se tako da ide iz strema u map pa u foreach

	//nacin na koij kreiramo tokove podataka, pomocu factory metoda
//		System.out.println();
//		System.out.println("Kreiranje toka navodjenjem elemenata");
//		Stream.of("A", "B", "C", "D")
//			.forEach(System.out::println);

//		System.out.println();
//		System.out.println("Tok iz niza");
//		String[] nizStringova = new String[] { "Q", "W", "E" };
//		Arrays.stream(nizStringova)
//			.forEach(System.out::println);

//		System.out.println();
//		System.out.println("Prazan tok");
//		long br = Stream.empty()
//			.count();
//		System.out.println(br);

//		System.out.println();
//		System.out.println("Tokovi primitivnih vrednosti");
//		IntStream.of(1, 2, 3)
//			.forEach(System.out::println);
//		DoubleStream.of(1.0, 0.5, 0.33, 0.25)
//			.forEach(System.out::println);
//		IntStream.range(0, 5)
//			.forEach(System.out::println);
//		LongStream.iterate(2, l -> 2 * l)
//			.limit(5)
//			.forEach(System.out::println);
//		Stream.iterate("x", s -> s + " " + s)
//			.limit(5)
//			.forEach(System.out::println);
//		Stream.generate(() -> 1.0)
//			.limit(5)
//			.map(d -> String.format("%7.5f", d))
//			.forEach(System.out::println);
//		 Stream.iterate(seed, hasNext, next) Java 9+

//		System.out.println();
//		System.out.println("Pretvaranje jedne vrste toka u drugu");
//		LongStream.of(1, 5, 10, 20, 100)
//			.map(x -> x + 1)
//			.mapToObj(x -> "Br " + x)
//			.mapToInt(s -> s.length())
//			.forEach(System.out::println);

//		System.out.println();
//		System.out.println("Znakovi stringa kao tok");
//		"Neki tekst".chars()
//			.forEach(System.out::println);

//		System.out.println();
//		System.out.println("Delovi stringa kao tok");
//		Pattern.compile("\\s").splitAsStream("Ovo je isto neki tekst")
//			.forEach(System.out::println);

//		System.out.println();
//		System.out.println("Sadrzaj fajla kao tok linija");
//		Path path = Paths.get("src/imena.txt");
//		Files.lines(path)
//			.forEach(System.out::println);

//		System.out.println();
//		System.out.println("Tok nastao spajanjem");
//		Stream<String> x = Stream.of("A", "B", "C");
//		Stream<String> y = Stream.of("1", "2", "3");
//		Stream.concat(x, y)
//			.forEach(System.out::println);

//najmocniji nacin za pravljenje tokova
		System.out.println();
		System.out.println("Tok nastao gradjenjem");
		Builder<String> b = Stream.builder();//gradjenje tokova
		b.add("Prvi");//dodajemo elemnt
        //bilder je ujedno i konzumer, tj. ono sta se koreisti u terminalnim operazijama
		IntStream.range(0, 5)
			.map(i -> i + 1)
			.mapToObj(i -> "Broj " + i)
			.forEach(b);//terminalna op
		b.add("Drugi");
		String[] a = new String[] { "Element iz niza 1", "Drugi element iz niza", "Element iz niza br 3" };
		for (String s : a) {
			b.add(s);
		}
		b.add("Treci");
		b.build()
			.forEach(System.out::println);

    }
}
