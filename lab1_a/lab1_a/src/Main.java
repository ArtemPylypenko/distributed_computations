import javax.swing.*;
import javax.swing.JSlider;
import javax.swing.JFrame;
import  javax.swing.JButton;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Main {

    static JFrame window = new JFrame();

    static JSlider slider = new JSlider();

    public static class MyThread extends Thread{
        public int sliderPosition;
        MyThread(String name,int sliderPos){
            super(name);
            this.sliderPosition = sliderPos;
        }

        @Override
        public void run() {
            System.out.println("Thread "+ this.getName());
            while (!isInterrupted()) {
                try {
                    sleep(500);
                    slider.setValue(sliderPosition);
                } catch (InterruptedException e) {
                    //interrupt();
                    System.out.println("Interrupted " + getName());
                    break;
                }
            }
        }
    }

    static MyThread thread1 ;
    static MyThread thread2 ;



    public static void main(String[] args) {

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(350,350);
        window.setLayout(null);

        SpinnerModel firstSpinnerModel = new SpinnerNumberModel(0, 0, 10, 1);
        JSpinner firstSpinner = new JSpinner(firstSpinnerModel);
        firstSpinner.setBounds(45, 70, 50, 60);
        firstSpinner.addChangeListener(e -> {
            int priority = (int) firstSpinner.getValue();
            thread1.setPriority(priority);
        });

        SpinnerModel secondSpinnerModel = new SpinnerNumberModel(0, 0, 10, 1);
        JSpinner secondSpinner = new JSpinner(secondSpinnerModel);
        secondSpinner.setBounds(210, 70, 50, 60);
        secondSpinner.addChangeListener(e -> {
            int priority = (int) secondSpinner.getValue();
            thread2.setPriority(priority);
        });

        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(10);
        slider.setPaintLabels(true);
        slider.setBounds(50, 10, 200, 50);

        JButton start = new JButton();
        start.setBounds( 120,70,70,40);
        start.setText("Start");

        MouseListener startListener = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                thread1 = new MyThread("Thread1",10);
                thread2 = new MyThread("Thread2",90);
                thread1.start();
                thread2.start();
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }
        };
        start.addMouseListener(startListener);

        window.add(slider);
        window.add(start);
        window.add(firstSpinner);
        window.add(secondSpinner);
        window.setVisible(true);
    }
}