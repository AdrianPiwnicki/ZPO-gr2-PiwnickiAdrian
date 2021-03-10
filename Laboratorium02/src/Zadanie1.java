/*1. Zmodyfikuj projekt symulatora kaczki. Utwórz listy oraz tablize.
        Posortuj je algorytmami znanymi z przedmiotu algorytmy.
        Losuj strategię sortowania. Porównaj czasy wykonania.*/

import java.util.*;

public class Zadanie1 {

    public static class Kaczka implements Comparable<Kaczka>
    {
        Latac latac;
        Kwakac kwakac;
        Plywac plywac;
        private String name;

        public Kaczka(String name)
        {
            this.name = name;
        }

        public int compareTo(Kaczka k)
        {
            return this.name.compareTo(k.name);
        }
    }

    interface Latac
    {
        void lataj();
    }

    interface Kwakac
    {
        void kwakaj();
    }

    interface Plywac
    {
        void plywaj();
    }

    public class LatacNaSkrzydlach implements Latac {
        @Override
        public void lataj()
        {
            System.out.println("Kaczka na skrzydlach lata.");
        }
    }

    public class BezLatania implements Latac {
        @Override
        public void lataj()
        {
            System.out.println("Kaczka nie polata bo nie ma skrzydel.");
        }
    }

    public class KwakacPoProstu implements Kwakac {
        @Override
        public void kwakaj()
        {
            System.out.println("Kaczka kwaka po prostu");
        }
    }

    public class Piszczec implements Kwakac {
        @Override
        public void kwakaj()
        {
            System.out.println("Kaczka piszczy zamiast kwakac");
        }
    }

    public class BezGlosu implements Kwakac {
        @Override
        public void kwakaj()
        {
            System.out.println("Kaczka nie daje glosu");
        }
    }

    public class PlywacNaWodzie implements Plywac {
        @Override
        public void plywaj()
        {
            System.out.println("Kaczka plywa na wodzie.");
        }
    }

    public class Tonac implements Plywac {
        @Override
        public void plywaj()
        {
            System.out.println("Kaczka tonie.");
        }
    }

    public static void main(String[] args) {
        List<Kaczka> kaczki = new ArrayList<>();
        kaczki.add(new Kaczka("Kwoka"));
        kaczki.add(new Kaczka("Koszka"));
        kaczki.add(new Kaczka("Kartotka"));
        Collections.sort(kaczki);
        for(Kaczka k : kaczki){
            System.out.println(k.name);
        }
    }

}
