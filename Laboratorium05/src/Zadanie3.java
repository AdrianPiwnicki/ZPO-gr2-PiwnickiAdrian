import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Zadanie3 {
    public static void main(String[] args) {
        Pizza pizza = new Pizza();
        System.out.println(pizza.getSkladniki());
        PizzaWithSalami pizzaWithSalami = new PizzaWithSalami(pizza);
        System.out.println(pizzaWithSalami.getSkladniki());

        Pizza pizza2 = new Pizza(false, false);
        PizzaWithPieczarki pizzaWithPieczarki = new PizzaWithPieczarki(pizza2);
        System.out.println(pizzaWithPieczarki.getSkladniki());

    }
}

class Pizza{
    List<String> skladniki = new ArrayList<String>();

    public Pizza(){
        this.skladniki.add("Ser");
        this.skladniki.add("Sos Pomidorowy");
        this.skladniki.add("Ciasto");
    }

    public Pizza(boolean ser, boolean sos){
        if(ser)
            this.skladniki.add("Ser");
        if(sos)
            this.skladniki.add("Sos Pomidorowy");

        this.skladniki.add("Ciasto");
    }

    public ArrayList<String> getSkladniki(){
        return (ArrayList<String>) skladniki;
    }
}

class PizzaWithSalami extends Pizza{
    String salami;
    Pizza pizza;

    public PizzaWithSalami(Pizza pizza){
        this.pizza = pizza;
        this.salami = "Salami";
    }

    @Override
    public ArrayList<String> getSkladniki(){
        pizza.getSkladniki().add(salami);
        return pizza.getSkladniki();
    }
}

class PizzaWithPieczarki extends Pizza{
    String pieczarki;
    Pizza pizza;

    public PizzaWithPieczarki(Pizza pizza){
        this.pizza = pizza;
        this.pieczarki = "Pieczarki";
    }

    @Override
    public ArrayList<String> getSkladniki(){
        pizza.getSkladniki().add(pieczarki);
        return pizza.getSkladniki();
    }
}

