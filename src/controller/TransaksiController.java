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

    public double hitungTotalBayar(ArrayList<Keranjang> listKeranjang, ArrayList<Layanan> listLayanan, String nama){

        boolean isAnggota = false;
        for(Pelanggan pelanggan : listPelanggan){
            if(nama.equals(pelanggan.getNama())){
                if(pelanggan instanceof Anggota){
                    isAnggota = true;
                    break;
                }
            }
        }

        double totalBayar = 0;

        for(Keranjang keranjang : listKeranjang){
            totalBayar += (keranjang.getBarang().getHarga() * keranjang.getKuantitas());
        }

        if(!isAnggota){
            for(Layanan layanan : listLayanan){
                totalBayar += layanan.getHarga();
            }            
        }

        return totalBayar;
    }

    public void setTransaksiPelanggan(String nama, JenisPembayaran jenisPembayaran, Date tanggalTransaksi, double totalBayar, ArrayList<Keranjang> listKeranjang, ArrayList<Layanan> listLayanan){

        Anggota anggotaSelected = null;
        Pelanggan pelangganSelected = null;
        for(Pelanggan pelanggan : listPelanggan){
            if(nama.equals(pelanggan.getNama())){
                if(pelanggan instanceof Anggota){
                    anggotaSelected = (Anggota) pelanggan;
                    break;
                }else{
                    pelangganSelected = pelanggan;
                    break;
                }
            }
        }

        if(anggotaSelected != null){
            Transaksi transaksiAnggota = new Transaksi(jenisPembayaran, tanggalTransaksi, totalBayar, listLayanan, listKeranjang);

            if(anggotaSelected.getListTransaksi() != null){
                anggotaSelected.getListTransaksi().add(transaksiAnggota);
            }else{
                anggotaSelected.setListTransaksi(transaksiAnggota);
            }
        }
        
        if(pelangganSelected != null){
            Transaksi transaksiPelanggan = new Transaksi(jenisPembayaran, tanggalTransaksi, totalBayar, listLayanan, listKeranjang);

            if(pelangganSelected.getListTransaksi() != null){
                pelangganSelected.getListTransaksi().add(transaksiPelanggan);
            }else{
                anggotaSelected.setListTransaksi(transaksiPelanggan);
            }
        }

    }

    public String getDataTransaksiPelanggan(String nama){
        String dataTransaksi = "";
        for(Pelanggan pelanggan : listPelanggan){
            if(nama.equals(pelanggan.getNama())){
                if(pelanggan instanceof Anggota){
                    Anggota selected = (Anggota) pelanggan;
                    dataTransaksi = selected.getNama() + "\n\n" + selected.getListTransaksi().toString();
                    break;
                }else{
                    Pelanggan selected = pelanggan;
                    dataTransaksi = selected.getNama() + "\n\n" + selected.getListTransaksi().toString();
                }
            }
        }

        return dataTransaksi;
    }
}
