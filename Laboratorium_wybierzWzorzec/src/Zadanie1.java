public class Zadanie1 {
    public static void main(String[] args) {
        KontoBankowe konto = new KontoBankowe(3000);

        konto.saldo = konto.wplata.wykonaj(konto.saldo, 200);
        konto.getSaldo();

        konto.saldo = konto.wyplata.wykonaj(konto.saldo, 300);
        konto.getSaldo();

        konto.saldo = konto.przelew.wykonaj(konto.saldo, 400);
        konto.getSaldo();

    }
}

class KontoBankowe{
    double saldo;
    Wyplata wyplata = new Wyplata();
    Wplata wplata = new Wplata();
    Przelew przelew = new Przelew();

    public KontoBankowe(double saldo){
        this.saldo = saldo;
    }

    public void getSaldo(){
        System.out.println("Saldo wynosi " + this.saldo);
    }
}

interface Operacja{
    double wykonaj(double saldo, double kwota);
}

class Wyplata implements Operacja{

    @Override
    public double wykonaj(double saldo, double kwota) {
        saldo = saldo - kwota;
        System.out.println("Wypłacono " + kwota);
        return saldo;
    }
}

class Wplata implements Operacja{

    @Override
    public double wykonaj(double saldo, double kwota) {
        saldo = saldo + kwota;
        System.out.println("Wplacono " + kwota);
        return saldo;
    }
}

class Przelew implements Operacja{

    @Override
    public double wykonaj(double saldo, double kwota) {
        saldo = saldo - kwota;
        System.out.println("Wykonano przelew za " + kwota);
        return saldo;
    }
}

