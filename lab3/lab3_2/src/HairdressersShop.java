import java.util.Currency;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class HairdressersShop {
    private BlockingQueue<Visitor> visitors;

    public HairdressersShop() {
        this.visitors = new LinkedBlockingQueue<>();
    }

    public void start(){
        Thread[] threads = new Thread[3];
        for (int i = 0;i < threads.length;i++){
            threads[i] = new Thread(new Visitor(this,i));
        }

        Thread hairdresser = new Thread(new Hairdresser(this));

        for (Thread thread : threads){
            thread.start();
        }
        hairdresser.start();
    }

    public void addVisitor(Visitor visitor) throws InterruptedException {
        visitors.put(visitor);
    }

    public Visitor takeVisitor() throws InterruptedException {
        return visitors.take();
    }

    public int visitorsCount(){
        return visitors.size();
    }
}
