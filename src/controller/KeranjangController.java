package controller;

import model.Keranjang;
import model.Barang;
import java.util.ArrayList;

public class KeranjangController {
    private ArrayList<Keranjang> listKeranjang;

    public KeranjangController(){
        this.listKeranjang = new ArrayList<Keranjang>();
    }

    public void addKeranjang(Barang barang, int kuantitas){
        listKeranjang.add(new Keranjang(barang, kuantitas));
    }

    public ArrayList<Keranjang> getKeranjang(){
        return listKeranjang;
    }

    public void setListKeranjangToNull(){
        this.listKeranjang = null;
    }
}
