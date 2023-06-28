package view;

import controller.TransaksiController;
import model.JenisPembayaran;
import model.Keranjang;
import model.Layanan;
import java.util.ArrayList;
import java.util.Date;

public class TransaksiScreen {
    private TransaksiController transaksiController;

    public TransaksiScreen(TransaksiController transaksiController){
        this.transaksiController = transaksiController;
    }

    public void inputTransaksi(ArrayList<Keranjang> listKeranjang, ArrayList<Layanan> listLayanan){

        String nama = Dialog.showInputDialog("Masukkan nama pelanggan/anggota yang ingin diinput transaksinya: ");
        

        JenisPembayaran jenisPembayaran = Dialog.showInputDialogForEnum("Pilih jenis pembayaran:", "Jenis Pembayaran", JenisPembayaran.values(), JenisPembayaran.GOPAY);

        Date tanggalTransaksi = Dialog.showInputDialogForDate("Masukkan tanggal: ", "Input tanggal", new Date());

        double totalBayar = transaksiController.hitungTotalBayar(listKeranjang, listLayanan);

        transaksiController.setTransaksiPelanggan(nama, jenisPembayaran, tanggalTransaksi, totalBayar, listKeranjang, listLayanan);

        String dataTransaksi = transaksiController.getDataTransaksiPelanggan(nama);

        Dialog.showMessageDialog("Transaksi berhasil di-input! \n\n" + dataTransaksi);

    }
}
