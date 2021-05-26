import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Zadanie1 {
    public static void main(String[] args) {
        Komponent komponent = new Komponent();
        GUI gui = new GUI(komponent);
        gui.init();
    }
}

abstract class State1 {
    Komponent komponent;

    State1(Komponent komponent) {
        this.komponent = komponent;
    }

    public abstract String wylacz();
    public abstract String wlacz();
    public abstract String dalej();
    public abstract String rysuj();
}

class LockedState1 extends State1 {

    LockedState1(Komponent komponent) {
        super(komponent);
        komponent.setWlacz(false);
    }

    @Override
    public String wylacz() {
        if (komponent.czyWlaczony()) {
            komponent.changeState(new ReadyState1(komponent));
            return "Wyłączam";
        } else {
            return "Zablokowany ...";
        }
    }

    @Override
    public String wlacz() {
        if (!komponent.czyWlaczony()) {
            komponent.changeState(new ReadyState1(komponent));
            return "Włączam";
        } else {
            return "Zablokowany ...";
        }
    }

    @Override
    public String dalej() {
        return "Zablokowany ...";
    }

    @Override
    public String rysuj() {
        return "Zablokowany ...";
    }
}

class ReadyState1 extends State1 {

    public ReadyState1(Komponent komponent) {
        super(komponent);
    }

    @Override
    public String wylacz() {
        komponent.changeState(new LockedState1(komponent));
        return "Zablokowany ...";
    }

    @Override
    public String wlacz() {
        String action = komponent.kolejneNarzedzie();
        komponent.changeState(new PlayingState1(komponent));
        return action;
    }

    @Override
    public String dalej() {
        return "Zablokowany ...";
    }

    @Override
    public String rysuj() {
        String action = komponent.rysujObiekt();
        komponent.changeState(new PlayingState1(komponent));
        return action;
    }
}

class PlayingState1 extends State1 {

    PlayingState1(Komponent komponent) {
        super(komponent);
    }

    @Override
    public String wylacz() {
        komponent.changeState(new LockedState1(komponent));
        komponent.setPrzybornikPoWylaczeniu();
        return "Wyłączam Przybornik";
    }

    @Override
    public String wlacz() {
        return "Zablokowany ...";
    }

    @Override
    public String dalej() {
        return komponent.kolejneNarzedzie();
    }

    @Override
    public String rysuj() {
        return komponent.rysujObiekt();
    }
}

class Komponent {
    private State1 state;
    private boolean wlaczony = false;
    private List<String> narzedziaList = new ArrayList<>();
    private int numerNarzedzia = 0;

    public Komponent() {
        this.state = new ReadyState1(this);
        setWlacz(true);
        narzedziaList.add("Ołówek");
        narzedziaList.add("Długopis");
        narzedziaList.add("Farba");
        narzedziaList.add("Pędzel");
    }

    public void changeState(State1 state) {
        this.state = state;
    }

    public State1 getState() {
        return state;
    }

    public void setWlacz(boolean wlaczony) {
        this.wlaczony = wlaczony;
    }

    public boolean czyWlaczony() {
        return wlaczony;
    }

    public String rysujObiekt() {
        return "Rysuje obiekt za pomocą: " + narzedziaList.get(numerNarzedzia);
    }

    public String kolejneNarzedzie() {
        numerNarzedzia++;
        if (numerNarzedzia > narzedziaList.size() - 1) {
            numerNarzedzia = 0;
        }
        return "Aktualnie wybór: " + narzedziaList.get(numerNarzedzia);
    }

    public void setPrzybornikPoWylaczeniu() {
        this.numerNarzedzia = 0;
    }
}

class GUI {
    private Komponent komponent;
    private static JTextField textField = new JTextField();

    public GUI(Komponent komponent) {
        this.komponent = komponent;
    }

    public void init() {
        JFrame frame = new JFrame("Przybornik do rysowania");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel context = new JPanel();
        context.setLayout(new BoxLayout(context, BoxLayout.Y_AXIS));
        frame.getContentPane().add(context);
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
        context.add(textField);
        context.add(buttons);

        JButton wlacz = new JButton("Włącz");
        wlacz.addActionListener(e -> textField.setText(komponent.getState().wlacz()));
        JButton wylacz = new JButton("Wylacz");
        wylacz.addActionListener(e -> textField.setText(komponent.getState().wylacz()));
        JButton dalej = new JButton("Kolejne narzedzie");
        dalej.addActionListener(e -> textField.setText(komponent.getState().dalej()));
        JButton rysuj = new JButton("Rysuj");
        rysuj.addActionListener(e -> textField.setText(komponent.getState().rysuj()));
        frame.setVisible(true);
        frame.setSize(500, 100);
        buttons.add(wlacz);
        buttons.add(wylacz);
        buttons.add(dalej);
        buttons.add(rysuj);
    }
}