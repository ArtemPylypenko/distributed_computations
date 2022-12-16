package org.example.model;

import java.io.Serializable;

public class Phone implements Serializable {
    private int id;
    private String name;
    private String sName;
    private String fName;
    private String address;
    private String creditNumber;
    private int debit;
    private int credit;
    private int city;
    private int intercity;

    public Phone(int id, String name, String sName, String fName,
                 String address, String creditNumber, int debit, int credit, int city, int intercity) {
        this.id = id;
        this.name = name;
        this.sName = sName;
        this.fName = fName;
        this.address = address;
        this.creditNumber = creditNumber;
        this.debit = debit;
        this.credit = credit;
        this.city = city;
        this.intercity = intercity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sName='" + sName + '\'' +
                ", fName='" + fName + '\'' +
                ", address='" + address + '\'' +
                ", creditNumber='" + creditNumber + '\'' +
                ", debit=" + debit +
                ", credit=" + credit +
                ", city=" + city +
                ", intercity=" + intercity +
                '}';
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreditNumber() {
        return creditNumber;
    }

    public void setCreditNumber(String creditNumber) {
        this.creditNumber = creditNumber;
    }

    public int getDebit() {
        return debit;
    }

    public void setDebit(int debit) {
        this.debit = debit;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getCity() {
        return city;
    }

    public void setCity(int city) {
        this.city = city;
    }

    public int getIntercity() {
        return intercity;
    }

    public void setIntercity(int intercity) {
        this.intercity = intercity;
    }
}
