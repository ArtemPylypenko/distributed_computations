public class Nechuporchuk implements Runnable {
    private Truck truck;
    private int totalValue;

    Nechuporchuk(Truck truck){
        this.truck = truck;
        this.totalValue = 0;
        Thread t = new Thread(this, "Nechuporchuk");
        t.start();
    }

    @Override
    public void run() {
        for(int i=0; i<truck.getTruckLength(); i++){
            totalValue = totalValue + truck.get(i);
            try {
                Thread.sleep(1000);} catch (Exception e){System.out.println("Exception caught");
            }
        }
        System.out.println("Nechuporchuk counted that total value of all staff, " +
                "that they had stolen is - "+ totalValue);
    }
}
