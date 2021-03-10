/*4. Piszesz program dla międzynarodowej firmy reklamowej.
        Program wybiera z bazy loso-wego klienta i losową reklamę.
        Reklama przed wysłaniem jest tłumaczona na preferowanyprzez klienta język.
        Ponadto w zalezności od tego ile zapłacił reklamodawca, reklamamoże być wysyłana
        za pomocą listu elektronicznego, wiadomości sms lub wiadomościgłosowej odczytanej
        przez syntezator mowy. Zaproponuj rozwiązanie oparte na Strategy.*/


public class Zadanie4 {
    public static class Reklama
    {
        private double oplata;
        Tlumaczenie tlumaczenie;
        TypPrzekazu typPrzekazu;

        void oplacone(Reklama obj)
        {
            if(oplata == 4.99)
                obj.typPrzekazu = new SMS();
            else if(oplata == 5.99)
                obj.typPrzekazu = new Email();
            else if(oplata == 7.99)
                obj.typPrzekazu = new WiadomoscGlosowa();
        }
    }

    interface Tlumaczenie
    {
        String tlumacz();
    }

    public class Polski implements Tlumaczenie
    {
        @Override
        public String tlumacz()
        {
            return "Tłumaczenie w PL";
        }
    }

    public class Angielski implements Tlumaczenie
    {
        @Override
        public String tlumacz()
        {
            return "Tłumaczenie w ENG";
        }
    }

    public class Niemiecki implements Tlumaczenie
    {
        @Override
        public String tlumacz()
        {
            return "Tłumaczenie w DE";
        }
    }

    interface TypPrzekazu
    {
        String przekaz();
    }

    public static class Email implements TypPrzekazu
    {
        @Override
        public String przekaz()
        {
            return "Przekazanie pocztą elektroniczną.";
        }
    }

    public static class SMS implements TypPrzekazu
    {
        @Override
        public String przekaz()
        {
            return "Przekazanie SMSem.";
        }
    }

    public static class WiadomoscGlosowa implements TypPrzekazu
    {
        @Override
        public String przekaz()
        {
            return "Przekazanie Wiadomością Głosową.";
        }
    }

    public static void main(String[] args) {
        Reklama pReklama = new Reklama();
        pReklama.oplata = 4.99;
        pReklama.oplacone(pReklama);
        System.out.println(pReklama.typPrzekazu.przekaz());
    }
}
