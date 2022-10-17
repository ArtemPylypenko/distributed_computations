import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Manager {

    public List<Register> registersList;

    public Manager() {
        registersList = new ArrayList<>();

    }

    public void checkRegisters(int currentQueue, Register register) {
        for (int i = 0; i < registersList.size(); i++) {
            if (currentQueue - registersList.get(i).queue.size() >= 2) {
                User tmp = register.queue.pollLast();
                registersList.get(i).queue.add(tmp);
                System.out.println(tmp.name + " from " + register.name + "  join " + registersList.get(i).name);
                break;
            }
        }
    }

    public void addRegister(Register... registers) {
        Collections.addAll(this.registersList, registers);
    }

}
