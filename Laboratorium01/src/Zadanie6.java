public class Zadanie6
{
    public class Pracownik
    {
        Pracowac pracowac;
        Dojedzac dojedzac;
        SpedzanieWolnegoCzasu spedzanieWolnegoCzasu;

        void pracownik(String zawod)
        {

        }

        void methods()
        {

        }
    }

    //interfejsy Pracowac, Dojedzac i SpedznaieWolnegoCzasu dla klasy Pracownik

    interface Pracowac
    {
        void pracuj();
    }

    interface Dojedzac
    {
        void dojedzaj();
    }

    interface SpedzanieWolnegoCzasu
    {
        void spedzajWolnyCzas();
    }

    //podklasy interfejsu Pracowac

    public class NaprawaSamochodu implements Pracowac{
        @Override
        public void pracuj()
        {

        }
    }

    public class Leczenie implements Pracowac{
        @Override
        public void pracuj()
        {

        }
    }

    public class RoznoszenieListow implements Pracowac{
        @Override
        public void pracuj()
        {

        }
    }

    //podklasy interfejsu Dojedzac

    public class Samochod implements Dojedzac{
        @Override
        public void dojedzaj()
        {

        }
    }

    public class Rower implements Dojedzac{
        @Override
        public void dojedzaj()
        {

        }
    }

    //podklasy interfejsu SpedzanieWolnegoCzasu

    public class LiteraturaPopularnoNaukowa implements SpedzanieWolnegoCzasu{
        @Override
        public void spedzajWolnyCzas()
        {

        }
    }

    public class Silownia implements SpedzanieWolnegoCzasu{
        @Override
        public void spedzajWolnyCzas()
        {

        }
    }

}