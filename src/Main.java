public class Main {
    public static void main(String args[]){
        //tekst je rreferenca na neke stringovne objekte
        String tekst = "Neki kratki tekst.";
        String tekst2 = "neki drugi tekst";


        if(tekst.equals(tekst2)){
            System.out.println("Jednaki su");
        }else{
            System.out.println("Nisu");
        }

        System.out.println(tekst);
    }
}
