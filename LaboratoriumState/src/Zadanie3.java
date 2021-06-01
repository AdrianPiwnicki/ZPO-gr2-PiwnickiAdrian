import java.util.Scanner;

public class Zadanie3 {
    public static void main(String[] args) throws InterruptedException {
        Autoryzacja autoryzacja = new Autoryzacja();
        SprawdzanieStan sprawdzanieStan = new SprawdzanieStan(autoryzacja);
        autoryzacja.changeState(sprawdzanieStan);
        autoryzacja.loguj();
    }
}

abstract class State3 {
    Autoryzacja autoryzacja;
    String login = "login";
    String password = "password";
    Integer error = 0;

    State3(Autoryzacja autoryzacja) {
        this.autoryzacja = autoryzacja;
    }

    public abstract void stan() throws InterruptedException;
}

class SprawdzanieStan extends State3{
    SprawdzanieStan(Autoryzacja autoryzacja){
        super(autoryzacja);
    }

    @Override
    public void stan() throws InterruptedException {
        if (autoryzacja.currentLogin.equals(login) && autoryzacja.currentPassword.equals(password)){
            autoryzacja.changeState(new PoprawnaStan(autoryzacja));
            error = 0;
        }
        else{
            error += 1;

            if (error == 3){
                error = 0;
                autoryzacja.changeState(new BladAutoryzacji3RazyStan(autoryzacja));
            }
            else{
                System.out.println(error);
                autoryzacja.changeState(new BladAutoryzacjiStan(autoryzacja));
            }

        }
    }
}

class PoprawnaStan extends State3{
    PoprawnaStan(Autoryzacja autoryzacja){
        super(autoryzacja);
        stan();
    }

    @Override
    public void stan(){
        System.out.println("Login i hasło są poprawne");
    }
}

class BladAutoryzacjiStan extends State3{
    BladAutoryzacjiStan(Autoryzacja autoryzacja) throws InterruptedException {
        super(autoryzacja);
        stan();
    }

    @Override
    public void stan() throws InterruptedException {
        System.out.println("Bląd Autoryzacji Stanu");
        autoryzacja.loguj();
        autoryzacja.changeState(new SprawdzanieStan(autoryzacja));
    }
}

class BladAutoryzacji3RazyStan extends State3{
    BladAutoryzacji3RazyStan(Autoryzacja autoryzacja) throws InterruptedException {
        super(autoryzacja);
        stan();
    }

    @Override
    public void stan() throws InterruptedException {
        System.out.println("Błąd Autoryzacji 3 Razy - odczekaj 30 sekund");
        Thread.sleep(30000);
        autoryzacja.loguj();
        autoryzacja.changeState(new SprawdzanieStan(autoryzacja));
    }
}

class Autoryzacja{
    State3 state;
    String currentLogin = "";
    String currentPassword = "";

    void loguj() throws InterruptedException {
        Scanner in = new Scanner(System.in);

        System.out.println("Login: ");
        this.currentLogin = in.next();

        System.out.println("Password: ");
        this.currentPassword = in.next();

        stan();
    }

    void changeState(State3 newState){
        this.state = newState;
    }

    void stan() throws InterruptedException {
        state.stan();
    }
}