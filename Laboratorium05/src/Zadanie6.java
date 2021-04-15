public class Zadanie6 {
    public static void main(String[] args) {

    }
}

interface MenadzerTuszu{
    void zaladujTusz(int ilosc);
    void pobierzTusz(int ilosc);
    int sprawdzIlosc();
}

class SterownikDecorator implements MenadzerTuszu{

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
}