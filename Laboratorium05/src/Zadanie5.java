public class Zadanie5 {
    public static void main(String[] args) {
        Tusz tusz= new Tusz(100);

        while(tusz.ilosc > 1){
            System.out.println("Drukuję stronę ...");
            tusz.ilosc -= 10;


            if(tusz.ilosc == 50){
                PolowaTuszu polowaTuszu = new PolowaTuszu(tusz);
                System.out.println(polowaTuszu.getIlosc());
            }
            else if(tusz.ilosc == 10){
                KoncowkaTuszu koncowkaTuszu = new KoncowkaTuszu(tusz);
                System.out.println(koncowkaTuszu.getIlosc());
            }
            else if(tusz.ilosc == 0){
                BrakTuszu brakTuszu = new BrakTuszu(tusz);
                System.out.println(brakTuszu.getIlosc());
                break;
            }
            else
                System.out.println(tusz.getIlosc());
        }

        tusz.doladujTusz();
        System.out.println(tusz.getIlosc());

    }
}

class Tusz{
    int ilosc;

    public Tusz(int ilosc){
        if(ilosc <= 100 && ilosc >= 0)
            this.ilosc = ilosc;
        else
            this.ilosc = 0;
    }

    public String getIlosc(){
        return "Poziom tuszu wynosi: " + this.ilosc + "%";
    }

    public void doladujTusz(){
        this.ilosc = 100;
    }
}

class PolowaTuszu extends Tusz {
    Tusz tusz;

    public PolowaTuszu(Tusz tusz){
        super(50);
        this.tusz = tusz;
    }

    @Override
    public String getIlosc(){
        return tusz.getIlosc();
    }

    @Override
    public void doladujTusz() {
        super.doladujTusz();
    }
}

class KoncowkaTuszu extends Tusz{
    Tusz tusz;

    public KoncowkaTuszu(Tusz tusz){
        super(10);
        this.tusz = tusz;
    }

    @Override
    public String getIlosc(){
        return tusz.getIlosc() + "      " + "Tusz się kończy!!!";
    }

    @Override
    public void doladujTusz() {
        super.doladujTusz();
    }

}

class BrakTuszu extends Tusz{
    Tusz tusz;

    public BrakTuszu(Tusz tusz){
        super(0);
        this.tusz = tusz;
    }

    @Override
    public String getIlosc(){
        return tusz.getIlosc() + "      " + "Brak tuszu, doładuj!!!";
    }

    @Override
    public void doladujTusz() {
        super.doladujTusz();
    }
}

