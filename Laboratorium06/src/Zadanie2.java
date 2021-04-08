import java.util.Scanner;

public class Zadanie2 {
    public static void main(String[] args) {
        ObslugaTransportu obslugaTransportu;
        GUITransport factory;

        Scanner in = new Scanner(System.in);
        System.out.println("Wybrane rodzaje transportu ...");
        System.out.println("1. Ciężarówka");
        System.out.println("2. Statek");
        System.out.println("3. Samolot");
        System.out.print("\nWybierz rodzaj wysyłki: ");
        int a = in.nextInt();
        System.out.println();
        if (a == 1){
            factory = new CiezarowkaFactory();
            obslugaTransportu = new ObslugaTransportu(factory);
            obslugaTransportu.transportuj();
        }
        else if (a == 2){
            factory = new StatekFactory();
            obslugaTransportu = new ObslugaTransportu(factory);
            obslugaTransportu.transportuj();
        }
        else if (a == 3){
            factory = new SamolotFactory();
            obslugaTransportu = new ObslugaTransportu(factory);
            obslugaTransportu.transportuj();
        }
        else{
            System.out.println("Nie ma takiego wyboru!");
        }

    }
}

interface Transport{
    void transportuj();
}

class CiezarowkaTransport implements Transport{

    @Override
    public void transportuj() {
        System.out.println("Transportuj ciężarówką.");
    }
}

class StatekTransport implements Transport{

    @Override
    public void transportuj() {
        System.out.println("Transportuj statkiem.");
    }
}

class SamolotTransport implements Transport{

    @Override
    public void transportuj(){
        System.out.println("Transportuj samolotem.");
    }
}

interface GUITransport{
    Transport createTransport();
}

class CiezarowkaFactory implements GUITransport{

    @Override
    public Transport createTransport(){
        return new CiezarowkaTransport();
    }
}

class StatekFactory implements GUITransport{

    @Override
    public Transport createTransport(){
        return new StatekTransport();
    }
}

class SamolotFactory implements GUITransport{

    @Override
    public Transport createTransport(){
        return new SamolotTransport();
    }
}

class ObslugaTransportu{
    private Transport transport;

    public ObslugaTransportu(GUITransport factory){
        transport = factory.createTransport();
    }

    public void transportuj(){
        transport.transportuj();
    }
}