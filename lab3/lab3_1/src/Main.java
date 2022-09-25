public class Main {
    public static void main(String[] args) {


        BeeHouse House = new BeeHouse(10);
        Bee bee1 = new Bee(House);
        Bee bee2 = new Bee(House);
        Bee bee3 = new Bee(House);
        Bee bee4 = new Bee(House);
        Bear bear = new Bear(House);
        bee1.start();
        bee2.start();
        bee3.start();
        bee4.start();
        bear.start();
        System.out.println(House.size);
    }
}