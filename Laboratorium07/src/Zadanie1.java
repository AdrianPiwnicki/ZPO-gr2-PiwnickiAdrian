import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Zadanie1 {
    public static void main(String[] args) throws IOException {
        String filePath = "D:/ZPO-gr2-PiwnickiAdrian/Laboratorium07/src/drzewo.txt";
        ArrayList<String> drzewo = new ArrayList<>();
        int i = 0;

        //coś nie chce dobrze wierszy zczytać dlatego ręcznie je zczytuje://
        try(BufferedReader fileReader = new BufferedReader(new FileReader(filePath))) {
//        int wiersze = (int) fileReader.lines().count();
//        while(i < wiersze) {
            drzewo.add(fileReader.readLine());
            drzewo.add(fileReader.readLine());
            drzewo.add(fileReader.readLine());
            drzewo.add(fileReader.readLine());
            drzewo.add(fileReader.readLine());
//        i = i + 1;
//    }
        }

        Drzewo drzewoWarstwami = new Drzewo(drzewo);
        Przeglad przeglad = new Przeglad(drzewoWarstwami);
        przeglad.drukujDrzewo();

    }
}

interface Iterator{
    boolean hasNext();
    Object next();
}

class Drzewo implements Iterator{
    List<String> drzewo;
    int pozycja = 0;

    Drzewo(List<String> drzewo){
        this.drzewo = drzewo;
    }


    @Override
    public boolean hasNext() {
        return pozycja < drzewo.size() && drzewo.get(pozycja) != null;
    }

    @Override
    public Object next() {
        String pozycjaDrzewa = drzewo.get(pozycja);
        pozycja = pozycja + 1;
        return pozycjaDrzewa;
    }
}


class Przeglad{
    Drzewo drzewo;

    public Przeglad(Drzewo drzewo){
        this.drzewo = drzewo;
    }

    void drukujDrzewo(){
        while(drzewo.hasNext()){
            System.out.println(drzewo.next());
        }
    }
}