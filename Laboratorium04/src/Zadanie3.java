import java.util.Random;
import java.util.Stack;

public class Zadanie3 {

    public static void main(String[] args) {
        Ksztalt ksztalt = new Ksztalt(100, 100 , "Colorful");

        ChangeColor changeColor = new ChangeColor();
        ChangeWeight changeWeight = new ChangeWeight();
        ChangeHeight changeHeight = new ChangeHeight();

        ksztalt.doOperation(changeColor);
        ksztalt.doOperation(changeWeight);
        ksztalt.doOperation(changeWeight);
        ksztalt.undoOperation();
        ksztalt.undoOperation();
        ksztalt.undoOperation();
    }
}

interface Command{

    void execute();
    void undo();
}

class HistoriaPolecen{

    Stack<Command> historiaPolecen = new Stack<>();

    public void push(Command command){
        this.historiaPolecen.push(command);
    }

    public Command pop(){
        return this.historiaPolecen.pop();
    }

    public boolean isEmpty(){
        return this.historiaPolecen.isEmpty();
    }

}

class Ksztalt{

    int weight;
    int hight;
    String color;
    HistoriaPolecen historiaPolecen;

    public Ksztalt(int weight, int hight, String color){
        this.weight = weight;
        this.hight = hight;
        this.color = color;
        this.historiaPolecen = new HistoriaPolecen();
    }

    public void doOperation(Command command){
        this.historiaPolecen.push(command);
        command.execute();
    }

    public void undoOperation(){
        if(!this.historiaPolecen.isEmpty())
            this.historiaPolecen.pop().undo();
    }
}

class ChangeWeight implements Command{
    int weight;

    @Override
    public void execute() {
        Random rnd = new Random();
        this.weight = rnd.nextInt(151 - 50) + 50;
        System.out.println("Change: " + this.weight);
    }

    @Override
    public void undo() {
        System.out.println("Undo: " + this.weight);
    }
}

class ChangeHeight implements Command{
    int height;

    @Override
    public void execute() {
        Random rnd = new Random();
        this.height = rnd.nextInt(151 - 50) + 50;
        System.out.println("Change: " + this.height);
    }

    @Override
    public void undo() {
        System.out.println("Undo: " + this.height);
    }
}

class ChangeColor implements Command{
    String color;

    @Override
    public void execute() {
        Random rnd = new Random();
        String [] colors = {"Red", "Green", "Yellow", "Blue", "Black", "White"};
        int randomColor = rnd.nextInt(colors.length);
        this.color = colors[randomColor];
        System.out.println("Change: " + this.color);
    }

    @Override
    public void undo() {
        System.out.println("Undo: " + this.color);
    }
}
