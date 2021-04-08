import java.util.Scanner;

public class Zadanie3 {
    public static void main(String[] args) {
        WariantZestawu wariantZestawu;
        GUIZestaw factory;

        Scanner in = new Scanner(System.in);
        System.out.println("Wybrane rodzaje zestawów ...");
        System.out.println("1. Nowoczesny");
        System.out.println("2. Wiktoriański");
        System.out.println("3. ArtDeco");
        System.out.print("\nPodaj rodzaj zestawu: ");
        int a = in.nextInt();
        System.out.println();
        if (a == 1){
            factory = new NowoczesnyZestaw();
            wariantZestawu = new WariantZestawu(factory);
            wariantZestawu.informacja();
        }
        else if (a == 2){
            factory = new WiktorianskiZestaw();
            wariantZestawu = new WariantZestawu(factory);
            wariantZestawu.informacja();
        }
        else if (a == 3){
            factory = new ArtDecoZestaw();
            wariantZestawu = new WariantZestawu(factory);
            wariantZestawu.informacja();
        }
        else{
            System.out.println("Nie ma takiego wyboru!");
        }
    }
}

interface Fotel{
    void fotel();
}

interface Sofa{
    void sofa();
}

interface StolikKawowy{
    void stolikKawowy();
}

class FotelNowoczesny implements Fotel{

    @Override
    public void fotel(){
        System.out.println("Fotel Nowoczesny");
    }
}

class FotelWiktorianski implements Fotel{

    @Override
    public void fotel(){
        System.out.println("Fotel Wiktoriański");
    }
}

class FotelArtDeco implements Fotel{

    @Override
    public void fotel(){
        System.out.println("Fotel ArtDeco");
    }
}

class SofaNowoczesna implements Sofa{

    @Override
    public void sofa(){
        System.out.println("Sofa Nowoczesna");
    }
}

class SofaWiktorianska implements Sofa{

    @Override
    public void sofa(){
        System.out.println("Sofa Wiktoriańska");
    }
}

class SofaArtDeco implements Sofa{

    @Override
    public void sofa(){
        System.out.println("Sofa ArtDeco");
    }
}

class StolikKawowyNowoczesny implements StolikKawowy{

    @Override
    public void stolikKawowy(){
        System.out.println("Stolik Kawowy Nowoczesny");
    }
}

class StolikKawowyWiktorianski implements StolikKawowy{

    @Override
    public void stolikKawowy(){
        System.out.println("Stolik Kawowy Wiktorianski");
    }
}

class StolikKawowyArtDeco implements StolikKawowy{

    @Override
    public void stolikKawowy(){
        System.out.println("Stolik Kawowy ArtDeco");
    }
}

interface GUIZestaw {
    Fotel createFotel();
    Sofa createSofa();
    StolikKawowy creteStolik();
}

class NowoczesnyZestaw implements GUIZestaw{

    @Override
    public Fotel createFotel() {
        return new FotelNowoczesny();
    }

    @Override
    public Sofa createSofa() {
        return new SofaNowoczesna();
    }

    @Override
    public StolikKawowy creteStolik() {
        return new StolikKawowyNowoczesny();
    }
}

class WiktorianskiZestaw implements GUIZestaw{

    @Override
    public Fotel createFotel() {
        return new FotelWiktorianski();
    }

    @Override
    public Sofa createSofa() {
        return new SofaWiktorianska();
    }

    @Override
    public StolikKawowy creteStolik() {
        return new StolikKawowyWiktorianski();
    }
}

class ArtDecoZestaw implements GUIZestaw{

    @Override
    public Fotel createFotel() {
        return new FotelArtDeco();
    }

    @Override
    public Sofa createSofa() {
        return new SofaArtDeco();
    }

    @Override
    public StolikKawowy creteStolik() {
        return new StolikKawowyArtDeco();
    }
}

class WariantZestawu{
    private Fotel fotel;
    private Sofa sofa;
    private StolikKawowy stolikKawowy;

    public WariantZestawu(GUIZestaw factory){
        fotel = factory.createFotel();
        sofa = factory.createSofa();
        stolikKawowy = factory.creteStolik();
    }

    public void informacja(){
        fotel.fotel();
        sofa.sofa();
        stolikKawowy.stolikKawowy();
    }
}