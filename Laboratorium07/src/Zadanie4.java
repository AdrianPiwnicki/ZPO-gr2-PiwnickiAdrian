import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Zadanie4 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        Pizza pizza = null;

        System.out.println("""
                Wybierz pizze:
                1 - Pizza Margherita
                2 - Pizza Sycylijska""");
        int wybor = Integer.parseInt(reader.readLine());

        if(wybor == 1){
            pizza = new PizzaMargherita();
        } else if (wybor == 2){
            pizza = new PizzaSycylijska();
        }

        pizza.proces();

    }
}

abstract class Pizza{
    String nazwa;

    Pizza() {}

    public void proces(){
        przygotujCiasto();
        dodajSosPomidorowy();
        dodajSkaldnik();
        pieczPrzez15Minut();
        System.out.println("Pizza gotowa !!!");
    }

    abstract void przygotujCiasto();
    abstract void dodajSosPomidorowy();
    abstract void dodajSkaldnik();
    abstract void pieczPrzez15Minut();
}

class PizzaMargherita extends Pizza{

    @Override
    void przygotujCiasto() {
        System.out.println("Przygotuj cienkie ciasto.");
        simulateNetworkLatency();
    }

    @Override
    void dodajSosPomidorowy() {
        System.out.println("\nDodaj sos pomidorowy.");
        simulateNetworkLatency();
    }

    @Override
    void dodajSkaldnik() {
        System.out.println("\nDodaj ser mozzarella.");
        simulateNetworkLatency();
        System.out.println("\nDodaj ser mozzarella.");
        simulateNetworkLatency();
        System.out.println("\nDodaj bazylię oraz odrobinę oliwy.");
        simulateNetworkLatency();
    }

    @Override
    void pieczPrzez15Minut() {
        System.out.println("\nPiecz przez około 15 minut");
        simulateNetworkLatency();
    }

    private void simulateNetworkLatency() {
        try {
            int i = 0;
            while (i < 5) {
                System.out.print(".");
                Thread.sleep(500);
                i++;
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}


class PizzaSycylijska extends Pizza{

    @Override
    void przygotujCiasto() {
        System.out.println("Przygotuj grube ciasto.");
        simulateNetworkLatency();
    }

    @Override
    void dodajSosPomidorowy() {
        System.out.println("\nDodaj sos pomidorowy.");
        simulateNetworkLatency();
    }

    @Override
    void dodajSkaldnik() {
        System.out.println("\nDodaj oliwki i kapary.");
        simulateNetworkLatency();
        System.out.println("\nDodaj przyprawy.");
        simulateNetworkLatency();
    }

    @Override
    void pieczPrzez15Minut() {
        System.out.println("\nPiecz przez około 15 minut");
        simulateNetworkLatency();
    }

    private void simulateNetworkLatency() {
        try {
            int i = 0;
            while (i < 5) {
                System.out.print(".");
                Thread.sleep(500);
                i++;
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}