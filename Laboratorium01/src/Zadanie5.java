/*Przypuśćmy, że tworzymy sklep internetowy oferujący swoje usługi w kilku państwach.
        Jak wiadomo prawo podatkowe znacząco różni się w poszczególnych krajach.
        Powstaje problem naliczenia odpowiedniego podatku dla klientów pochodzących z odmiennych państw.
        Jak to rozwiązać?  Wybrać odpowiednią stawkę za pomocą licznych instruk-cji warunkowych?
        Zaimplementuj rozwiązanie jako wzorzec Strategia.  Zakładamy, żesklep działa tylko w Polsce,
        Wielkiej Brytanii i Niemczech.*/


public class Zadanie5 {
    public class Sklep
    {
        NaliczacPodatek naliczacPodatek;
    }

    interface NaliczacPodatek
    {
        double naliczPodatek(double kwotaNetto);
    }

    public class PodatekPolska implements NaliczacPodatek {
        @Override
        public double naliczPodatek(double kwotaNetto)
        {
            double kwotaBrutto = kwotaNetto * 23% + kwotaNetto;
            return kwotaBrutto;
        }
    }

    public class PodatekWielkaBrytania implements NaliczacPodatek {
        @Override
        public double naliczPodatek(double kwotaNetto)
        {
            double kwotaBrutto = kwotaNetto * 20% + kwotaNetto;
            return kwotaBrutto;
        }
    }

    public class PodatekNiemcy implements NaliczacPodatek {
        @Override
        public double naliczPodatek(double kwotaNetto)
        {
            double kwotaBrutto = kwotaNetto * 19% + kwotaNetto;
            return kwotaBrutto;
        }
    }
}
