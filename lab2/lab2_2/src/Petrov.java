import java.util.Queue;

public class Petrov implements Runnable{
    private Ivanov ivanov;
    private Truck truck;

    Petrov(Ivanov ivanov, Truck truck){
        this.ivanov = ivanov;
        this.truck = truck;
        Thread t = new Thread(this, "Petrov");
        t.start();
    }
    @Override
    public void run() {
        for (int i=0; i<ivanov.getAmountOfElements(); i++){
            truck.put(ivanov.get(i));
            try {Thread.sleep(1000);} catch (Exception e){
                System.out.println("Exception caught");
            }
        }
    }
}
