import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.*;

public class Zadanie2 {
    public static void main(String[] args) {
        TV tv = new TV();
        Pilot pilot = new Pilot(tv);
        pilot.init();
    }
}

abstract class State2 {
    TV tv;

    State2(TV tv) {
        this.tv = tv;
    }

    public abstract String wylacz();
    public abstract String wlacz();
    public abstract String dalej();
}

class LockedState2 extends State2 {

    LockedState2(TV tv) {
        super(tv);
        tv.setWlacz(false);
    }

    @Override
    public String wylacz() {
        if (tv.czyWlaczony()) {
            tv.changeState(new ReadyState2(tv));
            return "Wyłączam";
        } else {
            return "Zablokowany ...";
        }
    }

    @Override
    public String wlacz() {
        tv.changeState(new ReadyState2(tv));
        return "Włączam";
    }

    @Override
    public String dalej() {
        return "Zablokowany ...";
    }
}

class ReadyState2 extends State2 {

    public ReadyState2(TV tv) {
        super(tv);
    }

    @Override
    public String wylacz() {
        tv.changeState(new LockedState2(tv));
        return "Zablokowany ...";
    }

    @Override
    public String wlacz() {
        String action = tv.uruchomKanal();
        tv.changeState(new PlayingState2(tv));
        return action;
    }

    @Override
    public String dalej() {
        return "Zablokowany ...";
    }
}

class PlayingState2 extends State2 {

    PlayingState2(TV tv) {
        super(tv);
    }

    @Override
    public String wylacz() {
        tv.changeState(new LockedState2(tv));
        tv.setKanalPoWylaczeniu();
        return "Wyłączam TV";
    }

    @Override
    public String wlacz() {
        return "Zablokowany ...";
    }

    @Override
    public String dalej() {
        return tv.kolejnyKanal();
    }
}


class TV {
    private State2 state;
    private boolean wlaczony = false;
    private List<String> tvList = new ArrayList<>();
    private int kanal = 0;

    public TV() {
        this.state = new ReadyState2(this);
        setWlacz(true);
        for (int i = 1; i <= 100; i++) {
            tvList.add("Kanał numer " + i);
        }
    }

    public void changeState(State2 state) {
        this.state = state;
    }

    public State2 getState() {
        return state;
    }

    public void setWlacz(boolean wlaczony) {
        this.wlaczony = wlaczony;
    }

    public boolean czyWlaczony() {
        return wlaczony;
    }

    public String uruchomKanal() {
        return "Uruchamiam kanal " + tvList.get(kanal);
    }

    public String kolejnyKanal() {
        kanal++;
        if (kanal > tvList.size() - 1) {
            kanal = 0;
        }
        return "Aktualnie kanał " + tvList.get(kanal);
    }

    public void setKanalPoWylaczeniu() {
        this.kanal = 0;
    }
}

class Pilot {
    private TV tv;
    private static JTextField textField = new JTextField();

    public Pilot(TV tv) {
        this.tv = tv;
    }

    public void init() {
        JFrame frame = new JFrame("Pilot do LG");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel context = new JPanel();
        context.setLayout(new BoxLayout(context, BoxLayout.Y_AXIS));
        frame.getContentPane().add(context);
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
        context.add(textField);
        context.add(buttons);

        JButton wlacz = new JButton("Włącz");
        wlacz.addActionListener(e -> textField.setText(tv.getState().wlacz()));
        JButton wylacz = new JButton("Wylacz");
        wylacz.addActionListener(e -> textField.setText(tv.getState().wylacz()));
        JButton dalej = new JButton("Dalej");
        dalej.addActionListener(e -> textField.setText(tv.getState().dalej()));
        frame.setVisible(true);
        frame.setSize(300, 100);
        buttons.add(wlacz);
        buttons.add(wylacz);
        buttons.add(dalej);
    }
}