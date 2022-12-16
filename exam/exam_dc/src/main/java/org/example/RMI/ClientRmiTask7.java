package org.example.RMI;

import org.example.RMI.PhoneManagerRemote;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ClientRmiTask7 {
    public static void main(String[] args) {
        try {
            PhoneManagerRemote managerRemote =
                    (PhoneManagerRemote) Naming.lookup("//localhost/CustomerManager");
            System.out.println(managerRemote.getPhones());
            System.out.println(managerRemote.getSortedPhones());
            System.out.println(managerRemote.getPhonesCityBiggerThan(300));
            System.out.println(managerRemote.getPhonesWithInterCity());
        } catch (NotBoundException | MalformedURLException | RemoteException e) {
            e.printStackTrace();
        }
    }
}