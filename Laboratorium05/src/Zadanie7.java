public class Zadanie7 {
    public static void main(String[] args) {

    }
}

class Sterownik extends SterownikDecorator{
    MenadzerTuszu menadzerTuszu;
    private Sterownik(){
        menadzerTuszu = new MenadzerTuszu() {
            @Override
            public void zaladujTusz(int ilosc) {

            }

            @Override
            public void pobierzTusz(int ilosc) {

            }

            @Override
            public int sprawdzIlosc() {
                return 0;
            }
        };
    }
}
