package org.example.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PhoneManager {
    private final List<Phone> phones;

    public PhoneManager() {
        phones = new ArrayList<>();

    }

    public synchronized void addPhone(Phone phone) {
        phones.add(phone);
    }

    public synchronized List<Phone> getPhones() {
        return phones;
    }

    public synchronized List<Phone> getSortedPhones() {
        List<Phone> res = new ArrayList<>();
        res.sort(Comparator.comparing(Phone::getName));
        return res;
    }

        public synchronized List<Phone> getPhonesCityBiggerThan(int value) {
        List<Phone> res = new ArrayList<>();
        phones.forEach(phone -> {
            if (phone.getCity() > value)
                res.add(phone);
        });
        return res;
    }
    public synchronized List<Phone> getPhonesWithInterCity() {
        List<Phone> res = new ArrayList<>();
        phones.forEach(phone -> {
            if (phone.getIntercity() > 0)
                res.add(phone);
        });
        return res;
    }
}
