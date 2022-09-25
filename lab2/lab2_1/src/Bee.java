public class Bee extends Thread{
    private  final Manager manager;
    int rowToCheck;
    public Bee(String name, Manager manager) {
        super(name);
        this.manager = manager;
    }

    @Override
    public void run() {
        while(manager.checkTask()){
            rowToCheck = manager.getTask();
            for(int i=0;i<manager.fieldSize;i++){
                if(i== manager.GetBearX() &&   rowToCheck == manager.GetBearY()){
                    System.out.println("Bear found! "+ i+" "+ rowToCheck+ " "+ this.getName());
                    manager.SetFound();
                    break;
                }else{
                    System.out.println(i +" " + rowToCheck + " Checked " + this.getName());
                }
            }
        }
    }
}
