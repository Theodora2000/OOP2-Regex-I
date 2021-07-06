import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample2 {
    public static void main(String args[]){
        String tekst = "060 123456789 | NS 123-AB | 061/234-56-78 | +381 21 123 456 | 194 | noreply@somedomain.com | studentska@pmf.uns.ac.rs | ime.prezime@domen.rs | 123-456";
        String regex = " (\\+\\d{1,3} \\d{2}|0\\d{2})[ /]\\d{2,}([ -]\\d{2,})* ";
        //prvo neki niz cifara pa onda 0 ili vise koji su odvojeni sa necime
        Pattern pattern  = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(tekst);
        while (matcher.find()) {
            System.out.println(matcher.group(0));
			System.out.println("      0: " + matcher.start(0) + "-" + matcher.end(0) + ": " + matcher.group(0));
			/*System.out.println("      1: " + matcher.start(1) + "-" + matcher.end(1) + ": " + matcher.group(1));
			System.out.println("      2: " + matcher.start(2) + "-" + matcher.end(2) + ": " + matcher.group(2));
            System.out.println("pozivni: " + matcher.start("pozivni") + "-" + matcher.end("pozivni") + ": " + matcher.group("pozivni"));
            System.out.println("osnovni: " + matcher.start("osnovni") + "-" + matcher.end("osnovni") + ": " + matcher.group("osnovni"));
            System.out.println();*/
        }
    }
}
