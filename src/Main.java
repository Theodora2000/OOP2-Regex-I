public class Main {
    public static void main(String args[]){
        //regularni izraz -  to su stringovi pomocu koijh mozemo da opisemo jezik,
        //odnosno skup stringova koji pripadaju tom nekom jeziku

        String tekst = "Neki kratka tekst.";
        String rec = "kratak";


        if(tekst.contains(rec) || tekst.contains("kratka") || tekst.contains("kratko")){
            System.out.println("Sadrzi");
        }else{
            System.out.println("Ne sadrzi");
        }

        System.out.println(tekst.indexOf(rec));
    }
}
