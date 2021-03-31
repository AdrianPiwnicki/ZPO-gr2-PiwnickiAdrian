import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Zadanie4 {
    public static void main(String[] args) {
        Produkt ser = new Produkt(2.99, "ser");
        Produkt chleb = new Produkt(1.99, "chleb");
        Produkt maslo = new Produkt(4.50, "masło");

        Zakupy zakupy = new Zakupy(ser, chleb, maslo, ser);
        Wysylka wysylka = new Wysylka(zakupy);


        Dodatek maskotka = new Dodatek(wysylka, 1);
        Dodatek rabat = new Dodatek(maskotka, 3);
        System.out.println(rabat.getZakupy());
        System.out.println(rabat.getCena());
        System.out.println(rabat.getDodatki());
    }
}

class Produkt{
    double cena;
    String nazwa;

    public Produkt(double cena, String nazwa){
        this.cena = cena;
        this.nazwa = nazwa;
    }
}

class Zakupy{
    double cena = 0;
    List<String> zakupy = new ArrayList<String>();
    List<String> dodatki = new ArrayList<String>();

    public Zakupy(Produkt... zakupy){
        for(Produkt zakup : zakupy) {
            this.zakupy.add(zakup.nazwa);
            this.cena += zakup.cena;
        }
    }

    public ArrayList<String> getZakupy(){
        return (ArrayList<String>) zakupy;
    }

    public ArrayList<String> getDodatki(){
        return (ArrayList<String>) dodatki;
    }

    public double getCena(){
        return this.cena;
    }
}

class Wysylka extends Zakupy{
    double cena_wysylki = 13;
    Zakupy zakupy;

    public Wysylka(Zakupy zakupy){
        this.zakupy = zakupy;
    }

    @Override
    public double getCena(){
        return zakupy.getCena() + cena_wysylki;
    }

    @Override
    public ArrayList<String> getZakupy(){
        return zakupy.getZakupy();
    }

    @Override
    public ArrayList<String> getDodatki(){
        return zakupy.getDodatki();
    }
}

class Dodatek extends Zakupy{
    double cena_dodatku;
    String nazwa;
    Zakupy zakupy;

    public Dodatek(Zakupy zakupy, int dodatek) {
        this.zakupy = zakupy;
        if (dodatek == 1) {
            this.cena_dodatku = 0;
            this.nazwa = "maskotka sklepu";
        }
        if (dodatek == 2) {
            this.cena_dodatku = 1;
            this.nazwa = "smycz do pendrive";
        }
        if (dodatek == 3){
            this.cena_dodatku = -20;
            this.nazwa = "rabat -10 zł";
        }
    }

    @Override
    public ArrayList<String> getZakupy(){
        return zakupy.getZakupy();
    }

    @Override
    public ArrayList<String> getDodatki(){
        zakupy.getDodatki().add(nazwa);
        return zakupy.getDodatki();
    }

    @Override
    public double getCena(){
        return zakupy.getCena() + cena_dodatku;
    }
}

