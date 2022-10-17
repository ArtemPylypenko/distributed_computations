import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;


public class Register implements Runnable {
    public String name;
    private final Manager manager;
    public Deque<User> queue = new LinkedList<>();

    @Override
    public void run() {
        while (!queue.isEmpty()) {
            try {
                Main.SEMAPHORE.acquire();

                manager.checkRegisters(this.queue.size(), this);

                User tmp = this.queue.poll();
                System.out.println("Customer " + tmp.name + " left " + this.name + " register");

                Main.SEMAPHORE.release();

                Thread.sleep(2000);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public Register(Manager manager, String name, User... variables) {
        this.manager = manager;
        this.name = name;
        Collections.addAll(this.queue, variables);
    }

}
