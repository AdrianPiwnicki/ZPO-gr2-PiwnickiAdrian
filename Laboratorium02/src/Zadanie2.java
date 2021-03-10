/*Zaimplementuj program wybierajacy kodowanie dźwięku: DolbyProLogic, DolbyDigital*/

public class Zadanie2 {

    public static class Dzwiek
    {
        private int iloscGlosnikow;
        Kodowanie kodowanie;

        void ustaw()
        {
            if(this.iloscGlosnikow > 2)
                this.kodowanie = new DolbyDigital();
            else
                this.kodowanie = new DolbyProLogic();
        }

    }

    interface Kodowanie
    {
        String koduj();
    }

    public static class DolbyProLogic implements Kodowanie
    {
        @Override
        public String koduj() {
            return "Ustawiono DolbyProLogic";
        }
    }

    public static class DolbyDigital implements Kodowanie
    {
        @Override
        public String koduj() {
            return "Ustawiono DolbyDigital";
        }
    }

    public static void main(String[] args) {
        Dzwiek zestawPierwszy = new Dzwiek();
        zestawPierwszy.iloscGlosnikow = 3;
        zestawPierwszy.ustaw();
        System.out.println(zestawPierwszy.kodowanie.koduj());

        Dzwiek zestawDrugi = new Dzwiek();
        zestawDrugi.iloscGlosnikow = 2;
        zestawDrugi.ustaw();
        System.out.println(zestawDrugi.kodowanie.koduj());
    }

}
