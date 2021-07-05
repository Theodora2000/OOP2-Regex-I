public class Main {
    public static void main(String args[]){
        //tekst je rreferenca na neke stringovne objekte
        String tekst = "Neki kratki tekst.";


        //stringovi se ne porede sa == nego sa equals

        //ovo nije dobar nacin porejdenja jer su stringovi objekti, referencijalni tip podataka
        String tekst2 = "neki drugi tekst";
        if(tekst==tekst2){
            System.out.println("Jednaki su");
        }else{
            System.out.println("Nisu");
        }

        System.out.println(tekst);
    }
}
