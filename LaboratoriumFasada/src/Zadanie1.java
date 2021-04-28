import java.io.File;
import java.io.FileNotFoundException;
import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Zadanie1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner skan = new Scanner(System.in);
        System.out.print("Podaj ile chcesz wprowadzić liczb: ");
        int ile = skan.nextInt();
        Fasada fasada = new Fasada(ile);
        fasada.wprowadzLiczby();
        fasada.wyswietlTablice();
        fasada.posortujTablice();
        fasada.odczytPliku();
    }
}

class Klawiatura{
    int n;
    ArrayList<Integer> tablica = new ArrayList<Integer>();

    public Klawiatura(int n){
        this.n = n;
    }

    public void wprowadz(){
        Scanner skan = new Scanner(System.in);
        int liczba = skan.nextInt();
        tablica.add(liczba);
    }

    public ArrayList<Integer> pobierz(){
        return this.tablica;
    }
}

class Sortowanie{

    public void sort(ArrayList<Integer> tablica){
        Collections.sort(tablica);
    }
}

class OdczytPLiku{

    public void odczyt(String sciezka, ArrayList<Integer> tablica) throws FileNotFoundException {
        Scanner in = new Scanner(new File(sciezka));
        while (in.hasNext()) {
            int i = in.nextInt();
            tablica.add(i);
        }
    }
}

class Fasada{
    int n;
    Klawiatura klawiatura = new Klawiatura(n);
    Sortowanie sortowanie = new Sortowanie();
    OdczytPLiku odczytPLiku = new OdczytPLiku();

    public Fasada(int n){
        this.n = n;
    }

    public void wprowadzLiczby(){
        for(int i=0; i<n; i++){
            klawiatura.wprowadz();
        }
    }

    public void wyswietlTablice(){
        System.out.println(klawiatura.pobierz());
    }

    public void posortujTablice(){
        sortowanie.sort(klawiatura.tablica);
        System.out.println(klawiatura.pobierz());
    }

    public void odczytPliku() throws FileNotFoundException {
        odczytPLiku.odczyt("Zadanie.txt", klawiatura.tablica);
        System.out.println("Odczytana tablica z pliku: " + klawiatura.pobierz());
    }
}

