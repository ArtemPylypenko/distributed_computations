package org.example.Socket;

import org.example.model.Phone;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class ClientSocketTask7 {
    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;

    public ClientSocketTask7(String ip, int port) {
        try {
            socket = new Socket(ip, port);
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    List<Phone> getPhones() {
        try {
            out.writeObject("get phones");
            return (List<Phone>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    List<Phone> getSortedPhones() {
        try {
            out.writeObject("get sorted phones");
            return (List<Phone>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    List<Phone> getPhonesCityBiggerThan(int value) {
        try {
            out.writeObject("get phones whit city > than");
            out.writeObject(value);
            return (List<Phone>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    List<Phone> getPhonesWithInterCity() {
        try {
            out.writeObject("get phones whit intercity");
            return (List<Phone>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String[] args) {
        ClientSocketTask7 client = new ClientSocketTask7("localhost", 8080);
        System.out.println(client.getPhones());
        System.out.println(client.getSortedPhones());
        System.out.println(client.getPhonesCityBiggerThan(150));
        System.out.println(client.getPhonesWithInterCity());
    }
}