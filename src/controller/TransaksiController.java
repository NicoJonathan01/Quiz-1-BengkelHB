package controller;

import java.util.ArrayList;
import java.util.Date;

import model.Anggota;
import model.JenisPembayaran;
import model.Pelanggan;
import model.Layanan;
import model.Keranjang;
import model.Transaksi;

public class TransaksiController {
    private ArrayList<Pelanggan> listPelanggan;

    public TransaksiController(ArrayList<Pelanggan> listPelanggan){
        this.listPelanggan = listPelanggan;
    }

    public double hitungTotalBayar(ArrayList<Keranjang> listKeranjang, ArrayList<Layanan> listLayanan){
        double totalBayar = 0;
        for(Keranjang keranjang : listKeranjang){
            totalBayar += (keranjang.getBarang().getHarga() * keranjang.getKuantitas());
        }

        for(Layanan layanan : listLayanan){
            totalBayar += layanan.getHarga();
        }
        return totalBayar;
    }

    public void setTransaksiPelanggan(String nama, JenisPembayaran jenisPembayaran, Date tanggalTransaksi, double totalBayar, ArrayList<Keranjang> listKeranjang, ArrayList<Layanan> listLayanan){

        Anggota anggotaSelected = null;
        for(Pelanggan pelanggan : listPelanggan){
            if(nama.equals(pelanggan.getNama())){
                if(pelanggan instanceof Anggota){
                    anggotaSelected = (Anggota) pelanggan;
                    break;
                }
            }
        }

        Transaksi transaksiAnggota = new Transaksi(jenisPembayaran, tanggalTransaksi, totalBayar, listLayanan, listKeranjang);
        anggotaSelected.setListTransaksi(transaksiAnggota);

    }

    public String getDataTransaksiPelanggan(String nama){
        String dataTransaksi = "";
        for(Pelanggan pelanggan : listPelanggan){
            if(nama.equals(pelanggan.getNama())){
                if(pelanggan instanceof Anggota){
                    Anggota selected = (Anggota) pelanggan;
                    dataTransaksi = selected.getNama() + "\n\n" + selected.getListTransaksi().toString();
                    break;
                }
            }
        }

        return dataTransaksi;
    }
}
