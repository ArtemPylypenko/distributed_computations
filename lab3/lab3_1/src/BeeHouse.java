public class BeeHouse {
    public  int size;
    public int fill;
    boolean isFull;
    private boolean locked;

    public BeeHouse(int size) {
        this.size = size;
        this.fill=0;
        this.locked=false;
        this.isFull=false;
    }

    public void setLock(boolean lock){
        this.locked=lock;
    }

    public boolean isLocked(){
        return locked;
    }
}
