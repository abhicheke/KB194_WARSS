package com.example.rameshsih;
public class Globalclass {
   String id=new String();
    String name=new String();
    String aathar=new String();
    String dob=new String();
    String mob=new String();
    String house=new String();
    String road=new String();
    String land=new String();
    String pin=new String();
    String village=new String();
    String taluk=new String();
    String district=new String();
    String cows=new String();
    String buff=new String();
    String goat=new String();
    String sheep=new String();
    String horse=new String();
    String password=new String();
    private static final Globalclass ourInstance = new Globalclass();
    public static Globalclass getInstance() {
        return ourInstance;
    }
    private Globalclass() {
    }
    public void setData(String id,String name,String aathar,String dob,String mob,String house,String road,String land,String pin,String village,String taluk,String district,String cows
            ,String buff,String goat,String sheep,String horse) {
        this.id=id;
        this.name = name;
        this.aathar = aathar;
        this.dob = dob;
        this.mob = mob;
        this.house = house;
        this.road = road;
        this.land = land;
        this.pin = pin;
        this.village = village;
        this.taluk = taluk;
        this.district = district;
        this.cows = cows;
        this.buff = buff;
        this.goat = goat;
        this.sheep = sheep;
        this.horse = horse;
    }
    public String getId() { return id; }
    public String getName() {
        return name;
    }
    public String getaathar() {
        return aathar;
    }
    public String getDob() {
        return dob;
    }
    public String getmob() {
        return mob;
    }
    public String gethouse() {
        return house;
    }
    public String getroad() {
        return road;
    }
    public String getland() {
        return land;
    }
    public String getpin() {
        return pin;
    }
    public String getvillage() {
        return village;
    }
    public String gettaluk() {
        return taluk;
    }
    public String getdistrict() {
        return district;
    }
    public String getcows() {
        return cows;
    }
    public String getbuff() {
        return buff;
    }
    public String getgoat() {
        return goat;
    }
    public String getsheep() {
        return sheep;
    }
    public String gethorse() {
        return horse;
    }
}