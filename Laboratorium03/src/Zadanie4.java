import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Zadanie4 {
    public static void main(String [] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Zadanie4().start();
            }
        });
    }
    private void start() {
        MainWindow m = new MainWindow();
        MainWindow2 m2 = new MainWindow2();
        new DialogWindow(m, m2);
    }

} // ExampleAppStarter

class MainWindow implements Observer {
    private JLabel label;
    @Override
    public void update(Observable o, Object data) {
        label.setText((String) data); // displays new text in JLabel
    }

    MainWindow() {
        JFrame frame = new JFrame("Main Window");
        frame.getRootPane().setBorder(
                BorderFactory.createEmptyBorder(20, 20, 20, 20));
        label = new JLabel("Liczba punktów: ");
        label.setFont(new Font("Dialog", Font.PLAIN, 20));
        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLocation(200, 200);
        frame.setVisible(true);
    }
}

class MainWindow2 implements Observer {
    private JLabel label;
    @Override
    public void update(Observable o, Object data) {
        label.setText((String) data); // displays new text in JLabel
    }

    MainWindow2() {
        JFrame frame = new JFrame("Main Window");
        frame.getRootPane().setBorder(
                BorderFactory.createEmptyBorder(20, 20, 20, 20));
        label = new JLabel("Współrzędne punktów: ");
        label.setFont(new Font("Dialog", Font.PLAIN, 20));
        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(3000, 300);
        frame.setLocation(200, 200);
        frame.setVisible(true);
    }
}

class DialogWindow {
    private int clicks;
    private final ArrayList<Point> points = new ArrayList<Point>();
    DialogWindow(MainWindow mainWindow, MainWindow2 mainWindow2) {
        // Create Observable and add Observer
        final MessageObservable observable = new MessageObservable();
        final MessageObservable observable1 = new MessageObservable();
        observable.addObserver(mainWindow);
        observable1.addObserver(mainWindow2);
        // Display Dialog
        JFrame dialog = new JFrame("Dialog");

        dialog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dialog.pack();
        MouseTestPanel mml = new MouseTestPanel();
        mml.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                String data = "Liczba punktów: " + ++clicks;
                observable.changeData(data);

                points.add(new Point(e.getX(), e.getY()));
                String data2 = "";
                for(Point p : points){
                    data2 += "[" + p.x + ", " + p.y + "]\n";
                }
                observable1.changeData(data2);
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        dialog.add(mml);
        dialog.setSize(500, 500);
        dialog.setVisible(true);

    }
}

class MessageObservable extends Observable {
    MessageObservable() {
        super();
    }
    void changeData(Object data) {
        setChanged();
        notifyObservers(data);
    }
}

class MouseTestPanel extends JPanel implements MouseListener {

    private static final int DEFAULT_WIDTH = 400;
    private static final int DEFAULT_HEIGHT = 400;

    private int x, y;

    ArrayList<Point> points = new ArrayList<Point>();

    public MouseTestPanel() {
        addMouseListener(this);
        setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        points.add(new Point(x, y));
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
        g2d.setColor(Color.BLACK);
        drawOval(g2d);
    }

    private void drawOval(Graphics2D g2d) {
        int x, y;
        for (Point p : points) {
            x = (int) p.getX();
            y = (int) p.getY();
            g2d.fillOval(x, y, 10, 10);
        }
    }
}
