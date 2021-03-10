/*3. Załóżmy że Tworzymy grę RPG, pomińmy w jakiej technologii to robimy oraz dokładną implementację.
        Zajmijmy się tylko i wyłącznie sposobem ataku postaci.  Wiemy już że na początku będą tylko
        4 typy postaci, oto one: strzelec, łucznik, rycerz, kanonier.Zaimplementuj wybór broni
        za pomocą wzorca strategia.*/

public class Zadanie3 {

    public static class Postac
    {
        private int level;
        private String name;
        KlasaPostaci klasaPostaci;
    }

    interface KlasaPostaci
    {
        String typ_broni();
    }

    public static class Strzelec implements KlasaPostaci
    {
        @Override
        public String typ_broni()
        {
            return "Kusza dla strzelca";
        }
    }

    public static class Lucznik implements KlasaPostaci
    {
        @Override
        public String typ_broni()
        {
            return "Luk dla lucznika";
        }
    }

    public static class Rycerz implements KlasaPostaci
    {
        @Override
        public String typ_broni()
        {
            return "Miecz dla rycerza";
        }
    }

    public static class Kanonier implements KlasaPostaci
    {
        @Override
        public String typ_broni()
        {
            return "Kanonierka dla kanoniera";
        }
    }

    public static void main(String[] args) {
        Postac nowaPostac = new Postac();
        nowaPostac.klasaPostaci = new Strzelec();
        System.out.println(nowaPostac.klasaPostaci.typ_broni());

        Postac nowaPostac2 = new Postac();
        nowaPostac2.klasaPostaci = new Kanonier();
        System.out.println(nowaPostac2.klasaPostaci.typ_broni());
    }
}
