public class Main {
    public static void main(String args[]){
        //tekst je rreferenca na neke stringovne objekte
        String tekst = "Neki kratki tekst.";
        String rec = "kratki";


        if(tekst.contains(rec)){
            System.out.println("Sadrzi");
        }else{
            System.out.println("Ne sadrzi");
        }

        System.out.println(tekst);
    }
}
