import static java.lang.Thread.sleep;

public class Hairdresser implements Runnable{
    HairdressersShop hairdressersShop;

    public Hairdresser(HairdressersShop hairdressersShop) {
        this.hairdressersShop = hairdressersShop;
    }


    @Override
    public void run() {
        while (true){
            try {
                if (hairdressersShop.visitorsCount() == 0){
                    System.out.println("No consumers...");
                }

                Visitor visitor = hairdressersShop.takeVisitor();
                System.out.printf("Haircutter started working \n",visitor.getId());

                sleep(2000);

                System.out.printf("Haircutter finished his work\n", visitor.getId());

                synchronized (visitor){
                    visitor.notifyAll();
                }
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }
    }
}