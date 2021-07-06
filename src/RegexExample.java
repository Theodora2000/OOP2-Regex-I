import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample {
    public static void main(String [] args){
        String tekst = "Neki kratak tekst. U njemu se rec tekst javlja vise puta.";
        String regex = "\\b(?<prvoslovo>t).*?(?<poslednjeslovo>.)\\b";
        Pattern pattern  = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(tekst);
        while(matcher.find()){
            System.out.println("Nasli");
            System.out.println(matcher.start());
            System.out.println(matcher.end());
            System.err.println(matcher.group(1));
        }
    }
}
