package controller;

import model.Pelanggan;
import model.Anggota;
import model.Transaksi;
import model.Kendaraan;
import java.util.ArrayList;

public class PelangganController {
    private ArrayList<Pelanggan> listPelanggan;

    public PelangganController(ArrayList<Pelanggan> listPelanggan){
        this.listPelanggan = listPelanggan;
    }

    public void addNewMember(String nama, String alamat, String nomortelepon, ArrayList<Transaksi> listTransaksi, String email, ArrayList<Kendaraan> listKendaraan){
        listPelanggan.add(new Anggota(nama, alamat, nomortelepon, listTransaksi, email, listKendaraan));
    }

    public String getDataMember(String email){
        String data = "";
        for(Pelanggan pelanggan : listPelanggan){
            if(pelanggan instanceof Anggota){
                Anggota anggota = (Anggota) pelanggan;
                if(email.equals(anggota.getEmail())){
                    data =  anggota.toString();
                }
            }
        }
        return data;
    }

    
}
