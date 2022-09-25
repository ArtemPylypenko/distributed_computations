public class Bear extends Thread{
    final BeeHouse HOUSE;

    public Bear(BeeHouse house) {
        this.HOUSE=house;
    }

    @Override
    public void run() {
        while (true){
            if(HOUSE.isFull){
                System.out.println("Bear alive");
                HOUSE.fill=0;
                HOUSE.isFull=false;
                HOUSE.setLock(false);
            }else{
                try {
                    Thread.sleep(1500);
                } catch(InterruptedException e) {
                    System.out.println("got interrupted!");
                }
            }
        }
    }
}
