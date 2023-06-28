package model;

import java.util.ArrayList;
import java.util.Date;

public class Transaksi {
    private JenisPembayaran jenisPembayaran;
    private Date tanggalTransaksi;
    private double totalBayar;
    private ArrayList<Layanan> listLayanan;
    private ArrayList<Keranjang> listKeranjang;

    

    public Transaksi(JenisPembayaran jenisPembayaran, Date tanggalTransaksi, double totalBayar, ArrayList<Layanan> listLayanan, ArrayList<Keranjang> listKeranjang) {
        this.jenisPembayaran = jenisPembayaran;
        this.tanggalTransaksi = tanggalTransaksi;
        this.totalBayar = totalBayar;
        this.listLayanan = listLayanan;
        this.listKeranjang = listKeranjang;
    }



    public JenisPembayaran getJenisPembayaran() {
        return jenisPembayaran;
    }



    public void setJenisPembayaran(JenisPembayaran jenisPembayaran) {
        this.jenisPembayaran = jenisPembayaran;
    }



    public Date getTanggalTransaksi() {
        return tanggalTransaksi;
    }



    public void setTanggalTransaksi(Date tanggalTransaksi) {
        this.tanggalTransaksi = tanggalTransaksi;
    }



    public double getTotalBayar() {
        return totalBayar;
    }



    public void setTotalBayar(double totalBayar) {
        this.totalBayar = totalBayar;
    }



    public ArrayList<Layanan> getListLayanan() {
        return listLayanan;
    }



    public void setListLayanan(ArrayList<Layanan> listLayanan) {
        this.listLayanan = listLayanan;
    }



    public ArrayList<Keranjang> getListKeranjang() {
        return listKeranjang;
    }



    public void setListKeranjang(ArrayList<Keranjang> listKeranjang) {
        this.listKeranjang = listKeranjang;
    }

    public String toString(){
        String itemLayanan = "";
        for(Layanan layanan: listLayanan){
            itemLayanan += layanan.toString();
        }

        String itemKeranjang = "";
        for(Keranjang keranjang : listKeranjang){
            itemKeranjang += keranjang.toString();
        }

        return "\nJenis Pembayaran: " + jenisPembayaran + "\nTanggal transaksi: " + tanggalTransaksi + "\nTotal Bayar: " + totalBayar + "\nDetail Layanan: " + itemLayanan + "\nDetail Keranjang: " + itemKeranjang + "\n";
    }
    
}
