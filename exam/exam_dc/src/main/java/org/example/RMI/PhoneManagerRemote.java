package org.example.RMI;

import org.example.model.Phone;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface PhoneManagerRemote extends Remote {
    List<Phone> getPhones() throws RemoteException;

    List<Phone> getSortedPhones() throws RemoteException;

    List<Phone> getPhonesCityBiggerThan(int value) throws RemoteException;

    List<Phone> getPhonesWithInterCity() throws RemoteException;
}
