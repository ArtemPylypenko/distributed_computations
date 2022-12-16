package org.example.Socket;

import org.example.model.PhoneManager;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ServerSocketTask7 {
    private ServerSocket serverSocket;
    private final Executor executor;
    private final PhoneManager manager;

    public ServerSocketTask7(int port, int size) {
        executor = Executors.newSingleThreadExecutor();
        manager = new PhoneManager();
        try {
            serverSocket = new ServerSocket(port, 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ServerSocketTask7 server = new ServerSocketTask7(8080, 30);
        server.run();
    }

    public void run() {
        while (true) {
            try {
                var client = serverSocket.accept();
                System.out.println(client + " connected!");
                executor.execute(new ClientRunnable(manager, client));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static class ClientRunnable implements Runnable {
        private ObjectOutputStream out;
        private ObjectInputStream in;
        private final PhoneManager manager;
        private final Socket client;

        public ClientRunnable(PhoneManager manager, Socket client) {
            this.manager = manager;
            this.client = client;
            try {
                out = new ObjectOutputStream(client.getOutputStream());
                in = new ObjectInputStream(client.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void getPhones() throws IOException {
            var phones = manager.getPhones();
            out.writeObject(Objects.requireNonNullElseGet(phones, ArrayList::new));
        }

        private void getSortedPhones() throws IOException {
            var phones = manager.getSortedPhones();
            out.writeObject(Objects.requireNonNullElseGet(phones, ArrayList::new));
        }

        private void getPhonesCityBiggerThan() throws IOException, ClassNotFoundException {
            Integer value = (Integer) in.readObject();
            var phones = manager.getPhonesCityBiggerThan(value);
            out.writeObject(Objects.requireNonNullElseGet(phones, ArrayList::new));
        }

        private void getPhonesWithInterCity() throws IOException, ClassNotFoundException {
            var phones = manager.getPhonesWithInterCity();
            out.writeObject(Objects.requireNonNullElseGet(phones, ArrayList::new));
        }

        @Override
        public void run() {
            while (!Thread.interrupted()) {
                try {
                    if (client.isClosed() || !client.isConnected()) break;
                    String code = (String) in.readObject();
                    System.out.println(">" + code);
                    switch (code) {
                        case "get phones" -> getPhones();
                        case "get sorted phones" -> getSortedPhones();
                        case "get phones whit city > than" -> getPhonesCityBiggerThan();
                        case "get phones whit intercity" -> getPhonesWithInterCity();
                        default -> out.writeObject(new ArrayList<>());
                    }
                } catch (IOException | ClassNotFoundException e) {
                    System.err.println(client + " disconnected!");
                    return;
                }
            }
        }
    }
}