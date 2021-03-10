/*Zaimplementuj program wybierajacy kodowanie dźwięku: DolbyProLogic, DolbyDigital*/

public class Zadanie2 {

    public static class Dzwiek
    {
        private int iloscGlosnikow;
        Kodowanie kodowanie;

        Dzwiek(int iloscGlosnikow)
        {
            this.iloscGlosnikow = iloscGlosnikow;
        }
    }

    public static class Kodowanie
    {
        private String typKodowania;
        Kodowanie(Dzwiek obj)
        {
            //DolbyDigital jest ustawiany jeśli ilość głośników w zestawie jest większa od 2
            if (obj.iloscGlosnikow > 2)
                typKodowania="DolbyDigital";
            else
                //jeżeli jest 2 lub mniej głośników to ustawia DolbyProLogic
                typKodowania="DolbyProLogic";
        }
    }

    public static void main(String[] args) {
        Dzwiek dzwiek1 = new Dzwiek(2);
        dzwiek1.kodowanie = new Kodowanie(dzwiek1);
        System.out.println(dzwiek1.kodowanie.typKodowania);

        Dzwiek dzwiek2 = new Dzwiek(5);
        dzwiek2.kodowanie = new Kodowanie(dzwiek2);
        System.out.println(dzwiek2.kodowanie.typKodowania);

    }
}
