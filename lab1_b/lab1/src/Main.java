import javax.swing.*;
import javax.swing.JSlider;
import javax.swing.JFrame;
import  javax.swing.JButton;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Main {

    static int semafor = 0;
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
                    sleep(400);
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

        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(10);
        slider.setPaintLabels(true);
        slider.setBounds(50, 10, 200, 50);


        JButton start1 = new JButton();
        start1.setBounds( 50,70,70,40);
        start1.setText("Start1");

        JButton stop1 = new JButton();
        stop1.setBounds( 50,115,70,40);
        stop1.setText("Stop1");

        JButton start2 = new JButton();
        start2.setBounds( 120,70,70,40);
        start2.setText("Start2");

        JButton stop2 = new JButton();
        stop2.setBounds( 120,115,70,40);
        stop2.setText("Stop2");

        MouseListener listenerStart1;
        listenerStart1 = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                if(semafor == 0){
                    System.out.println("Start1");
                    semafor = 1;
                    thread1 = new MyThread("thread1",10);
                    thread1.start();

                }
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

        MouseListener listenerStop1;
        listenerStop1 = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                if(semafor == 1){
                    System.out.println("Stop1");
                    semafor = 0;
                    slider.setValue(50);
                    thread1.interrupt();

                }
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

        MouseListener listenerStart2;
        listenerStart2 = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                if(semafor == 0){
                    System.out.println("Start2");
                    semafor = -1;
                    thread2 = new MyThread("thread2",90);
                    thread2.start();

                }
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

        MouseListener listenerStop2;
        listenerStop2 = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                if(semafor==-1){
                    //thread1.interrupt();
                    System.out.println("Stop2");
                    semafor = 0;
                    slider.setValue(50);
                    thread2.interrupt();
                }
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

        start1.addMouseListener(listenerStart1);
        stop1.addMouseListener(listenerStop1);
        start2.addMouseListener(listenerStart2);
        stop2.addMouseListener(listenerStop2);

        window.add(slider);
        window.add(start1);
        window.add(stop1);
        window.add(start2);
        window.add(stop2);
        window.setVisible(true);

    }
}