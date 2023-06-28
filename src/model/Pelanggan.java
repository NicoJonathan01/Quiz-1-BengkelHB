package model;

import java.util.ArrayList;

public class Pelanggan {
    private String nama;
    private String alamat;
    private String nomorTelepon;
    private ArrayList<Transaksi> listTransaksi = new ArrayList<Transaksi>();

    public Pelanggan(String nama, String alamat, String nomorTelepon, ArrayList<Transaksi> listTransaksi) {
        this.nama = nama;
        this.alamat = alamat;
        this.nomorTelepon = nomorTelepon;
        this.listTransaksi = listTransaksi;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNomorTelepon() {
        return nomorTelepon;
    }

    public void setNomorTelepon(String nomorTelepon) {
        this.nomorTelepon = nomorTelepon;
    }

    public ArrayList<Transaksi> getListTransaksi() {
        return listTransaksi;
    }

    public void setListTransaksi(Transaksi transaksi) {
        this.listTransaksi.add(transaksi);
    }

    public String toString(){
        String itemTransaksi = "no data";
        if(listTransaksi != null){
            for(Transaksi transaksi : listTransaksi){
                itemTransaksi += transaksi.toString();
            }
        }
    
        return "\nNama: " + nama + "\nAlamat: " + alamat + "\nNo. Telp: " + nomorTelepon + "\nDaftar Transaksi: " + itemTransaksi;
    }
    
}
