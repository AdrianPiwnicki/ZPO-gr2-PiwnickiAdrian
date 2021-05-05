import java.io.*;

public class Zadanie3 {
    public static void main(String[] args) throws IOException {
        Singleton firmaFinansowa = Singleton.getInstance();
        String filePath = "D:/ZPO-gr2-PiwnickiAdrian/LaboratoriumSingleton/src/daneFinansowe.txt";
        String dane;

        try (BufferedReader fileReader = new BufferedReader(new FileReader(filePath))) {
            dane = fileReader.readLine();
            dane += "\n";
            dane += fileReader.readLine();
        }

        firmaFinansowa.daneFinansowe = dane;
        System.out.println(firmaFinansowa.daneFinansowe);
    }
}

class Singleton{
    private static Singleton instance = null;
    public String daneFinansowe;

    private Singleton(){
        System.out.println("Singleton Dane Finansowe created");
    }

    public static Singleton getInstance(){
        if(instance == null)
            instance = new Singleton();
        return instance;
    }
}
