import java.awt.*;

public class Truck {
    private int [] truck;
    private int amount;
    private boolean valueSet;

    Truck(int [] array){
        this.truck = new int[array.length];
        this.amount = 0;
        this.valueSet=false;
    }
    public synchronized void put(int element){
        while (valueSet){
            try {wait();} catch (Exception e){System.out.println("Exception caught");}
        }
        System.out.println("Petrov put an element to the truck "+element);
        truck[amount] = element;
        amount++;
        valueSet=true;
        notify();
    }
    public synchronized int get(int index){
        while (!valueSet){
            try {wait();} catch (Exception e){System.out.println("Exception caught");}
        }
        System.out.println("Nechuporchuk got an element " + truck[index]);
        valueSet=false;
        notify();
        return truck[index];
    }
    public int getTruckLength(){
        return truck.length;
    }
}
