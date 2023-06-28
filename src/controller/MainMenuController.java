package controller;

import java.util.ArrayList;
import model.Pelanggan;
import model.Transaksi;

public class MainMenuController {
    private ArrayList<Pelanggan> listPelanggan;

    public MainMenuController(ArrayList<Pelanggan> listPelanggan){
        this.listPelanggan = listPelanggan;
    }

    public double hitungTotalPendapatan(){
        double totalPendapatan = 0;
        for(Pelanggan pelanggan : listPelanggan){
            for(Transaksi transaksi : pelanggan.getListTransaksi()){
                totalPendapatan += transaksi.getTotalBayar();
            }
        }
        return totalPendapatan;
    }
}
