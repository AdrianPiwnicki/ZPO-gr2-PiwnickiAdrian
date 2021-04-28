public class Zadanie3 {
    public static void main(String[] args) {

    }
}

class Linia{
    int x1, x2, y1, y2;

    public Linia() {

    }

    public Linia(int x1, int x2, int y1, int y2){
        this.x1= x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    public void nowaLinia(int x1, int x2, int y1, int y2){
        this.x1= x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }
}

class Prostokat{
    int dlugosc;
    int wysokosc;
    int x, y;

    public Prostokat(){

    }

    public Prostokat(int dlugosc, int wysokosc, int x, int y){
        this.dlugosc = dlugosc;
        this.wysokosc = wysokosc;
        this.x = x;
        this.y = y;
    }

    public void nowyProstokat(int dlugosc, int wysokosc, int x, int y){
        this.dlugosc = dlugosc;
        this.wysokosc = wysokosc;
        this.x = x;
        this.y = y;
    }
}

class Fasada3{
    Linia linia= new Linia();
    Prostokat prostokat = new Prostokat();

    public void stworzLinie(int x1, int x2, int y1, int y2){
        linia.nowaLinia(x1,x2,y1,y2);
    }

    public void stworzProstokat(int dlugosc, int wysokosc, int x, int y){
        prostokat.nowyProstokat(dlugosc, wysokosc, x, y);
    }
}