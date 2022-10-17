import java.util.concurrent.Semaphore;

public class Main {
    public static final Semaphore SEMAPHORE = new Semaphore(1, true);

    public static void main(String[] args) {


        Manager manager = new Manager();

        User u1 = new User("u1");
        User u2 = new User("u2");
        User u3 = new User("u3");
        User u4 = new User("u4");
        User u5 = new User("u5");
        User u6 = new User("u6");
        User u7 = new User("u7");
        User u8 = new User("u8");

        Register register1 = new Register(manager, "reg1", u1);
        Register register2 = new Register(manager, "reg2", u2, u3, u4, u5);
        Register register3 = new Register(manager, "reg3", u6, u7, u8);

        manager.addRegister(register1, register2, register3);


        new Thread(register1).start();
        new Thread(register2).start();
        new Thread(register3).start();
    }

}