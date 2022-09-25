public class Manager {
    public int fieldSize;
    private int bear[] = new int[2];//Bear coordinates
    private boolean isFound;
    static int givenTasks = 0;
    public Manager(int field_Size,int bear_x,int bear_y) {
        super();
        this.fieldSize=field_Size;
        this.bear[0]=bear_x;
        this.bear[1]=bear_y;
        this.isFound=false;
    }
    public synchronized int getTask(){
       if(checkTask()){
           givenTasks++;
           return givenTasks;
       }else{
           return -1;
       }
    }
    public boolean checkTask(){
        if(givenTasks == fieldSize){
            return false;
        }else if(isFound){
            return false;
        }else{
            return true;
        }
    }
    public int GetBearX(){
        return bear[0];
    }
    public int GetBearY(){
        return bear[1];
    }
    public void SetFound(){
        this.isFound=true;
    }
    public boolean ChechFound(){
        return isFound;
    }
}
