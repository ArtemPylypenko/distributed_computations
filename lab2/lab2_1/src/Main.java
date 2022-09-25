
public class Main {

    public static void main(String[] args) {
    Manager m = new Manager(10,1,1);

    Bee bee1 = new Bee("Bee1",m);
    Bee bee2 = new Bee("Bee2",m);
    Bee bee3 = new Bee("Bee3",m);
    Bee bee4= new Bee("Bee4",m);

    bee1.start();
    bee2.start();
    bee3.start();
    bee4.start();
    }
}