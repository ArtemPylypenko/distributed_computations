package org.example.RMI;

import org.example.model.Phone;
import org.example.model.PhoneManager;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class ServerRmiTask7 extends UnicastRemoteObject implements PhoneManagerRemote {
    private final PhoneManager manager;

    public ServerRmiTask7() throws RemoteException {
        manager = new PhoneManager();
    }

    @Override
    public List<Phone> getPhones() throws RemoteException {
        return manager.getPhones();
    }

    @Override
    public List<Phone> getSortedPhones() throws RemoteException {
        return manager.getSortedPhones();
    }

    @Override
    public List<Phone> getPhonesCityBiggerThan(int value) throws RemoteException {
        return manager.getPhonesCityBiggerThan(value);
    }

    @Override
    public List<Phone> getPhonesWithInterCity() throws RemoteException {
        return manager.getPhonesWithInterCity();
    }

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("PhoneManager", new ServerRmiTask7());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
