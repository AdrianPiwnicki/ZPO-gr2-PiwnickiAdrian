import java.util.ArrayList;
import java.util.List;

public class Zadanie2 {
    public static void main(String[] args) {
        Wlasciciel wlasciciel = new Wlasciciel();

        Komunikat komunikat1 = new Komunikat("Komunikat1");
        Komunikat komunikat2 = new Komunikat("Komunikat2");
        Komunikat komunikat3 = new Komunikat("Komunikat3");

        wlasciciel.dodajKomunikat(komunikat1);
        wlasciciel.dodajKomunikat(komunikat2);
        wlasciciel.dodajKomunikat(komunikat3);

    }
}

interface Observer{
    void newsletter();
}

class Komunikat implements Observer{
    String komunikat;

    public Komunikat(String komunikat){
        this.komunikat = komunikat;
    }

    @Override
    public void newsletter() {
        System.out.println("Nowy komunikat: " + this.komunikat);
    }
}

class Wlasciciel{
    List<Observer> komunikaty;

    public Wlasciciel(){
        komunikaty = new ArrayList<>();
    }

    public void dodajKomunikat(Observer observers){
        this.komunikaty.add(observers);
        System.out.println("Twoje komunikaty ...");
        for (Observer komunikat : komunikaty){
            komunikat.newsletter();
        }
        System.out.println();
    }

}