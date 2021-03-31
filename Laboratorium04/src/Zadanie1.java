import java.util.Stack;

public class Zadanie1 {
    public static void main(String[] args) {
        Argumenty argumenty = new Argumenty(0);
        Suma suma = new Suma();
        suma.execute(1, 2, 3, 4 ,5);
        argumenty.doOperation(suma);
        argumenty.undoOperation();
    }
}

interface Command_1{
    int execute(int... args);
    void undo();
}

class HistoriaPolecen_1{

    Stack<Command_1> historiaPolecen = new Stack<>();

    public void push(Command_1 command){
        this.historiaPolecen.push(command);
    }

    public Command_1 pop(){
        return this.historiaPolecen.pop();
    }

    public boolean isEmpty(){
        return this.historiaPolecen.isEmpty();
    }

}

class Argumenty {
    int wynik;
    HistoriaPolecen_1 historiaPolecen;

    public Argumenty(int wynik){
        this.wynik = wynik;
        historiaPolecen = new HistoriaPolecen_1();
    }

    public void doOperation(Command_1 command){
        this.historiaPolecen.push(command);
        command.execute();
    }

    public void undoOperation(){
        if(!this.historiaPolecen.isEmpty())
            this.historiaPolecen.pop().undo();
    }



}

class Suma implements Command_1{
    int wynik = 0;

    @Override
    public int execute(int... args) {
        for(int arg: args)
            this.wynik += arg;

        System.out.println("WyniK: " + this.wynik);

        return wynik;
    }

    @Override
    public void undo() {
        System.out.println("Undo: " + this.wynik);
    }

}