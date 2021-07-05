public class Main {
    public static void main(String args[]){
        //regularni izraz -  to su stringovi pomocu koijh mozemo da opisemo jezik,
        //odnosno skup stringova koji pripadaju tom nekom jeziku

        String tekst = "Neki kratka tekst.";
        //stringovi mogu da se koriste kako regularni izrazi,
        //medjutim sami regularni izrazi kao string ne
        String[] reci = tekst.split(" ");
        for (String rec : reci){
            System.out.println(rec);
        }


    }
}
