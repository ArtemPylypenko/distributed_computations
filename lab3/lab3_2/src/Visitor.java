import static java.lang.Thread.sleep;
public class Visitor implements Runnable{
    private HairdressersShop hairdressersShop;
    private int id;
    private long sleepTime;

    public Visitor(HairdressersShop hairdressersShop, int id) {
        this.hairdressersShop = hairdressersShop;
        this.id = id;
        this.sleepTime = 2000;
    }

    public int getId() {
        return id;
    }

    @Override
    public void run() {
        while (true){
            try {
                sleep(sleepTime);

                int current = hairdressersShop.visitorsCount();

                if(current > 0){
                    System.out.println("Consumer "+ id +" is sleeping  in queue"+(current+1)+"\n");
                }else{
                    System.out.printf("Consumer "+ id +" is waiting on his turn"+"\n");
                }

                hairdressersShop.addVisitor(this);

                synchronized (this){
                    wait();
                }
                System.out.printf("Consumer  will appear through ",id+"\n");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

