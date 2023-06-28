package view;

import controller.PelangganController;
import java.util.ArrayList;
import model.Transaksi;
import model.Kendaraan;

public class PelangganScreen {
    private PelangganController pelangganController;

    public PelangganScreen(PelangganController pelangganController){
        this.pelangganController = pelangganController;
    }

    public void inputNewMember(){
        String nama = Dialog.showInputDialog("Masukkan nama: ");
        String alamat = Dialog.showInputDialog("Masukkan alamat: ");
        String nomorTelepon = Dialog.showInputDialog("Masukkan no telp: ");
        String email = Dialog.showInputDialog("Masukkan email: ");

        ArrayList<Transaksi> listTransaksi = new ArrayList<Transaksi>();
        ArrayList<Kendaraan> listKendaraan = new ArrayList<Kendaraan>();

        pelangganController.addNewMember(nama, alamat, nomorTelepon, listTransaksi, email, listKendaraan);

        String data = pelangganController.getDataMember(email);

        Dialog.showMessageDialog("Data berhasil diinput! \n\n" + data);
    }
}
