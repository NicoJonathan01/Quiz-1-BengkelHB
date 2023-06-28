package controller;

import java.util.ArrayList;
import model.Layanan;

public class LayananController {
    private ArrayList<Layanan> listLayanan;

    public LayananController(){
        this.listLayanan = new ArrayList<Layanan>();
    }

    public void addLayanan(String jenisLayanan, int harga){
        listLayanan.add(new Layanan(jenisLayanan, harga));
    }

    public ArrayList<Layanan> getLayanan(){
        return listLayanan;
    }

    public void setListLayananToNull(){
        this.listLayanan = null;
    }
}
