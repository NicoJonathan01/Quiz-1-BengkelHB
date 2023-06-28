package model;

import java.util.ArrayList;

public class Anggota extends Pelanggan{
    private String email;
    private ArrayList<Kendaraan> listKendaraan = new ArrayList<Kendaraan>();

    public Anggota(String nama, String alamat, String nomorTelepon, ArrayList<Transaksi> listTransaksi, String email, ArrayList<Kendaraan> listKendaraan) {
        super(nama, alamat, nomorTelepon, listTransaksi);
        this.email = email;
        this.listKendaraan = listKendaraan;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Kendaraan> getListKendaraan() {
        return listKendaraan;
    }

    public void setListKendaraan(ArrayList<Kendaraan> listKendaraan) {
        this.listKendaraan = listKendaraan;
    }
    
    @Override
    public String toString(){
        String itemKendaraan = "no data";
        if(listKendaraan != null){
            for(Kendaraan kendaraan : listKendaraan){
                itemKendaraan += kendaraan.toString();
            }
        }

        return super.toString() + "\nEmail: " + email + "\nDaftar Kendaraan: " + itemKendaraan;
    }
}
