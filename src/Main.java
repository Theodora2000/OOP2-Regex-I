public class Main {
    public static void main(String args[]){
        //regularni izraz -  to su stringovi pomocu koijh mozemo da opisemo jezik,
        //odnosno skup stringova koji pripadaju tom nekom jeziku

        //jednom napravljen strinf ne moze vise da se menja, imutable su,
        //jedino sta moze da se napravi je novi string na osnovu onog starog
        String tekst = "Neki kratka tekst.";
         // !!!!! tekst.replaceAll("a", "e"); // nece nam zameniti, nego poramo ga sacuvati u neki novi string
        String tekst2 = tekst.replaceAll(".", "!");
        //sve se zamenulo, zato sto je to regularan izraz
        System.out.println(tekst);
        System.out.println(tekst2);


    }
}
