import java.sql.SQLOutput;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

public class Zadanie3 {

    public static class CurrentNumber implements Observer {

        private int number;

        @Override
        public void update(Observable o, Object number) {
        }
    }

    public static class WiekszeOd extends Observable {

        private int number;

        public void setNumber(int number) {
            if (number > 0) {
                this.number = number;
                setChanged();
                notifyObservers(number);
                System.out.println("Wychwycona liczba: " + this.number);
            }
        }
    }

    public static class RowneTrzy extends Observable {

        private int number;

        public void setNumber(int number) {
            if (number == 3) {
                this.number = number;
                setChanged();
                notifyObservers(number);
                System.out.println("Wychwycona liczba: " + this.number);
            }
        }
    }

    public static class PodzielnePrzezDwa extends Observable {

        private int number;

        public void setNumber(int number) {
            if (number % 2 == 0) {
                this.number = number;
                setChanged();
                notifyObservers(number);
                System.out.println("Wychwycona liczba: " + this.number);
            }
        }
    }


        public static void main(String[] args) {
            CurrentNumber observer = new CurrentNumber();
            Scanner scanner = new Scanner(System.in);
            int number;

            do {
                System.out.println("Podaj liczbe: ");
                number = scanner.nextInt();
            }while(number != 0);

            System.out.println("Jakie mam wychwytywac wartosci?");
            System.out.println("1 - liczby wieksze od zera");
            System.out.println("2 - liczby równe 3");
            System.out.println("3 - liczby podzielne przez 2");
            int wybor = scanner.nextInt();

            switch (wybor) {
                case 1:
                    WiekszeOd observable1 = new WiekszeOd();
                    observable1.addObserver(observer);
                    while (number == 0) {
                        System.out.println("Podaj liczbe: ");
                        int number1 = scanner.nextInt();
                        observable1.setNumber(number1);
                    }
                    break;
                case 2:
                    RowneTrzy observable2 = new RowneTrzy();
                    observable2.addObserver(observer);
                    while (number == 0) {
                        System.out.println("Podaj liczbe: ");
                        int number1 = scanner.nextInt();
                        observable2.setNumber(number1);
                    }
                        break;
                    case 3:
                        PodzielnePrzezDwa observable3 = new PodzielnePrzezDwa();
                        observable3.addObserver(observer);
                        while (number == 0) {
                            System.out.println("Podaj liczbe: ");
                            int number1 = scanner.nextInt();
                            observable3.setNumber(number1);
                        }
                        break;
                    default:
                        break;
                }

        }
}
