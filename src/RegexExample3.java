public class RegexExample3 {
    private static final String[] PODACI = {
            "Petar Petrovic, rodjen 1976",
            "Mika Mikic, rodjen 1983",
            "Zika Zikic, rodjen 1956",
            "Ana Anic, rodjen 1993",
    };

    public static void mainOldWay(String[] args) {
        for(String s : PODACI){
            int index = s.indexOf(' ');
            int index2 = s.indexOf(',');
            String ime = s.substring(0, index);
            String prezime = s.substring(index+1, index2);
            System.out.println(prezime + " "+ ime);
        }
    }
    public static void main(String[] args) {
        for(String s : PODACI){
            System.out.println(s.replaceAll("([A-Z][a-z]+) ([A-Z][a-z]+), rodjen [0-9]{0,}", "$2 $1"));
        }
    }
}
