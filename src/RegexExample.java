import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample {
    public static void main(String [] args){
        String tekst = "Neki kratak tekst. U njemu se rec tekst javlja vise puta.";
        String regex = ".e";
        Pattern pattern  = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(tekst);

        if(matcher.lookingAt()){
            System.out.println("da");
        }else{
            System.out.println("ne");
        }
    }
}
