import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
            int [] array = {1, 3, 6, 8, 9};
            Ivanov ivanov = new Ivanov(array);
            Truck truck = new Truck(array);
            Petrov petrov = new Petrov(ivanov, truck);
            Nechuporchuk nechuporchuk = new Nechuporchuk(truck);

    }
}