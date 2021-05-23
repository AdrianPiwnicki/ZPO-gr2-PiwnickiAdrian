import java.io.IOException;
import java.net.UnknownServiceException;
import java.util.ArrayList;
import java.util.Iterator;

public class Zadanie6 {
    public static void main(String[] args) throws IOException {
        ElementMenu bolt = new Menu("bold");
        ElementMenu slant = new Menu("slant");
        ElementMenu underline = new Menu("underline");

        ElementMenu przybornik = new Menu("przybornik");
        przybornik.add(bolt);
        przybornik.add(slant);
        przybornik.add(underline);

        bolt.add(new PozycjaWMenu("Wielkość-1"));
        bolt.add(new PozycjaWMenu("Wielkość-2"));

        slant.add(new PozycjaWMenu("Wielkość-1"));
        slant.add(new PozycjaWMenu("Wielkość-2"));

        underline.add(new PozycjaWMenu("Wielkość-1"));
        underline.add(new PozycjaWMenu("Wielkość-2"));

        System.out.println("Technika wspólnego liścia i korzenia");
        przybornik.print();

        System.out.println("\nTechnika oddzielnego liścia i korzenia");
        bolt.print();
        underline.print();
        slant.print();

    }
}

//przykład na podstawie kodu z książki o klasie kompozyt
abstract class ElementMenu {
    public void add(ElementMenu elementMenu){
        throw new UnsupportedOperationException();
    }

    public void pop(ElementMenu elementMenu){
        throw new UnsupportedOperationException();
    }

    public ElementMenu getLeaf(int p){
        throw new UnsupportedOperationException();
    }

    public String getName(){
        throw new UnsupportedOperationException();
    }

    public void print() throws IOException{
        throw new UnsupportedOperationException();
    }
}

class PozycjaWMenu extends ElementMenu{
    String name;

    public PozycjaWMenu(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void print(){
        System.out.println("Aktualny element menu: " + getName());
    }
}

class Menu extends ElementMenu{
    ArrayList<ElementMenu> elementMenus = new ArrayList<>();
    String name;

    public Menu(String name){
        this.name = name;
    }

    public void add(ElementMenu elementMenu) {
        elementMenus.add(elementMenu);
    }

    public void pop(ElementMenu elementMenu) {
        elementMenus.remove(elementMenu);
    }

    public ElementMenu getLeaf(int p) {
        return elementMenus.get(p);
    }

    public String getName() {
        return this.name;
    }

    public void print() throws IOException {
        System.out.println(getName());

        Iterator iterator = elementMenus.iterator();
        while(iterator.hasNext()) {
            ElementMenu elementMenu = (ElementMenu) iterator.next();
            elementMenu.print();
        }
    }

}