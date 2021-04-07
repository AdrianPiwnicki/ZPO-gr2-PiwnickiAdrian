import java.util.Scanner;

public class Zadanie1 {
    public static void main(String[] args) {
        Zamowienie zamowienie;
        GUIFactory factory;

        Scanner in = new Scanner(System.in);
        System.out.println("Wybrane rodzaje wysyłki ...");
        System.out.println("1. Poczta Polska");
        System.out.println("2. DPD");
        System.out.println("3. InPost");
        System.out.print("\nPodaj rodzaj wysyłki: ");
        int a = in.nextInt();
        System.out.println();
        if (a == 1){
            factory = new PocztaPolskaFactory();
            zamowienie = new Zamowienie(factory);
            zamowienie.zamowienie();
        }
        else if (a == 2){
            factory = new DPDFactory();
            zamowienie = new Zamowienie(factory);
            zamowienie.zamowienie();
        }
        else if (a == 3){
            factory = new InPostFactory();
            zamowienie = new Zamowienie(factory);
            zamowienie.zamowienie();
        }
        else{
            System.out.println("Nie ma takiego wyboru!");
        }
    }
}

interface Wysylka {
    void zamowienie();
}

interface Kurier {
        void zamowienie();
}

class PocztaPolskaWysylka implements Wysylka{

    @Override
    public void zamowienie() {
        System.out.println("Wybrano wysylkę Pocztą Polską");
    }
}

class DPDWysylka implements Wysylka{

    @Override
    public void zamowienie() {
        System.out.println("Wybrano wysylkę DPD");
    }
}

class InPostWysylka implements Wysylka{

    @Override
    public void zamowienie() {
        System.out.println("Wybrano wysylkę Inpost");
    }
}

class PocztaPolskaKurier implements Kurier {

    @Override
    public void zamowienie(){
        System.out.println("Wybrano kuriera PocztaPolska");
    }
}

class DPDKurier implements Kurier {

    @Override
    public void zamowienie(){
        System.out.println("Wybrano kuriera DPD");
    }
}

class InPostKurier implements Kurier {

    @Override
    public void zamowienie(){
        System.out.println("Wybrano kuriera InPost");
    }
}

interface GUIFactory{
    Wysylka createWysylka();
    Kurier createKurier();
}

class PocztaPolskaFactory implements GUIFactory{

    @Override
    public Wysylka createWysylka() {
        return new PocztaPolskaWysylka();
    }

    @Override
    public Kurier createKurier() {
        return new PocztaPolskaKurier();
    }
}

class DPDFactory implements GUIFactory{

    @Override
    public Wysylka createWysylka() {
        return new DPDWysylka();
    }

    @Override
    public Kurier createKurier() {
        return new DPDKurier();
    }
}

class InPostFactory implements GUIFactory{

    @Override
    public Wysylka createWysylka() {
        return new InPostWysylka();
    }

    @Override
    public Kurier createKurier() {
        return new InPostKurier();
    }
}

class Zamowienie {
    private Wysylka wysylka;
    private Kurier kurier;

    public Zamowienie(GUIFactory factory){
        wysylka = factory.createWysylka();
        kurier = factory.createKurier();
    }

    public void zamowienie(){
        wysylka.zamowienie();
        kurier.zamowienie();
    }
}