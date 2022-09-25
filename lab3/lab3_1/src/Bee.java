public class Bee extends Thread{
    final BeeHouse HOUSE;

    public Bee(BeeHouse HOUSE) {
        this.HOUSE = HOUSE;
    }

    @Override
    public void run() {
        while(true){
            if(!HOUSE.isLocked()){
                HOUSE.setLock(true);
                if(HOUSE.size <= HOUSE.fill){
                    System.out.println("Full");
                    HOUSE.isFull=true;
                    //HOUSE.setLock(true);
                }else{
                    System.out.println("Filling "+ this.getName());
                    HOUSE.fill++;
                    HOUSE.setLock(false);
                }
            }

            try {
                Thread.sleep(1000);
            } catch(InterruptedException e) {
                System.out.println("got interrupted!");
            }
        }
    }
}
